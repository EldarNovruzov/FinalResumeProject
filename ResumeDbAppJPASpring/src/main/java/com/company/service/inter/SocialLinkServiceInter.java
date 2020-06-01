/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.SocialLink;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface SocialLinkServiceInter {
    
    public List<SocialLink> getAllSocialLinkByUserId(int id);

    public boolean insertSocialLink(SocialLink sl);

    public boolean updateSocialLink(SocialLink sl);

    public boolean removeSocialLink(int id);

    public boolean removeSocialLinkbyUserId(int id);
}
