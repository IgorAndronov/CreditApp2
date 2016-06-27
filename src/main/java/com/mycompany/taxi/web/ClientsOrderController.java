package com.mycompany.taxi.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.taxi.logic.Address;
import com.mycompany.taxi.logic.CarDetails;
import com.mycompany.taxi.logic.OrderDetails;
import com.mycompany.credit.web.LoginController;
import com.mycompany.credit.web.utils.LocaleUsage;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.mycompany.credit.web.utils.WebConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */

@Controller
public class ClientsOrderController {

    @Autowired
    OrderDetails orderDetails;

    public static final String PAGE_NAME=PUBLIC_PAGES_PATH+"taxi/clientorder";

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/order" , method = RequestMethod.GET)
    public ModelAndView getPage(@RequestParam Map<String,String> params, HttpServletRequest req) {

        String localeFromRequest=params.get("locale");
        String locale = LocaleUsage.setSessionLocale(req.getSession(), localeFromRequest);

        ModelAndView model = new ModelAndView(PAGE_NAME);

        Integer userId = (req.getSession().getAttribute(LOGIN_CONTROLLER))==null ? 0:((LoginController)req.getSession().getAttribute(LOGIN_CONTROLLER)).getUserId();

        //Prepare client data (fields to be shown on the screen)
        Map<String,Address> clientOrderData = orderDetails.getOrderDetails(userId);
        model.addObject("clientOrderData", clientOrderData);


        return model;
    }

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/order" , method = RequestMethod.POST)
    public @ResponseBody String setOrder(HttpServletRequest request, HttpServletResponse response) {

        String orderData="";
        try {
            orderData = IOUtils.toString(request.getInputStream(), "utf-8");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(orderData, new TypeReference<Map<String,String>>(){});

            OrderDetails orderDetails = new OrderDetails();
            Long orderId = orderDetails.setOrderDetails(map);

            return orderId.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

       return "";
    }

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/getCar" , method = RequestMethod.POST)
    public @ResponseBody String getCar(HttpServletRequest request, HttpServletResponse response) {

        String orderData="";
        try {
            orderData = IOUtils.toString(request.getInputStream(), "utf-8");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(orderData, new TypeReference<Map<String,String>>(){});

            OrderDetails orderDetails = new OrderDetails();
            CarDetails carDetails = orderDetails.getCar(Long.getLong(map.get("orderId")));

            String carDetailsJson = mapper.writeValueAsString(carDetails);
            return carDetailsJson;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}
