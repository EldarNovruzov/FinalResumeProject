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
@Table(name = "education_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationHistory.findAll", query = "SELECT e FROM EducationHistory e")
    , @NamedQuery(name = "EducationHistory.findById", query = "SELECT e FROM EducationHistory e WHERE e.id = :id")
    , @NamedQuery(name = "EducationHistory.findByEducationHeader", query = "SELECT e FROM EducationHistory e WHERE e.educationHeader = :educationHeader")
    , @NamedQuery(name = "EducationHistory.findByEducationDegree", query = "SELECT e FROM EducationHistory e WHERE e.educationDegree = :educationDegree")
    , @NamedQuery(name = "EducationHistory.findByBeginDate", query = "SELECT e FROM EducationHistory e WHERE e.beginDate = :beginDate")
    , @NamedQuery(name = "EducationHistory.findByEndDate", query = "SELECT e FROM EducationHistory e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "EducationHistory.findByLocatedPlace", query = "SELECT e FROM EducationHistory e WHERE e.locatedPlace = :locatedPlace")})
public class EducationHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "education_header")
    private String educationHeader;
    @Column(name = "education_degree")
    private String educationDegree;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "located_place")
    private String locatedPlace;
    @Lob
    @Column(name = "education_description")
    private String educationDescription;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User userId;

    public EducationHistory() {
    }

    public EducationHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationHeader() {
        return educationHeader;
    }

    public void setEducationHeader(String educationHeader) {
        this.educationHeader = educationHeader;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
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

    public String getLocatedPlace() {
        return locatedPlace;
    }

    public void setLocatedPlace(String locatedPlace) {
        this.locatedPlace = locatedPlace;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
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
        if (!(object instanceof EducationHistory)) {
            return false;
        }
        EducationHistory other = (EducationHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.EducationHistory[ id=" + id + " ]";
    }
    
}
