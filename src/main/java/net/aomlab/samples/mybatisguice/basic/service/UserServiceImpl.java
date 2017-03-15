package net.aomlab.samples.mybatisguice.basic.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.aomlab.samples.mybatisguice.basic.dto.User;
import net.aomlab.samples.mybatisguice.basic.mapper.UserMapper;
import net.aomlab.samples.mybatisguice.dao.mysql.MyBATISUserDAO;
import org.mybatis.guice.transactional.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    private MyBATISUserDAO daoUser;

    @Transactional
    public User doSomeBusinessStuff(String userId) {
            return daoUser.getUser(userId);
    }

}
