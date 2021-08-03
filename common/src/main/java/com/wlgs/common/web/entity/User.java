package com.wlgs.common.web.entity;

import lombok.Data;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 10:36
 */
@Data
public class User {
    private Long userId;
    private String userName;
    private String phone;
    private String password;
}
