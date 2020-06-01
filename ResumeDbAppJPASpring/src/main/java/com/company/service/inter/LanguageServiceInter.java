/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.Language;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface LanguageServiceInter {
    
     public List<Language> getallLanguage();

    public List<Language> getallLanguagebyId(int id);

    boolean updateLanguage(Language ln);

    boolean removeLanguage(int id);

    public List<Language> getByName(String name);

    public boolean insertLanguage(Language ln);
}
