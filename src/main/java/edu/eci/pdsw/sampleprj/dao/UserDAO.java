/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.sampleprj.basic.dto.User;

/**
 *
 * @author hcadavid
 */
public interface UserDAO {
    
    public User getUser(String id);
    
    public void save(User u);
    
}
