package com.hehaoyisheng.znhp.dao.DO;

/**
 * Created by yunzhao on 2017/8/2.
 */
public class KindDO {
    private Long id;
    private String name;
    private int count;
    private Long upKindId;
    private String upKindName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getUpKindId() {
        return upKindId;
    }

    public void setUpKindId(Long upKindId) {
        this.upKindId = upKindId;
    }

    public String getUpKindName() {
        return upKindName;
    }

    public void setUpKindName(String upKindName) {
        this.upKindName = upKindName;
    }
}
