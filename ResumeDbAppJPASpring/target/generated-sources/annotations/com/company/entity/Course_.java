package com.company.entity;

import com.company.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> institution;
    public static volatile SingularAttribute<Course, Date> beginDate;
    public static volatile SingularAttribute<Course, String> courseName;
    public static volatile SingularAttribute<Course, Date> endDate;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, User> userId;

}