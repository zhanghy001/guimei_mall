package cn.guimei_mall.dao;

import cn.guimei_mall.entity.GoodsNew;

import java.util.List;

public interface GoodsNewDao {
    /**
     * 查询全部
     */
    List<GoodsNew> getGoods(String goodsName,int goodsSeId,int goodsSmalId,int pageCurrentNo, int pageSize);
    /**
     * 查询商家名字
     */
    List<GoodsNew> getSellerName();
    /**
     * 查询小分类名
     */
    List<GoodsNew> getSmallName();
    /**
     *  折扣
     */
    List<GoodsNew> getDiscount();
    /**
     * 根据id查询
     */
    GoodsNew getIdGoods(int id);
    /**
     * 修改、
     */
    int updateGoods(GoodsNew good, int id);
    /**
     * 删除、
     */
    int delectgoods(int id);
    /**
     * 添加、级联查询
     */
    int addGoods(GoodsNew goods);
    /**
     * 分页
     */
    int getTotalCount();
}
