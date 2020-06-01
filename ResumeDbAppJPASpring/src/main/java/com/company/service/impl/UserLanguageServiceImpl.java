/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.UserLanguage;
import com.company.impl.UserLanguageRepositoryCustom;
import com.company.service.inter.UserLanguageServiceInter;
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
public class UserLanguageServiceImpl implements UserLanguageServiceInter {
    
    @Autowired
    @Qualifier("userLanguage1")
    private UserLanguageRepositoryCustom ulrc;

    @Override
    public List<UserLanguage> getAllLanguageByUserId(int id) {
        return ulrc.getAllLanguageByUserId(id);
    }

    @Override
    public boolean insertUserLanguage(UserLanguage ul) {
        return ulrc.insertUserLanguage(ul);
    }

    @Override
    public boolean updateUserLanguage(UserLanguage ul) {
        return ulrc.updateUserLanguage(ul);
    }

    @Override
    public boolean removeUserLanguage(int id) {
        return ulrc.removeUserLanguage(id);
    }

    @Override
    public boolean removeUserLanguagebyUserId(int id) {
        return ulrc.removeUserLanguagebyUserId(id);
    }

}
