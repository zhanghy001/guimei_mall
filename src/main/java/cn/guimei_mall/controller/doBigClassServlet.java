package cn.guimei_mall.controller;

import cn.guimei_mall.entity.BigClass;
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

/**
 * 大分类 servlet creatBy祝杰汉 2019-04-11
 */
@WebServlet(name = "doBigClassServlet",urlPatterns = "/doBig")
public class doBigClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        SuperUserService sus=new SuperUserServiceImpl();
        PrintWriter out=response.getWriter();
        //大分类 json
        if("bigQuery".equals(action)){
            int pageCurrentNo= Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pagesize= Integer.parseInt(request.getParameter("pagesize"));
            List<BigClass> bigClassList=sus.getBigClassList(pageCurrentNo,pagesize);
//            request.setAttribute("BigClass",bigClassList);
//            request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigQuery.jsp").forward(request,response);
            PageSupport pageSupport=new PageSupport();
            pageSupport.setList(bigClassList);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setPagesize(pagesize);
            pageSupport.setTotalCount(sus.bigCount());
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            String bigJson= JSON.toJSONString(pageSupport);
            out.print(bigJson);
            out.flush();
            out.close();

        }
        //
        if ("getBig".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            BigClass bigClass=sus.getBigClassById(id);
            request.setAttribute("Big",bigClass);
            request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigUpdate.jsp").forward(request,response);
        }
        if ("bigUpdate".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            String bigName=request.getParameter("bigName");
            String bigText=request.getParameter("bigText");

            if (sus.updateBigById(id,bigName,bigText)){
                BigClass bigClass=sus.getBigClassById(id);
                request.setAttribute("Big",bigClass);
                request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigUpdate.jsp?msg=0").forward(request,response);
            }else {
                request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigUpdate.jsp?msg=1").forward(request,response);
            }

        }
        if ("bigAdd".equals(action)){
            String bigName=request.getParameter("bigName");
            String bigText=request.getParameter("bigText");
            if (sus.creatBig(bigName,bigText)){
                request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigAdd.jsp?msg=0").forward(request,response);
            }else {
                request.getRequestDispatcher(request.getContextPath()+"/page/bigclass/bigAdd.jsp?msg=1").forward(request,response);
            }
        }
        if ("delBig".equals(action)){
          int id= Integer.parseInt(request.getParameter("id"));
          out.print(sus.deleteBig(id));
          out.flush();
          out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
