package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.SellerDao;
import cn.guimei_mall.entity.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoimpl extends BaseDao implements SellerDao {

    @Override
    public List<Seller> getList() {
        List<Seller> newsList = new ArrayList<>();
        try {
        String sql="select `id`,`sellerName`,`sellerUser`,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel` from `seller`";
        ResultSet rs = this.excuteSelect(sql, null);
        while (rs.next()) {
           Seller s = new Seller();
            String sellerName = rs.getString("sellerName");
            String sellerUser = rs.getString("sellerUser");
            String sellerSex = rs.getString("sellerSex");
            Timestamp sellerBirthday = rs.getTimestamp("sellerBirthday");
            String sellerIdCard = rs.getString("sellerIdCard");
            String sellerEmail = rs.getString("sellerEmail");
            String sellerTel = rs.getString("sellerTel");
            String sellerAddress = rs.getString("sellerAddress");
            System.out.println( sellerName + "\t" + sellerUser + "\t" + sellerSex + "\t" + sellerBirthday + "\t" + sellerIdCard + "\t" + sellerEmail+"\t"+sellerTel+"\t"+sellerAddress);
            s.setSellerName(sellerName);
            s.setSellerUser(sellerUser);
            s.setSellerSex(sellerSex);
            s.setSerllerBDate(sellerBirthday);
            s.setSellerIdCard(sellerIdCard);
            s.setSellerEmail(sellerEmail);
            s.setSellerTel(sellerTel);
            s.setSellerAddress(sellerAddress);
            newsList.add(s);
        }
    } catch (
    SQLException e) {
        e.printStackTrace();
    } finally {
        //关闭资源
        this.closeConn();
    }
        return newsList;
    }

    @Override
    public Seller getsListById(int sId) {
      Seller seller = new Seller();
        try {
            String sql="select `id`,`sellerName`,`sellerUser`,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel` from `seller`where id=?";
            ResultSet rs = this.excuteSelect(sql, null);
            while (rs.next()) {
                Seller s = new Seller();
                String sellerName = rs.getString("sellerName");
                String sellerUser = rs.getString("sellerUser");
                String sellerSex = rs.getString("sellerSex");
                Timestamp sellerBirthday = rs.getTimestamp("sellerBirthday");
                String sellerIdCard = rs.getString("sellerIdCard");
                String sellerEmail = rs.getString("sellerEmail");
                String sellerTel = rs.getString("sellerTel");
                String sellerAddress = rs.getString("sellerAddress");
                System.out.println( sellerName + "\t" + sellerUser + "\t" + sellerSex + "\t" + sellerBirthday + "\t" + sellerIdCard + "\t" + sellerEmail+"\t"+sellerTel+"\t"+sellerAddress);
                s.setSellerName(sellerName);
                s.setSellerUser(sellerUser);
                s.setSellerSex(sellerSex);
                s.setSerllerBDate(sellerBirthday);
                s.setSellerIdCard(sellerIdCard);
                s.setSellerEmail(sellerEmail);
                s.setSellerTel(sellerTel);
                s.setSellerAddress(sellerAddress);

            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            this.closeConn();
        }
       return  seller;
    }

    /**
     * 删除
     * @param sId
     * @return
     */
    @Override
    public int deleteById(int sId) {
        int ire = 0;
        try {
            //创建statument执行sql
            String sql = "DELETE FROM `seller` WHERE id=?";
            Object[] params = {sId};
            ire = this.excutUpdateRows(sql, params);
            if (ire > 0) {
                System.out.println("删除成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConn();
        }
        return ire;
    }

    /**
     * 修改
     * @param seller
     * @return
     */
    @Override
    public int updateseller(Seller seller) {
        int ire = 0;
        try {
            //创建statument执行sql
            String sql = "UPDATE `seller` SET `sellerName`= ? , `sellerUser` = ? ," +
                    " `sellerSex` = ? ,`sellerBirthday`=?, `sellerIdCard` = ?, `sellerEmail`=?,`sellerTel`=? sellerAddress=? WHERE `id` = ?";
            Object[] params = {seller.getSellerName(), seller.getSellerUser(), seller.getSellerSex(),
                    seller.getSerllerBDate(), seller.getSellerIdCard(), seller.getSellerEmail(), seller.getSellerTel(),seller.getSellerAddress()};
            ire = this.excutUpdateRows(sql, params);
            if (ire > 0) {
                System.out.println("修改成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return ire;
    }

    /**
     * 添加
     * @param seller
     * @return
     */
    @Override
    public int addseller(Seller seller) {
        int ire = 0;
        try {
            //创建statument执行sql
            String sql = "INSERT INTO `seller`(`sellerName`,`sellerUser`,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel`,sellerAddress)VALUES (?, ?, ?, ?, ?, ?, ?)";
            Object[] params =  {seller.getSellerName(), seller.getSellerUser(), seller.getSellerSex(),
                    seller.getSerllerBDate(), seller.getSellerIdCard(), seller.getSellerEmail(), seller.getSellerTel(),seller.getSellerAddress()};
            ire = this.excutUpdateRows(sql, params);
            if (ire > 0) {
                System.out.println("添加成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return ire;
    }

    /**
     * 分页查询
     * @param sId
     * @param selleruser
     * @param pageCurrentNo
     * @param pagesize
     * @return
     */
    @Override
    public List<Seller> getNewsListBy(int sId, String selleruser, int pageCurrentNo, int pagesize) {
        List<Seller> newsList = new ArrayList<>();
        try {
            if (getConn()) {

                //创建statument执行sql
                StringBuffer sql = new StringBuffer("select * from news_detail where 1=1 ");
                if (sId != -1) {
                    sql.append(" and categoryId=" + sId);
                }
                if (selleruser != "" && selleruser != null) {
                    sql.append(" and title=\'" + selleruser + "\'");//加引号
                }
                sql.append(" limit ?,?");
                Object[] params = {(pageCurrentNo - 1) * pagesize, pagesize};
                ResultSet rs = this.excuteSelect(sql.toString(), params);
                while (rs.next()) {
                    Seller s = new Seller();
                    int id = rs.getInt("id");
                    String  sellerName = rs.getString("sellerName");
                    String sellerUser = rs.getString("sellerUser");
                    String sellerSex = rs.getString("sellerSex");
                    Timestamp sellerBirthday = rs.getTimestamp("sellerBirthday");
                    String sellerIdCard = rs.getString("sellerIdCard");
                    String sellerEmail = rs.getString("sellerEmail");
                    String sellerTel = rs.getString("sellerTel");
                    System.out.println(id + "\t" + id+ "\t" + sellerName + "\t" + sellerUser + "\t" + sellerSex + "\t" + sellerBirthday + "\t" + sellerIdCard + "\t" + sellerEmail+"\t"+sellerTel);
                    s.setSellerId(id);
                    s.setSellerName(sellerName);
                    s.setSellerUser(sellerUser);
                    s.setSellerSex(sellerSex);
                    s.setSerllerBDate(sellerBirthday);
                    s.setSellerIdCard(sellerIdCard);
                    s.setSellerEmail(sellerEmail);
                    s.setSellerTel(sellerTel);
                    newsList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return newsList;
    }

    /**
     * 分页
     * @param sid
     * @param selleruser
     * @return
     */
    @Override
    public int getTotalCount(int sid, String selleruser) {
        ResultSet rs = null;
        int totalCount = 0;
        try {
            //创建statument执行sql
            StringBuffer sql = new StringBuffer("select count(*) from news_detail where 1=1 ");
            if (sid != -1) {
                sql.append(" and categoryId=" + sid);
            }
            if (selleruser != "" && selleruser != null) {
                sql.append(" and title=" + "\'"+selleruser+"\'");
            }
            Object[] params = {};
            rs = this.excuteSelect(sql.toString(), params);
            while (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return totalCount;
    }


}
