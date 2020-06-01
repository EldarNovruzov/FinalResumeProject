package com.company.controller;

import com.company.entity.Role;
import com.company.entity.UserRole;
import com.company.form.SignUpForm;
import com.company.service.inter.UserRoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    @Autowired
    public UserRoleServiceInter userRoleServiceInter;

    @RequestMapping(method = RequestMethod.GET, value = "/sign")
    public ModelAndView getSignUpPage(){
        ModelAndView mv=new ModelAndView("signUp");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUpController")
    public ModelAndView setSignUpParameter(@ModelAttribute("signUpForm") SignUpForm signUp){
        ModelAndView m=new ModelAndView("signUp");

        if (signUp.getName()!=null && signUp.getSurname()!=null
                &&signUp.getEmail()!=null
                &&signUp.getPassword()!=null && !signUp.getName().trim().isEmpty() && !signUp.getSurname().trim().isEmpty()
        && !signUp.getEmail().trim().isEmpty() && !signUp.getPassword().trim().isEmpty()){
            ModelAndView mv=new ModelAndView("login");

            Role r=new Role();
            r.setRoleName(signUp.getRole());

            UserRole ur=new UserRole();
            ur.setName(signUp.getName());
            ur.setSurname(signUp.getSurname());
            ur.setEmail(signUp.getEmail());
            ur.setPassword(signUp.getPassword());
            ur.setRoleId(r);

                UserRole userRolebyEmail = userRoleServiceInter.findUserRolebyEmail(ur.getEmail());
                if(userRolebyEmail!=null){
                    return m;
                }

                userRoleServiceInter.addUserRole(ur);

                return mv;
        }
        return m;
    }

    @ModelAttribute("signUpForm")
    public SignUpForm getSignUpForm(){
        return new SignUpForm();
    }
}
