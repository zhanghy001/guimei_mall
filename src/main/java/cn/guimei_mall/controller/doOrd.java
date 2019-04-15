package cn.guimei_mall.controller;

import cn.guimei_mall.entity.Ord;
import cn.guimei_mall.service.Impl.OrdServiceImpl;
import cn.guimei_mall.service.OrdService;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "doOrd", urlPatterns = "/doOrd")
public class doOrd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        OrdService ordService = new OrdServiceImpl();
        if (action == null || action == "") {
            action = "select";
        }
        if ("select".equals(action)) {
            int pageCurrentNo = Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            List<Ord> newsList = ordService.getListbyId((pageCurrentNo - 1) * pageSize, pageSize);
            PageSupport pageSupport = new PageSupport();
            pageSupport.setpagesize(pageSize);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setTotalCount(ordService.getTotalCount());
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(newsList);
            //将此对象转换称jSON数据
            String pageSupportJson = JSON.toJSONString(pageSupport);
            out.write(pageSupportJson);
        }else if("findById".equals(action)){
            String id=request.getParameter("id");
            Ord ord=ordService.FindById(Integer.parseInt(id));
            String newsJson= JSON.toJSONStringWithDateFormat(ord,"yyyy-MM-dd");
            out.write(newsJson);
        } else if ("ordUpdate".equals(action)) {
            int id=Integer.parseInt(request.getParameter("id"));
            int statusId=Integer.parseInt(request.getParameter("status"));
            Ord ord = new Ord();
            ord.setId(id);
            ord.setOrderseStatus(statusId);
            int n = ordService.updateOrderse(ord);
            boolean flag = false;
            if (n > 0) {
                flag = true;
            }
            String addJson = "{\"flag\":\"" + flag + "\"}";
            out.write(addJson);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
