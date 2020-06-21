package com.company.entity;

import com.company.entity.UserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile CollectionAttribute<Role, UserRole> userRoleCollection;
    public static volatile SingularAttribute<Role, String> roleName;
    public static volatile SingularAttribute<Role, Integer> id;

}