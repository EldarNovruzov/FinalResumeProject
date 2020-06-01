package com.company.controller;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.form.TemplateDiv;
import com.company.form.UserInformForResume;
import com.company.service.inter.EmploymentHistoryServiceInter;
import com.company.service.inter.SkillServiceInter;
import com.company.service.inter.UserServiceInter;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class GettingTemplateController {
    @Autowired
    private UserServiceInter userServiceInter;

    @Autowired
    private UserSkillServiceInter usi;

    @Autowired
    private SkillServiceInter skillServiceInter;

    @Autowired
    private EmploymentHistoryServiceInter ehsi;

    @RequestMapping(method = RequestMethod.POST, value = "/getAzerbaijan")
    public ModelAndView getAmsterdam(@ModelAttribute("userInform") UserInformForResume userInformForResume)
            throws Exception{
        ModelAndView mv=new ModelAndView("azerbaijan");

        User u = userServiceInter.getbyID(userInformForResume.getIdInform());
        if (u == null) {
            throw new IllegalArgumentException("There is no user with this id");
        }
        List<UserSkill> asu =usi.getAllSkillByUserId(userInformForResume.getIdInform());

        List<EmploymentHistory> ehsiList = ehsi.getallEmploymentHistorybyuserId(userInformForResume.getIdInform());

        mv.addObject("employmentHistoryListForCreateResume",ehsiList);
        mv.addObject("listSkill",asu);
        mv.addObject("user", u);


        return mv;
    }

    @ModelAttribute("templateDiv")
    public TemplateDiv div(){
        return new TemplateDiv();
    }

    @ModelAttribute("userInform")
    public UserInformForResume userInformForResume(){
        return new UserInformForResume();
    }

}
