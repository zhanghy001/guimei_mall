package cn.guimei_mall.entity;


import java.util.Date;

/**
 *商家类
 */
public class Seller {
    private int sellerId;//商家id
    private String sellerName;//名称
    private String sellerUser;//登陆帐号
    private String sellerPassword;//密码
    private String sellerSex;//性别
    private Date sellerBirthday;//出生日期
    private String sellerIdCard;//证件号
    private String sellerEmail;//邮箱
    private String sellerTel;//联系电话
    private String sellerAddress;//地址


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerUser() {
        return sellerUser;
    }

    public void setSellerUser(String sellerUser) {
        this.sellerUser = sellerUser;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public String getSellerSex() {
        return sellerSex;
    }

    public void setSellerSex(String sellerSex) {
        this.sellerSex = sellerSex;
    }
    public Date getSellerBirthday() {
        return sellerBirthday;
    }

    public void setSellerBirthday(Date sellerBirthday) {
        this.sellerBirthday = sellerBirthday;
    }

    public String getSellerIdCard() {
        return sellerIdCard;
    }

    public void setSellerIdCard(String sellerIdCard) {
        this.sellerIdCard = sellerIdCard;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerTel() {
        return sellerTel;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }
}
