package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.Impl.OrdDaoImpl;
import cn.guimei_mall.dao.Impl.OrderseDaoImpl;
import cn.guimei_mall.dao.OrdDao;
import cn.guimei_mall.dao.OrderseDao;
import cn.guimei_mall.entity.Ord;
import cn.guimei_mall.entity.Orderse;
import cn.guimei_mall.service.OrdService;

import java.util.List;

public class OrdServiceImpl implements OrdService {
  OrdDao ordDao = null;
    public OrdServiceImpl() {
        ordDao = new OrdDaoImpl();
    }
    @Override
    public List<Ord> getListbyId(int pageCurrentNo, int pageSize) {
        return ordDao.getListbyId(pageCurrentNo,pageSize);
    }

    @Override
    public int getTotalCount() {
        return ordDao.getTotalCount();
    }

    @Override
    public int updateOrderse(Ord ord) {
        return ordDao.updateOrderse(ord);
    }

    @Override
    public Ord FindById(int oid) {
        return ordDao.FindById(oid);
    }
}
