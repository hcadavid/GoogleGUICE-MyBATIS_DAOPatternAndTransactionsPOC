package net.aomlab.samples.mybatisguice.multiple.mapper;

import net.aomlab.samples.mybatisguice.multiple.dto.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/13
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoMapper {

    @Select("SELECT * FROM userinfo WHERE id = #{userId}")
    UserInfo getUserInfo(@Param("userId") String userId);

}
