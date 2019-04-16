package cn.guimei_mall.dao;

import cn.guimei_mall.entity.Ord;
import cn.guimei_mall.entity.Orderse;

import java.util.List;

public interface OrdDao {
    //查询订单
    List<Ord> getListbyId(int pageCurrentNo, int pageSize);
    int getTotalCount();
    //修改订单状态
    int updateOrderse(Ord ord);
    //根据Id查询数据
    Ord FindById(int id);
}
