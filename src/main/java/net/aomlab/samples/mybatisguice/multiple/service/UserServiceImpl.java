package net.aomlab.samples.mybatisguice.multiple.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.aomlab.samples.mybatisguice.basic.service.UserService;
import net.aomlab.samples.mybatisguice.multiple.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Transactional
    public net.aomlab.samples.mybatisguice.basic.dto.User doSomeBusinessStuff(String userId) {
            return this.userMapper.getUser(userId);
    }

}
