package com.mycompany.credit.web;

import com.mycompany.credit.commons.FieldAttribute;
import com.mycompany.credit.dao.entity.client.ClientFieldSpecification;
import com.mycompany.credit.dao.entity.commons.KeyValueResult;
import com.mycompany.credit.dao.interfaces.client.ClientService;
import com.mycompany.credit.logic.FieldsTechSpec;
import com.mycompany.credit.web.utils.LocaleUsage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static com.mycompany.credit.commons.Constants.*;
import static com.mycompany.credit.web.utils.WebConstants.*;
import static com.mycompany.credit.dao.entity.commons.Constants.*;


/**
 * Created by igor on 09.08.15.
 */

@Controller
public class ClientDataController {

   public static final String PAGE_NAME="secured/clientmaintanance/clientInput";
   public static final String PROPERTIES_NAME="clientInput.properties"; //file with locale data
   final static Logger logger = Logger.getLogger(ClientDataController.class);

    @Autowired
    private ServletContext servletContext;


    LoginController loginController;

    @Resource(name = "FieldsTechSpec")
    FieldsTechSpec fieldsTechSpec;



    @RequestMapping(value = SECURED_PAGES_PATH+CLIENT_DATA_CONTROLLER, method = RequestMethod.GET)
    public ModelAndView getPage(@RequestParam Map<String,String> params, HttpServletRequest req) {
        String localeFromRequest;
        localeFromRequest=params.get("locale");
        String locale = LocaleUsage.setSessionLocale(req.getSession(),localeFromRequest);

        ModelAndView model = new ModelAndView(PAGE_NAME);

        //LocaleUsage.setLocaleDatafromFile(model,servletContext.getRealPath(""),locale, PROPERTIES_NAME);//alternative to db to keep locales data in file


        //Prepare client data (fields to be shown on the screen)
        Integer userId = ((LoginController)req.getSession().getAttribute(LOGIN_CONTROLLER)).getUserId();
        List<Map<String,FieldAttribute>> clientData = fieldsTechSpec.getFieldsEditMode(userId, locale, 1, V_CONTACTS_TECH_SPEC,1);
        model.addObject("clientData", clientData);


        return model;
    }



}
