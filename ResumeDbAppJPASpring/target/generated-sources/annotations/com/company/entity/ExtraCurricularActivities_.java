package com.company.entity;

import com.company.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-01T14:51:24")
@StaticMetamodel(ExtraCurricularActivities.class)
public class ExtraCurricularActivities_ { 

    public static volatile SingularAttribute<ExtraCurricularActivities, Date> beginDate;
    public static volatile SingularAttribute<ExtraCurricularActivities, String> cityName;
    public static volatile SingularAttribute<ExtraCurricularActivities, Date> endDate;
    public static volatile SingularAttribute<ExtraCurricularActivities, String> activitiesDescription;
    public static volatile SingularAttribute<ExtraCurricularActivities, String> employer;
    public static volatile SingularAttribute<ExtraCurricularActivities, Integer> id;
    public static volatile SingularAttribute<ExtraCurricularActivities, String> activitiesHeader;
    public static volatile SingularAttribute<ExtraCurricularActivities, User> userId;

}