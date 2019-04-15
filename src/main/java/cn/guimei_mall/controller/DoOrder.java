package cn.guimei_mall.controller;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.entity.Customer;
import cn.guimei_mall.entity.Goods;
import cn.guimei_mall.entity.Orderse;
import cn.guimei_mall.util.PageSupport;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name="DoOrder",urlPatterns = "/doOrder")
public class DoOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =""+ req.getParameter("action");
        HttpSession httpSession=req.getSession();
        Customer customer=(Customer)httpSession.getAttribute("customer");
        long Id=customer.getId();
        BaseDao baseDao=new BaseDao();

        switch(action){
            case "init":{
                PageSupport pageSupport=new PageSupport();
                String sql="SELECT\n" +
                        "count(*)\n" +
                        "FROM\n" +
                        "customer AS c\n" +
                        "INNER JOIN orderse AS o ON c.id = o.orderseCusId\n" +
                        "INNER JOIN goods AS g ON o.orderseGoodsId = g.id\n"+
                        "where c.id=?";
                Object[] objects=new Object[1];
                objects[0]=Id;
                ResultSet resultSet=baseDao.excuteSelect(sql,objects);
                int rsCount=0;
                try {
                    while (resultSet.next()){
                        rsCount=resultSet.getInt(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                pageSupport.setTotalCount(rsCount);
                pageSupport.setpagesize(1);
                pageSupport.setTotalPages(pageSupport.getTotalPages());


                httpSession.setAttribute("pageSupport",pageSupport);
                resp.sendRedirect("/Customer/GUIMEI/ordersInformation.jsp");
                return;
            }
            case "first":{
                PageSupport pageSupport=(PageSupport) httpSession.getAttribute("pageSupport");
                pageSupport.setPageCurrentNo(1);
                httpSession.setAttribute("pageSupport",pageSupport);
                break;
            }
            case "forward":{
                PageSupport pageSupport=(PageSupport) httpSession.getAttribute("pageSupport");
                int pageCurrentNo=pageSupport.getPageCurrentNo();
                if(pageCurrentNo<2){
                    pageCurrentNo=1;
                }else{
                    pageCurrentNo--;
                }
                pageSupport.setPageCurrentNo(pageCurrentNo);
                httpSession.setAttribute("pageSupport",pageSupport);
                break;
            }
            case "next":{
                PageSupport pageSupport=(PageSupport) httpSession.getAttribute("pageSupport");
                int pageCurrentNo=pageSupport.getPageCurrentNo();
                if(pageCurrentNo+1>pageSupport.getTotalPages()){
                    pageCurrentNo=pageSupport.getTotalPages();
                }else{
                    pageCurrentNo++;
                }
                pageSupport.setPageCurrentNo(pageCurrentNo);
                httpSession.setAttribute("pageSupport",pageSupport);
                break;
            }
            case "last":{
                PageSupport pageSupport=(PageSupport) httpSession.getAttribute("pageSupport");
                pageSupport.setPageCurrentNo(pageSupport.getTotalPages());
                httpSession.setAttribute("pageSupport",pageSupport);
                break;
            }
        }

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
                "where c.id=?\n" +
                "limit ?,?";
        Object[] objects=new Object[3];
        PageSupport pageSupport=(PageSupport) httpSession.getAttribute("pageSupport");
        objects[0]=Id;
        objects[1]=(pageSupport.getPageCurrentNo()-1)*pageSupport.getpagesize();
        objects[2]=pageSupport.getpagesize();


        List list=new LinkedList();
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
        list.add(pageSupport);
        String str=new Gson().toJson(list);
        PrintWriter out=resp.getWriter();
        out.write(str);
        baseDao.closeConn();
        out.flush();
        out.close();
    }

    private class GoodsAndOrderse{
        Goods goods;
        Orderse orderse;
    }
}
