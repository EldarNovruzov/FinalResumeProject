/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "extra_curricular_activities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExtraCurricularActivities.findAll", query = "SELECT e FROM ExtraCurricularActivities e")
    , @NamedQuery(name = "ExtraCurricularActivities.findById", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.id = :id")
    , @NamedQuery(name = "ExtraCurricularActivities.findByActivitiesHeader", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.activitiesHeader = :activitiesHeader")
    , @NamedQuery(name = "ExtraCurricularActivities.findByEmployer", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.employer = :employer")
    , @NamedQuery(name = "ExtraCurricularActivities.findByBeginDate", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.beginDate = :beginDate")
    , @NamedQuery(name = "ExtraCurricularActivities.findByEndDate", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "ExtraCurricularActivities.findByCityName", query = "SELECT e FROM ExtraCurricularActivities e WHERE e.cityName = :cityName")})
public class ExtraCurricularActivities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "activities_header")
    private String activitiesHeader;
    @Column(name = "employer")
    private String employer;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "city_name")
    private String cityName;
    @Lob
    @Column(name = "activities_description")
    private String activitiesDescription;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User userId;

    public ExtraCurricularActivities() {
    }

    public ExtraCurricularActivities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivitiesHeader() {
        return activitiesHeader;
    }

    public void setActivitiesHeader(String activitiesHeader) {
        this.activitiesHeader = activitiesHeader;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getActivitiesDescription() {
        return activitiesDescription;
    }

    public void setActivitiesDescription(String activitiesDescription) {
        this.activitiesDescription = activitiesDescription;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtraCurricularActivities)) {
            return false;
        }
        ExtraCurricularActivities other = (ExtraCurricularActivities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.ExtraCurricularActivities[ id=" + id + " ]";
    }
    
}
