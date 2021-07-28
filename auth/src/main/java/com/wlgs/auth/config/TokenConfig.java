package com.wlgs.auth.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;


@Configuration
public class TokenConfig {

    //@Autowired 采用redis管理token
    //private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    // jdbc管理token
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    @Bean
    public TokenStore tokenStore() {
        // redis 管理令牌
//        return new RedisTokenStore(redisConnectionFactory);
        return new RedisTokenStore(redisConnectionFactory);
        //return new JdbcTokenStore(dataSource());
    }

}
