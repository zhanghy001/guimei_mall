package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.OrderseDao;
import cn.guimei_mall.entity.Orderse;
import cn.guimei_mall.entity.Seller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderseDaoImpl extends BaseDao implements OrderseDao {

    @Override
    public List<Orderse> getListbyId() {
        List<Orderse> newsList = new ArrayList<>();
       if(getConn()){
           try {
           String sql = "SELECT o.`id`,g.`goodsName`,c.`cusName`,o.`orderseDate`,o.`orderseAddress`,o.`orderseMoney`,o.`orderseStatus`\n" +
                   "FROM `orderse` o\n" +
                   "INNER JOIN `goods` g ON o.`orderseGoodsId` = g.`id`\n" +
                   "INNER JOIN `customer` c ON o.`orderseCusId`=c.`id`";
           Object[] param = {};
           ResultSet rs = this.excuteSelect(sql, param);
           while (rs.next()) {
              Orderse orderse = new Orderse();
               int id = rs.getInt("id");
               int orderseGoodsId = rs.getInt("orderseGoodsId");
               int orderseCusId = rs.getInt("orderseCusId");
               Date orderseDate = rs.getDate("orderseDate");
               String orderseAddress = rs.getString("orderseAddress");
               Double orderseMoney = rs.getDouble("orderseMoney");
               int orderseStatus = rs.getInt("orderseStatus");
               orderse.setId(id);
               orderse.setOrderseGoodsId(orderseGoodsId);
               orderse.setOrderseCusId(orderseCusId);
               orderse.setOrderseDate(orderseDate);
               orderse.setOrderseAddress(orderseAddress);
               orderse.setOrderseMoney(orderseMoney);
               orderse.setOrderseStatus(orderseStatus);
               newsList.add(orderse);
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
    public int updateOrderse(Orderse orderse) {
        int ire = 0;
        try {
        String sql ="UPDATE `orderse` SET `orderseStatus`=? WHERE id =? ";
        Object[] params ={orderse.getOrderseStatus(),orderse.getId()};
        ire = this.excutUpdateRows(sql,params);
        if(ire>0){
            System.out.println("修改成功!");
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return ire;

    }
}
