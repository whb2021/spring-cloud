package com.wlgs.auth.web.service;

import com.wlgs.common.web.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author whb
 * @version 1.0
 * @date 2020/9/23 10:09
 */
@Component
public interface UserService {

    @GetMapping(value = "/auths/getUser")
    User getUser(String phone);

}
