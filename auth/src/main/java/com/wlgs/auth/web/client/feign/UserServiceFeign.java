package com.wlgs.auth.web.client.feign;

import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 14:06
 */
@FeignClient(name = "user")
public interface UserServiceFeign {
    @GetMapping(value = {"/user/userInfo/getUser"}, produces = {"application/json;charset=UTF-8"})
    UserExcecution getUser(@RequestParam("phone") String phone);
}
