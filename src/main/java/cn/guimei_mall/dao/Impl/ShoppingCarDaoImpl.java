package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.ShoppingCarDao;
import cn.guimei_mall.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCarDaoImpl extends BaseDao implements ShoppingCarDao {

    @Override//根据用户id 和商品id 添加到购物车
    public boolean addShoppingCar(int cusId, int goodsId) {
        boolean flag=false;
        try {
            String sql="INSERT INTO `shoppingcar` (`scCusId`, `scGoodsId`, `scNumber`, `scStatus`) \n" +
                    "VALUES (?, ?, '1', '0'); ";
            Object[] params={cusId,goodsId};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;

    }

    @Override  //根据用户id查询未提交的购物车
    public  List<All> getShopById(int cusId ,int status) {

        List<All> allList =new ArrayList<>();
        try {
        String sql="select  * from shoppingcar as s,goods as g,customer as c,discount as d  where scCusId=c.id and scGoodsId=g.id and goodsDiscId=d.id and scCusId=? and scStatus=?";
        Object[] params={cusId,status};
            ResultSet rs=this.excuteSelect(sql,params);
            while (rs.next()){
                All all=new All();
                ShoppingCar shop=new ShoppingCar();
                shop.setId((int) rs.getLong("id"));
                shop.setScNumber((int) rs.getLong("scNumber"));
                shop.setScStatus((int) rs.getLong("scStatus"));
                all.setShoppingcar(shop);
                CustomerNew cus=new CustomerNew();
                cus.setCusName(rs.getString("cusName"));
                all.setCustomer(cus);
                GoodsNew goods=new GoodsNew();
                goods.setId((int) rs.getLong("g.id"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsMoney(rs.getDouble("goodsMoney"));
                goods.setGoodsNumber((int) rs.getLong("goodsNumber"));
                goods.setGoodsImage(rs.getString("goodsImage"));
                goods.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                goods.setGoodsType((int) rs.getLong("goodsType"));
                all.setGoods(goods);
                Discount dis=new Discount();
                dis.setDiscRate(rs.getDouble("discRate"));
                dis.setId((int) rs.getLong("d.id"));
                all.setDiscount(dis);
                all.setCheapPrice(rs.getDouble("goodsMoney")*rs.getDouble("discRate"));

                Orderse orderse=new Orderse();
                orderse.setOrderseMoney(rs.getDouble("goodsMoney")*(int) rs.getLong("scNumber"));
                all.setOrderse(orderse);
                allList.add(all);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return allList;
    }

    @Override//根据id修改购物车中商品数量
    public boolean updateGoodsNumber(int shopId, int num) {
        boolean flag=false;
        try {
            String sql="UPDATE `shoppingcar` SET `scNumber`=?  WHERE `id`=?";
            Object[] params={num,shopId};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override//根据用户id删除未提交的购物车
    public boolean deleteShop(int shopId) {
        boolean flag=false;
        try {
            String sql="DELETE FROM `shoppingcar` WHERE `id` =?";
            Object[] params={shopId};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override //修改订单状态
    public boolean updateStatus(int cusId) {
        boolean flag=false;
        try {
            String sql="UPDATE `shoppingcar` SET `scStatus`=1  WHERE `id`=?";
            Object[] params={cusId};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override
    public boolean addOrderse(List<All> allList, String url) {
        boolean ire=false;
        try {
            this.getConn();
            for(int i = 0 ;i < allList.size() ;i++){
                //创建Statement 执行sql
                String sql = "INSERT INTO `orderse` (`orderseGoodsId`, `orderseCusId`, `orderseDate`, `orderseAddress`, `orderseMoney`, `orderseStatus`)" +
                        "VALUES (?, ?, ?, ?, ?, ?)";

              //  System.out.println(allList.get(i).getOrderse().getOrderseMoney());
                Object[] params = {allList.get(i).getGoods().getId(),allList.get(i).getCustomer().getId(),new Date(),url,allList.get(i).getOrderse().getOrderseMoney(),0};
                //返回结果
                int res=this.excutUpdateRows(sql,params);
                if (res>0){
                //    System.out.println("探讨对方水电费手打");
                    ire=true;
                }
            }
        }catch (Exception e){
            e.getMessage();
        } finally {
            closeConn();
        }
        return ire;
    }
}
