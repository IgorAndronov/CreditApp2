package com.mycompany.taxi.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.credit.web.utils.LocaleUsage;
import com.mycompany.taxi.logic.OrderDetails;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mycompany.credit.web.utils.WebConstants.PUBLIC_PAGES_PATH;

/**
 * Created by admin on 23.07.2016.
 */

@Controller
public class DriverServiceController {

    @Autowired
    OrderDetails orderDetails;

    public static final String PAGE_NAME=PUBLIC_PAGES_PATH+"taxi/drivermain";

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/driver/search" , method = RequestMethod.GET)
    public ModelAndView getMainSearchForm(@RequestParam Map<String,String> params, HttpServletRequest req){

        String localeFromRequest=params.get("locale");
        String locale = LocaleUsage.setSessionLocale(req.getSession(), localeFromRequest);

        ModelAndView model = new ModelAndView(PAGE_NAME);


       return model;
    }

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/driver/alldata" , method = RequestMethod.POST)
    public @ResponseBody
    String getAllData(HttpServletRequest request, HttpServletResponse response) {

        String inputData="";
        try {
            inputData = IOUtils.toString(request.getInputStream(), "utf-8");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> inputMap = mapper.readValue(inputData, new TypeReference<Map<String,String>>(){});
            System.out.println("!!!!!!!!"+inputMap);

            Map<String,List<String>> resultData = orderDetails.getDataForLov(inputMap);

            String allDataJson = mapper.writeValueAsString(resultData);
            return allDataJson;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
