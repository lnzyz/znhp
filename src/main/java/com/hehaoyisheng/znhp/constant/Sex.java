package com.hehaoyisheng.znhp.constant;

/**
 * Created by yunzhao on 2017/7/30.
 */
public enum Sex {
    MAN(1, "MAN", "男"),
    WOMAN(2, "WOMAN", "女");

    Sex(){}

    private int    value;
    private String code;
    private String desc;

    Sex(int value, String code, String desc){
        this.value = value;
        this.code = code;
        this.desc = desc;
    }
}
