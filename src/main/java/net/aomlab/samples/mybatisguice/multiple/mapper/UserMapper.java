package net.aomlab.samples.mybatisguice.multiple.mapper;

import net.aomlab.samples.mybatisguice.multiple.dto.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public interface UserMapper {

    @Select("SELECT * FROM usuario WHERE codigo = #{userId}")
    User getUser(@Param("userId") String userId);

}
