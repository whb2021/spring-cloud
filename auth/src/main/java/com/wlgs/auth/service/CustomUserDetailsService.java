package com.wlgs.auth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wlgs.auth.web.client.feign.UserServiceFeign;
import com.wlgs.auth.web.entity.UserDetail;
import com.wlgs.auth.web.service.UserService;
import com.wlgs.common.web.dto.UserExcecution;
import com.wlgs.common.web.entity.User;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

   /* @Autowired
    private UserServiceFeign userServiceFeign;*/

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //查询业主信息
        try {
            UserExcecution ue = this.userServiceFeign.getUser(name);
            User user = JSON.parseObject(ue.getData().toString(), User.class);
            logger.info("user {} " + user.toString());
            UserDetail u = new UserDetail();
            if (user != null && user.getPhone() != null) {
                u.setUsername(user.getUserName());
                u.setPassword(user.getPassword());
                findCustomerPermission(u);
            }
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取用户错误 {}" + e.toString());
            throw new UsernameNotFoundException("获取用户错误");
        }

    }

    //角色权限部分
    public void findCustomerPermission(UserDetail u) {
        List<GrantedAuthority> authorities = Lists.newArrayList();
        authorities.add(new SimpleGrantedAuthority("test1"));
        authorities.add(new SimpleGrantedAuthority("test2"));
        u.setAuthorities(authorities);
    }
}
