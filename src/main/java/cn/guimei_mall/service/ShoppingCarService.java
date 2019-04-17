package cn.guimei_mall.service;

import cn.guimei_mall.entity.All;
import cn.guimei_mall.entity.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {
    //根据用户id 和商品id 添加到购物车
    boolean addShoppingCar(int cusId, int goodsId);

    //根据用户id查询未提交的购物车
    List<All> getShopById(int cusId,int status);

    //根据id修改购物车中商品数量
    boolean updateGoodsNumber(int shopId,int num);

    //根据用户id删除未提交的购物车
    boolean deleteShop(int shopId);

    //修改订单状态
    boolean updateStatus(int cusId);


    //添加订单
    boolean addOrderse(List<All> allList,String url);


}
