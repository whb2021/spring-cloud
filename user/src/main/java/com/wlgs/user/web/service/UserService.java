package com.wlgs.user.web.service;

import com.wlgs.common.web.entity.User;

import java.util.List;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 11:01
 */

public interface UserService {
    List<User> listUser();

    User getUserByName(String name);
}
