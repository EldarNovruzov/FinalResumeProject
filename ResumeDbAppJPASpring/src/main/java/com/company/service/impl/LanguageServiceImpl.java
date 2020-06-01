/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.Language;
import com.company.impl.LanguageRepositoryCustom;
import com.company.service.inter.LanguageServiceInter;
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
public class LanguageServiceImpl implements LanguageServiceInter{
    
    @Autowired
    @Qualifier("language1")
    private LanguageRepositoryCustom lrc;

    @Override
    public List<Language> getallLanguage() {
        return lrc.getallLanguage();
    }

    @Override
    public List<Language> getallLanguagebyId(int id) {
        return lrc.getallLanguagebyId(id);
    }

    @Override
    public boolean updateLanguage(Language ln) {
        return lrc.updateLanguage(ln);
    }

    @Override
    public boolean removeLanguage(int id) {
        return lrc.removeLanguage(id);
    }

    @Override
    public List<Language> getByName(String name) {
        return lrc.getByName(name);
    }

    @Override
    public boolean insertLanguage(Language ln) {
        return lrc.insertLanguage(ln);
    }
    
}
