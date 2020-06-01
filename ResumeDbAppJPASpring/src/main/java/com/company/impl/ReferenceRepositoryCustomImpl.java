/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Reference;
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
@Repository("reference1")
public class ReferenceRepositoryCustomImpl extends AbstractDAO implements ReferenceRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Reference> getAllReferenceByUserId(int id) {
        Query query = em.createQuery("select re from Reference re where re.userId.id=:usid ");
        query.setParameter("usid",id);
        return query.getResultList();
    }

    @Override
    public boolean insertReference(Reference r) {
        em.persist(r);
        return true;
    }

    @Override
    public boolean updateReference(Reference r) {
        em.merge(r);
        return true;
    }

    @Override
    public boolean removeReference(int id) {
        Reference refer = em.find(Reference.class, id);
        em.remove(refer);
        return true;
    }

    @Override
    public boolean removeReferencebyUserId(int id) {
        Query q=em.createQuery("delete from Reference dd where dd.userId.id=:iii");
        q.setParameter("iii", id);
        q.executeUpdate();
        return true;
    }


}
