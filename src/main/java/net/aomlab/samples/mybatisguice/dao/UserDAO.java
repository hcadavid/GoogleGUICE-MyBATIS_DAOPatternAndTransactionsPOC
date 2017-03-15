/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aomlab.samples.mybatisguice.dao;

import net.aomlab.samples.mybatisguice.basic.dto.User;

/**
 *
 * @author hcadavid
 */
public interface UserDAO {
    
    public User getUser(String id);
    
}
