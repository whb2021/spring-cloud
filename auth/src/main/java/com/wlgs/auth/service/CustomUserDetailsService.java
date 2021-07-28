package com.wlgs.auth.service;

import com.wlgs.auth.web.entity.UserDetail;
import com.wlgs.auth.web.service.UserService;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        //查询业主信息
        try {
            com.wlgs.auth.web.entity.User user = this.userService.getUser(phone);
            UserDetail u = new UserDetail();
            if (user != null && user.getPhone() != null) {
                u.setUsername(user.getPhone());
                u.setPassword(passwordEncoder.encode("1234"));
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
