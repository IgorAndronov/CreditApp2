package com.mycompany.credit.web;

import com.mycompany.credit.dao.interfaces.DictionaryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BaseController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "public/login_tmp";

    @Autowired
    private ApplicationContext appContext;

    @Resource(name = "DictionaryAddressServiceImpl")
    private DictionaryAddressService dictionaryAddressService;



    @RequestMapping(value = "/test.html", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        System.out.println();
        System.out.println("appContext="+appContext);


        System.out.println("!!!dictionaryAddressService=" + dictionaryAddressService);

        System.out.println("!!!list=" + dictionaryAddressService.getListStreetType("").size());


        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);


        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

//    @RequestMapping(value = "/public/{name}", method = RequestMethod.GET)
//    public String welcomeName(@PathVariable String name, ModelMap model) {
//
//        model.addAttribute("message", "Welcome " + name);
//        model.addAttribute("counter", ++counter);
//
//        return VIEW_INDEX;
//
//    }


    public DictionaryAddressService getDictionaryAddressService() {
        return dictionaryAddressService;
    }

    public void setDictionaryAddressService(DictionaryAddressService dictionaryAddressService) {
        this.dictionaryAddressService = dictionaryAddressService;
    }
}