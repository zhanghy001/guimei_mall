package cn.guimei_mall.dao;



import cn.guimei_mall.entity.CustomerNew;

import java.util.List;

public interface CustomerNewDao {
    /**
     * 查询全部
     */
    List<CustomerNew> getCustomerNew(String cid,String name,String sex,int pageCurrentNo, int pageSize);
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
}
