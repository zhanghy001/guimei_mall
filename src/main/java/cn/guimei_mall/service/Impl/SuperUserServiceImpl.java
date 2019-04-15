package cn.guimei_mall.service.Impl;
import cn.guimei_mall.dao.Impl.SuperUserDaoImpl;
import cn.guimei_mall.dao.SuperUserDao;
import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SmallClass;
import cn.guimei_mall.entity.SuperUser;
import cn.guimei_mall.service.SuperUserService;

import java.util.List;

/**
 * 管理员 service creatBy祝杰汉 2019-04-10
 */
public class SuperUserServiceImpl implements SuperUserService {
    //Dao层对象
    SuperUserDao superUserDao=new SuperUserDaoImpl();
    @Override //登录
    public SuperUser login(String name, String pwd) {
        return superUserDao.login(name,pwd);
    }

    @Override //根据id查询
    public SuperUser QueryById(int superUserId) {
        return superUserDao.QueryById(superUserId);
    }

    @Override //根据ID修改管理员信息
    public boolean userUpdate(SuperUser superUser) {
        return superUserDao.userUpdate(superUser);
    }

    @Override //根据ID修改管理员密码
    public boolean userUpdatePwd(String pwd, int id) {
        return superUserDao.userUpdatePwd(pwd,id);
    }

    @Override    //查询所有大分类

    public List<BigClass> getBigClassList(int pageCurrentNo, int totalPages) {
        return superUserDao.getBigClassList(pageCurrentNo,totalPages);
    }

    @Override    //查询所有分类条数
    public int bigCount() {
        return superUserDao.bigCount();
    }

    @Override    //根据id查询大分类
    public BigClass getBigClassById(int id) {
        return superUserDao.getBigClassById(id);
    }

    @Override    //根据id修改分类
    public boolean updateBigById(int id, String bigName, String bigText) {
        return superUserDao.updateBigById(id,bigName,bigText);
    }

    @Override    //添加大分类
    public boolean creatBig(String bigName, String bigText) {
        return superUserDao.creatBig(bigName,bigText);
    }

    @Override   //删除大分类
    public boolean deleteBig(int id) {
        return superUserDao.deleteBig(id);
    }

    @Override   //小分类查询
    public List<SmallClass> getSmllListBy(String smallName, int smallBigId, int pageCurrentNo, int totalPages) {
        return superUserDao.getSmllListBy(smallName,smallBigId,pageCurrentNo,totalPages);
    }

    @Override    //得到小分类条数
    public int getSmallCount(String smallName, int smallBigId) {
        return superUserDao.getSmallCount(smallName,smallBigId);
    }

    @Override    //添加小分类
    public boolean creatSmall(String smallName, int smallBigId, String smallText) {
        return superUserDao.creatSmall(smallName,smallBigId,smallText);
    }

    @Override    //删除小分类
    public boolean deleteSmall(int id) {
        return superUserDao.deleteSmall(id);
    }

    @Override
    public SmallClass getSmallClassById(int id) {
        return superUserDao.getSmallClassById(id);
    }

    @Override
    public boolean updateSmallById(int id,String smallName,int smallBigId,String smallText) {
        return superUserDao.updateSmallById(id,smallName,smallBigId,smallText);
    }
}
