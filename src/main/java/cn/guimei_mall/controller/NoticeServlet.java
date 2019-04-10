package cn.guimei_mall.controller;

import cn.guimei_mall.dao.daoImpl.AnnouncementDaoImpl;
import cn.guimei_mall.entity.Announcement;
import cn.guimei_mall.service.AnnouncementService;
import cn.guimei_mall.service.serviceImpl.AnnouncementServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NoticeServlet",urlPatterns = "/NoticeServlet")
public class NoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        AnnouncementService announ = new AnnouncementServiceImpl();

        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        System.out.println(action);
        if ("select".equals(action)){
            List<Announcement> list = announ.getAnnounce();
            String str = JSON.toJSONString(list);
            out.write(str);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
