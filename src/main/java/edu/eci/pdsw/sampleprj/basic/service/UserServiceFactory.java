/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.basic.service;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;

/**
 *
 * @author hcadavid
 */
public class UserServiceFactory {

    private static UserServiceFactory instance = new UserServiceFactory();
    
    private static Injector injector;
    
    private UserServiceFactory(){
        injector = createInjector(new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.MySQL);                        
                        setClassPathResource("mybatis-config.xml");                        
                        bind(UserService.class).to(UserServiceDAOImpl.class);
                    }

                }
                
        );
        
    }

    public UserService getUserServices(){
        return injector.getInstance(UserService.class);   
    }

    
    public static UserServiceFactory getInstance(){
        return instance;
    }
    
}
