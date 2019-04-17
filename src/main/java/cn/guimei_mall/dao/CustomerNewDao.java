package cn.guimei_mall.dao;



import cn.guimei_mall.entity.CustomerNew;

import java.util.List;

public interface CustomerNewDao {
    /**
     * 登陆
     * @param cusLoginName
     * @param passWord
     * @return
     */
    CustomerNew cusLogin(String cusLoginName,String passWord);


    /**
     * 查询全部
     */
    List<CustomerNew> getCustomerNew(int cid,String name,String sex,int pageCurrentNo, int pagesize);
    /**
     * 根据id查询
     */
    CustomerNew getIdCustomerNew(int cid);
    /**
     * 修改、
     */
    int updateNews(CustomerNew cn, int cid);
    /**
     * 删除、
     */
    int delectCustomerNew(int id);
    /**
     * 添加、级联查询
     */
    int addAnn(CustomerNew customerNew);
    /**
     * 分页
     */
    int getTotalCount();
    /**
     * 查询总条数
     */
    int getTotalCount(int custId,String custName,String custSex);

    /**
     * 查询购物车总条数
     */
    int shoppingCarCount(int custId);


}
