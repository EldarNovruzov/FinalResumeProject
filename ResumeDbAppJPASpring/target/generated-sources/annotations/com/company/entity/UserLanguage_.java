package com.company.entity;

import com.company.entity.Language;
import com.company.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(UserLanguage.class)
public class UserLanguage_ { 

    public static volatile SingularAttribute<UserLanguage, Integer> languageLevel;
    public static volatile SingularAttribute<UserLanguage, Language> languageId;
    public static volatile SingularAttribute<UserLanguage, Integer> id;
    public static volatile SingularAttribute<UserLanguage, User> userId;

}