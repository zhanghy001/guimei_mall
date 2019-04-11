package cn.guimei_mall.controller;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.entity.Customer;
import cn.guimei_mall.entity.Goods;
import cn.guimei_mall.entity.Orderse;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name="DoOrder",urlPatterns = "/doOrder")
public class DoOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseDao baseDao=new BaseDao();
        String sql="SELECT\n" +
                "o.orderseDate,\n" +
                "o.orderseAddress,\n" +
                "o.orderseMoney,\n" +
                "o.orderseStatus,\n" +
                "g.goodsName,\n" +
                "g.goodsMoney\n" +
                "FROM\n" +
                "customer AS c\n" +
                "INNER JOIN orderse AS o ON c.id = o.orderseCusId\n" +
                "INNER JOIN goods AS g ON o.orderseGoodsId = g.id\n"+
                "where id=?";
        Object[] objects=new Object[1];
        HttpSession httpSession=req.getSession();
        Customer customer=(Customer)httpSession.getAttribute("customer");
        objects[0]=customer.getId();
        List<GoodsAndOrderse> list=new LinkedList<>();
        ResultSet resultset=baseDao.excuteSelect(sql,objects);
        try {
            while (resultset.next()) {
                    GoodsAndOrderse goodsAndOrderse=new GoodsAndOrderse();
                    Goods goods=new Goods();
                    Orderse orderse=new Orderse();
                    orderse.setOrderseDate(resultset.getDate(1));
                    orderse.setOrderseAddress(resultset.getString(2));
                    orderse.setOrderseMoney(resultset.getDouble(3));
                    orderse.setOrderseStatus(resultset.getInt(4));
                    goods.setGoodsName(resultset.getString(5));
                    goods.setGoodsMoney(resultset.getDouble(6));
                    goodsAndOrderse.goods=goods;
                    goodsAndOrderse.orderse=orderse;
                    list.add(goodsAndOrderse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String str=JSON.toJSONString(list);
        PrintWriter out=resp.getWriter();
        out.write(str);
        out.close();
    }

    private class GoodsAndOrderse{
        Goods goods;
        Orderse orderse;
    }
}
