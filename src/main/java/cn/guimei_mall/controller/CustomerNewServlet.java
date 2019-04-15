package cn.guimei_mall.controller;

import cn.guimei_mall.entity.Announcement;
import cn.guimei_mall.entity.CustomerNew;
import cn.guimei_mall.service.CustomerNewService;
import cn.guimei_mall.service.Impl.CustomerNewServiceImpl;
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

@WebServlet(name = "CustomerNewServlet",urlPatterns = "/CustomerNewServlet")
public class CustomerNewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerNewService customerNewService = new CustomerNewServiceImpl();
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if ("select".equals(action)){
            int pageCurrenNo = Integer.parseInt(request.getParameter("pageCurrenNo"));
            int pageSize =  Integer.parseInt(request.getParameter("pageSize"));
            String id = request.getParameter("id");
            String cusName = request.getParameter("cusName");
            String cusSex = request.getParameter("cusSex");
            List<CustomerNew> list = customerNewService.getCustomerNew(id,cusName,cusSex,pageCurrenNo,pageSize);
            PageSupport pageSupport = new PageSupport();
            pageSupport.setPagesize(pageSize);
            pageSupport.setPageCurrentNo(pageCurrenNo);
            pageSupport.setTotalCount(customerNewService.getTotalCount());
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(list);

            String pageSupportJson= JSON.toJSONStringWithDateFormat(pageSupport,"yyyy-MM-dd");

            out.write(pageSupportJson);
        }else if ("selectid".equals(action)){
            String id = request.getParameter("id"); // 获取 ID
            CustomerNew customerNew = customerNewService.getIdCustomerNew(Integer.parseInt(id));

            String annJson= JSON.toJSONStringWithDateFormat(customerNew,"yyyy-MM-dd");
            out.write(annJson);
        }else if ("add".equals(action)){

        }else if ("update".equals(action)){
            try {
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            ////`id``cusName``cusLoginName``cusPassword``cusEmail``cusSex``cusPhoto``cusHobby``cusCode``cusBirthday`
            int id = Integer.parseInt(request.getParameter("id"));
            String cusName = request.getParameter("cusName");
            String cusLoginName = request.getParameter("cusLoginName");
            String cusPassword = request.getParameter("cusPassword");
            String cusEmail = request.getParameter("cusEmail");
            String cusSex = request.getParameter("cusSex");
            String cusPhoto = request.getParameter("cusPhoto");
            String cusHobby = request.getParameter("cusHobby");
            String cusCode = request.getParameter("cusCode");
            String cusBirthday = request.getParameter("cusBirthday");
            Date date = f.parse(cusBirthday);

            CustomerNew cn = new CustomerNew();
            cn.setId(id);
            cn.setCusName(cusName);
            cn.setCusLoginName(cusLoginName);
            cn.setCusPassword(cusPassword);
            cn.setCusEmail(cusEmail);
            cn.setCusSex(cusSex);
            cn.setCusPhoto(cusPhoto);
            cn.setCusHobby(cusHobby);
            cn.setCusCode(cusCode);
            cn.setCusBirthday(date);

            int i = customerNewService.updateNews(cn,id);
            boolean flag = false;
            if (i > 0){
                flag = true;
            }
            String upJion = "{\"flag\":\""+flag+"\"}";
            out.write(upJion);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("delect".equals(action)){

        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
