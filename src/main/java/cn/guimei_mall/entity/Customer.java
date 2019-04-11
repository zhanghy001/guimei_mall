package cn.guimei_mall.entity;
import java.util.Date;

public class Customer {

    private long id;//主键
    private String cusName;
    private String cusLoginName;
    private String cusPassword;
    private String cusEmail;
    private String cusSex;
    private String cusPhoto;
    private String cusHobby;
    private String cusCode;
    private Date cusBirthday;//对应数据库中的Date类型

    public Customer() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() { return id; }

    public String getCusName() {
        return cusName;
    }

    public String getCusLoginName() {
        return cusLoginName;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public String getCusSex() {
        return cusSex;
    }

    public String getCusPhoto() {
        return cusPhoto;
    }

    public String getCusHobby() {
        return cusHobby;
    }

    public String getCusCode() {
        return cusCode;
    }

    public Date getCusBirthday() {
        return cusBirthday;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusLoginName(String cusLoginName) {
        this.cusLoginName = cusLoginName;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public void setCusEmail(String cusEnail) {
        this.cusEmail = cusEnail;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public void setCusPhoto(String cusPhoto) {
        this.cusPhoto = cusPhoto;
    }

    public void setCusHobby(String cusHobby) {
        this.cusHobby = cusHobby;
    }


    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public void setCusBirthday(Date date) {
        this.cusBirthday = date;
    }

}
