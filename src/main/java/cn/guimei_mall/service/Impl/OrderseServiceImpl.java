package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.Impl.GoodsNewDaoImpl;
import cn.guimei_mall.dao.Impl.OrderseDaoImpl;
import cn.guimei_mall.dao.OrderseDao;
import cn.guimei_mall.entity.Orderse;
import cn.guimei_mall.service.OrderseService;

import java.util.List;

public class OrderseServiceImpl implements OrderseService {
    OrderseDao orderseDao = null;
    public OrderseServiceImpl() {
        orderseDao = new OrderseDaoImpl();
    }

    @Override
    public List<Orderse> getListbyId(int pageCurrentNo, int pageSize) {
        return null;
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public int updateOrderse(Orderse orderse) {
        return 0;
    }
}
