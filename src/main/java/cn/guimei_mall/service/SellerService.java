package cn.guimei_mall.service;

import cn.guimei_mall.entity.Seller;

import java.util.List;

public interface SellerService {
    //商家登陆
    Seller SellerLogin(String name,String pwd);
    //查询列表
    List<Seller> getList();
   //根据ID查询列表
   Seller getsListById(int sId);
    //根据ID删除
    int deleteById(int sId);
    //修改信息
    int updateseller(Seller seller);
    //增加新闻信息
    int addseller(Seller seller);

    List<Seller> getNewsListBy(int sId,String selleruser,int pageCurrentNo,int pageSize);

    int getTotalCount(int sId,String selleruser);
}
