package com.company.controller;


import com.company.entity.User;
import com.company.entity.UserRole;
import com.company.form.UserDetailForm;
import com.company.form.UserForm;
import com.company.form.UserInformForResume;
import com.company.service.DummyService;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userServiceInter;

    @Autowired
    UserRoleServiceInter roleServiceInter;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//
//        String name=request.getParameter("name");
//        String surname=request.getParameter("surname");
//        String nationId=request.getParameter("nationalityId");
//
//        Integer nationalityIdbyRequest=null;
//        if (nationId!=null && !nationId.trim().isEmpty()){
//            nationalityIdbyRequest=Integer.parseInt(nationId);
//        }
//        List<User> list= userServiceInter.getAll(name,surname,nationalityIdbyRequest);
//        request.setAttribute("list",list);
//
//        return "users";
//    }

    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public ModelAndView index(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "surname",required = false) String surname,
            @RequestParam(value = "nationalityId",required = false) Integer nationalityIdbyRequest
    ){
        List<User> list= userServiceInter.getAll(name,surname,nationalityIdbyRequest);

        ModelAndView mv=new ModelAndView("users");

        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/usersM")
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm us, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView("users");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
            String username = userPrincipal.getUsername();
            UserRole userRolebyEmail = roleServiceInter.findUserRolebyEmail(username);
            String roleName= userRolebyEmail.getRoleId().getRoleName();
            System.out.println("cavabim"+roleName);
            if( roleName.equals("ADMIN")){
//                mv.addObject("userRoleAuthenticated",userRolebyEmail);
                List<User> list= userServiceInter.getAll(us.getName(),us.getSurname(),us.getNationalityIdbyRequest());
                mv.addObject("list",list);
                return mv;
            }

            List<User> list= userServiceInter.getAll(us.getName(),us.getSurname(),us.getNationalityIdbyRequest());
            List<User> userbyUserRoleId = userServiceInter.getUserbyUserRoleId(userRolebyEmail.getId());

            List<User> afterCondition=new ArrayList<>();
            for (int i=0;i<list.size();i++) {
                for (int j=0; j<userbyUserRoleId.size();j++) {
                    if (list.get(i).getId().toString().equals(userbyUserRoleId.get(j).getId().toString())) {
                        afterCondition.add(list.get(i));
                    }
                }
            }
//            mv.addObject("userRoleAuthenticated",userRolebyEmail);
            mv.addObject("list",afterCondition);
            return mv;
        }
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public  String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public  String logoutPage(){
        return "logout";
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET, value = "/foo")
    public  String foo(){
        System.out.println("foo in controller");
        dummyService.foo();
        return "users";
    }

    @ModelAttribute("us")
    public UserDetailForm getEmptyUserDetailForm(){
        return new UserDetailForm();
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }

    @ModelAttribute("userInform")
    public UserInformForResume userInformForResume(){
        return new UserInformForResume();
    }

}
