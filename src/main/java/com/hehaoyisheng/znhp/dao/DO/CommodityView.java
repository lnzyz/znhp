package com.hehaoyisheng.znhp.dao.DO;

/**
 * Created by yunzhao on 2017/8/4.
 */
public class CommodityView {
    private Long id;
    private String name;
    private double price;
    private String overView;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
