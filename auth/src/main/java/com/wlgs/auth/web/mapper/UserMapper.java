package com.wlgs.auth.web.mapper;

import com.wlgs.auth.web.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author whb
 * @version 1.0
 * @date 2020/9/23 10:10
 */
@Mapper
public interface UserMapper {

    UserDetail getUser(@Param("phone") String phone);

}


