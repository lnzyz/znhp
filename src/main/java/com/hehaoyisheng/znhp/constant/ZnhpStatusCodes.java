package com.hehaoyisheng.znhp.constant;

/**
 * Created by yunzhao on 2017/7/29.
 */
public enum ZnhpStatusCodes {

    SUCCESS(200, "SUCCESS", "成功"),
    LOGIN_FALSE(201, "LOGIN_FALSE", "用户名或密码错误！"),
    PHONE_EXESL(401, "PHONE_EXESL", "手机号码不正确"),
    PHONE_HAVED(402, "PHONE_HAVED", "手机号码已存在"),
    MESSAGE_SEND(403, "MESSAGE_SEND", "短信发送失败"),
    USER_EXIST(405, "USER_EXIST", "用户已存在"),
    CHECK_CODE_ERROR(406, "CHECK_CODE_ERROR", "验证码错误！"),
    SYSTEM_ERROR(500, "SYSTEM_ERROR", "系统异常!"),
    USER_NOT_LOGIN(407, "USER_NOT_LOGIN", "用户未登陆"),
    DATA_NOT_FOUND(404, "DATA_NOT_FOUND", "您所请求的资源不存在");

    ZnhpStatusCodes(){}

    private int    value;
    private String code;
    private String desc;

    ZnhpStatusCodes(int value, String code, String desc){
        this.value = value;
        this.code = code;
        this.desc = desc;
    }

    public static ZnhpStatusCodes getType(int value){
        for(ZnhpStatusCodes znhpStatusCodes : ZnhpStatusCodes.values()){
            if(znhpStatusCodes.getValue() == value){
                return znhpStatusCodes;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

}
