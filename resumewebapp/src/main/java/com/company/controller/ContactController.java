package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @RequestMapping(method = RequestMethod.GET, value = "getContact")
    public ModelAndView getContact(){
        ModelAndView mv=new ModelAndView("contact");
        return mv;
    }
}
