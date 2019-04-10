package cn.guimei_mall.entity;

/**
 * Created by 爬树猛男1997 on 2019/4/10.
 * 管理员实体类
 */
public class SuperUser {

    private int id;
    private String userName;         //真实姓名
    private String userPassWord;     //登录密码
    private String userImage;        //头像路径 可设置默认
    private int userStatus;          //管理员状态 0可用 1冻结
    private String userID;           //管理员身份证号
    private String userLoginName;    //管理员登录名


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }
}
