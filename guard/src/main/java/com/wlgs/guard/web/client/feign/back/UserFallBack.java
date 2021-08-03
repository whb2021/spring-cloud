package com.wlgs.guard.web.client.feign.back;

import com.alibaba.fastjson.JSONObject;
import com.wlgs.common.web.dto.GuardExcecution;
import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.enums.GuardStateEnum;
import com.wlgs.common.web.enums.UserStateEnum;
import com.wlgs.guard.web.client.feign.UserServiceFeign;
import org.springframework.context.annotation.Configuration;

/**
 * @author whb
 * @version 1.0
 * @date 2021-08-03 11:14
 */
@Configuration
public class UserFallBack implements UserServiceFeign {

    @Override
    public UserExcecution getUser() {
        return new UserExcecution(UserStateEnum.SUCCESS);
    }

}
