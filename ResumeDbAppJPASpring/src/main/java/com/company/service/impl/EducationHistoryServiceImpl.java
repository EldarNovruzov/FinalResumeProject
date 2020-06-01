/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.EducationHistory;
import com.company.impl.EducationHistoryRepositoryCustom;
import com.company.service.inter.EducationHistoryServiceInter;
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
public class EducationHistoryServiceImpl implements EducationHistoryServiceInter{
    
    @Autowired
    @Qualifier("educationHistory1")
    private EducationHistoryRepositoryCustom ehrc;

    @Override
    public List<EducationHistory> getallEducationHistorybyUserId(int userId) {
        return ehrc.getallEducationHistorybyUserId(userId);
    }

    @Override
    public boolean removeEducationHistorybyUserId(int id) {
        return ehrc.removeEducationHistorybyUserId(id);
    }

}
