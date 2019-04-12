package cn.guimei_mall.dao;

import cn.guimei_mall.entity.GoodsNew;

import java.util.List;

public interface GoodsNewDao {
    /**
     * 查询全部
     */
    List<GoodsNew> getGoods(int pageCurrentNo, int pageSize);
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
