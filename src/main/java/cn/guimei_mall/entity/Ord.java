package cn.guimei_mall.entity;

import java.util.Date;

public class Ord {
    long id;
    long orderseGoodsId;
    long orderseCusId;
    Date orderseDate;
    String orderseAddress;
    double orderseMoney;
    int orderseStatus;
    String goodsName;
    String cusName;
    private Goods goods;
    private Customer customer;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderseGoodsId() {
        return orderseGoodsId;
    }

    public void setOrderseGoodsId(long orderseGoodsId) {
        this.orderseGoodsId = orderseGoodsId;
    }

    public long getOrderseCusId() {
        return orderseCusId;
    }

    public void setOrderseCusId(long orderseCusId) {
        this.orderseCusId = orderseCusId;
    }

    public Date getOrderseDate() {
        return orderseDate;
    }

    public void setOrderseDate(Date orderseDate) {
        this.orderseDate = orderseDate;
    }

    public String getOrderseAddress() {
        return orderseAddress;
    }

    public void setOrderseAddress(String orderseAddress) {
        this.orderseAddress = orderseAddress;
    }

    public double getOrderseMoney() {
        return orderseMoney;
    }

    public void setOrderseMoney(double orderseMoney) {
        this.orderseMoney = orderseMoney;
    }

    public int getOrderseStatus() {
        return orderseStatus;
    }

    public void setOrderseStatus(int orderseStatus) {
        this.orderseStatus = orderseStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
