package com.hehaoyisheng.znhp.controller.DTO;

import com.hehaoyisheng.znhp.constant.ZnhpStatusCodes;

/**
 * 返回数据基础类，所有AJAX请求返回值必须被包装进这个类
 * Created by yunzhao on 2017/7/29.
 */
public class BaseDTO {
    private int status;
    private String massage;
    private Object data;
    private int total;

    public static BaseDTO createSuccessBaseDTO(Object data){
        return new BaseDTO(ZnhpStatusCodes.SUCCESS.getValue(), ZnhpStatusCodes.SUCCESS.getDesc(), data, 0);
    }

    public static BaseDTO createSuccessBaseDTO(Object data, int total){
        return new BaseDTO(ZnhpStatusCodes.SUCCESS.getValue(), ZnhpStatusCodes.SUCCESS.getDesc(), data, total);
    }

    public static BaseDTO createErrorBaseDTO(ZnhpStatusCodes znhpStatusCodes){
        return new BaseDTO(znhpStatusCodes.getValue(), znhpStatusCodes.getDesc(), null, 0);
    }

    private BaseDTO(){};

    private BaseDTO(int status, String massage, Object data, int total) {
        this.status = status;
        this.massage = massage;
        this.data = data;
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
