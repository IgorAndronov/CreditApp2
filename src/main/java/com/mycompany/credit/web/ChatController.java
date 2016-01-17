package com.mycompany.credit.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.mycompany.credit.web.utils.WebConstants.*;

/**
 * Created by igor on 31.07.15.
 */
@Controller
public class ChatController {

    private static final String CHAT_PAGE = "public/chat";

    @RequestMapping(value = "/"+CHAT_CONTROLLER, method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest req) {
        ModelAndView model = new ModelAndView(CHAT_PAGE);
        System.out.println("nickname is " +((LoginController)req.getSession().getAttribute(LOGIN_CONTROLLER)).getNickName() );

        model.addObject("nickname", ((LoginController)req.getSession().getAttribute(LOGIN_CONTROLLER)).getNickName());

        return model;
    }
}
