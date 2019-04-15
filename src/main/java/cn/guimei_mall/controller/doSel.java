package cn.guimei_mall.controller;

import cn.guimei_mall.entity.Seller;
import cn.guimei_mall.service.Impl.SellerServicecImpl;
import cn.guimei_mall.service.SellerService;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "doSel", urlPatterns = "/doSel")
public class doSel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String action = request.getParameter("action");
        SellerService newsService = new SellerServicecImpl();
        if("sellerLogin".equals(action)){
            String sn = request.getParameter("userLoginName");
            String sp = request.getParameter("userPassword");
            Seller seller = newsService.SellerLogin(sn,sp);
            out.write(JSON.toJSONString(seller));
            request.getSession().setAttribute("seller",seller);
        }else if ("select".equals(action)) {

            int pageCurrentNo=Integer.parseInt(request.getParameter("pageCurrentNo"));
            System.out.println(pageCurrentNo);
            int pageSize=Integer.parseInt(request.getParameter("pageSize"));
            List<Seller> newsList = newsService.getNewsListBy(0,null,(pageCurrentNo-1)*pageSize,pageSize);
            PageSupport pageSupport=new PageSupport();
            pageSupport.setPagesize(pageSize);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setTotalCount(newsService.getTotalCount(0,null));
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(newsList);
            //将此对象转换称jSON数据
            String pageSupportJson= JSON.toJSONString(pageSupport);
            out.write(pageSupportJson);
        }else if("selAdd".equals(action)){
            String sellerName = request.getParameter("sellerName");
            String sellerUser = request.getParameter("sellerUser");
            String sellerPassword = request.getParameter("sellerPassword");
            String sellerSex = request.getParameter("sellerSex");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String sellerBirthday = request.getParameter("sellerBirthday");
            Date d = null;
            try {
                d = sdf.parse(sellerBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String sellerIdCard = request.getParameter("sellerIdCard");
            String sellerEmail = request.getParameter("sellerEmail");
            String sellerTel = request.getParameter("sellerTel");
            String sellerAddress = request.getParameter("sellerAddress");
            Seller s = new Seller();
            s.setSellerName(sellerName);
            s.setSellerUser(sellerUser);
            s.setSellerPassword(sellerPassword);
            s.setSellerSex(sellerSex);
            s.setSellerBirthday(d);
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
            String id=request.getParameter("id");
            Seller news=newsService.getsListById(Integer.parseInt(id));
            String newsJson= JSON.toJSONStringWithDateFormat(news,"yyyy-MM-dd");
            out.write(newsJson);
        }else if("selUpdateLogin".equals(action)){
            int id=Integer.parseInt(request.getParameter("id"));
            String sellerName = request.getParameter("sellerName");
            String sellerUser = request.getParameter("sellerUser");
            String sellerSex = request.getParameter("sellerSex");
            String sellerBirthday = request.getParameter("sellerBirthday");
            String sellerIdCard = request.getParameter("sellerIdCard");
            String sellerEmail = request.getParameter("sellerEmail");
            String sellerTel = request.getParameter("sellerTel");
            String sellerAddress = request.getParameter("sellerAddress");
            Seller s = new Seller();
            s.setSellerId(id);
            s.setSellerName(sellerName);
            s.setSellerUser(sellerUser);
            s.setSellerSex(sellerSex);
            try {
                s.setSellerBirthday(formatter.parse(sellerBirthday));
                s.setSellerIdCard(sellerIdCard);
                s.setSellerEmail(sellerEmail);
                s.setSellerTel(sellerTel);
                s.setSellerAddress(sellerAddress);
                int n = newsService.updateseller(s);
                boolean flag = false;
                if (n > 0) {
                    flag = true;
                }
                String addJson = "{\"flag\":\"" + flag + "\"}";
                out.write(addJson);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else if("sellerUpdatePwd".equals(action)){
            int id=Integer.parseInt(request.getParameter("id"));
            String sellerPassword = request.getParameter("sellerPassword");
            Seller s = new Seller();
            s.setSellerId(id);
            s.setSellerPassword(sellerPassword);
                int n = newsService.updatePwd(s);
                boolean flag = false;
                if (n > 0) {
                    flag = true;
                }
                String addJson = "{\"flag\":\"" + flag + "\"}";
                out.write(addJson);

        } else if ("selDelById".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            int n = newsService.deleteById(id);
            boolean flag = false;
            if (n > 0) {
                flag = true;
            }
            out.write("{\"flag\":\"" + flag + "\"}");
        }

        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
