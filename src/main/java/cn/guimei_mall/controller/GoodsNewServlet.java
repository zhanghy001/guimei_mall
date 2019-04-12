package cn.guimei_mall.controller;

import cn.guimei_mall.entity.GoodsNew;
import cn.guimei_mall.service.GoodsNewService;
import cn.guimei_mall.service.Impl.GoodsNewServiceImpl;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GoodsNewServlet",urlPatterns = "/GoodsNewServlet")
public class GoodsNewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsNewService goodsNewService = new GoodsNewServiceImpl();
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if ("select".equals(action)){
            int pageCurrenNo = Integer.parseInt(request.getParameter("pageCurrenNo"));
            int pageSize =  Integer.parseInt(request.getParameter("pageSize"));
            String goodName = request.getParameter("goodName");
            int sellerName = Integer.parseInt(request.getParameter("sellerName"));
            int smallName = Integer.parseInt(request.getParameter("smallName"));
            List<GoodsNew> list = goodsNewService.getGoods(goodName,sellerName,smallName,pageCurrenNo,pageSize);
            PageSupport pageSupport = new PageSupport();
            pageSupport.setPagesize(pageSize);
            pageSupport.setPageCurrentNo(pageCurrenNo);
            pageSupport.setTotalCount(goodsNewService.getTotalCount());
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(list);

            String pageSupportJson = JSON.toJSONString(pageSupport);
            out.write(pageSupportJson);
        }else if ("selectSell".equals(action)){// 得到商家下拉框
            List<GoodsNew> list = goodsNewService.getSellerName();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        }else if ("selectsmall".equals(action)){
            List<GoodsNew> list = goodsNewService.getSmallName();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        }else if ("selectDiscRate".equals(action)){
            List<GoodsNew> list = goodsNewService.getSmallName();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        }else if ("selectid".equals(action)){

        }else if ("update".equals(action)){
            int id = Integer.parseInt("id");
            String goodsName = request.getParameter("goodsName");
            int goodsSmalId = Integer.parseInt(request.getParameter("goodsSmalId"));
            Double goodsMoney = Double.parseDouble(request.getParameter("goodsMoney"));
            int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
            String goodsImage = request.getParameter("goodsImage");
            Double goodsCarriage = Double.parseDouble(request.getParameter("goodsCarriage"));
            int goodsType = Integer.parseInt(request.getParameter("goodsType"));
            int goodsSeId = Integer.parseInt(request.getParameter("goodsSeId"));
            int goodsDiscId = Integer.parseInt(request.getParameter("goodsDiscId"));

            GoodsNew good = new GoodsNew();
            good.setId(id);
            good.setGoodsName(goodsName);
            good.setGoodsSmalId(goodsSmalId);
            good.setGoodsMoney(goodsMoney);
            good.setGoodsNumber(goodsNumber);
            good.setGoodsImage(goodsImage);
            good.setGoodsCarriage(goodsCarriage);
            good.setGoodsType(goodsType);
            good.setGoodsSeId(goodsSeId);
            good.setGoodsDiscId(goodsDiscId);
            int i = goodsNewService.updateGoods(good,id);
        }else if ("delect".equals(action)){
            String id = request.getParameter("id");
            int i = goodsNewService.delectgoods(Integer.parseInt(id));
            boolean flag = false;
            if (i > 0){
                flag = true;
            }
            String deleJion = "{\"flag\":\""+flag+"\"}";
            out.write(deleJion);
        }else if ("add".equals(action)){

            String goodsName = request.getParameter("goodsName");
            int goodsSmalId = Integer.parseInt(request.getParameter("goodsSmalId"));
            Double goodsMoney = Double.parseDouble(request.getParameter("goodsMoney"));
            int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
            String goodsImage = request.getParameter("goodsImage");
            Double goodsCarriage = Double.parseDouble(request.getParameter("goodsCarriage"));
            int goodsType = Integer.parseInt(request.getParameter("goodsType"));
            int goodsSeId = Integer.parseInt(request.getParameter("goodsSeId"));
            int goodsDiscId = Integer.parseInt(request.getParameter("goodsDiscId"));


                GoodsNew good = new GoodsNew();
                good.setGoodsName(goodsName);
                good.setGoodsSmalId(goodsSmalId);
                good.setGoodsMoney(goodsMoney);
                good.setGoodsNumber(goodsNumber);
                good.setGoodsImage(goodsImage);
                good.setGoodsCarriage(goodsCarriage);
                good.setGoodsType(goodsType);
                good.setGoodsSeId(goodsSeId);
                good.setGoodsDiscId(goodsDiscId);
                int i = goodsNewService.addGoods(good);

                boolean flag = false;
                if (i > 0){
                    flag = true;
                }
                String addJion = "{\"flag\":\""+flag+"\"}";
                out.write(addJion);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
