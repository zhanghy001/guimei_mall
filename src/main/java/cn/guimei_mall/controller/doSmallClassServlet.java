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

        String action=request.getParameter("action");
        SuperUserService sus=new SuperUserServiceImpl();
        PrintWriter out=response.getWriter();
        //大分类 json
        if("smallQuery".equals(action)){
//            int pageCurrentNo= Integer.parseInt(request.getParameter("pageCurrentNo"));
            int smallBigId= Integer.parseInt(request.getParameter("smallBigId"));
            String smallName=request.getParameter("smallName");
            int pageCurrentNo= Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pagesize= Integer.parseInt(request.getParameter("pagesize"));
            List<SmallClass> smallClassList=sus.getSmllListBy(smallName,smallBigId,pageCurrentNo,pagesize);
            //       smallClassList.get(1).toString();
            PageSupport pageSupport=new PageSupport();
            pageSupport.setList(smallClassList);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setpagesize(pagesize);
            pageSupport.setTotalCount(sus.getSmallCount(smallName,smallBigId));
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            String smallJson= JSON.toJSONString(pageSupport);
            out.print(smallJson);
            out.flush();
            out.close();

        }

        if ("getBigName".equals(action)){
            List<BigClass> bigClassList=sus.getBigClassList(-1,-1);
            int id= Integer.parseInt(request.getParameter("id"));
            StringBuffer sb=new StringBuffer();
            if (id==-1){
                sb.append("<option value='-1'>全部</option>");
            }
            for (int i = 0; i <bigClassList.size() ; i++) {
                if (bigClassList.get(i).getId()==id){
                    sb.append("<option selected value="+bigClassList.get(i).getId()+">"+bigClassList.get(i).getBigName()+"</option>");
                }else {
                    sb.append("<option  value="+bigClassList.get(i).getId()+">"+bigClassList.get(i).getBigName()+"</option>");

                }
            }
            out.print(sb);
            out.flush();
            out.close();

        }
        if ("smallAdd".equals(action)){
            String smallName=request.getParameter("smallName");
            int smallBigId= Integer.parseInt(request.getParameter("smallBigId"));
            String smallText=request.getParameter("smallText");
            if (sus.creatSmall(smallName,smallBigId,smallText)){
                request.getRequestDispatcher(request.getContextPath()+"/page/smallclass/smallAdd.jsp?msg=0").forward(request,response);
            }else {
                request.getRequestDispatcher(request.getContextPath()+"/page/smallclass/smallAdd.jsp?msg=1").forward(request,response);
            }
        }

        if ("delSmall".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            out.print(sus.deleteSmall(id));
            out.flush();
            out.close();

        }
        if ("getSmall".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            SmallClass smallClass=sus.getSmallClassById(id);
            request.setAttribute("Small",smallClass);
            request.getRequestDispatcher(request.getContextPath()+"/page/smallclass/SmallUpdate.jsp").forward(request,response);

        }
        if ("SmallUpdate".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            String smallName=request.getParameter("smallName");
            int smallBigId= Integer.parseInt(request.getParameter("smallBigId"));
            String smallText=request.getParameter("smallText");

            if (sus.updateSmallById(id,smallName,smallBigId,smallText)){
                SmallClass smallClass=sus.getSmallClassById(id);
                request.setAttribute("Small",smallClass);
                request.getRequestDispatcher(request.getContextPath()+"/page/smallclass/SmallUpdate.jsp?msg=0").forward(request,response);
            }else {
                request.getRequestDispatcher(request.getContextPath()+"/page/smallclass/SmallUpdate.jsp?msg=1").forward(request,response);
            }

        }
        if("smallQueryByBigId".equals(action)){
            int bigId= Integer.parseInt(request.getParameter("bigId"));
            List<SmallClass> smallClassList=sus.getSmllListBy("",bigId,1,1000);
            String smallJson= JSON.toJSONString(smallClassList);
            out.print(smallJson);
            out.flush();
            out.close();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
