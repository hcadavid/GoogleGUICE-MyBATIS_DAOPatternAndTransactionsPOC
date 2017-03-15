package edu.eci.pdsw.sampleprj.basic.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.basic.dto.User;
import edu.eci.pdsw.sampleprj.basic.mapper.UserMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISUserDAO;
import org.mybatis.guice.transactional.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class UserServiceDAOImpl implements UserService {

    @Inject
    private MyBATISUserDAO daoUser;

    
    @Transactional
    public User doSomeBusinessStuff(String userId) {
            return daoUser.getUser(userId);
    }

    @Transactional
    @Override
    public void addUser(User u) {
            System.out.println("DAO>>>>"+daoUser);        
            daoUser.save(u);
    }
    
    
    
}
