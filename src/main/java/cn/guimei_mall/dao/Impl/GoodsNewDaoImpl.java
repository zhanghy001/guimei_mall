package cn.guimei_mall.dao.Impl;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.GoodsNewDao;
import cn.guimei_mall.entity.GoodsNew;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品
 * Hao
 */
public class GoodsNewDaoImpl extends BaseDao implements GoodsNewDao {
    /**
     * 查询全部
     * @param pageCurrentNo
     * @param pagesize
     * @return
     */
    @Override
    public List<GoodsNew> getGoods(String goodName,int goodSeId,int goodSmalId,int pageCurrentNo, int pagesize) {
        List<GoodsNew> goodsList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("SELECT g.`id`,g.`goodsName`,g.`goodsSmalId`,sma.`smallName`,g.`goodsMoney`,g.`goodsNumber`,g.`goodsImage`,g.`goodsCarriage`,g.`goodsType`,g.`goodsSeId`,se.`sellerName`,g.`goodsDiscId`,dis.`discRate`\n" +
                    "FROM `goods` g " +
                    "INNER JOIN `smallclass` sma ON g.`goodsSmalId` = sma.`id`" +
                    "INNER JOIN `seller` se ON g.`goodsSeId` = se.`id` " +
                    "INNER JOIN `discount` dis ON g.`goodsDiscId` = dis.`id` " +
                    "WHERE  1=1 ");
            if (goodName != "" && goodName != null){
                sql.append(" AND goodsName ='"+goodName+"' ");
            }
            if (goodSeId != -1){
                sql.append(" AND goodsSeId = "+goodSeId);
            }
            if (goodSmalId != -1){
                sql.append(" AND goodsSmalId = "+goodSmalId);
            }

            sql.append(" limit ?,?");
            Object[] p = {(pageCurrentNo-1)*pagesize,pagesize};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                GoodsNew goods = new GoodsNew();
                int id = rs.getInt("id");
                String goodsName = rs.getString("goodsName");
                int goodsSmalId = rs.getInt("goodsSmalId");
                String goodsSmallName = rs.getString("smallName");
                double goodsMoney = rs.getDouble("goodsMoney");
                int goodsNumber = rs.getInt("goodsNumber");
                String goodsImage = rs.getString("goodsImage");
                double goodsCarriage = rs.getDouble("goodsCarriage");
                int goodsType = rs.getInt("goodsType");
                int goodsSeld = rs.getInt("goodsSeId");
                String goodsSeName =rs.getString("sellerName");
                int goodsDiscld = rs.getInt("goodsDiscId");
                double goodsDiscRate = rs.getDouble("discRate");


                goods.setId(id);
                goods.setGoodsName(goodsName);
                goods.setGoodsSmalId(goodsSmalId);
                goods.setGoodsSmallName(goodsSmallName);
                goods.setGoodsMoney(goodsMoney);
                goods.setGoodsNumber(goodsNumber);
                goods.setGoodsImage(goodsImage);
                goods.setGoodsCarriage(goodsCarriage);
                goods.setGoodsType(goodsType);
                goods.setGoodsSeId(goodsSeld);
                goods.setGoodsSeName(goodsSeName);
                goods.setGoodsDiscId(goodsDiscld);
                goods.setGoodsDiscRate(goodsDiscRate);

                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return goodsList;
    }

    /**
     * 得到商家
     * @return
     */
    @Override
    public List<GoodsNew> getSellerName() {
        List<GoodsNew> goodsList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("SELECT * FROM `seller`");

            Object[] p = {};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                GoodsNew goods = new GoodsNew();
                int id = rs.getInt("id");
                String sellerName = rs.getString("sellerName");

                goods.setId(id);
                goods.setGoodsSeName(sellerName);


                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return goodsList;
    }

    /**
     * 得到小分类
     * @return
     * SELECT * FROM `smallclass`
     */
    @Override
    public List<GoodsNew> getSmallName() {
        List<GoodsNew> goodsList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("SELECT * FROM `smallclass`");

            Object[] p = {};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                GoodsNew goods = new GoodsNew();
                int id = rs.getInt("id");
                String goodsSmallName = rs.getString("smallName");

                goods.setId(id);
                goods.setGoodsSmallName(goodsSmallName);


                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return goodsList;
    }

    /**
     * 折扣
     * @return
     */
    @Override
    public List<GoodsNew> getDiscount() {
        List<GoodsNew> goodsList = new ArrayList<>();
        try {
            // 获取连接
            this.getConn();
            //返回结果

            StringBuffer sql = new StringBuffer("SELECT * FROM `discount`");

            Object[] p = {};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){
                GoodsNew goods = new GoodsNew();
                int id = rs.getInt("id");
                Double goodsDiscRate = Double.parseDouble(rs.getString("discRate"));
                goods.setId(id);
                goods.setGoodsDiscRate(goodsDiscRate);

                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return goodsList;
    }

    /**
     * 根据Id 查询
     * @param gid
     * @return
     */
    @Override
    public GoodsNew getIdGoods(int gid) {
        GoodsNew goods = new GoodsNew();
        try {
            // 获取连接
            this.getConn();
            //返回结果
            StringBuffer sql = new StringBuffer("\tSELECT g.`id`,g.`goodsName`,g.`goodsSmalId`,sma.`smallName`,g.`goodsMoney`,g.`goodsNumber`,g.`goodsImage`,g.`goodsCarriage`,g.`goodsType`,g.`goodsSeId`,se.`sellerName`,g.`goodsDiscId`,dis.`discRate`\n" +
                    "\tFROM `goods` g\n" +
                    "\tINNER JOIN `smallclass` sma ON g.`goodsSmalId` = sma.`id`\n" +
                    "\tINNER JOIN `seller` se ON g.`goodsSeId` = se.`id` \n" +
                    "\tINNER JOIN `discount` dis ON g.`goodsDiscId` = dis.`id` \n" +
                    "\tWHERE g.`id` =?");
            Object[] p = {gid};
            ResultSet rs = this.excuteSelect(sql.toString(),p);

            while (rs.next()){

                int id = rs.getInt("id");
                String goodsName = rs.getString("goodsName");
                int goodsSmalId = rs.getInt("goodsSmalId");
                String goodsSmallName = rs.getString("smallName");
                double goodsMoney = rs.getDouble("goodsMoney");
                int goodsNumber = rs.getInt("goodsNumber");
                String goodsImage = rs.getString("goodsImage");
                double goodsCarriage = rs.getDouble("goodsCarriage");
                int goodsType = rs.getInt("goodsType");
                int goodsSeld = rs.getInt("goodsSeId");
                String goodsSeName =rs.getString("sellerName");
                int goodsDiscld = rs.getInt("goodsDiscId");
                double goodsDiscRate = rs.getDouble("discRate");

                goods.setId(id);
                goods.setGoodsName(goodsName);
                goods.setGoodsSmalId(goodsSmalId);
                goods.setGoodsSmallName(goodsSmallName);
                goods.setGoodsMoney(goodsMoney);
                goods.setGoodsNumber(goodsNumber);
                goods.setGoodsImage(goodsImage);
                goods.setGoodsCarriage(goodsCarriage);
                goods.setGoodsType(goodsType);
                goods.setGoodsSeId(goodsSeld);
                goods.setGoodsSeName(goodsSeName);
                goods.setGoodsDiscId(goodsDiscld);
                goods.setGoodsDiscRate(goodsDiscRate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return goods;
    }

    /**
     * 修改
     * @param good
     * @param id
     * @return
     */
    @Override
    public int updateGoods(GoodsNew good, int id) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "UPDATE `goods` " +
                    "SET `goodsName` = ?,`goodsSmalId` = ?,`goodsMoney` = ? , `goodsNumber` = ? , `goodsCarriage` = ? , `goodsType` = ? , `goodsSeId` = ? , `goodsDiscId` = ? \n" +
                    "WHERE `id` = ? ";
            Object [] p = {good.getGoodsName(),good.getGoodsSmalId(),good.getGoodsMoney(),good.getGoodsNumber(),good.getGoodsCarriage(),good.getGoodsType(),good.getGoodsSeId(),good.getGoodsDiscId(),id};

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
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delectgoods(int id) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "DELETE FROM goods WHERE id =?";
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

    /**
     * 添加
     * @param good
     * @return
     */
    @Override
    public int addGoods(GoodsNew good) {
        int ire = 0;
        try {
            this.getConn();
            //创建Statement 执行sql
            String sql = "INSERT INTO `guimei`.`goods` (`id`, `goodsName`, `goodsSmalId`, `goodsMoney`, `goodsNumber`, `goodsImage`, `goodsCarriage`, `goodsType`, `goodsSeId`, `goodsDiscId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object [] p = {good.getId(),good.getGoodsName(),good.getGoodsSmalId(),good.getGoodsMoney(),good.getGoodsNumber(),good.getGoodsImage(),good.getGoodsCarriage(),good.getGoodsType(),good.getGoodsSeId(),good.getGoodsDiscId()};

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

    public int getTotalCount(String goodsName, int goodsId, int smallId) {
        int a = 0;
        StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM `goods` g\n" +
                "                INNER  JOIN `smallclass` sm ON g.goodsSmalId=sm.id\n" +
                "                INNER JOIN `discount` d ON g.`goodsDiscId`=d.`id`\n" +
                "                WHERE 1=1");
        if (goodsId != -1) {
            sql.append(" AND g.`goodsSeId`=" + goodsId);
        }
        if (smallId != -1) {
            sql.append(" AND sm.`id`=" + smallId);
        }
        if (goodsName != null && goodsName != "") {
            sql.append(" AND g.`goodsName` LIKE" + "'%" + goodsName + "%'");
        }
        Object[] params = {};
        ResultSet rs = this.excuteSelect(sql.toString(), params);
        try {
            while (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConn();
        }
        return a;
    }




    /**
     * 分页
     * @return
     */
    @Override
    public int getTotalCount() {
        int totalCount = 0;
        try {
            // 加载驱动
            this.getConn();
            //创建Statement 执行sql
            StringBuffer sql = new StringBuffer("select count(*) from goods ");

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
