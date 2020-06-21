package com.company.entity;

import com.company.entity.Country;
import com.company.entity.Course;
import com.company.entity.EducationHistory;
import com.company.entity.EmploymentHistory;
import com.company.entity.ExtraCurricularActivities;
import com.company.entity.Reference;
import com.company.entity.SocialLink;
import com.company.entity.UserLanguage;
import com.company.entity.UserRole;
import com.company.entity.UserSkill;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Reference> referenceList;
    public static volatile SingularAttribute<User, String> address;
    public static volatile ListAttribute<User, Course> courseList;
    public static volatile ListAttribute<User, SocialLink> socialLinkList;
    public static volatile ListAttribute<User, UserLanguage> userLanguageList;
    public static volatile ListAttribute<User, EmploymentHistory> employmentHistoryList;
    public static volatile SingularAttribute<User, Date> birthDate;
    public static volatile ListAttribute<User, ExtraCurricularActivities> extraCurricularActivitiesList;
    public static volatile SingularAttribute<User, String> userHobby;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Country> nationality;
    public static volatile SingularAttribute<User, Country> birthplace;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> profileDesc;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, UserRole> userRoleId;
    public static volatile ListAttribute<User, EducationHistory> educationHistoryList;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, UserSkill> userSkillList;

}