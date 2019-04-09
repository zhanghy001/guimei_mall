package cn.guimei_mall.dao;

import cn.guimei_mall.util.ConfigManager;

import java.sql.*;

public class BassDao {
    private Connection conn ;
    private PreparedStatement ps;
    private ResultSet rs;
    String driver = ConfigManager.getInstance().getValues("driver");
    String url = ConfigManager.getInstance().getValues("url");
    String username = ConfigManager.getInstance().getValues("username");
    String password = ConfigManager.getInstance().getValues("password");
    // 获取连接
    public boolean getConn(){
        boolean flag = false;
        // 加载驱动
        try {
//            Context ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");
//            conn = ds.getConnection();
            Class.forName(driver);
            // 获取连接
            conn = DriverManager.getConnection(url,username,password);
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //查询
    public ResultSet excuteSelect(String sql,Object[] p){
        if (getConn()) {
            //创建Statement 执行sql
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < p.length; i++) {
                    ps.setObject(i + 1, p[i]);
                }
                rs = ps.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    //更新
    public int excutUpdateRows(String sql,Object[] p) {
        int ire = 0;
        if (getConn()) {
            //创建Statement 执行sql
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < p.length; i++) {
                    ps.setObject(i + 1, p[i]);
                }
                ire = ps.executeUpdate();
                return ire;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ire;
    }

    // 关闭连接
    public void closeConn(){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
