package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.AnnouncementDao;
import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.entity.Announcement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 * 公告
 * Hao
 */
public class AnnouncementDaoImpl extends BaseDao implements AnnouncementDao {
    @Override
    public List<Announcement> getAnnounce(int pageCurrentNo,int pageSize) {
        List<Announcement> announcementList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("select * from announcement");
            sql.append(" limit ?,?");
            Object[] p = {(pageCurrentNo-1)*pageSize,pageSize};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                Announcement ann = new Announcement();
                int id = rs.getInt("id");
                String aTitle = rs.getString("aTitle");
                String aText = rs.getString("aText");
                Timestamp aDate = rs.getTimestamp("aDate");
                ann.setId(id);
                ann.setaTitle(aTitle);
                ann.setaText(aText);
                ann.setaDate(aDate);
                announcementList.add(ann);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return announcementList;
    }

    @Override
    public Announcement getIdAnnounce(int aid) {
        Announcement ann = new Announcement();
        try {
            // 获取连接
            this.getConn();
            //返回结果
            String sql = "select * from announcement where id=?";
            Object[] p = {aid};
            ResultSet rs = this.excuteSelect(sql,p);
            while (rs.next()){
                int id = rs.getInt("id");
                String aTitle = rs.getString("aTitle");
                String aText = rs.getString("aText");
                Timestamp aDate = rs.getTimestamp("aDate");
                ann.setId(id);
                ann.setaTitle(aTitle);
                ann.setaText(aText);
                ann.setaDate(aDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return ann;
    }

    /**
     * 修改
     * @param ann
     * @param id
     * @return
     */
    @Override
    public int updateNews(Announcement ann, int id) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "UPDATE `announcement` SET `aTitle` = ? , `aText` = ? , `aDate` = ? WHERE `id` = ?";
            Object [] p = {ann.getaTitle(),ann.getaText(),ann.getaDate(),id};

            //返回结果
            ire = this.excutUpdateRows(sql,p);
            if (ire >0){
                System.out.println("修改成功");
            }
        }catch (Exception e){
            e.getMessage();
        } finally {
            closeConn();
        }
        return ire;
    }

    /**
     *  根据ID 删除
     * @param id
     * @return
     */
    @Override
    public int delectAnn(int id) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "DELETE FROM announcement WHERE id =?";
            Object [] p = {id};

            //返回结果
            ire = this.excutUpdateRows(sql,p);
            if (ire >0){
                System.out.println("删除成功");
            }
        }catch (Exception e){
            e.getMessage();
        } finally {
            closeConn();
        }
        return ire;
    }

    @Override
    public int addAnn(Announcement ann) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "INSERT INTO announcement (aTitle, aText, aDate) VALUES (?, ?, ?)";
            Object [] p = {ann.getaTitle(),ann.getaText(),ann.getaDate()};

            //返回结果
            ire = this.excutUpdateRows(sql,p);
            if (ire >0){
                System.out.println("添加成功");
            }
        }catch (Exception e){
            e.getMessage();
        } finally {
            closeConn();
        }
        return ire;
    }

    @Override
    public int getTotalCount() {
        int totalCount = 0;
        try {
            // 加载驱动
            this.getConn();
            //创建Statement 执行sql
            StringBuffer sql = new StringBuffer("select count(*) from announcement ");

            Object[] p = {};
            ResultSet rs= this.excuteSelect(sql.toString(),p);

            //返回结果
            while (rs.next()){
                totalCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();

        }
        return totalCount;
    }


}
