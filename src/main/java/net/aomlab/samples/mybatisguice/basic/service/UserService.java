package net.aomlab.samples.mybatisguice.basic.service;

import net.aomlab.samples.mybatisguice.basic.dto.User;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    User doSomeBusinessStuff(String userId);

}
