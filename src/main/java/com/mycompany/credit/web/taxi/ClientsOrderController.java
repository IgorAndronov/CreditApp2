package com.mycompany.credit.web.taxi;

import com.mycompany.credit.logic.taxi.Address;
import com.mycompany.credit.logic.taxi.OrderDetails;
import com.mycompany.credit.web.LoginController;
import com.mycompany.credit.web.utils.LocaleUsage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.mycompany.credit.web.utils.WebConstants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */

@Controller
public class ClientsOrderController {

    public static final String PAGE_NAME=PUBLIC_PAGES_PATH+"taxi/clientorder";

    @RequestMapping(value = PUBLIC_PAGES_PATH+"taxi/order" , method = RequestMethod.GET)
    public ModelAndView getPage(@RequestParam Map<String,String> params, HttpServletRequest req) {

        String localeFromRequest=params.get("locale");
        String locale = LocaleUsage.setSessionLocale(req.getSession(), localeFromRequest);

        ModelAndView model = new ModelAndView(PAGE_NAME);

        Integer userId = (req.getSession().getAttribute(LOGIN_CONTROLLER))==null ? 0:((LoginController)req.getSession().getAttribute(LOGIN_CONTROLLER)).getUserId();

        //Prepare client data (fields to be shown on the screen)
        OrderDetails orderDetails = new OrderDetails();
        Map<String,Address> clientOrderData = orderDetails.getOrderDetails(userId);
        model.addObject("clientOrderData", clientOrderData);


        return model;
    }


}
