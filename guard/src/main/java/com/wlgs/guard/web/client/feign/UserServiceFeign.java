package com.wlgs.guard.web.client.feign;

import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.guard.web.client.feign.back.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 14:06
 */
@FeignClient(name = "user", fallback = UserFallBack.class)
public interface UserServiceFeign {
    @GetMapping(value = {"/user/user/getUserInfo"}, produces = {"application/json;charset=UTF-8"})
    UserExcecution getUser();
}
