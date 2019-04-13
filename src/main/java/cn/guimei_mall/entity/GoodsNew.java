package cn.guimei_mall.entity;

/**
 * 商品实体类
 * 朱豪
 */
public class GoodsNew {
    // id
    int id;
    String goodsName;
    int goodsSmalId;
    String goodsSmallName; // 类别名
    double goodsMoney;
    int goodsNumber;
    String goodsImage;
    double goodsCarriage;
    int goodsType;
    int goodsSeId;
    String goodsSeName; // 类别名
    int goodsDiscId;
    double goodsDiscRate; // 折扣价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsSmalId() {
        return goodsSmalId;
    }

    public void setGoodsSmalId(int goodsSmalId) {
        this.goodsSmalId = goodsSmalId;
    }

    public String getGoodsSmallName() {
        return goodsSmallName;
    }

    public void setGoodsSmallName(String goodsSmallName) {
        this.goodsSmallName = goodsSmallName;
    }

    public double getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public double getGoodsCarriage() {
        return goodsCarriage;
    }

    public void setGoodsCarriage(double goodsCarriage) {
        this.goodsCarriage = goodsCarriage;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public int getGoodsSeId() {
        return goodsSeId;
    }

    public void setGoodsSeId(int goodsSeId) {
        this.goodsSeId = goodsSeId;
    }

    public String getGoodsSeName() {
        return goodsSeName;
    }

    public void setGoodsSeName(String goodsSeName) {
        this.goodsSeName = goodsSeName;
    }

    public int getGoodsDiscId() {
        return goodsDiscId;
    }

    public void setGoodsDiscId(int goodsDiscId) {
        this.goodsDiscId = goodsDiscId;
    }

    public double getGoodsDiscRate() {
        return goodsDiscRate;
    }

    public void setGoodsDiscRate(double goodsDiscRate) {
        this.goodsDiscRate = goodsDiscRate;
    }
}
