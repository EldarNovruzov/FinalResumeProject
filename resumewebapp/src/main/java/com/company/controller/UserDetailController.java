package com.company.controller;


import com.company.entity.*;
import com.company.form.*;
import com.company.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userServiceInter;

    @Autowired
    private UserSkillServiceInter usi;

    @Autowired
    private LanguageServiceInter languageServiceInter;

    @Autowired
    private SkillServiceInter skillServiceInter;

    @Autowired
    private EmploymentHistoryServiceInter ehsi;

    @Autowired
    private CountryServiceInter countryServiceInter;

    @Autowired
    private UserRoleServiceInter roleServiceInter;

    @Autowired
    private UserLanguageServiceInter userLanguageServiceInter;

    @Autowired
    private CourseServiceInter courseServiceInter;

    @Autowired
    private EducationHistoryServiceInter educationHistoryServiceInter;

    @Autowired
    private ExtraCurricularServiceInter extraCurricularServiceInter;

    @Autowired
    private SocialLinkServiceInter socialLinkServiceInter;

    @Autowired
    private ReferenceServiceInter referenceServiceInter;

    @RequestMapping(method = RequestMethod.GET,value ="/addUserOneByOne")
    public ModelAndView add(
                            @RequestParam(value = "name",required = true) String name,
                            @RequestParam(value = "surname",required = false) String surname,
                            @RequestParam(value = "address",required = false) String address,
                            @RequestParam(value = "birthDate",required = false) String birthDate,
                            @RequestParam(value = "country",required = false) String country,
                            @RequestParam(value = "email",required = false) String email,
                            @RequestParam(value = "nationality",required = false) String nationality,
                            @RequestParam(value = "phone",required = false) String phone,
                            @RequestParam(value = "powerInputs[]",required = false) List<String> power,
                            @RequestParam(value = "profileDescription",required = false) String profileDescription,
                            @RequestParam(value = "skillNameInputs[]",required = false) List<String> skillName,
                            @RequestParam(value = "employmentHistoryHeaderInputs[]",required = false) List<String> employmentHistoryHeader,
                            @RequestParam(value = "employmentHistoryBeginDateInputs[]",required = false) List<String> employmentHistoryBeginDate,
                            @RequestParam(value = "employmentHistoryEndDateInputs[]",required = false) List<String> employmentHistoryEndDate,
                            @RequestParam(value = "employmentHistoryJobDescriptionInputs[]",required = false) List<String> employmentHistoryJobDescription,
                            @RequestParam(value = "hobby",required = false) String hobby,
                            @RequestParam(value = "courseNameInputs[]", required = false) List<String> courseName,
                            @RequestParam(value = "institutionInputs[]", required = false) List<String> institution,
                            @RequestParam(value = "courseBeginDateInputs[]",required = false) List<String> courseBeginDate,
                            @RequestParam(value = "courseEndDateInputs[]",required = false) List<String> courseEndDate,
                            @RequestParam(value = "universityNameInputs[]",required = false) List<String> universityName,
                            @RequestParam(value = "degreeInputs[]",required = false) List<String> universityDegree,
                            @RequestParam(value = "educationBeginDateInputs[]", required = false) List<String> educationBeginDate,
                            @RequestParam(value = "educationEndDateInputs[]", required = false) List<String> educationEndDate,
                            @RequestParam(value = "locatedPlaceInputs[]",required = false) List<String> locatedPlace,
                            @RequestParam(value = "educationDescriptionInputs[]", required = false) List<String> educationDescription,
                            @RequestParam(value = "functionTitleInputs[]", required = false) List<String> extraFunctionTitle,
                            @RequestParam(value = "employerInputs[]",required = false) List<String> extraEmployer,
                            @RequestParam(value = "extraBeginDateInputs[]", required = false) List<String> extraBeginDate,
                            @RequestParam(value = "extraEndDateInputs[]", required = false) List<String> extraEndDate,
                            @RequestParam(value = "cityInputs[]", required = false) List<String> extraCity,
                            @RequestParam(value = "extraDescriptionInputs[]", required = false) List<String> extraDesc,
                            @RequestParam(value = "linkLabelInputs[]", required = false) List<String> linkLabel,
                            @RequestParam(value = "linkInputs[]", required = false) List<String> link,
                            @RequestParam(value = "referentNameInputs[]", required = false) List<String> referentName,
                            @RequestParam(value = "companyInputs[]", required = false) List<String> referentCompany,
                            @RequestParam(value = "phoneInputs[]", required = false) List<String> referentPhone,
                            @RequestParam(value = "emailInputs[]", required = false) List<String> referentEmail,
                            @RequestParam(value = "languageNameInputs[]", required = false) List<String> languageName,
                            @RequestParam(value = "languageLevelInputs[]", required = false) List<String> languageLevel
                            ) throws Exception{

        ModelAndView mv=new ModelAndView("addUser");
        User user=new User();



        //skill List
        List<Skill> skillListAfter=new ArrayList<>();
        Skill skill=null;
        if(skillName.size()!=0) {
            for (String skillNameAfter : skillName) {
                if (!skillNameAfter.trim().isEmpty()) {
                    skill = new Skill();
                    skill.setName(skillNameAfter);
                    skillListAfter.add(skill);
                }else {
                    skill = new Skill();
                    skill.setName(null);
                    skillListAfter.add(skill);
                }
            }
        }else {
            skill = new Skill();
            skill.setName(null);
            skillListAfter.add(skill);
        }

        List<UserSkill> skillList= new ArrayList<>();

        UserSkill userSkill=null;
        if(power.size()!=0) {
            for (String powerAfter : power) {
                if(!powerAfter.trim().isEmpty()) {
                    userSkill = new UserSkill();

                    userSkill.setPower(Integer.parseInt(powerAfter));

                    skillList.add(userSkill);
                }else {
                    userSkill = new UserSkill();
                    userSkill.setPower(null);
                    skillList.add(userSkill);
                }
            }
        }else {
            userSkill = new UserSkill();
            userSkill.setPower(null);
            skillList.add(userSkill);
        }
        int i = 0;
            for(Skill ss: skillListAfter) {
                UserSkill use=skillList.get(i);
                use.setUser(user);
                use.setSkill(ss);
                i++;
            }
        user.setUserSkillList(skillList);
            //skill List



            //userLanguage
            List<Language> languageList=new ArrayList<>();
            Language language=null;
            if(languageName.size()!=0) {
                for (String ln1 : languageName) {
                    if(!ln1.trim().isEmpty()) {
                        language = new Language();
                        language.setName(ln1);
                        languageList.add(language);
                    }else {
                        language = new Language();
                        language.setName(null);
                        languageList.add(language);
                    }
                }
            }else {
                language = new Language();
                language.setName(null);
                languageList.add(language);
            }


            List<UserLanguage> userLanguageList=new ArrayList<>();
            UserLanguage userLanguage=null;
            if(languageLevel.size()!=0) {
                for (String ln2 : languageLevel) {
                    if(!ln2.trim().isEmpty()) {
                        userLanguage = new UserLanguage();
                        userLanguage.setLanguageLevel(Integer.parseInt(ln2));
                        userLanguageList.add(userLanguage);
                    }else {
                        userLanguage = new UserLanguage();
                        userLanguage.setLanguageLevel(null);
                        userLanguageList.add(userLanguage);
                    }
                }
            }else {
                userLanguage = new UserLanguage();
                userLanguage.setLanguageLevel(null);
                userLanguageList.add(userLanguage);
            }

            int jhk=0;
            for(Language lg: languageList){
                UserLanguage ln4 = userLanguageList.get(jhk);
                ln4.setLanguageId(lg);
                ln4.setUserId(user);
                jhk++;
            }

            user.setUserLanguageList(userLanguageList);
            //userLanguage




            //employment history
        List<EmploymentHistory> historyList=new ArrayList<>();
        EmploymentHistory employmentHistory=null;

        if(employmentHistoryHeader.size()!=0) {
            for (String ehd : employmentHistoryHeader) {
                if(!ehd.trim().isEmpty()) {
                    employmentHistory = new EmploymentHistory();
                    employmentHistory.setHeader(ehd);
                    historyList.add(employmentHistory);
                }else {
                    employmentHistory = new EmploymentHistory();
                    employmentHistory.setHeader(null);
                    historyList.add(employmentHistory);
                }
            }
        }else {
            employmentHistory = new EmploymentHistory();
            employmentHistory.setHeader(null);
            historyList.add(employmentHistory);
        }

        int jeq=0;
        if(employmentHistoryJobDescription.size()!=0) {
            for (String ehjd : employmentHistoryJobDescription) {
                if(!ehjd.trim().isEmpty()) {
                    EmploymentHistory history = historyList.get(jeq);
                    history.setJobDescription(ehjd);
                    jeq++;
                }else {
                    EmploymentHistory history = historyList.get(jeq);
                    history.setJobDescription(null);
                    jeq++;
                }
            }
        }else {
            EmploymentHistory history = historyList.get(jeq);
            history.setJobDescription(null);
            jeq++;
        }

        List<Date> begin=new ArrayList<>();
        List<Date> end=new ArrayList<>();

        if(employmentHistoryBeginDate.size()!=0) {
            for (String beginAfter : employmentHistoryBeginDate) {
                if(!beginAfter.trim().isEmpty()) {
                    Date employmentHistoryBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(beginAfter);
                    begin.add(employmentHistoryBeginDateParse);
                }else {
                    begin.add(null);
                }
            }
        }else {
            begin.add(null);
        }

        if(employmentHistoryEndDate.size()!=0) {
            for (String endAfter : employmentHistoryEndDate) {
                if(!endAfter.trim().isEmpty()) {
                    Date employmentHistoryEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(endAfter);
                    end.add(employmentHistoryEndDateParse);
                }else {
                    end.add(null);
                }
            }
        }else {
            end.add(null);
        }

        int k=0;
        for (Date bgn: begin){
            EmploymentHistory history=historyList.get(k);
            history.setBeginDate(bgn);
            k++;
        }

        int m=0;
        for (Date ed: end){
            EmploymentHistory history=historyList.get(m);
            history.setEndDate(ed);
            m++;
        }


        for(EmploymentHistory elt:historyList ) {
            elt.setUser(user);
        }

        user.setEmploymentHistoryList(historyList);
        //employment history



        //country
        Country userCountry=new Country();
        userCountry.setName(country);
        userCountry.setNationality(nationality);
        user.setBirthplace(userCountry);
        user.setNationality(userCountry);

        //country


        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setEmail(email);
        if(!birthDate.trim().isEmpty()) {
            Date birthDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            user.setBirthDate(birthDateParse);
        }else {
            user.setBirthDate(null);
        }
        user.setPhone(phone);
        user.setProfileDesc(profileDescription);
        user.setUserHobby(hobby);





        //course List
        List<Course> courseList = new ArrayList<>();
        Course c = null;
        if(courseName.size()!=0) {
            for (String course : courseName) {
                if(!course.trim().isEmpty()) {
                    c = new Course();
                    c.setCourseName(course);
                    courseList.add(c);
                }else {
                    c = new Course();
                    c.setCourseName(null);
                    courseList.add(c);
                }
            }
        }else {
            c = new Course();
            c.setCourseName(null);
            courseList.add(c);
        }

        int jk = 0;
        if(institution.size()!=0) {
            for (String str : institution) {
                if(!str.trim().isEmpty()) {
                    Course crs = courseList.get(jk);
                    crs.setInstitution(str);
                    jk++;
                }else {
                    Course crs = courseList.get(jk);
                    crs.setInstitution(null);
                    jk++;
                }
            }
        }else {
            Course crs = courseList.get(jk);
            crs.setInstitution(null);
            jk++;
        }
        List<Date> b1 = new ArrayList<>();
        List<Date> e1 = new ArrayList<>();

        if(courseBeginDate.size()!=0) {
            for (String begin1 : courseBeginDate) {
                if(!begin1.trim().isEmpty()) {
                    Date courseBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(begin1);
                    b1.add(courseBeginDateParse);
                }else {
                    b1.add(null);
                }
            }
        }else {
            b1.add(null);
        }

        if(courseEndDate.size()!=0) {
            for (String end1 : courseEndDate) {
                if(!end1.trim().isEmpty()) {
                    Date courseEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(end1);
                    e1.add(courseEndDateParse);
                }else {
                    e1.add(null);
                }
            }
        }else {
            e1.add(null);
        }

        int kj2=0;
        for (Date bgn2: b1){
            Course cou = courseList.get(kj2);
            cou.setBeginDate(bgn2);
            kj2++;
        }

        int lk=0;
        for (Date ed2: e1){
            Course cour = courseList.get(lk);
            cour.setEndDate(ed2);
            lk++;
        }

        for( Course crr:courseList ) {
            crr.setUserId(user);
        }

        user.setCourseList(courseList);
        //course list


        //education History
        List<EducationHistory> educationHistories=new ArrayList<>();
        EducationHistory educationHistory=null;

        if(universityName.size()!=0) {
            for (String a1 : universityName) {
                if(!a1.trim().isEmpty()) {
                    educationHistory = new EducationHistory();
                    educationHistory.setEducationHeader(a1);
                    educationHistories.add(educationHistory);
                }else {
                    educationHistory = new EducationHistory();
                    educationHistory.setEducationHeader(null);
                    educationHistories.add(educationHistory);
                }
            }
        }else {
            educationHistory = new EducationHistory();
            educationHistory.setEducationHeader(null);
            educationHistories.add(educationHistory);
        }

        int h1=0;
        if(universityDegree.size()!=0) {
            for (String a2 : universityDegree) {
                if(!a2.trim().isEmpty()) {
                    EducationHistory educationHistory1 = educationHistories.get(h1);
                    educationHistory1.setEducationDegree(a2);
                    h1++;
                }else {
                    EducationHistory educationHistory1 = educationHistories.get(h1);
                    educationHistory1.setEducationDegree(null);
                    h1++;
                }
            }
        }else {
            EducationHistory educationHistory1 = educationHistories.get(h1);
            educationHistory1.setEducationDegree(null);
            h1++;
        }

        int h4=0;
        if(locatedPlace.size()!=0) {
            for (String u2 : locatedPlace) {
                if(!u2.trim().isEmpty()) {
                    EducationHistory educationPlace = educationHistories.get(h4);
                    educationPlace.setLocatedPlace(u2);
                    h4++;
                }else {
                    EducationHistory educationPlace = educationHistories.get(h4);
                    educationPlace.setLocatedPlace(null);
                    h4++;
                }
            }
        }else {
            EducationHistory educationPlace = educationHistories.get(h4);
            educationPlace.setLocatedPlace(null);
            h4++;
        }

        int h5=0;
        if(educationDescription.size()!=0) {
            for (String educationDesc : educationDescription) {
                if(!educationDesc.trim().isEmpty()) {
                    EducationHistory rr4 = educationHistories.get(h5);
                    rr4.setEducationDescription(educationDesc);
                    h5++;
                }else {
                    EducationHistory rr4 = educationHistories.get(h5);
                    rr4.setEducationDescription(null);
                    h5++;
                }
            }
        }else {
            EducationHistory rr4 = educationHistories.get(h5);
            rr4.setEducationDescription(null);
            h5++;
        }

        List<Date> educationBegin=new ArrayList<>();
        List<Date> educationEnd=new ArrayList<>();

        if(educationBeginDate.size()!=0) {
            for (String a3 : educationBeginDate) {
                if(!a3.trim().isEmpty()) {
                    Date educationBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(a3);
                    educationBegin.add(educationBeginDateParse);
                }else {
                    educationBegin.add(null);
                }
            }
        }else {
            educationBegin.add(null);
        }

        if(educationEndDate.size()!=0) {
            for (String a4 : educationEndDate) {
                if(!a4.trim().isEmpty()) {
                    Date educationEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(a4);
                    educationEnd.add(educationEndDateParse);
                }else {
                    educationEnd.add(null);
                }
            }
        }else {
            educationEnd.add(null);
        }

        int h2=0;
        for(Date dr: educationBegin){
            EducationHistory er1 = educationHistories.get(h2);
            er1.setBeginDate(dr);
            h2++;
        }

        int h3=0;
        for(Date dr1: educationEnd){
            EducationHistory er2 = educationHistories.get(h3);
            er2.setEndDate(dr1);
            h3++;
        }

        for(EducationHistory erm: educationHistories){
            erm.setUserId(user);
        }

        user.setEducationHistoryList(educationHistories);
        //education History




        //Extra Curricular
        List<ExtraCurricularActivities> curricularActivitiesList=new ArrayList<>();
        ExtraCurricularActivities curricularActivities=null;
        if(extraFunctionTitle.size()!=0) {
            for (String ss : extraFunctionTitle) {
                if(!ss.trim().isEmpty()) {
                    curricularActivities = new ExtraCurricularActivities();
                    curricularActivities.setActivitiesHeader(ss);
                    curricularActivitiesList.add(curricularActivities);
                }else {
                    curricularActivities = new ExtraCurricularActivities();
                    curricularActivities.setActivitiesHeader(null);
                    curricularActivitiesList.add(curricularActivities);
                }
            }
        }else {
            curricularActivities = new ExtraCurricularActivities();
            curricularActivities.setActivitiesHeader(null);
            curricularActivitiesList.add(curricularActivities);
        }

        int gg1=0;
        if(extraEmployer.size()!=0) {
            for (String ss2 : extraEmployer) {
                if(!ss2.trim().isEmpty()) {
                    ExtraCurricularActivities activities = curricularActivitiesList.get(gg1);
                    activities.setEmployer(ss2);
                    gg1++;
                }else {
                    ExtraCurricularActivities activities = curricularActivitiesList.get(gg1);
                    activities.setEmployer(null);
                    gg1++;
                }
            }
        }else {
            ExtraCurricularActivities activities = curricularActivitiesList.get(gg1);
            activities.setEmployer(null);
            gg1++;
        }

        int gg2=0;
        if(extraCity.size()!=0) {
            for (String ss3 : extraCity) {
                if(!ss3.trim().isEmpty()) {
                    ExtraCurricularActivities activities2 = curricularActivitiesList.get(gg2);
                    activities2.setCityName(ss3);
                    gg2++;
                }else {
                    ExtraCurricularActivities activities2 = curricularActivitiesList.get(gg2);
                    activities2.setCityName(null);
                    gg2++;
                }
            }
        }else {
            ExtraCurricularActivities activities2 = curricularActivitiesList.get(gg2);
            activities2.setCityName(null);
            gg2++;
        }

        int gg3=0;
        if(extraDesc.size()!=0) {
            for (String ss4 : extraDesc) {
                if(!ss4.trim().isEmpty()) {
                    ExtraCurricularActivities activities3 = curricularActivitiesList.get(gg3);
                    activities3.setActivitiesDescription(ss4);
                    gg3++;
                }else {
                    ExtraCurricularActivities activities3 = curricularActivitiesList.get(gg3);
                    activities3.setActivitiesDescription(null);
                    gg3++;
                }
            }
        }else {
            ExtraCurricularActivities activities3 = curricularActivitiesList.get(gg3);
            activities3.setActivitiesDescription(null);
            gg3++;
        }

        List<Date> extraCurricularBeginDate=new ArrayList<>();
        List<Date> extraCurricularEndDate=new ArrayList<>();

        if(extraBeginDate.size()!=0) {
            for (String ss5 : extraBeginDate) {
                if(!ss5.trim().isEmpty()) {
                    Date extraBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(ss5);
                    extraCurricularBeginDate.add(extraBeginDateParse);
                }else {
                    extraCurricularBeginDate.add(null);
                }
            }
        }else {
            extraCurricularBeginDate.add(null);
        }

        if(extraEndDate.size()!=0) {
            for (String ss6 : extraEndDate) {
                if(!ss6.trim().isEmpty()) {
                    Date extraEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(ss6);
                    extraCurricularEndDate.add(extraEndDateParse);
                }else {
                    extraCurricularEndDate.add(null);
                }
            }
        }else {
            extraCurricularEndDate.add(null);
        }

        int gg4=0;
        for(Date ss7: extraCurricularBeginDate){
            ExtraCurricularActivities activities4 = curricularActivitiesList.get(gg4);
            activities4.setBeginDate(ss7);
            gg4++;
        }

        int gg5=0;
        for(Date ss8: extraCurricularEndDate){
            ExtraCurricularActivities activities5 = curricularActivitiesList.get(gg5);
            activities5.setEndDate(ss8);
            gg5++;
        }

        for(ExtraCurricularActivities rxcra: curricularActivitiesList){
            rxcra.setUserId(user);
        }

        user.setExtraCurricularActivitiesList(curricularActivitiesList);
        //extra Curricular Activities


        //social Link
        List<SocialLink> socialLinkList=new ArrayList<>();
        SocialLink socialLink=null;

        if(linkLabel.size()!=0) {
            for (String rr1 : linkLabel) {
                if(!rr1.trim().isEmpty()) {
                    socialLink = new SocialLink();
                    socialLink.setLabel(rr1);
                    socialLinkList.add(socialLink);
                }else {
                    socialLink = new SocialLink();
                    socialLink.setLabel(null);
                    socialLinkList.add(socialLink);
                }
            }
        }else {
            socialLink = new SocialLink();
            socialLink.setLabel(null);
            socialLinkList.add(socialLink);
        }

        int fg=0;
        if(link.size()!=0) {
            for (String rr2 : link) {
                if(!rr2.trim().isEmpty()) {
                    SocialLink link1 = socialLinkList.get(fg);
                    link1.setLink(rr2);
                    fg++;
                }else {
                    SocialLink link1 = socialLinkList.get(fg);
                    link1.setLink(null);
                    fg++;
                }
            }
        }else {
            SocialLink link1 = socialLinkList.get(fg);
            link1.setLink(null);
            fg++;
        }

        for(SocialLink sc:socialLinkList){
            sc.setUserId(user);
        }

        user.setSocialLinkList(socialLinkList);
        //social Link


        //reference
        List<Reference> referenceList=new ArrayList<>();
        Reference reference=null;

        if(referentName.size()!=0) {
            for (String qe1 : referentName) {
                if(!qe1.trim().isEmpty()) {
                    reference = new Reference();
                    reference.setReferentFullName(qe1);
                    referenceList.add(reference);
                }else {
                    reference = new Reference();
                    reference.setReferentFullName(null);
                    referenceList.add(reference);
                }
            }
        }else {
            reference = new Reference();
            reference.setReferentFullName(null);
            referenceList.add(reference);
        }

        int gh1=0;
        if(referentCompany.size()!=0) {
            for (String qe2 : referentCompany) {
                if(!qe2.trim().isEmpty()) {
                    Reference rfr1 = referenceList.get(gh1);
                    rfr1.setReferentCompanyName(qe2);
                    gh1++;
                }else {
                    Reference rfr1 = referenceList.get(gh1);
                    rfr1.setReferentCompanyName(null);
                    gh1++;
                }
            }
        }else {
            Reference rfr1 = referenceList.get(gh1);
            rfr1.setReferentCompanyName(null);
            gh1++;
        }

        int gh2=0;
        if(referentPhone.size()!=0) {
            for (String qe3 : referentPhone) {
                if(!qe3.trim().isEmpty()) {
                    Reference rfr2 = referenceList.get(gh2);
                    rfr2.setReferentPhone(qe3);
                    gh2++;
                }else {
                    Reference rfr2 = referenceList.get(gh2);
                    rfr2.setReferentPhone(null);
                    gh2++;
                }
            }
        }else {
            Reference rfr2 = referenceList.get(gh2);
            rfr2.setReferentPhone(null);
            gh2++;
        }

        int gh3=0;
        if(referentEmail.size()!=0) {
            for (String qe4 : referentEmail) {
                if(!qe4.trim().isEmpty()) {
                    Reference rfr3 = referenceList.get(gh3);
                    rfr3.setReferentEmail(qe4);
                    gh3++;
                }else {
                    Reference rfr3 = referenceList.get(gh3);
                    rfr3.setReferentEmail(null);
                    gh3++;
                }
            }
        }else {
            Reference rfr3 = referenceList.get(gh3);
            rfr3.setReferentEmail(null);
            gh3++;
        }

        for(Reference refer: referenceList){
            refer.setUserId(user);
        }

        user.setReferenceList(referenceList);
        //reference


        //additional
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
            String username = userPrincipal.getUsername();
            UserRole userRolebyEmail = roleServiceInter.findUserRolebyEmail(username);
            user.setUserRoleId(userRolebyEmail);
        }
//        UserRole urbi = roleServiceInter.findUserRolebyId(authorId);

        userServiceInter.addUser(user);
//mv.addObject("userRoleId",authorId);
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST,value ="/userdelete")
    public ModelAndView userDetailIndex(@ModelAttribute("userDeleteForm") UserDeleteForm deleteForm,
                                        @RequestParam(value = "id") Integer id){
        courseServiceInter.removeCoursebyUserId(id);
        educationHistoryServiceInter.removeEducationHistorybyUserId(id);
        extraCurricularServiceInter.removeExtraCurricularbyUserId(id);
        referenceServiceInter.removeReferencebyUserId(id);
        socialLinkServiceInter.removeSocialLinkbyUserId(id);
        List<UserLanguage> allLanguageByUserId = userLanguageServiceInter.getAllLanguageByUserId(id);
        for(UserLanguage ss: allLanguageByUserId) {
            Language languageId = ss.getLanguageId();
            languageServiceInter.removeLanguage(languageId.getId());
        }
        userLanguageServiceInter.removeUserLanguagebyUserId(id);

        List<UserSkill> allSkillByUserId = usi.getAllSkillByUserId(id);
        for(UserSkill sdf: allSkillByUserId){
            Skill skill = sdf.getSkill();
            skillServiceInter.removeSkill(skill.getId());
        }
        usi.removeUserSkillbyUserId(id);

        ehsi.removeEmploymentHistorybyUserId(id);

        userServiceInter.removeUser(id);

        ModelAndView mv=new ModelAndView("menu");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST,value ="/userupdate")
    public ModelAndView userDetailUpdateIndex(@ModelAttribute("userUpdateForm") UserUpdateForm updateForm,
                                              @RequestParam(value = "name",required = false) String name,
                                              @RequestParam(value= "surname",required = false) String surname,
                                              @RequestParam(value = "email",required = false) String email,
                                              @RequestParam(value = "phone",required = false) String phone,
                                              @RequestParam(value = "address",required = false) String address,
                                              @RequestParam(value = "birthDate",required = false) String birthDate,
                                              @RequestParam(value = "country",required = false) String country,
                                              @RequestParam(value = "nationality",required = false) String nationality,
                                              @RequestParam(value = "profileDescription",required = false) String profileDescription,
                                              @RequestParam(value = "hobby",required = false) String hobby,
                                              @RequestParam(value = "courseName",required = false) List<String> courseName,
                                              @RequestParam(value = "courseInstitution",required = false) List<String> courseInstitution,
                                              @RequestParam(value = "courseBeginDate",required = false) List<String> courseBeginDate,
                                              @RequestParam(value = "courseEndDate",required = false) List<String> courseEndDate,
                                              @RequestParam(value = "educationHeader",required = false) List<String> educationHeader,
                                              @RequestParam(value = "educationDegree",required = false) List<String> educationDegree,
                                              @RequestParam(value = "educationBeginDate",required = false) List<String> educationBeginDate,
                                              @RequestParam(value = "educationEndDate",required = false) List<String> educationEndDate,
                                              @RequestParam(value = "educationLocatedPlace",required = false) List<String> educationLocatedPlace,
                                              @RequestParam(value = "educationDescription",required = false) List<String> educationDescription,
                                              @RequestParam(value = "employmentHeader",required = false) List<String> employmentHeader,
                                              @RequestParam(value = "employmentBeginDate",required = false) List<String> employmentBeginDate,
                                              @RequestParam(value = "employmentEndDate",required = false) List<String> employmentEndDate,
                                              @RequestParam(value = "employmentJobDescription",required = false) List<String> employmentJobDescription,
                                              @RequestParam(value = "extraCurricularHeader",required = false) List<String> extraCurricularHeader,
                                              @RequestParam(value = "extraEmployer",required = false) List<String> extraEmployer,
                                              @RequestParam(value = "extraBeginDate",required = false) List<String> extraBeginDate,
                                              @RequestParam(value = "extraEndDate",required = false) List<String> extraEndDate,
                                              @RequestParam(value = "extraCityName",required = false) List<String> extraCityName,
                                              @RequestParam(value = "extraDescription",required = false) List<String> extraDescription,
                                              @RequestParam(value = "languageName",required = false) List<String> languageName,
                                              @RequestParam(value = "languageLevel",required = false) List<String> languageLevel,
                                              @RequestParam(value = "referentFullName",required = false) List<String> referentFullName,
                                              @RequestParam(value = "referentCompanyName",required = false) List<String> referentCompanyName,
                                              @RequestParam(value = "referentPhone",required = false) List<String> referentPhone,
                                              @RequestParam(value = "referentEmail",required = false) List<String> referentEmail,
                                              @RequestParam(value = "linkLabel",required = false) List<String> linkLabel,
                                              @RequestParam(value = "socialLink",required = false) List<String> socialLink,
                                              @RequestParam(value = "skillName",required = false) List<String> skillName,
                                              @RequestParam(value = "skillPower",required = false) List<String> skillPower
                                              ) throws Exception{



        ModelAndView mv=new ModelAndView("menu");

        User s= userServiceInter.getbyID(updateForm.getId());
        s.setName(name);
        s.setSurname(surname);

        //skill List

        List<UserSkill> skillList= s.getUserSkillList();
        if(skillList.size()!=0) {
            UserSkill userSkill = null;
            int ij = 0;
            if(skillPower.size()!=0) {
                for (String powerAfter : skillPower) {
                    if(!powerAfter.trim().isEmpty()) {
                        userSkill = skillList.get(ij);
                        userSkill.setPower(Integer.parseInt(powerAfter));
                        ij++;
                    }else {
                        userSkill = skillList.get(ij);
                        userSkill.setPower(null);
                        ij++;
                    }
                }
            }else {
                userSkill = skillList.get(ij);
                userSkill.setPower(null);
                ij++;
            }

            int mn=0;
            if(skillName.size()!=0) {
                for (String skillNameAfter : skillName) {
                    if(!skillNameAfter.trim().isEmpty()) {
                        userSkill = skillList.get(mn);
                        Skill skl = userSkill.getSkill();
                        skl.setName(skillNameAfter);
                        mn++;
                    }else {
                        userSkill = skillList.get(mn);
                        Skill skl = userSkill.getSkill();
                        skl.setName(null);
                        mn++;
                    }
                }
            }else {
                userSkill = skillList.get(mn);
                Skill skl = userSkill.getSkill();
                skl.setName(null);
                mn++;
            }
        }

        //userLanguage



        List<UserLanguage> userLanguageList=s.getUserLanguageList();
        if(userLanguageList.size()!=0) {
            UserLanguage userLanguage = null;
            int o = 0;
            if(languageLevel.size()!=0) {
                for (String ln2 : languageLevel) {
                    if (!ln2.trim().isEmpty()) {
                        userLanguage = userLanguageList.get(o);
                        userLanguage.setLanguageLevel(Integer.parseInt(ln2));
                        o++;
                    }else {
                        userLanguage = userLanguageList.get(o);
                        userLanguage.setLanguageLevel(null);
                        o++;
                    }
                }
            }else {
                userLanguage = userLanguageList.get(o);
                userLanguage.setLanguageLevel(null);
                o++;
            }

            int ki1=0;
            if(languageName.size()!=0) {
                for (String ln1 : languageName) {
                    if (!ln1.trim().isEmpty()) {
                        userLanguage = userLanguageList.get(ki1);
                        Language language = userLanguage.getLanguageId();
                        language.setName(ln1);
                        ki1++;
                    }else {
                        userLanguage = userLanguageList.get(ki1);
                        Language language = userLanguage.getLanguageId();
                        language.setName(null);
                        ki1++;
                    }
                }
            }else {
                userLanguage = userLanguageList.get(ki1);
                Language language = userLanguage.getLanguageId();
                language.setName(null);
                ki1++;
            }
        }
        //userLanguage

        //employment history
        List<EmploymentHistory> historyList=s.getEmploymentHistoryList();
        if(historyList.size()!=0) {
            EmploymentHistory employmentHistory = null;

            int o1 = 0;
            if(employmentHeader.size()!=0) {
                for (String ehd : employmentHeader) {
                    if(!ehd.trim().isEmpty()) {
                        employmentHistory = historyList.get(o1);
                        employmentHistory.setHeader(ehd);
                        o1++;
                    }else {
                        employmentHistory = historyList.get(o1);
                        employmentHistory.setHeader(null);
                        o1++;
                    }
                }
            }else {
                employmentHistory = historyList.get(o1);
                employmentHistory.setHeader(null);
                o1++;
            }

            int nin5=0;
            if(employmentJobDescription.size()!=0) {
                for (String ehjd : employmentJobDescription) {
                    if(!ehjd.trim().isEmpty()) {
                        employmentHistory= historyList.get(nin5);
                        employmentHistory.setJobDescription(ehjd);
                        nin5++;
                    }else {
                        employmentHistory= historyList.get(nin5);
                        employmentHistory.setJobDescription(null);
                        nin5++;
                    }
                }
            }else {
                employmentHistory= historyList.get(nin5);
                employmentHistory.setJobDescription(null);
                nin5++;
            }

            int nin1=0;
            if(employmentBeginDate.size()!=0) {
                for (String nin2 : employmentBeginDate) {
                    if (!nin2.trim().isEmpty()) {
                        Date employmentBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(nin2);
                        employmentHistory=historyList.get(nin1);
                        employmentHistory.setBeginDate(employmentBeginDateParse);
                        nin1++;

                    } else{
                        employmentHistory=historyList.get(nin1);
                        employmentHistory.setBeginDate(null);
                        nin1++;
                    }
                }
            }else {
                employmentHistory=historyList.get(nin1);
                employmentHistory.setBeginDate(null);
                nin1++;
            }

            int nin3=0;
            if(employmentEndDate.size()!=0) {
                for (String nin4 : employmentEndDate) {
                    if (!nin4.trim().isEmpty()) {
                        Date employmentEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(nin4);
                        employmentHistory=historyList.get(nin3);
                        employmentHistory.setEndDate(employmentEndDateParse);
                        nin1++;

                    } else{
                        employmentHistory=historyList.get(nin3);
                        employmentHistory.setEndDate(null);
                        nin1++;
                    }
                }
            }else {
                employmentHistory=historyList.get(nin3);
                employmentHistory.setEndDate(null);
                nin1++;
            }


        }
        //employment history

        //country
        Country userCountry=s.getBirthplace();
        userCountry.setName(country);
        Country nationality1 = s.getNationality();
        nationality1.setNationality(nationality);
//        s.setBirthplace(userCountry);
//        s.setNationality(userCountry);

        //country

        s.setAddress(address);
        s.setEmail(email);
        if(!birthDate.trim().isEmpty()) {
            Date birthDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            s.setBirthDate(birthDateParse);
        }else {
            s.setBirthDate(null);
        }
        s.setPhone(phone);
        s.setProfileDesc(profileDescription);
        s.setUserHobby(hobby);


        //course List
        List<Course> courseList = s.getCourseList();
        if(courseList.size()!=0) {
            Course c = null;
            int ii1 = 0;
            if(courseName.size()!=0) {
                for (String course : courseName) {
                    if(!course.trim().isEmpty()) {
                        c = courseList.get(ii1);
                        c.setCourseName(course);
                        ii1++;
                    }else {
                        c = courseList.get(ii1);
                        c.setCourseName(null);
                        ii1++;
                    }
                }
            }else {
                c = courseList.get(ii1);
                c.setCourseName(null);
                ii1++;
            }

            int hij3=0;
            if(courseInstitution.size()!=0) {
                for (String str : courseInstitution) {
                    if(!str.trim().isEmpty()) {
                        c=courseList.get(hij3);
                        c.setInstitution(str);
                        hij3++;
                    }else {
                        c=courseList.get(hij3);
                        c.setInstitution(null);
                        hij3++;
                    }
                }
            }else {
                c=courseList.get(hij3);
                c.setInstitution(null);
                hij3++;
            }

            int hij1=0;
            if(courseBeginDate.size()!=0) {
                for (String hij2 : courseBeginDate) {
                    if (!hij2.trim().isEmpty()) {
                        Date courseBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(hij2);
                        c=courseList.get(hij1);
                        c.setBeginDate(courseBeginDateParse);
                        hij1++;

                    } else{
                        c=courseList.get(hij1);
                        c.setBeginDate(null);
                        hij1++;
                    }
                }
            }else {
                c=courseList.get(hij1);
                c.setBeginDate(null);
                hij1++;
            }

            int hi3=0;
            if(courseEndDate.size()!=0) {
                for (String hi4 : courseEndDate) {
                    if (!hi4.trim().isEmpty()) {
                        Date courseEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(hi4);
                        c=courseList.get(hi3);
                        c.setEndDate(courseEndDateParse);
                        hi3++;

                    } else{
                        c=courseList.get(hi3);
                        c.setEndDate(null);
                        hi3++;
                    }
                }
            }else {
                c=courseList.get(hi3);
                c.setEndDate(null);
                hi3++;
            }


        }

        //course list


        //education History
        List<EducationHistory> educationHistories= s.getEducationHistoryList();
        if(educationHistories.size()!=0) {
            EducationHistory educationHistory = null;
            int ii2 = 0;
            if(educationHeader.size()!=0) {
                for (String a1 : educationHeader) {
                    if(!a1.trim().isEmpty()) {
                        educationHistory = educationHistories.get(ii2);
                        educationHistory.setEducationHeader(a1);
                        ii2++;
                    }else {
                        educationHistory = educationHistories.get(ii2);
                        educationHistory.setEducationHeader(null);
                        ii2++;
                    }
                }
            }else {
                educationHistory = educationHistories.get(ii2);
                educationHistory.setEducationHeader(null);
                ii2++;
            }

            int yu7=0;
            if(educationDegree.size()!=0) {
                for (String a2 : educationDegree) {
                    if(!a2.trim().isEmpty()) {
                        educationHistory=educationHistories.get(yu7);
                        educationHistory.setEducationDegree(a2);
                        yu7++;
                    }else {
                        educationHistory=educationHistories.get(yu7);
                        educationHistory.setEducationDegree(null);
                        yu7++;
                    }
                }
            }else {
                educationHistory=educationHistories.get(yu7);
                educationHistory.setEducationDegree(null);
                yu7++;
            }

            int yu6=0;
            if(educationLocatedPlace.size()!=0) {
                for (String u2 : educationLocatedPlace) {
                    if (!u2.trim().isEmpty()) {
                        educationHistory=educationHistories.get(yu6);
                        educationHistory.setLocatedPlace(u2);
                        yu6++;
                    }else {
                        educationHistory=educationHistories.get(yu6);
                        educationHistory.setLocatedPlace(null);
                        yu6++;
                    }
                }
            }else {
                educationHistory=educationHistories.get(yu6);
                educationHistory.setLocatedPlace(null);
                yu6++;
            }

            int yu5=0;
            if(educationDescription.size()!=0) {
                for (String educationDesc : educationDescription) {
                    if (!educationDesc.trim().isEmpty()) {
                        educationHistory=educationHistories.get(yu5);
                        educationHistory.setEducationDescription(educationDesc);
                        yu5++;
                    }else {
                        educationHistory=educationHistories.get(yu5);
                        educationHistory.setEducationDescription(null);
                        yu5++;
                    }
                }
            }else {
                educationHistory=educationHistories.get(yu5);
                educationHistory.setEducationDescription(null);
                yu5++;
            }

            int yu1=0;
            if(educationBeginDate.size()!=0) {
                for (String yu2 : educationBeginDate) {
                    if (!yu2.trim().isEmpty()) {
                        Date educationBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(yu2);
                        educationHistory = educationHistories.get(yu1);
                        educationHistory.setBeginDate(educationBeginDateParse);
                        yu1++;

                    } else{
                        educationHistory = educationHistories.get(yu1);
                        educationHistory.setBeginDate(null);
                        yu1++;
                    }
                }
            }else {
                educationHistory = educationHistories.get(yu1);
                educationHistory.setBeginDate(null);
                yu1++;
            }

            int yu3=0;
            if(educationEndDate.size()!=0) {
                for (String yu4 : educationEndDate) {
                    if (!yu4.trim().isEmpty()) {
                        Date educationEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(yu4);
                        educationHistory = educationHistories.get(yu3);
                        educationHistory.setEndDate(educationEndDateParse);
                        yu3++;

                    } else{
                        educationHistory = educationHistories.get(yu3);
                        educationHistory.setEndDate(null);
                        yu3++;
                    }
                }
            }else {
                educationHistory = educationHistories.get(yu3);
                educationHistory.setEndDate(null);
                yu3++;
            }

        }

        //education History


        //Extra Curricular
        List<ExtraCurricularActivities> curricularActivitiesList=s.getExtraCurricularActivitiesList();
        if(curricularActivitiesList.size()!=0) {
            ExtraCurricularActivities curricularActivities = null;

            int ii3 = 0;
            if(extraCurricularHeader.size()!=0) {
                for (String ss : extraCurricularHeader) {
                    if (!ss.trim().isEmpty()) {
                        System.out.println("salamun aleykum1");
                        System.out.println("salamun aleykum2");
                        curricularActivities = curricularActivitiesList.get(ii3);
                        curricularActivities.setActivitiesHeader(ss);
                        ii3++;
                    } else {
                        curricularActivities = curricularActivitiesList.get(ii3);
                        curricularActivities.setActivitiesHeader(null);
                        ii3++;
                    }
                }
            }else {
                curricularActivities = curricularActivitiesList.get(ii3);
                curricularActivities.setActivitiesHeader(null);
                ii3++;
            }


            int ii4=0;
            if(extraEmployer.size()!=0) {
                for (String ss2 : extraEmployer) {
                    if (!ss2.trim().isEmpty()) {
                        System.out.println("salamun aleykum4");
                        curricularActivities = curricularActivitiesList.get(ii4);
                        curricularActivities.setEmployer(ss2);
                        ii4++;
                    } else{
                    curricularActivities = curricularActivitiesList.get(ii4);
                    curricularActivities.setEmployer(null);
                    ii4++;
                    }
                }
            }else {
                curricularActivities = curricularActivitiesList.get(ii4);
                curricularActivities.setEmployer(null);
                ii4++;
            }

            int ii5=0;
            if(extraCityName.size()!=0) {
                for (String ss3 : extraCityName) {
                    if (!ss3.trim().isEmpty()) {
                        System.out.println("salamun aleykum5");
                        curricularActivities = curricularActivitiesList.get(ii5);
                        curricularActivities.setCityName(ss3);
                        ii5++;
                    } else {
                    curricularActivities = curricularActivitiesList.get(ii5);
                    curricularActivities.setCityName(null);
                    ii5++;
                    }
                }
            }else {
                curricularActivities = curricularActivitiesList.get(ii5);
                curricularActivities.setCityName(null);
                ii5++;
            }


            int ii6=0;
            if(extraDescription.size()!=0) {
                for (String ss4 : extraDescription) {

                    if (!ss4.trim().isEmpty()) {
                        curricularActivities = curricularActivitiesList.get(ii6);
                        curricularActivities.setActivitiesDescription(ss4);
                        ii6++;
                    } else {
                            curricularActivities = curricularActivitiesList.get(ii6);
                            curricularActivities.setActivitiesDescription(null);
                            ii6++;
                    }
                }
            }else{
                curricularActivities = curricularActivitiesList.get(ii6);
                curricularActivities.setActivitiesDescription(null);
                ii6++;
            }


            int ij1=0;
            if(extraBeginDate.size()!=0) {
                for (String ss5 : extraBeginDate) {
                    if (!ss5.trim().isEmpty()) {
                        System.out.println("salamun aleykum7");
                        Date extraBeginDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(ss5);
                        curricularActivities = curricularActivitiesList.get(ij1);
                        curricularActivities.setBeginDate(extraBeginDateParse);
                        ij1++;

                    } else{
                        curricularActivities = curricularActivitiesList.get(ij1);
                        curricularActivities.setBeginDate(null);
                        ij1++;
                    }
                }
            }else {
                curricularActivities = curricularActivitiesList.get(ij1);
                curricularActivities.setBeginDate(null);
                ij1++;
            }
            int ij2=0;
            if(extraEndDate.size()!=0) {
                    for (String ss6 : extraEndDate) {
                        if(!ss6.trim().isEmpty()) {
                            System.out.println(extraEndDate.get(ij2));

                            Date extraEndDateParse = new SimpleDateFormat("yyyy-MM-dd").parse(ss6);
                            curricularActivities = curricularActivitiesList.get(ij2);
                            curricularActivities.setEndDate(extraEndDateParse);
                            ij2++;
                        }else {
                            curricularActivities = curricularActivitiesList.get(ij2);
                            curricularActivities.setEndDate(null);
                            ij2++;
                        }
                    }
            }else {
                System.out.println("alooo sesim geliriiiirmimmmmmmm");
                curricularActivities = curricularActivitiesList.get(ij2);
                curricularActivities.setEndDate(null);
                ij2++;
            }

        }

        //extra Curricular Activities


//social Link
        List<SocialLink> socialLinkList=s.getSocialLinkList();
        if(socialLinkList.size()!=0) {
            SocialLink socialLink1 = null;
            int ii4 = 0;
            if(linkLabel.size()!=0) {
                for (String rr1 : linkLabel) {
                    if(!rr1.trim().isEmpty()) {
                        socialLink1 = socialLinkList.get(ii4);
                        socialLink1.setLabel(rr1);
                        ii4++;
                    }else {
                        socialLink1 = socialLinkList.get(ii4);
                        socialLink1.setLabel(null);
                        ii4++;
                    }
                }
            }else {
                socialLink1 = socialLinkList.get(ii4);
                socialLink1.setLabel(null);
                ii4++;
            }
            int in1=0;
            if(socialLink.size()!=0) {
                for (String rr2 : socialLink) {
                    if (!rr2.trim().isEmpty()) {
                        socialLink1= socialLinkList.get(in1);
                        socialLink1.setLink(rr2);
                        in1++;
                    }else {
                        socialLink1= socialLinkList.get(in1);
                        socialLink1.setLink(null);
                        in1++;
                    }
                }
            }else {
                socialLink1= socialLinkList.get(in1);
                socialLink1.setLink(null);
                in1++;
            }
        }

        //social Link


        //reference
        List<Reference> referenceList=s.getReferenceList();
        if (referenceList.size()!=0) {
            Reference reference = null;
            int ii5 = 0;
            if(referentFullName.size()!=0) {
                for (String qe1 : referentFullName) {
                    if(!qe1.trim().isEmpty()) {
                        reference = referenceList.get(ii5);
                        reference.setReferentFullName(qe1);
                        ii5++;
                    }else {
                        reference = referenceList.get(ii5);
                        reference.setReferentFullName(null);
                        ii5++;
                    }
                }
            }else {
                reference = referenceList.get(ii5);
                reference.setReferentFullName(null);
                ii5++;
            }

            int in2=0;
            if(referentCompanyName.size()!=0) {
                for (String qe2 : referentCompanyName) {
                    if(!qe2.trim().isEmpty()) {
                        reference=referenceList.get(in2);
                        reference.setReferentCompanyName(qe2);
                        in2++;
                    }else {
                        reference=referenceList.get(in2);
                        reference.setReferentCompanyName(null);
                        in2++;
                    }
                }
            }else {
                reference=referenceList.get(in2);
                reference.setReferentCompanyName(null);
                in2++;
            }

            int in3=0;
            if(referentPhone.size()!=0) {
                for (String qe3 : referentPhone) {
                    if(!qe3.trim().isEmpty()) {
                        reference=referenceList.get(in3);
                        reference.setReferentPhone(qe3);
                        in3++;
                    }else {
                        reference=referenceList.get(in3);
                        reference.setReferentPhone(null);
                        in3++;
                    }
                }
            }else {
                reference=referenceList.get(in3);
                reference.setReferentPhone(null);
                in3++;
            }

            int in4=0;
            if(referentEmail.size()!=0) {
                for (String qe4 : referentEmail) {
                    if(!qe4.isEmpty()) {
                        reference=referenceList.get(in4);
                        reference.setReferentEmail(qe4);
                        in4++;
                    }else {
                        reference=referenceList.get(in4);
                        reference.setReferentEmail(null);
                        in4++;
                    }
                }
            }else {
                reference=referenceList.get(in4);
                reference.setReferentEmail(null);
                in4++;
            }
        }

        //reference

        userServiceInter.updateUser(s);

//        List<UserSkill> asu =usi.getAllSkillByUserId(updateForm.getId());
//        mv.addObject("listskill",asu);
//        mv.addObject("user", s);

        return mv;
    }


    @RequestMapping(method = RequestMethod.POST,value = "/forCreateResume")
    public ModelAndView detailGetIndex(@ModelAttribute("userInform") UserInformForResume userInformForResume ){
            ModelAndView m = new ModelAndView("createResumeWithTemplates");
            User u = userServiceInter.getbyID(userInformForResume.getIdInform());
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            List<UserSkill> asu =usi.getAllSkillByUserId(userInformForResume.getIdInform());

            List<EmploymentHistory> ehsiList = ehsi.getallEmploymentHistorybyuserId(userInformForResume.getIdInform());

            m.addObject("employmentHistoryListForCreateResume",ehsiList);
            m.addObject("listSkill",asu);
            m.addObject("user", u);
            return m;

    }

    @RequestMapping(method = RequestMethod.POST,value = "/userdetail")
    public ModelAndView detailGetIndex(@ModelAttribute("user") UserForm udf){
        try {
            ModelAndView m = new ModelAndView("userdetailJstl");
            User u = userServiceInter.getbyID(udf.getId());
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            List<UserSkill> asu =usi.getAllSkillByUserId(udf.getId());
            m.addObject("listskill",asu);
            m.addObject("user", u);
            return m;
        }
        catch (Exception ex){
            ex.printStackTrace();
            ModelAndView mv=new ModelAndView("error");
            String message = ex.getMessage();
            mv.addObject("ms",message);
            return mv;
        }
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

    @ModelAttribute("userUpdateForm")
    public UserUpdateForm userUpdateForm(){
        return new UserUpdateForm();
    }

    @ModelAttribute("userDeleteForm")
    public UserDeleteForm userDeleteForm(){return new UserDeleteForm();}
}
