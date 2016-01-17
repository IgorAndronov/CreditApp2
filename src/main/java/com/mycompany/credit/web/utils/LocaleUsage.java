package com.mycompany.credit.web.utils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.mycompany.credit.commons.Constants.*;
import static com.mycompany.credit.commons.Constants.LOCALES_REL_PATH_UKR;
import static com.mycompany.credit.commons.Constants.LOCALE_VAL_UKR;

/**
 * Created by igor on 24.08.15.
 */
public class LocaleUsage {

    final static Logger logger = Logger.getLogger(LocaleUsage.class);

   public static String setSessionLocale(HttpSession session, String localeFromRequest){
    String locale;
       if(localeFromRequest !=null){
           session.setAttribute("locale", localeFromRequest);
           locale=localeFromRequest;
       }else {
           locale = (String) session.getAttribute("locale");
       }
       if(locale==null){
           //default locale
           locale=LOCALE_VAL_RU;
       }

       return locale;

    }

   public static String getLocalePath(String locale){
        String localePath =LOCALES_REL_PATH_EN; //default
        if(locale.equals(LOCALE_VAL_RU)){
            localePath=LOCALES_REL_PATH_RU;
        };
        if(locale.equals(LOCALE_VAL_UKR)){
            localePath=LOCALES_REL_PATH_UKR;
        };
        return localePath;
    }

    /**
     * sets data from properties file of specific locale to model
     *
     */
    public static void setLocaleDatafromFile(ModelAndView model, String realPath, String locale, String properiesFileName){

        String relativePath=getLocalePath(locale);
        String localePath = realPath + relativePath;

        Map<String, String> localeData = new HashMap<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(localePath+properiesFileName));
            String line =br.readLine();
            while(line !=null){
                int equalPosition = line.indexOf("=");
                localeData.put(line.substring(0,equalPosition), line.substring(equalPosition+1));
                line=br.readLine();
            }
            System.out.println(localeData);

            for(String keyVal:localeData.keySet()){
                model.addObject(keyVal,localeData.get(keyVal));
            }


        } catch (Exception e) {
            logger.error(e.getMessage());

        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

    }
}
