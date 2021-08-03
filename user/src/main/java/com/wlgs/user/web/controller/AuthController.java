package com.wlgs.user.web.controller;

import com.alibaba.fastjson.JSON;
import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.entity.User;
import com.wlgs.common.web.enums.UserStateEnum;
import com.wlgs.user.web.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-28 11:05
 */
@Controller
@RequestMapping("/userInfo")
public class AuthController {

    //日志
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger("UserController.class");

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/getUser"}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public UserExcecution getUser(@RequestParam("phone") String phone) {
        User user = this.userService.getUserByName(phone);
        if (user != null) {
            String str = JSON.toJSONString(user);
            return new UserExcecution(UserStateEnum.SUCCESS, str);
        } else {
            return new UserExcecution(UserStateEnum.ERROR);
        }
    }

}
