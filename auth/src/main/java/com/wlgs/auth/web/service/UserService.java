package com.wlgs.auth.web.service;

import com.wlgs.auth.web.entity.User;

/**
 * @author whb
 * @version 1.0
 * @date 2020/9/23 10:09
 */
public interface UserService {
    User getUser(String phone);
}
