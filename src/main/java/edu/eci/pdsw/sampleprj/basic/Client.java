/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.basic;

import edu.eci.pdsw.sampleprj.basic.dto.User;
import edu.eci.pdsw.sampleprj.basic.service.UserServiceFactory;

/**
 *
 * @author hcadavid
 */
public class Client {

    public static void main(String a[]){
        UserServiceFactory.getInstance().getUserServices().addUser(new User(88223234,"aadaddda","x3x55sasd22","asdasdas","asdasdas"));
    }
    
}
