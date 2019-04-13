package cn.guimei_mall.service;

import cn.guimei_mall.entity.Orderse;

import java.util.List;

public interface OrderseService {
    //查询订单
    List<Orderse> getListbyId();
    //修改订单状态
    int updateOrderse(Orderse orderse);
}
