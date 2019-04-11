package cn.guimei_mall.entity;

import java.util.Date;

public class Orderse {
    long id;
    long orderseGoodsId;
    long orderseCusId;
    Date orderseDate;
    String orderseAddress;
    double orderseMoney;
    int orderseStatus;

    public Orderse(){}

    public long getId() {
        return id;
    }

    public long getOrderseGoodsId() {
        return orderseGoodsId;
    }

    public long getOrderseCusId() {
        return orderseCusId;
    }

    public Date getOrderseDate() {
        return orderseDate;
    }

    public String getOrderseAddress() {
        return orderseAddress;
    }

    public double getOrderseMoney() {
        return orderseMoney;
    }

    public int getOrderseStatus() {
        return orderseStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderseGoodsId(long orderseGoodsId) {
        this.orderseGoodsId = orderseGoodsId;
    }

    public void setOrderseCusId(long orderseCusId) {
        this.orderseCusId = orderseCusId;
    }

    public void setOrderseDate(Date orderseDate) {
        this.orderseDate = orderseDate;
    }

    public void setOrderseAddress(String orderseAddress) {
        this.orderseAddress = orderseAddress;
    }

    public void setOrderseMoney(double orderseMoney) {
        this.orderseMoney = orderseMoney;
    }

    public void setOrderseStatus(int orderseStatus) {
        this.orderseStatus = orderseStatus;
    }
}
