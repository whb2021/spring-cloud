package com.wlgs.guard.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author whb
 * @version 1.0
 * @date 2021-01-05 14:34
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {

        Map<String, Object> map = new HashMap<>();
        Throwable cause = authException.getCause();

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", 401);
            jsonObject.put("msg", "用户凭证错误");
            if (cause instanceof InvalidTokenException) {
                response.getWriter().write(jsonObject.toJSONString());
            } else {
                response.getWriter().write(jsonObject.toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
