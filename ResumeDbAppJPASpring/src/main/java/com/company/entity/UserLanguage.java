/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "user_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLanguage.findAll", query = "SELECT u FROM UserLanguage u")
    , @NamedQuery(name = "UserLanguage.findById", query = "SELECT u FROM UserLanguage u WHERE u.id = :id")
    , @NamedQuery(name = "UserLanguage.findByLanguageLevel", query = "SELECT u FROM UserLanguage u WHERE u.languageLevel = :languageLevel")})
public class UserLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "language_level")
    private Integer languageLevel;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userId;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Language languageId;

    public UserLanguage() {
    }

    public UserLanguage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(Integer languageLevel) {
        this.languageLevel = languageLevel;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof UserLanguage)) {
            return false;
        }
        UserLanguage other = (UserLanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.UserLanguage[ id=" + id + " ]";
    }
    
}
