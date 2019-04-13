package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.SellerDao;
import cn.guimei_mall.entity.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerDaoImpl extends BaseDao implements SellerDao {
    @Override
    public Seller SellerLogin(String name, String pwd) {
        Seller seller = new Seller();
        boolean flag = false;
        if (getConn()) {
            String sql = "SELECT * FROM `seller` WHERE `sellerUser` =? AND  `sellerPassword`=? ";
            Object[] params = {name, pwd};
            ResultSet rs = this.excuteSelect(sql, params);
            try {

                while (rs.next()) {
                    seller.setSellerId(rs.getInt("id"));
                    seller.setSellerName(rs.getString("sellerName"));
                    seller.setSellerUser(rs.getString("sellerUser"));
                    seller.setSellerPassword(rs.getString("sellerPassword"));
                    seller.setSellerSex(rs.getString("sellerSex"));
                    seller.setSellerBirthday(rs.getDate("sellerBirthday"));
                    seller.setSellerIdCard(rs.getString("sellerIdCard"));
                    seller.setSellerEmail(rs.getString("sellerEmail"));
                    seller.setSellerTel(rs.getString("sellerTel"));
                    seller.setSellerAddress(rs.getString("sellerAddress"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.closeConn();
            }
        }
        return seller;

    }

    @Override
    public List<Seller> getList() {
        List<Seller> newsList = new ArrayList<>();
        if (getConn()) {

            try {
                String sql = "select `id`,`sellerName`,`sellerUser`,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel` from `seller`";
                Object[] param = {};
                ResultSet rs = this.excuteSelect(sql, param);
                while (rs.next()) {
                    Seller s = new Seller();
                    int id = rs.getInt("id");
                    String sellerName = rs.getString("sellerName");
                    String sellerUser = rs.getString("sellerUser");
                    String sellerSex = rs.getString("sellerSex");
                    Date sellerBirthday = rs.getDate("sellerBirthday");
                    String sellerIdCard = rs.getString("sellerIdCard");
                    String sellerEmail = rs.getString("sellerEmail");
                    String sellerTel = rs.getString("sellerTel");
                    String sellerAddress = rs.getString("sellerAddress");
                    s.setSellerId(id);
                    s.setSellerName(sellerName);
                    s.setSellerUser(sellerUser);
                    s.setSellerSex(sellerSex);
                    s.setSellerBirthday(sellerBirthday);
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

        }
        return newsList;
    }

    /**
     * 根据Id查询
     *
     * @param sId
     * @return
     */
    @Override
    public Seller getsListById(int sId) {
        Seller seller = new Seller();
        if (getConn()) {
            try {
                String sql = "select `id`,`sellerName`,`sellerUser`,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel` from `seller`where id=?";
                Object[] params = {sId};
                ResultSet rs = this.excuteSelect(sql, params);
                while (rs.next()) {
                    Seller s = new Seller();
                    int id = rs.getInt("id");
                    String sellerName = rs.getString("sellerName");
                    String sellerUser = rs.getString("sellerUser");
                    String sellerSex = rs.getString("sellerSex");
                    Date sellerBirthday = rs.getDate("sellerBirthday");
                    String sellerIdCard = rs.getString("sellerIdCard");
                    String sellerEmail = rs.getString("sellerEmail");
                    String sellerTel = rs.getString("sellerTel");
                    String sellerAddress = rs.getString("sellerAddress");
                    s.setSellerName(sellerName);
                    s.setSellerUser(sellerUser);
                    s.setSellerSex(sellerSex);
                    s.setSellerBirthday(sellerBirthday);
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
        }
        return seller;
    }

    /**
     * 删除
     *
     * @param sId
     * @return
     */
    @Override
    public int deleteById(int sId) {
        int ire = 0;
        if (getConn()) {
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
        }
        return ire;
    }

    /**
     * 修改
     *
     * @param seller
     * @return
     */
    @Override
    public int updateseller(Seller seller) {
        int ire = 0;
        if (getConn()) {
            try {
                //创建statument执行sql
                String sql = "UPDATE `seller` SET `sellerName`= ? , `sellerUser` = ? ," +
                        " `sellerSex` = ? ,`sellerBirthday`=?, `sellerIdCard` = ?, `sellerEmail`=?,`sellerTel`=? sellerAddress=? WHERE `id` = ?";
                Object[] params = {seller.getSellerName(), seller.getSellerUser(), seller.getSellerSex(),
                        seller.getSellerBirthday(), seller.getSellerIdCard(), seller.getSellerEmail(), seller.getSellerTel(), seller.getSellerAddress()};
                ire = this.excutUpdateRows(sql, params);
                if (ire > 0) {
                    System.out.println("修改成功!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConn();
            }
        }
        return ire;
    }

    /**
     * 添加
     *
     * @param seller
     * @return
     */
    @Override
    public int addseller(Seller seller) {
        int ire = 0;
        if (getConn()) {
            try {
                //创建statument执行sql
                String sql = "INSERT INTO `seller`(`sellerName`,`sellerUser`,sellerPassword,`sellerSex`,`sellerBirthday`,`sellerIdCard`,`sellerEmail`,`sellerTel`,sellerAddress)VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
                Object[] params = {seller.getSellerName(), seller.getSellerUser(), seller.getSellerPassword(),seller.getSellerSex(),
                        seller.getSellerBirthday(), seller.getSellerIdCard(), seller.getSellerEmail(), seller.getSellerTel(), seller.getSellerAddress()};
                ire = this.excutUpdateRows(sql, params);
                if (ire > 0) {
                    System.out.println("添加成功!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConn();
            }
        }
        return ire;
    }

    /**
     * 分页查询
     *
     * @param sId
     * @param selleruser
     * @param pageCurrentNo
     * @param pageSize
     * @return
     */
    @Override
    public List<Seller> getNewsListBy(int sId, String selleruser, int pageCurrentNo, int pageSize) {
        List<Seller> newsList = new ArrayList<>();
        if (getConn()) {
            //创建statument执行sql
            StringBuffer sql = new StringBuffer("select * from `seller` where 1=1 ");
            if (sId != 0) {
                sql.append(" and sId=" + sId);
            }
            if (selleruser != "" && selleruser != null) {
                sql.append(" and selleruser=\'" + selleruser + "\'");//加引号
            }
            sql.append(" limit ?,?");
            Object[] params = {pageCurrentNo, pageSize};
            ResultSet rs = this.excuteSelect(sql.toString(), params);
            try {
                while (rs.next()) {
                    Seller s = new Seller();
                    int id = rs.getInt("id");
                    String sellerName = rs.getString("sellerName");
                    String sellerUser = rs.getString("sellerUser");
                    String sellerSex = rs.getString("sellerSex");
                    Timestamp sellerBirthday = rs.getTimestamp("sellerBirthday");
                    String sellerIdCard = rs.getString("sellerIdCard");
                    String sellerEmail = rs.getString("sellerEmail");
                    String sellerTel = rs.getString("sellerTel");
                    String sellerAddress = rs.getString("sellerAddress");
                    s.setSellerId(id);
                    s.setSellerName(sellerName);
                    s.setSellerUser(sellerUser);
                    s.setSellerSex(sellerSex);
                    s.setSellerBirthday(sellerBirthday);
                    s.setSellerIdCard(sellerIdCard);
                    s.setSellerEmail(sellerEmail);
                    s.setSellerTel(sellerTel);
                    s.setSellerAddress(sellerAddress);
                    newsList.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConn();
            }
        }
        return newsList;
    }

    /**
     * 获取数据总数量
     *
     * @param sId
     * @param selleruser
     * @return
     */
    @Override
    public int getTotalCount(int sId, String selleruser) {
        ResultSet rs = null;
        int totalCount = 0;
        if (getConn()) {
            try {
                //创建statument执行sql
                StringBuffer sql = new StringBuffer("select COUNT(*) from `seller` where 1=1 ");
                if (sId != 0) {
                    sql.append(" and sId=" + sId);
                }
                if (selleruser != "" && selleruser != null) {
                    sql.append(" and selleruser=\'" + selleruser + "\'");//加引号
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
        }
        return totalCount;
    }


}
