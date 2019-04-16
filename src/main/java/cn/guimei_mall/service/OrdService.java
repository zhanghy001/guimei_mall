package cn.guimei_mall.service;

import cn.guimei_mall.entity.Ord;
import cn.guimei_mall.entity.Orderse;

import java.util.List;

public interface OrdService {
    //查询订单
    List<Ord> getListbyId(int pageCurrentNo, int pageSize);
    int getTotalCount();
    //修改订单状态
    int updateOrderse(Ord ord);
    //根据id查询
    public Ord FindById(int oid);
}
