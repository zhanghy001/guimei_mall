package cn.guimei_mall.service.customerService;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLogin {
    private String cusLoginName;
    private String cusPassword;

    public CustomerLogin() {
    }


    public void setCusLoginNme(String cusLoginNme) {
        this.cusLoginName = cusLoginNme;
    }

    public void setCusPassword(String cusPasswird) {
        this.cusPassword = cusPasswird;
    }

    /**
     * @return
     * 若用户名不存在或者用户名，密码不一致，将返回空
     * 否则从数据库读取相应的Customer数据并返回
     */
    public Customer ifCustomerLogin (){
        Customer customer=null;
        BaseDao baseDao=new BaseDao();
        String sql="select * from customer";
        ResultSet resultSet=baseDao.excuteSelect(sql,new Object[0]);
        try {
            while (resultSet.next()){
                if(cusLoginName.equals(resultSet.getString("cusLoginName"))&&cusPassword.equals(resultSet.getString("cusPassword"))){
                    customer=new Customer();
                    customer.setId(resultSet.getLong("id"));
                    customer.setCusName(resultSet.getString("cusName"));
                    customer.setCusLoginName(resultSet.getString("cusLoginName"));
                    customer.setCusPassword(resultSet.getString("cusPassword"));
                    customer.setCusEmail(resultSet.getString("cusEmail"));
                    customer.setCusSex(resultSet.getString("cusSex"));
                    customer.setCusPhoto(resultSet.getString("cusPhoto"));
                    customer.setCusHobby(resultSet.getString("cusHobby"));
                    customer.setCusCode(resultSet.getString("cusCode"));
                    customer.setCusBirthday(resultSet.getDate("cusBirthday"));
                    return customer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseDao.closeConn();
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customer;
    }
}
