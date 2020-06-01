package com.company.controller;


import com.company.entity.User;
import com.company.entity.UserRole;
import com.company.form.UserDetailForm;
import com.company.form.UserForm;
import com.company.form.UserInformForResume;
import com.company.service.inter.UserRoleServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    UserServiceInter userServiceInter;

    @Autowired
    UserRoleServiceInter roleServiceInter;


    @RequestMapping(method = RequestMethod.GET,value = "/addUserByMenu")
    public ModelAndView forAdd(){

        ModelAndView mv=new ModelAndView("addUser");
//        mv.addObject("userRoleId",id);

        return mv;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/search")
    public ModelAndView forSearch( @ModelAttribute("user") UserForm us, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView("users");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
            String username = userPrincipal.getUsername();
            UserRole userRolebyEmail = roleServiceInter.findUserRolebyEmail(username);
            String roleName= userRolebyEmail.getRoleId().getRoleName();
            System.out.println("cavabim"+roleName);
            if( roleName.equals("ADMIN")){
                mv.addObject("userRoleAuthenticated",userRolebyEmail);
                List<User> userList= userServiceInter.getAllWithoutParameter();
                mv.addObject("list",userList);
                return mv;
            }
            List<User> userbyUserRoleId = userServiceInter.getUserbyUserRoleId(userRolebyEmail.getId());
            mv.addObject("userRoleAuthenticated",userRolebyEmail);
            mv.addObject("list",userbyUserRoleId);
            return mv;
        }
        return mv;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/menu")
    public ModelAndView forMenuGet(){
        ModelAndView mv=new ModelAndView("menu");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
            String username = userPrincipal.getUsername();
            UserRole userRolebyEmail = roleServiceInter.findUserRolebyEmail(username);
            mv.addObject("userRoleAuthenticated",userRolebyEmail);
        }

        return mv;
    }


    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }

    @ModelAttribute("us")
    public UserDetailForm getEmptyUserDetailForm(){
        return new UserDetailForm();
    }

    @ModelAttribute("userInform")
    public UserInformForResume userInformForResume(){
        return new UserInformForResume();
    }
}
