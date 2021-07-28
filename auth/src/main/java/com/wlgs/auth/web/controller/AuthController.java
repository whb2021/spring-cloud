package com.wlgs.auth.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author whb
 * @version 1.0
 * @date 2020/9/24 15:41
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/authority")
    public Principal user(Principal auth) {
        return auth;
    }
}
