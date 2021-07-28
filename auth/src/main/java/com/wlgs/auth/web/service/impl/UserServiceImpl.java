package com.wlgs.auth.web.service.impl;

import com.wlgs.auth.web.entity.User;
import com.wlgs.auth.web.entity.UserDetail;
import com.wlgs.auth.web.mapper.UserMapper;
import com.wlgs.auth.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whb
 * @version 1.0
 * @date 2020/9/23 10:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String phone) {
        User u = new User();
        u.setId(1L);
        u.setPhone("13138895161");
        return u;
    }
}

