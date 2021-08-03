package com.wlgs.user.web.mapper;

import com.wlgs.common.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 10:47
 */
@Mapper
public interface UserMapper {

    List<User> listUser();

    User getUserByName(@Param("name") String name);

}
