package cn.guimei_mall.controller;

import cn.guimei_mall.service.Impl.SellerServicecImpl;
import cn.guimei_mall.service.SellerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@WebServlet(name = "doGoods",urlPatterns = "/doGoods")
public class doGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String action = request.getParameter("action");
        SellerService newsService = new SellerServicecImpl();
        if (action == null || action == "") {
            action = "select";
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
