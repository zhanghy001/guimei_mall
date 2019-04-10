package cn.guimei_mall.entity;

/**
 * 商家登陆类
 */
public class User {
    private String sellerName;//商家名称
    private String sellerPwd;//商家密码

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPwd() {
        return sellerPwd;
    }

    public void setSellerPwd(String sellerPwd) {
        this.sellerPwd = sellerPwd;
    }
}
