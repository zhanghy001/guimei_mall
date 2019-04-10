package cn.guimei_mall.dao.Impl;
import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.SuperUserDao;
import cn.guimei_mall.entity.SuperUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuperUserDaoImpl extends BaseDao implements SuperUserDao  {

    @Override
    public SuperUser login(String name, String pwd) {
        SuperUser superUser=new SuperUser();
        try {
            String sql="SELECT * FROM `superuser` WHERE `userLoginName` =? AND  `userPassword`=? ";
            Object[] params={name,pwd};
            ResultSet rs=this.excuteSelect(sql,params);
            while (rs.next()){
                int id= rs.getInt("id");
                String userName=rs.getString("userName");
                String userPassWord=rs.getString("userPassWord");
                String userImage=rs.getString("userImage");
                int userStatus=rs.getInt("userStatus");
                String userID=rs.getString("userID");
                String userLoginName=rs.getString("userLoginName");
                superUser.setId(id);
                superUser.setUserName(userName);
                superUser.setUserPassWord(userPassWord);
                superUser.setUserImage(userImage);
                superUser.setUserStatus(userStatus);
                superUser.setUserID(userID);
                superUser.setUserLoginName(userLoginName);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return superUser ;
    }
}
