/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Language;
import com.company.entity.Skill;
import com.company.inter.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository("language1")
public class LanguageRepositoryCustomImpl extends AbstractDAO implements LanguageRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Language> getallLanguage() {
        Query q= em.createQuery("select l from Language l ");
        return q.getResultList();
    }

    @Override
    public List<Language> getallLanguagebyId(int id) {
        Query q = em.createQuery("select l from Language l where l.id=:id");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public boolean updateLanguage(Language ln) {
        em.merge(ln);
        return true;
    }

    @Override
    public boolean removeLanguage(int id) {
        Query q= em.createQuery("delete from Language l where l.id=:lnl");
        q.setParameter("lnl", id);
        q.executeUpdate();
        return true;
    }

    @Override
    public List<Language> getByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Language> cbq = cb.createQuery(Language.class);
        Root<Language> from = cbq.from(Language.class);

        CriteriaQuery<Language> cqn = cbq.where(cb.equal(from.get("name"), name));

        Query query= em.createQuery(cqn);

        return query.getResultList();
    }

    @Override
    public boolean insertLanguage(Language ln) {
        em.persist(ln);
        return true;
    }
    
}
