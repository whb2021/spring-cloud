package com.wlgs.guard.web.controller;

import com.wlgs.common.web.dto.GuardExcecution;
import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.enums.GuardStateEnum;
import com.wlgs.guard.web.client.feign.UserServiceFeign;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-28 11:05
 */
@Controller
@RequestMapping("/guard")
public class GuardController {

    //日志
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger("TestController.class");

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping(value = {"/getInfo"}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public GuardExcecution test() {
        try {
            UserExcecution user = this.userServiceFeign.getUser();
            logger.info("user {} " + user);
            return new GuardExcecution(GuardStateEnum.SUCCESS);
        } catch (Exception e) {
            return new GuardExcecution(GuardStateEnum.ERROR);
        }
    }
}
