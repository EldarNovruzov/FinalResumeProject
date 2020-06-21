package com.company.entity;

import com.company.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(Reference.class)
public class Reference_ { 

    public static volatile SingularAttribute<Reference, String> referentPhone;
    public static volatile SingularAttribute<Reference, String> referentEmail;
    public static volatile SingularAttribute<Reference, Integer> id;
    public static volatile SingularAttribute<Reference, User> userId;
    public static volatile SingularAttribute<Reference, String> referentCompanyName;
    public static volatile SingularAttribute<Reference, String> referentFullName;

}