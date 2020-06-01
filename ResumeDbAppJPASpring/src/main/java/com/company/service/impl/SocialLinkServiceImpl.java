/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.SocialLink;
import com.company.impl.SocialLinkRepositoryCustom;
import com.company.service.inter.SocialLinkServiceInter;
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
public class SocialLinkServiceImpl implements SocialLinkServiceInter{
    
    
    @Autowired
    @Qualifier("social1")
    private SocialLinkRepositoryCustom slrc;

    @Override
    public List<SocialLink> getAllSocialLinkByUserId(int id) {
        return slrc.getAllSocialLinkByUserId(id);
    }

    @Override
    public boolean insertSocialLink(SocialLink sl) {
        return slrc.insertSocialLink(sl);
    }

    @Override
    public boolean updateSocialLink(SocialLink sl) {
        return slrc.updateSocialLink(sl);
    }

    @Override
    public boolean removeSocialLink(int id) {
        return slrc.removeSocialLink(id);
    }

    @Override
    public boolean removeSocialLinkbyUserId(int id) {
        return slrc.removeSocialLinkbyUserId(id);
    }

}
