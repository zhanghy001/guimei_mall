package cn.guimei_mall.controller;

import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SuperUser;

import cn.guimei_mall.service.SuperUserService;
import cn.guimei_mall.service.Impl.SuperUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doUserServlet",urlPatterns = "/doUser")
public class doUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
