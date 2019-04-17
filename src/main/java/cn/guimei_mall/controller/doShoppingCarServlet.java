package cn.guimei_mall.controller;
import cn.guimei_mall.entity.*;
import cn.guimei_mall.service.GoodsNewService;
import cn.guimei_mall.service.Impl.GoodsNewServiceImpl;
import cn.guimei_mall.service.Impl.ShoppingCarServiceImpl;
import cn.guimei_mall.service.ShoppingCarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "doShoppingCarServlet",urlPatterns = "/doShop")
public class doShoppingCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        GoodsNewService goodsNewService = new GoodsNewServiceImpl();

        ShoppingCarService scs=new ShoppingCarServiceImpl();

        PrintWriter out=response.getWriter();

        if ("Orders".equals(action)){

            String cusName = request.getParameter("cusName");
            String orderseAddress = request.getParameter("orderseAddress");
            String quhao = request.getParameter("quhao");
            String phone = request.getParameter("phone");
            String fenji = request.getParameter("fenji");
            String telpone = request.getParameter("telpone");
            StringBuffer url = new StringBuffer("姓名:");
            url.append(cusName);
            url.append(",地址：");
            url.append(orderseAddress);
            url.append(",电话：");
            url.append(quhao);
            if (phone.trim().length() != 0){
                url.append("-"+phone+"-");
                url.append(fenji);
            }
            url.append(";手机：");
            url.append(telpone);
            CustomerNew customer= (CustomerNew) request.getSession().getAttribute("customer");
            int cusId=customer.getId();
            List<All> list=scs.getShopById(cusId,0);
            if (scs.addOrderse(list,url.toString())){
                 if (scs.updateStatus(cusId)){
                     request.getRequestDispatcher(request.getContextPath()+"/BeforePage/GUIMEI/dingdan.jsp").forward(request,response);
                 }
            }


        }


        if ("shopQuery".equals(action)){
            int cusId= Integer.parseInt(request.getParameter("cusId"));
            List<All> all= scs.getShopById(cusId,0);
            request.setAttribute("all",all);
            request.getRequestDispatcher(request.getContextPath()+"/BeforePage/GUIMEI/gouwuche.jsp").forward(request,response);
        }

        if ("shopAdd".equals(action)){
            int goodsId= Integer.parseInt(request.getParameter("goodsId"));
            CustomerNew customer= (CustomerNew) request.getSession().getAttribute("customer");
            int cusId=customer.getId();
            if (scs.addShoppingCar(cusId,goodsId)){
               List<All> all= scs.getShopById(cusId,0);
                request.setAttribute("all",all);
                request.getRequestDispatcher(request.getContextPath()+"/BeforePage/GUIMEI/gouwuche.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher(request.getContextPath()+"/BeforePage/GUIMEI/info.jsp").forward(request,response);
            }

        }
        if ("delShop".equals(action)){
            int id= Integer.parseInt(request.getParameter("id"));
            out.print(scs.deleteShop(id));
            out.flush();
            out.close();
        }
        if ("numberAdd".equals(action)){
            int shopId= Integer.parseInt(request.getParameter("shopId"));
            int number= Integer.parseInt(request.getParameter("number"));
            out.print(scs.updateGoodsNumber(shopId,number));
            out.flush();
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
