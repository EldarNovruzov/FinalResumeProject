/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.SocialLink;
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
@Repository("social1")
public class SocialLinkRepositoryCustomImpl extends AbstractDAO implements SocialLinkRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<SocialLink> getAllSocialLinkByUserId(int id) {
        Query query = em.createQuery("select sl from SocialLink sl where sl.userId.id=:usid ");
        query.setParameter("usid",id);
        return query.getResultList();
    }

    @Override
    public boolean insertSocialLink(SocialLink sl) {
        em.persist(sl);
        return true;
    }

    @Override
    public boolean updateSocialLink(SocialLink sl) {
        em.merge(sl);
        return true;
    }

    @Override
    public boolean removeSocialLink(int id) {
        SocialLink slink = em.find(SocialLink.class, id);
        em.remove(slink);
        return true;
    }

    @Override
    public boolean removeSocialLinkbyUserId(int id) {
        Query q=em.createQuery("delete from SocialLink er where er.userId.id=:as");
        q.setParameter("as", id);
        q.executeUpdate();
        return true;
    }


}
