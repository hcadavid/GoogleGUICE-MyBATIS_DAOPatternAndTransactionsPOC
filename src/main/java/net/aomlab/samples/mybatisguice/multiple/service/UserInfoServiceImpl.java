package net.aomlab.samples.mybatisguice.multiple.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.aomlab.samples.mybatisguice.multiple.dto.UserInfo;
import net.aomlab.samples.mybatisguice.multiple.mapper.UserInfoMapper;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/13
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class UserInfoServiceImpl implements UserInfoService {

    @Inject
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String userId) {
        return this.userInfoMapper.getUserInfo(userId);
    }

}
