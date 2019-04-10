package cn.guimei_mall.dao;

import cn.guimei_mall.entity.SuperUser;

public interface SuperUserDao {

    //管理员登录
    SuperUser login(String name, String pwd);



}
