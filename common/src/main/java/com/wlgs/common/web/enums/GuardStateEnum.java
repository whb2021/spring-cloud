package com.wlgs.common.web.enums;

/**
 * @author whb
 * @version 1.0
 * @date 2021-07-30 10:41
 */
public enum GuardStateEnum {

    SUCCESS(1, "成功"),
    ERROR(2, "错误");

    private int status;
    private String msg;

    private GuardStateEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }


    public String getMsg() {
        return msg;
    }


    public static GuardStateEnum stateOf(int state) {
        for (GuardStateEnum stateEnum : values()) {
            if (stateEnum.getStatus() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
