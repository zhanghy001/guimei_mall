package cn.guimei_mall.service;

import cn.guimei_mall.entity.SuperUser;

public interface SuperUserService {
    //管理员登录
    SuperUser login(String name, String pwd);
}
