package com.company.entity;

import com.company.entity.UserLanguage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile SingularAttribute<Language, String> name;
    public static volatile SingularAttribute<Language, Integer> id;
    public static volatile ListAttribute<Language, UserLanguage> userLanguageList;

}