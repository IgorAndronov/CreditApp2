package com.mycompany.credit.dao;

import com.mycompany.credit.dao.entity.DicStreetType;
import com.mycompany.credit.dao.interfaces.DictionaryAddressService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by igor on 25.07.15.
 */

@Repository(value = "DictionaryAddressServiceImpl")
@Transactional
public class DictionaryAddressServiceImpl implements DictionaryAddressService {
    @Resource(name = "mySessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext appContext;

    public void persistStreetType(DicStreetType dicStreetType) {

    }


    @Transactional
    public List<DicStreetType> getListStreetType(String criteria) {

        System.out.println("dao appContext ="+appContext);

        String q = "from DicStreetType";
        List<DicStreetType> listStreetType = (List<DicStreetType>) sessionFactory.getCurrentSession()
                .createQuery(q)
                .list();
        System.out.println("listStreetType" + listStreetType);

        return listStreetType;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
