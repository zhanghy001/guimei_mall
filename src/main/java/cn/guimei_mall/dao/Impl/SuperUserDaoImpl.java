package cn.guimei_mall.dao.Impl;
import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.dao.SuperUserDao;
import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SmallClass;
import cn.guimei_mall.entity.SuperUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员 Dao实现类 creatBy祝杰汉 2019-04-10
 */
public class SuperUserDaoImpl extends BaseDao implements SuperUserDao  {

    @Override  //管理员登录
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

    @Override   //根据id查询管理员
    public SuperUser QueryById(int superUserId) {
        SuperUser superUser=new SuperUser();
        try {
            String sql="SELECT * FROM `superuser` WHERE id="+superUserId;
            Object[] params={};
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

    @Override//根据ID修改管理员信息
    public boolean userUpdate(SuperUser superUser) {
        boolean flag=false;
        try {
            String sql="UPDATE `guimei`.`superuser` SET `userName` =? ,`userID` =? ,`userLoginName` =? WHERE `id` =? ";
            Object[] params={superUser.getUserName(),superUser.getUserID(),superUser.getUserLoginName(),superUser.getId()};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override //根据ID修改管理员密码
    public boolean userUpdatePwd(String pwd, int id) {
        boolean flag=false;
        try {
            String sql="UPDATE `guimei`.`superuser` SET `userPassword` =? WHERE `id` =?";
            Object[] params={pwd,id};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override//查询所有大分类
    public List<BigClass> getBigClassList(int pageCurrentNo, int totalPages) {
        List<BigClass> bigClassList =new ArrayList<>();
        Object[] params={};
        try {
            StringBuffer sql=new StringBuffer("SELECT * FROM `bigclass` WHERE 1=1");

            if (pageCurrentNo!=-1 && totalPages!=-1){
                sql.append(" LIMIT ?,?");
                 params= new Object[]{(pageCurrentNo - 1) * totalPages, totalPages};
            }
         //   Object[] params={(pageCurrentNo-1)*totalPages,totalPages};
            ResultSet rs=this.excuteSelect(sql.toString(),params);
            BigClass bIgClass;
            while (rs.next()){
                int id= rs.getInt("id");
                String bigName=rs.getString("bigName");
                String bigText=rs.getString("bigText");
                bIgClass=new BigClass();
                bIgClass.setId(id);
                bIgClass.setBigName(bigName);
                bIgClass.setBigText(bigText);
                bigClassList.add(bIgClass);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return bigClassList;
    }

    @Override    //查询所有分类条数
    public int bigCount() {
        int bigcout=0;
        try {
            String sql="SELECT COUNT(*) FROM `bigclass`";
            Object[] params={};
            ResultSet rs=this.excuteSelect(sql,params);
            while (rs.next()){
               bigcout=rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return bigcout;
    }

    @Override    //根据id查询大分类
    public BigClass getBigClassById(int id) {
        BigClass bIgClass=new BigClass();
        try {
            String sql="SELECT * FROM `bigclass` WHERE id="+id;
            Object[] params={};
            ResultSet rs=this.excuteSelect(sql,params);
            while (rs.next()){
                String bigName=rs.getString("bigName");
                String bigText=rs.getString("bigText");
                bIgClass.setId(rs.getInt("id"));
                bIgClass.setBigName(bigName);
                bIgClass.setBigText(bigText);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return bIgClass;
    }

    @Override  //根据id修改分类
    public boolean updateBigById(int id,String bigName,String bigText) {
        boolean flag=false;
        try {
            String sql="UPDATE `guimei`.`bigclass` SET `bigName` = ? , `bigText` =? WHERE `id` = ?; ";
            Object[] params={bigName,bigText,id};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override   //添加大分类
    public boolean creatBig(String bigName, String bigText) {
        boolean flag=false;
        try {
            String sql="INSERT INTO `guimei`.`bigclass` (`bigName`, `bigText`) VALUES (?,?)";
            Object[] params={bigName,bigText};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override   //删除大分类
    public boolean deleteBig(int id) {
        boolean flag=false;
        try {
            String sql=" DELETE FROM `guimei`.`bigclass` WHERE `id` ="+id;
            Object[] params={};
            int res=this.excutUpdateRows(sql,params);
            if (res>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return flag ;
    }

    @Override    //小分类查询
    public List<SmallClass> getSmllListBy(String smallName, int smallBigId, int pageCurrentNo, int totalPages) {
        List<SmallClass> smallClassList =new ArrayList<>();
        try {
            StringBuffer sql=new StringBuffer("SELECT s.`id`,s.`smallName`,s.`smallBigId`,b.`bigName`,s.`smallText` \n" +
                    "FROM `smallclass` s,`bigclass` b\n" +
                    "WHERE 1=1 AND s.`smallBigId`=b.`id`");
            if (null!=smallName && !"".equals(smallName)){
                sql.append(" AND s.`smallName` LIKE '%"+smallName+"%'");
            }
            if (smallBigId!=-1){
                sql.append(" AND s.`smallBigId`="+smallBigId);
            }
            sql.append(" LIMIT ?,?");
            Object[] params={(pageCurrentNo-1)*totalPages,totalPages};
            ResultSet rs=this.excuteSelect(sql.toString(),params);
            SmallClass smallClass;
            while (rs.next()){
                smallClass=new SmallClass();
                smallClass.setId(rs.getInt("id"));
                smallClass.setSmallName(rs.getString("smallName"));
                smallClass.setBigName(rs.getString("bigName"));
                smallClass.setSmallBigId(rs.getInt("smallBigId"));
                smallClass.setSmallText(rs.getString("smallText"));
                smallClassList.add(smallClass);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return smallClassList;
    }

    @Override //得到小分类条数
    public int getSmallCount(String smallName, int smallBigId) {
        int count=0;
        try {
            StringBuffer sql=new StringBuffer("SELECT COUNT(*) \n" +
                    "FROM smallclass\n" +
                    "WHERE 1=1");
            if (null!=smallName && !"".equals(smallName)){
                sql.append(" AND smallName LIKE '%"+smallName+"%'");
            }
            if (smallBigId!=-1){
                sql.append(" AND smallBigId="+smallBigId);
            }

            Object[] params={};
            ResultSet rs=this.excuteSelect(sql.toString(),params);

            while (rs.next()){
                 count=rs.getInt(1);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn();
        }
        return count;
    }


}
