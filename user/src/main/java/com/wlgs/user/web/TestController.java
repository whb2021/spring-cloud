package com.wlgs.user.web;

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
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = {"/test"}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String test() {
        return "test";
    }
}
