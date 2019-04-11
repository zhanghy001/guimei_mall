package cn.guimei_mall.entity;

public class Goods {
    long id;
    String goodsName;
    long goodsSmallId;
    double goodsMoney;
    int goodsNumber;
    String goodsImage;
    double goodsCarriage;
    int goodsType;
    int goodsSeld;
    int goodsDiscld;

    public Goods() {
    }

    public long getId() {
        return id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public long getGoodsSmallId() {
        return goodsSmallId;
    }

    public double getGoodsMoney() {
        return goodsMoney;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public double getGoodsCarriage() {
        return goodsCarriage;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public int getGoodsSeld() {
        return goodsSeld;
    }

    public int getGoodsDiscld() {
        return goodsDiscld;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsSmallId(long goodsSmallId) {
        this.goodsSmallId = goodsSmallId;
    }

    public void setGoodsMoney(double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public void setGoodsCarriage(double goodsCarriage) {
        this.goodsCarriage = goodsCarriage;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public void setGoodsSeld(int goodsSeld) {
        this.goodsSeld = goodsSeld;
    }

    public void setGoodsDiscld(int goodsDiscld) {
        this.goodsDiscld = goodsDiscld;
    }
}
