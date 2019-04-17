package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.Impl.ShoppingCarDaoImpl;
import cn.guimei_mall.dao.ShoppingCarDao;
import cn.guimei_mall.entity.All;
import cn.guimei_mall.entity.ShoppingCar;
import cn.guimei_mall.service.ShoppingCarService;

import java.util.List;

public class ShoppingCarServiceImpl implements ShoppingCarService {
    ShoppingCarDao scd=new ShoppingCarDaoImpl();
    @Override
    public boolean addShoppingCar(int cusId, int goodsId) {
        return scd.addShoppingCar(cusId,goodsId);
    }

    @Override        //根据用户id查询未提交的购物车
    public List<All> getShopById(int cusId,int status) {
        return scd.getShopById(cusId,status);
    }

    @Override
    public boolean updateGoodsNumber(int shopId, int num) {
        return scd.updateGoodsNumber(shopId,num);
    }

    @Override
    public boolean deleteShop(int shopId) {
        return scd.deleteShop(shopId);
    }

    @Override
    public boolean updateStatus(int cusId) {
        return scd.updateStatus(cusId);
    }

    @Override
    public boolean addOrderse(List<All> allList, String url) {
        return scd.addOrderse(allList,url);
    }
}
