package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.GoodsNewDao;
import cn.guimei_mall.dao.Impl.GoodsNewDaoImpl;
import cn.guimei_mall.entity.GoodsNew;
import cn.guimei_mall.service.GoodsNewService;

import java.util.List;

public class GoodsNewServiceImpl implements GoodsNewService {
    GoodsNewDao goodsNewDao = null;
    public GoodsNewServiceImpl() {
        goodsNewDao = new GoodsNewDaoImpl();
    }

    @Override
    public List<GoodsNew> getGoods(int pageCurrentNo, int pageSize) {
        return goodsNewDao.getGoods(pageCurrentNo,pageSize);
    }

    @Override
    public GoodsNew getIdGoods(int id) {
        return goodsNewDao.getIdGoods(id);
    }

    @Override
    public int updateGoods(GoodsNew good, int id) {
        return goodsNewDao.updateGoods(good,id);
    }

    @Override
    public int delectgoods(int id) {
        return goodsNewDao.delectgoods(id);
    }

    @Override
    public int addGoods(GoodsNew goods) {
        return goodsNewDao.addGoods(goods);
    }

    @Override
    public int getTotalCount() {
        return goodsNewDao.getTotalCount();
    }
}
