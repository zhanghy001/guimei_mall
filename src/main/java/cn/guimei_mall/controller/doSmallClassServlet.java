package cn.guimei_mall.controller;

import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SmallClass;
import cn.guimei_mall.service.Impl.SuperUserServiceImpl;
import cn.guimei_mall.service.SuperUserService;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "doSmallClassServlet",urlPatterns = "/doSmall")
public class doSmallClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
