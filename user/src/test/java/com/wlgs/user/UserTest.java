package com.wlgs.user;

import com.wlgs.common.web.entity.User;
import com.wlgs.user.web.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 10:51
 */
@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    //日志
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger("UserTest.class");

    @Autowired
    private UserMapper userMapper;

    @Test
    public void listUser() {
        List<User> list = userMapper.listUser();
        logger.info("list {}" + list.toString());
    }

}
