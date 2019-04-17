package cn.guimei_mall.entity;

public class ShoppingCar {
    //购物车编号
    private long id;
    //顾客编号
    private long scCusId;
    //商品编号
    private long scGoodsId;
    //购物车数量
    private int scNumber;
    //购物车状态
    private int scStatus;

    /**
     * 无参构造
     */
    public ShoppingCar() {
    }

    /**
     * 带参构造函数
     * @param id
     * @param scCusId
     * @param scGoodsId
     * @param scNumber
     * @param scStatus
     */
    public ShoppingCar(long id, long scCusId, long scGoodsId, int scNumber, int scStatus) {
        this.id = id;
        this.scCusId = scCusId;
        this.scGoodsId = scGoodsId;
        this.scNumber = scNumber;
        this.scStatus = scStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScCusId() {
        return scCusId;
    }

    public void setScCusId(long scCusId) {
        this.scCusId = scCusId;
    }

    public long getScGoodsId() {
        return scGoodsId;
    }

    public void setScGoodsId(long scGoodsId) {
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
