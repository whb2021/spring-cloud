package com.wlgs.user.web.service.impl;

import com.wlgs.common.web.entity.User;
import com.wlgs.user.web.mapper.UserMapper;
import com.wlgs.user.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 11:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User getUserByName(String name) {
        return this.userMapper.getUserByName(name);
    }
}
