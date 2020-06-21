package com.company.entity;

import com.company.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(EducationHistory.class)
public class EducationHistory_ { 

    public static volatile SingularAttribute<EducationHistory, Date> beginDate;
    public static volatile SingularAttribute<EducationHistory, Date> endDate;
    public static volatile SingularAttribute<EducationHistory, String> educationDescription;
    public static volatile SingularAttribute<EducationHistory, String> educationDegree;
    public static volatile SingularAttribute<EducationHistory, String> educationHeader;
    public static volatile SingularAttribute<EducationHistory, String> locatedPlace;
    public static volatile SingularAttribute<EducationHistory, Integer> id;
    public static volatile SingularAttribute<EducationHistory, User> userId;

}