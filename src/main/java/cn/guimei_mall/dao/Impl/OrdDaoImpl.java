package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.OrdDao;
import cn.guimei_mall.entity.Customer;
import cn.guimei_mall.entity.Goods;
import cn.guimei_mall.entity.Ord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdDaoImpl extends BaseDao implements OrdDao {

    @Override
    public List<Ord> getListbyId(int pageCurrentNo, int pageSize) {
        List<Ord> newsList = new ArrayList<>();
        if(getConn()){
            try {
                String sql = "SELECT o.`id` id,g.`goodsName` gname,c.`cusName` cname,o.`orderseDate` odate,o.`orderseAddress` oaddress,o.`orderseMoney` omoney,o.`orderseStatus` ostatus\n" +
                        " FROM `orderse` o\n" +
                        " INNER JOIN `goods` g ON o.`orderseGoodsId` = g.`id`\n" +
                        " INNER JOIN `customer` c ON o.`orderseCusId`=c.`id` limit ?,?";
                Object[] param = {pageCurrentNo,pageSize};
                ResultSet rs = this.excuteSelect(sql, param);
                while (rs.next()) {
                    Ord ord = new Ord();
                    Goods goods=new Goods();
                    Customer customer=new Customer();
                    int id = rs.getInt("id");
                    String gname=rs.getString("gname");
                    String cname=rs.getString("cname");
                    Timestamp odate=rs.getTimestamp("odate");
                    String oaddress=rs.getString("oaddress");
                    double omoney=rs.getDouble("omoney");
                    int ostatus=rs.getInt("ostatus");
                    ord.setId(id);
                    goods.setGoodsName(gname);
                    customer.setCusName(cname);
                    ord.setGoods(goods);
                    ord.setCustomer(customer);
                    ord.setOrderseDate(odate);
                    ord.setOrderseAddress(oaddress);
                    ord.setOrderseMoney(omoney);
                    ord.setOrderseStatus(ostatus);
                    /*Date orderseDate = rs.getDate("orderseDate");
                    String orderseAddress = rs.getString("orderseAddress");
                    Double orderseMoney = rs.getDouble("orderseMoney");
                    int orderseStatus = rs.getInt("orderseStatus");
                    ord.setId(id);
                    ord.setOrderseGoodsId(orderseGoodsId);
                    ord.setOrderseCusId(orderseCusId);
                    ord.setOrderseDate(orderseDate);
                    ord.setOrderseAddress(orderseAddress);
                    ord.setOrderseMoney(orderseMoney);
                    ord.setOrderseStatus(orderseStatus);*/
                    newsList.add(ord);
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

    @Override
    public int getTotalCount() {
        ResultSet rs = null;
        int totalCount = 0;
            try {
                //创建statument执行sql
                StringBuffer sql = new StringBuffer("select COUNT(*) from `seller` where 1=1 ");
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

    @Override
    public int updateOrderse(Ord ord) {
        int ire = 0;
        try {
            String sql ="UPDATE `orderse` SET `orderseStatus`=? WHERE id =? ";
            Object[] params ={ord.getOrderseStatus(),ord.getId()};
            ire = this.excutUpdateRows(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return ire;
    }

    @Override
    public Ord FindById(int oid) {
        Ord ord = new Ord();
        if(getConn()) {
            try {
                String sql = "SELECT o.`id` id,g.`goodsName` gname,c.`cusName` cname,o.`orderseDate` odate,o.`orderseAddress` oaddress,o.`orderseMoney` omoney,o.`orderseStatus` ostatus\n" +
                        " FROM `orderse` o\n" +
                        " INNER JOIN `goods` g ON o.`orderseGoodsId` = g.`id`\n" +
                        " INNER JOIN `customer` c ON o.`orderseCusId`=c.`id` where o.id=?";
                Object[] param = new Object[]{oid};
                ResultSet rs = this.excuteSelect(sql, param);
                while (rs.next()) {
                    Goods goods = new Goods();
                    Customer customer = new Customer();
                    int id = rs.getInt("id");
                    String gname = rs.getString("gname");
                    String cname = rs.getString("cname");
                    Timestamp odate = rs.getTimestamp("odate");
                    String oaddress = rs.getString("oaddress");
                    double omoney = rs.getDouble("omoney");
                    int ostatus = rs.getInt("ostatus");
                    ord.setId(id);
                    goods.setGoodsName(gname);
                    customer.setCusName(cname);
                    ord.setGoods(goods);
                    ord.setCustomer(customer);
                    ord.setOrderseDate(odate);
                    ord.setOrderseAddress(oaddress);
                    ord.setOrderseMoney(omoney);
                    ord.setOrderseStatus(ostatus);
                }
            } catch (
                    SQLException e) {
                e.printStackTrace();
            } finally {
                //关闭资源
                this.closeConn();
            }
        }
        return ord;
    }
}
