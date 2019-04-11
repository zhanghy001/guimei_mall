package cn.guimei_mall.controller;

import cn.guimei_mall.entity.Seller;
import cn.guimei_mall.service.SellerService;
import cn.guimei_mall.service.impl.SellerServiceimpl;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;


@WebServlet(name = "doSel", urlPatterns = "/doSel")
public class doSel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String action = request.getParameter("action");
        SellerService newsService = new SellerServiceimpl();
        if (action == null || action == "") {
            action = "select";
        }
        if ("select".equals(action)) {
            int usern=Integer.parseInt(request.getParameter("id"));
            int pageCurrentNo=Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pageSize=Integer.parseInt(request.getParameter("pageSize"));


            PageSupport pageSupport=new PageSupport();

            pageSupport.setPagesize(pageSize);
            pageSupport.setPageCurrentNo(pageCurrentNo);

            pageSupport.setTotalPages(pageSupport.getTotalPages());

            //将此对象转换称jSON数据
            String pageSupportJson= JSON.toJSONString(pageSupport);
            System.out.println(pageSupportJson);
            out.write(pageSupportJson);
        }else if("selAdd".equals(action)){
            String sellerName = request.getParameter("sellerName");
            String sellerUser = request.getParameter("sellerUser");
            String sellerSex = request.getParameter("sellerSex");
            String sellerBirthday = request.getParameter("sellerBirthday");
            String sellerIdCard = request.getParameter("sellerIdCard");
            String sellerEmail = request.getParameter("sellerEmail");
            String sellerTel = request.getParameter("sellerTel");
            String sellerAddress = request.getParameter("sellerAddress");
            Seller s = new Seller();
            s.setSellerName(sellerName);
            s.setSellerUser(sellerUser);
            s.setSellerSex(sellerSex);
            s.setSerllerBDate(new Date());
            s.setSellerIdCard(sellerIdCard);
            s.setSellerEmail(sellerEmail);
            s.setSellerTel(sellerTel);
            s.setSellerAddress(sellerAddress);
            int n = newsService.addseller(s);
            boolean flag = false;
            if(n>0){
                flag=true;
            }
            String addJson="{\"flag\":\""+flag+"\"}";
            out.write(addJson);
        }else if("getNewById".equals(action)){

        }else if("selUpdate".equals(action)){
            String sellerName = request.getParameter("sellerName");
            String sellerUser = request.getParameter("sellerUser");
            String sellerSex = request.getParameter("sellerSex");
            String sellerBirthday = request.getParameter("sellerBirthday");
            String sellerIdCard = request.getParameter("sellerIdCard");
            String sellerEmail = request.getParameter("sellerEmail");
            String sellerTel = request.getParameter("sellerTel");
            String sellerAddress = request.getParameter("sellerAddress");
            Seller s = new Seller();
            s.setSellerName(sellerName);
            s.setSellerUser(sellerUser);
            s.setSellerSex(sellerSex);
            s.setSerllerBDate(new Date());
            s.setSellerIdCard(sellerIdCard);
            s.setSellerEmail(sellerEmail);
            s.setSellerTel(sellerTel);
            s.setSellerAddress(sellerAddress);
            int n = newsService.addseller(s);
            if(n>0) {
                request.getRequestDispatcher("/doSel?action=select&flag=true").include(request, response);
            }else{
                request.getRequestDispatcher(request.getContextPath() + "/sellerUpdate.jsp?flag=false").include(request, response);

            }
        }

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
