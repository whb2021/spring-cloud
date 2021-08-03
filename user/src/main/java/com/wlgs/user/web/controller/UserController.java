package com.wlgs.user.web.controller;

import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.enums.UserStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author whb
 * @version 1.0
 * @date 2021-08-03 10:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //日志
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger("UserController.class");

    @GetMapping(value = {"/getUserInfo"}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public UserExcecution getUserInfo() {
        if (true) {
            return new UserExcecution(UserStateEnum.SUCCESS);
        } else {
            return new UserExcecution(UserStateEnum.ERROR);
        }
    }
}
