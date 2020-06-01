/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.ExtraCurricularActivities;
import com.company.impl.ExtraCurricularRepositoryCustom;
import com.company.service.inter.ExtraCurricularServiceInter;
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
public class ExtraCurricularServiceImpl implements ExtraCurricularServiceInter{
    
    @Autowired
    @Qualifier("extraCurricular1")
    private ExtraCurricularRepositoryCustom ecrc;

    @Override
    public List<ExtraCurricularActivities> getallExtraCurricularActivitiesbyUserId(int userId) {
        return ecrc.getallExtraCurricularActivitiesbyUserId(userId);
    }

    @Override
    public boolean removeExtraCurricularbyUserId(int id) {
        return ecrc.removeExtraCurricularbyUserId(id);
    }

}
