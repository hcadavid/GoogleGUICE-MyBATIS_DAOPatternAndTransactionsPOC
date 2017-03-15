/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aomlab.samples.mybatisguice.dao.mysql;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.aomlab.samples.mybatisguice.basic.dto.User;
import net.aomlab.samples.mybatisguice.basic.mapper.UserMapper;
import net.aomlab.samples.mybatisguice.dao.UserDAO;

/**
 *
 * @author hcadavid
 */
@Singleton
public class MyBATISUserDAO implements UserDAO{

    @Inject
    private UserMapper userMapper;    
    
    public User getUser(String id) {
        return this.userMapper.getUser(id);
    }
    
}
