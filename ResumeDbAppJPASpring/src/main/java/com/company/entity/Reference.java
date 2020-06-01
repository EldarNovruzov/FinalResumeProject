/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r")
    , @NamedQuery(name = "Reference.findById", query = "SELECT r FROM Reference r WHERE r.id = :id")
    , @NamedQuery(name = "Reference.findByReferentFullName", query = "SELECT r FROM Reference r WHERE r.referentFullName = :referentFullName")
    , @NamedQuery(name = "Reference.findByReferentCompanyName", query = "SELECT r FROM Reference r WHERE r.referentCompanyName = :referentCompanyName")
    , @NamedQuery(name = "Reference.findByReferentPhone", query = "SELECT r FROM Reference r WHERE r.referentPhone = :referentPhone")
    , @NamedQuery(name = "Reference.findByReferentEmail", query = "SELECT r FROM Reference r WHERE r.referentEmail = :referentEmail")})
public class Reference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "referent_full_name")
    private String referentFullName;
    @Column(name = "referent_company_name")
    private String referentCompanyName;
    @Column(name = "referent_phone")
    private String referentPhone;
    @Column(name = "referent_email")
    private String referentEmail;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User userId;

    public Reference() {
    }

    public Reference(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferentFullName() {
        return referentFullName;
    }

    public void setReferentFullName(String referentFullName) {
        this.referentFullName = referentFullName;
    }

    public String getReferentCompanyName() {
        return referentCompanyName;
    }

    public void setReferentCompanyName(String referentCompanyName) {
        this.referentCompanyName = referentCompanyName;
    }

    public String getReferentPhone() {
        return referentPhone;
    }

    public void setReferentPhone(String referentPhone) {
        this.referentPhone = referentPhone;
    }

    public String getReferentEmail() {
        return referentEmail;
    }

    public void setReferentEmail(String referentEmail) {
        this.referentEmail = referentEmail;
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
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.Reference[ id=" + id + " ]";
    }
    
}
