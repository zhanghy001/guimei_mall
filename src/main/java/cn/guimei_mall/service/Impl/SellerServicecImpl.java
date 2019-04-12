package cn.guimei_mall.service.Impl;

import cn.guimei_mall.dao.Impl.SellerDaoImpl;
import cn.guimei_mall.dao.SellerDao;
import cn.guimei_mall.entity.Seller;
import cn.guimei_mall.service.SellerService;

import java.util.List;

public class SellerServicecImpl implements SellerService {
    private SellerDao sellerDao;
    public SellerServicecImpl(){sellerDao = new SellerDaoImpl();}
    @Override
    public Seller SellerLogin(String name, String pwd) {
        return sellerDao.SellerLogin(name,pwd);
    }

    @Override
    public List<Seller> getList() {
        return sellerDao.getList();
    }

    @Override
    public Seller getsListById(int sId) {
        return sellerDao.getsListById(sId);
    }


    @Override
    public int deleteById(int sId) {
        return sellerDao.deleteById(sId);
    }

    @Override
    public int updateseller(Seller seller) {
        return sellerDao.updateseller(seller);
    }

    @Override
    public int addseller(Seller seller) {
        return sellerDao.addseller(seller);
    }

    @Override
    public List<Seller> getNewsListBy(int sId, String selleruser, int pageCurrentNo, int pageSize) {
        return sellerDao.getNewsListBy(sId,selleruser,pageCurrentNo,pageSize);
    }

    @Override
    public int getTotalCount(int sId, String selleruser) {
        return sellerDao.getTotalCount(sId,selleruser);
    }

}
