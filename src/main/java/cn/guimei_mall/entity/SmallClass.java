package cn.guimei_mall.entity;

/**
 * 小分类实体类 creatBy 祝杰汉 2019-04-12
 */
public class SmallClass {

    private int id;
    private String smallName;
    private String bigName;
    private int smallBigId;
    private String smallText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }

    public String getBigName() {
        return bigName;
    }

    public void setBigName(String bigName) {
        this.bigName = bigName;
    }

    public int getSmallBigId() {
        return smallBigId;
    }

    public void setSmallBigId(int smallBigId) {
        this.smallBigId = smallBigId;
    }

    public String getSmallText() {
        return smallText;
    }

    public void setSmallText(String smallText) {
        this.smallText = smallText;
    }


    @Override
    public String toString() {
        return "SmallClass{" +
                "id=" + id +
                ", smallName='" + smallName + '\'' +
                ", bigName='" + bigName + '\'' +
                ", smallBigId=" + smallBigId +
                ", smallText='" + smallText + '\'' +
                '}';
    }
}
