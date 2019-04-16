package cn.guimei_mall.dao;

import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SmallClass;
import cn.guimei_mall.entity.SuperUser;

import java.util.List;

/**
 * 管理员 Dao  createBy祝杰汉 2019-04-10
 */
public interface SuperUserDao {

    //管理员登录
    SuperUser login(String name, String pwd);

    //根据ID查询管理员
    SuperUser QueryById(int superUserId);

    //根据ID修改管理员信息
    boolean userUpdate(SuperUser superUser);

    //根据ID修改管理员密码
    boolean userUpdatePwd(String pwd,int id);

    //查询所有大分类
    List<BigClass> getBigClassList(int pageCurrentNo, int totalPages);

    //查询所有分类条数
    int bigCount();

    //根据id查询大分类
    BigClass getBigClassById(int id);

    //根据id修改分类
    boolean updateBigById(int id,String bigName,String bigText);

    //添加大分类
    boolean creatBig(String bigName,String bigText);

    //删除大分类
    boolean deleteBig(int id);

    //小分类查询
    List<SmallClass> getSmllListBy(String smallName,int smallBigId,int pageCurrentNo, int totalPages);

    //得到小分类条数
    int getSmallCount(String smallName,int smallBigId);

    //添加小分类
    boolean creatSmall(String smallName,int smallBigId,String smallText);

    //删除小分类
    boolean deleteSmall(int id);


    //根据id查询小分类
    SmallClass getSmallClassById(int id);

    //根据id修改小分类
    boolean updateSmallById(int id,String smallName,int smallBigId,String smallText);



}
