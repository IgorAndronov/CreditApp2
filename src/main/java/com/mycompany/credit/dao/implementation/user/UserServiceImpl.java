package com.mycompany.credit.dao.implementation.user;

import com.mycompany.credit.dao.entity.client.ContactsPwd;
import com.mycompany.credit.dao.interfaces.user.UserService;
import com.mycompany.credit.web.LoginController;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

import static com.mycompany.credit.commons.Constants.*;

/**
 * Created by igor on 01.08.15.
 */
@Repository(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService{
    final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource(name = "mySessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean isUserCanLogin(String login, String password, String userType, LoginController loginController) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();


        if (userType.equals(CLIENT)){
           String q = "from ContactsPwd where loginName=:login and pwd=:password";
           List<ContactsPwd> results = (List<ContactsPwd>) sessionFactory.getCurrentSession()
                   .createQuery(q)
                   .setParameter("login", login)
                   .setParameter("password",password)
                   .list();
           if(results.size()==1){
               loginController.setUserId(results.get(0).getContactId());
               return true;
           }else{
               return false; //change to false
           }

        }else{
           //MANAGER
           if (login.equals("igor.emailplace@gmail.com") && password.equals("123")){
               return true;
           }else {
               return false;
           }
       }




    }
}
