package cn.guimei_mall.entity;

/**
 * 购物车实体类
 */
public class ShoppingCar {
    private  int id;
    private  int scCusId;
    private  int scGoodsId;
    private  int scNumber;
    private  int scStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScCusId() {
        return scCusId;
    }

    public void setScCusId(int scCusId) {
        this.scCusId = scCusId;
    }

    public int getScGoodsId() {
        return scGoodsId;
    }

    public void setScGoodsId(int scGoodsId) {
        this.scGoodsId = scGoodsId;
    }

    public int getScNumber() {
        return scNumber;
    }

    public void setScNumber(int scNumber) {
        this.scNumber = scNumber;
    }

    public int getScStatus() {
        return scStatus;
    }

    public void setScStatus(int scStatus) {
        this.scStatus = scStatus;
    }
}
