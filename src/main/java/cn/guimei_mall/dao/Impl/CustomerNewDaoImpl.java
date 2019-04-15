package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.CustomerNewDao;
import cn.guimei_mall.entity.CustomerNew;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerNewDaoImpl extends BaseDao implements CustomerNewDao {
    @Override
    public List<CustomerNew> getCustomerNew(String cid,String name,String sex,int pageCurrentNo, int pageSize) {
        List<CustomerNew> announcementList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("SELECT `id`,`cusName`,`cusLoginName`,`cusEmail`,`cusSex`,`cusPhoto`,`cusHobby`,`cusCode`,`cusBirthday` FROM `customer`");
            if (cid != "" && cid != null){
                sql.append(" AND id = "+Integer.parseInt(cid));
            }
            if (name != "" && name != null){
                sql.append(" AND cusName = "+name);
            }

            if (sex != "" && sex != null){
                sql.append(" AND cusSex = "+sex);
            }
            sql.append(" limit ?,?");
            Object[] p = {(pageCurrentNo-1)*pageSize,pageSize};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                //`id``cusName``cusLoginName``cusPassword``cusEmail``cusSex``cusPhoto``cusHobby``cusCode``cusBirthday`
                CustomerNew cn = new CustomerNew();
                int id = rs.getInt("id");
                String cusName = rs.getString("cusName");
                String cusLoginName = rs.getString("cusLoginName");

                String cusEmail = rs.getString("cusEmail");
                String cusSex = rs.getString("cusSex");
                String cusPhoto = rs.getString("cusPhoto");
                String cusHobby = rs.getString("cusHobby");
                String cusCode = rs.getString("cusCode");
                Date cusBirthday = rs.getTimestamp("cusBirthday");
                cn.setId(id);
                cn.setCusName(cusName);
                cn.setCusLoginName(cusLoginName);

                cn.setCusEmail(cusEmail);
                cn.setCusSex(cusSex);
                cn.setCusPhoto(cusPhoto);
                cn.setCusHobby(cusHobby);
                cn.setCusCode(cusCode);
                cn.setCusBirthday(cusBirthday);
                announcementList.add(cn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return announcementList;
    }

    @Override
    public CustomerNew getIdCustomerNew(int cid) {
        CustomerNew cn = new CustomerNew();
        try {
            // 获取连接
            this.getConn();
            //返回结果
            StringBuffer sql = new StringBuffer("SELECT * FROM `customer` WHERE id = ?");
            Object[] p = {cid};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                int id = rs.getInt("id");
                String cusName = rs.getString("cusName");
                String cusLoginName = rs.getString("cusLoginName");
                String cusPassword = rs.getString("cusPassword");
                String cusEmail = rs.getString("cusEmail");
                String cusSex = rs.getString("cusSex");
                String cusPhoto = rs.getString("cusPhoto");
                String cusHobby = rs.getString("cusHobby");
                String cusCode = rs.getString("cusCode");
                Date cusBirthday = rs.getTimestamp("cusBirthday");
                cn.setId(id);
                cn.setCusName(cusName);
                cn.setCusLoginName(cusLoginName);
                cn.setCusPassword(cusPassword);
                cn.setCusEmail(cusEmail);
                cn.setCusSex(cusSex);
                cn.setCusPhoto(cusPhoto);
                cn.setCusHobby(cusHobby);
                cn.setCusCode(cusCode);
                cn.setCusBirthday(cusBirthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return cn;
    }

    @Override
    public int updateNews(CustomerNew cn, int cid) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "UPDATE `guimei`.`customer` SET `cusName` = ? , `cusLoginName` = ? ,  `cusEmail` = ? ," +
                    " `cusSex` = ?  , `cusHobby` = ? , `cusCode` =? , `cusBirthday` = ? WHERE `id` = ? ";
            Object [] p = {cn.getCusName(),cn.getCusLoginName(),cn.getCusEmail(),cn.getCusSex(),cn.getCusHobby(),cn.getCusCode(),cn.getCusBirthday(),cid};

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

    @Override
    public int delectCustomerNew(int id) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "DELETE FROM customer WHERE id =?";
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
    public int addAnn(CustomerNew cn) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "INSERT INTO `customer` (`cusName`, `cusLoginName`, `cusPassword`, `cusEmail`, `cusSex`, `cusPhoto`, `cusHobby`, `cusCode`, `cusBirthday`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object [] p = {cn.getCusName(),cn.getCusLoginName(),cn.getCusPassword(),cn.getCusEmail(),cn.getCusSex(),cn.getCusPhoto(),cn.getCusHobby(),cn.getCusCode(),cn.getCusBirthday()};

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
