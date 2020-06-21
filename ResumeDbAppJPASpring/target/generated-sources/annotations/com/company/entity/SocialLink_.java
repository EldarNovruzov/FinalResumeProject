package com.company.entity;

import com.company.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(SocialLink.class)
public class SocialLink_ { 

    public static volatile SingularAttribute<SocialLink, String> link;
    public static volatile SingularAttribute<SocialLink, Integer> id;
    public static volatile SingularAttribute<SocialLink, String> label;
    public static volatile SingularAttribute<SocialLink, User> userId;

}