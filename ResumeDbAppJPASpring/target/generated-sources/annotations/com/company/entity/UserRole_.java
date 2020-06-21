package com.company.entity;

import com.company.entity.Role;
import com.company.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(UserRole.class)
public class UserRole_ { 

    public static volatile SingularAttribute<UserRole, String> password;
    public static volatile ListAttribute<UserRole, User> userList;
    public static volatile SingularAttribute<UserRole, String> surname;
    public static volatile SingularAttribute<UserRole, Role> roleId;
    public static volatile SingularAttribute<UserRole, String> name;
    public static volatile SingularAttribute<UserRole, Integer> id;
    public static volatile SingularAttribute<UserRole, String> email;

}