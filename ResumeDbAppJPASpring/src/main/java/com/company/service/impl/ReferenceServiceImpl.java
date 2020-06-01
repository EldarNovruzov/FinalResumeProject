/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.Reference;
import com.company.impl.ReferenceRepositoryCustom;
import com.company.service.inter.ReferenceServiceInter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class ReferenceServiceImpl implements ReferenceServiceInter{
    
    @Autowired
    @Qualifier("reference1")
    private ReferenceRepositoryCustom rrc;

    @Override
    public List<Reference> getAllReferenceByUserId(int id) {
        return rrc.getAllReferenceByUserId(id);
    }

    @Override
    public boolean insertReference(Reference r) {
        return rrc.insertReference(r);
    }

    @Override
    public boolean updateReference(Reference r) {
        return rrc.updateReference(r);
    }

    @Override
    public boolean removeReference(int id) {
        return rrc.removeReference(id);
    }

    @Override
    public boolean removeReferencebyUserId(int id) {
        return rrc.removeReferencebyUserId(id);
    }

}
