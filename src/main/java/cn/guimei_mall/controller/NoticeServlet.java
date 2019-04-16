package cn.guimei_mall.controller;

import cn.guimei_mall.entity.Announcement;
import cn.guimei_mall.service.AnnouncementService;

import cn.guimei_mall.service.Impl.AnnouncementServiceImpl;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * 公告
 * Hao
 */
@WebServlet(name = "NoticeServlet",urlPatterns = "/NoticeServlet")
public class NoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AnnouncementService announ = new AnnouncementServiceImpl();

        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if ("select".equals(action)){
            int pageCurrentNo = Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pagesize =  Integer.parseInt(request.getParameter("pagesize"));
            List<Announcement> list = announ.getAnnounce(pageCurrentNo,pagesize);
            PageSupport pageSupport = new PageSupport();
            pageSupport.setpagesize(pagesize);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setTotalCount(announ.getTotalCount());
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(list);
            String pageSupportJson= JSON.toJSONStringWithDateFormat(pageSupport,"yyyy-MM-dd");

            out.write(pageSupportJson);
        }else if ("selectid".equals(action)){
            String id = request.getParameter("id"); // 获取 ID
            Announcement announcement = announ.getIdAnnounce(Integer.parseInt(id));

            String pageSupportJson= JSON.toJSONStringWithDateFormat(announcement,"yyyy-MM-dd");
            out.write(pageSupportJson);
        }else if ("add".equals(action)){
            try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String aTitle = request.getParameter("aTitle");
            String aText = request.getParameter("aText");
            String aDate = request.getParameter("aDate");
                Date date = f.parse(aDate);
                Announcement ann = new Announcement();
                ann.setaTitle(aTitle);
                ann.setaText(aText);
                ann.setaDate(date);

                int i = announ.addAnn(ann);

                boolean flag = false;
                if (i > 0){
                    flag = true;
                }
                String addJion = "{\"flag\":\""+flag+"\"}";
                out.write(addJion);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else if ("updateid".equals(action)){
            String id = request.getParameter("id"); // 获取 ID
            Announcement announcement = announ.getIdAnnounce(Integer.parseInt(id));
            String pageSupportJson= JSON.toJSONStringWithDateFormat(announcement,"yyyy-MM-dd");
            out.write(pageSupportJson);
        }else if ("update".equals(action)){
            try {
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                int id = Integer.parseInt(request.getParameter("id"));
                String aTitle = request.getParameter("aTitle");
                String aText = request.getParameter("aText");
                String aDate = request.getParameter("aDate");
                Date date = f.parse(aDate);
                Announcement ann = new Announcement();
                ann.setaTitle(aTitle);
                ann.setaText(aText);
                ann.setaDate(date);

                int i = announ.updateNews(ann,id);

                boolean flag = false;
                if (i > 0){
                    flag = true;
                }
                String addJion = "{\"flag\":\""+flag+"\"}";
                out.write(addJion);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("delect".equals(action)){
            String id = request.getParameter("id");
            int i = announ.delectAnn(Integer.parseInt(id));
            boolean flag = false;
            if (i > 0){
                flag = true;
            }
            String deleJion = "{\"flag\":\""+flag+"\"}";
            out.write(deleJion);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
