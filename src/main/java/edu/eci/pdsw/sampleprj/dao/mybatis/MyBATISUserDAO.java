/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.basic.dto.User;
import edu.eci.pdsw.sampleprj.basic.mapper.UserMapper;
import edu.eci.pdsw.sampleprj.dao.UserDAO;

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

    public void save(User u) {
        System.out.println(">>>>>"+userMapper);
        userMapper.saveUser(u);
    }
    
}
