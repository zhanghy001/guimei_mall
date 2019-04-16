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
    public CustomerNew cusLogin(String cusLoginName, String passWord) {
        return customerNewDao.cusLogin(cusLoginName,passWord);
    }

    @Override
    public List<CustomerNew> getCustomerNew(int cid,String name,String sex,int pageCurrentNo, int pagesize) {
        return customerNewDao.getCustomerNew(cid,name,sex,pageCurrentNo,pagesize);
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

    @Override
    public int getTotalCount(int custId, String custName, String custSex) {
        return customerNewDao.getTotalCount(custId,custName,custSex);
    }
}
