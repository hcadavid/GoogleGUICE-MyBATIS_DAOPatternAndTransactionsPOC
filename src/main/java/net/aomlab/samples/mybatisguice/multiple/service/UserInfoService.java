package net.aomlab.samples.mybatisguice.multiple.service;

import net.aomlab.samples.mybatisguice.multiple.dto.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoService {

    UserInfo getUserInfo(String userId) throws Exception;
}
