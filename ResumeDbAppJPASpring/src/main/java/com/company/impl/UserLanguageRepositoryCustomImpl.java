/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.UserLanguage;
import com.company.inter.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository("userLanguage1")
public class UserLanguageRepositoryCustomImpl extends AbstractDAO implements UserLanguageRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserLanguage> getAllLanguageByUserId(int id) {
        Query createQuery = em.createQuery("select ulg from UserLanguage ulg where ulg.userId.id=:userid");
        createQuery.setParameter("userid", id);
        return createQuery.getResultList();
    }

    @Override
    public boolean insertUserLanguage(UserLanguage ul) {
        em.persist(ul);
        return true;
    }

    @Override
    public boolean updateUserLanguage(UserLanguage ul) {
        em.merge(ul);
        return true;
    }

    @Override
    public boolean removeUserLanguage(int id) {
        UserLanguage ulsd= em.find(UserLanguage.class,id);

        em.remove(ulsd);
        return true;
    }

    @Override
    public boolean removeUserLanguagebyUserId(int id) {
        Query q=em.createQuery("delete from UserLanguage fd where fd.userId.id=:uyu");
        q.setParameter("uyu", id);
        q.executeUpdate();
        return false;
    }

}
