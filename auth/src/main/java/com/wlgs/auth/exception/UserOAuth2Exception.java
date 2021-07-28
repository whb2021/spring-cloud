package com.wlgs.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = UserOAuth2ExceptionSerializer.class)
public class UserOAuth2Exception extends OAuth2Exception {

    private Integer status = 200;

    public UserOAuth2Exception(String message, Throwable t) {
        super(message, t);
        status = ((OAuth2Exception) t).getHttpErrorCode();
    }

    public UserOAuth2Exception(String message) {
        super(message);
    }

    @Override
    public int getHttpErrorCode() {
        return status;
    }

}