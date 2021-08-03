package com.wlgs.common.web.dto;

import com.wlgs.common.web.enums.GuardStateEnum;
import com.wlgs.common.web.enums.UserStateEnum;

/**
 * @author whb
 * @version 1.0
 * @date 2020-12-02 9:33
 */
public class GuardExcecution<T> {

    private int status;
    private String msg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public GuardExcecution() {

    }

    public GuardExcecution(GuardStateEnum stateEnum) {
        this.status = stateEnum.getStatus();
        this.msg = stateEnum.getMsg();
    }

    public GuardExcecution(GuardStateEnum stateEnum, T data) {
        this.status = stateEnum.getStatus();
        this.msg = stateEnum.getMsg();
        this.data = data;
    }
}
