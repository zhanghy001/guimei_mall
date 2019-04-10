package cn.guimei_mall.service.Impl;
import cn.guimei_mall.dao.Impl.SuperUserDaoImpl;
import cn.guimei_mall.dao.SuperUserDao;
import cn.guimei_mall.entity.SuperUser;
import cn.guimei_mall.service.SuperUserService;
public class SuperUserServiceImpl implements SuperUserService {
    SuperUserDao superUserDao=new SuperUserDaoImpl();
    @Override
    public SuperUser login(String name, String pwd) {
        return superUserDao.login(name,pwd);
    }
}
