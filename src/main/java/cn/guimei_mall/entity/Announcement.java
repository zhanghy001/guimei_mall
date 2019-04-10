package cn.guimei_mall.entity;

import java.util.Date;

public class Announcement {
    /**
     * 编号
     */
    private int id;
    /**
     * 标题
     */
    private String aTitle;
    /**
     * 内容
     */
    private String aText;
    /**
     * 时间
     */
    private Date aDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }
}
