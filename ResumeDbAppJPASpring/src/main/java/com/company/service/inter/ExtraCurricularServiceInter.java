/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.ExtraCurricularActivities;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ExtraCurricularServiceInter {
     public List<ExtraCurricularActivities> getallExtraCurricularActivitiesbyUserId(int userId);
     public boolean removeExtraCurricularbyUserId(int id);
}
