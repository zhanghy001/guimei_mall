package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.CustomerNewDao;
import cn.guimei_mall.dao.Impl.CustomerNewDaoImpl;
import cn.guimei_mall.entity.CustomerNew;
import cn.guimei_mall.service.CustomerNewService;

import java.util.List;

public class CustomerNewServiceImpl implements CustomerNewService {
    CustomerNewDao customerNewDao = null;
    public CustomerNewServiceImpl() {
        customerNewDao = new CustomerNewDaoImpl();
    }

    @Override
    public List<CustomerNew> getCustomerNew(String cid,String name,String sex,int pageCurrentNo, int pageSize) {
        return customerNewDao.getCustomerNew(cid,name,sex,pageCurrentNo,pageSize);
    }

    @Override
    public CustomerNew getIdCustomerNew(int cid) {
        return customerNewDao.getIdCustomerNew(cid);
    }

    @Override
    public int updateNews(CustomerNew cn, int cid) {
        return customerNewDao.updateNews(cn,cid);
    }

    @Override
    public int delectCustomerNew(int id) {
        return customerNewDao.delectCustomerNew(id);
    }

    @Override
    public int addAnn(CustomerNew customerNew) {
        return customerNewDao.addAnn(customerNew);
    }

    @Override
    public int getTotalCount() {
        return customerNewDao.getTotalCount();
    }
}
