package com.hehaoyisheng.znhp.dao.DO;

/**
 * Created by yunzhao on 2017/8/5.
 */
public class ShoppingCartDO {
    private Long id;
    private Long userId;
    private String username;
    private Long commodityId;
    private String commodityName;
    private String commodityView;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityView() {
        return commodityView;
    }

    public void setCommodityView(String commodityView) {
        this.commodityView = commodityView;
    }
}
