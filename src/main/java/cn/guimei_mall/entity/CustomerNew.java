package cn.guimei_mall.entity;

import java.util.Date;

/**
 * 顾客
 * zh
 * `id``cusName``cusLoginName``cusPassword``cusEmail``cusSex``cusPhoto``cusHobby``cusCode``cusBirthday`
 */
public class CustomerNew {
    private int id ;
    private String cusName;
    private String cusLoginName;
    private String cusPassword ;
    private String cusEmail;
    private String cusSex;
    private  String cusPhoto;
    private  String cusHobby;
    private  String cusCode;
    private Date cusBirthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusLoginName() {
        return cusLoginName;
    }

    public void setCusLoginName(String cusLoginName) {
        this.cusLoginName = cusLoginName;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusPhoto() {
        return cusPhoto;
    }

    public void setCusPhoto(String cusPhoto) {
        this.cusPhoto = cusPhoto;
    }

    public String getCusHobby() {
        return cusHobby;
    }

    public void setCusHobby(String cusHobby) {
        this.cusHobby = cusHobby;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public Date getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(Date cusBirthday) {
        this.cusBirthday = cusBirthday;
    }
}
