package cn.guimei_mall.controller;

import cn.guimei_mall.entity.GoodsNew;
import cn.guimei_mall.service.GoodsNewService;
import cn.guimei_mall.service.Impl.GoodsNewServiceImpl;
import cn.guimei_mall.util.PageSupport;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "GoodsNewServlet",urlPatterns = "/GoodsNewServlet")
public class GoodsNewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsNewService goodsNewService = new GoodsNewServiceImpl();
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if ("select".equals(action)) {
            int pageCurrentNo = Integer.parseInt(request.getParameter("pageCurrentNo"));
            int pagesize = Integer.parseInt(request.getParameter("pagesize"));
            String goodName = request.getParameter("goodName");
            int sellerName = Integer.parseInt(request.getParameter("sellerName"));
            int smallName = Integer.parseInt(request.getParameter("smallName"));
            List<GoodsNew> list = goodsNewService.getGoods(goodName, sellerName, smallName, pageCurrentNo, pagesize);
            PageSupport pageSupport = new PageSupport();
            pageSupport.setpagesize(pagesize);
            pageSupport.setPageCurrentNo(pageCurrentNo);
            pageSupport.setTotalCount(goodsNewService.getTotalCount(goodName,sellerName,smallName));
            pageSupport.setTotalPages(pageSupport.getTotalPages());
            pageSupport.setList(list);

            String pageSupportJson= JSON.toJSONStringWithDateFormat(pageSupport,"yyyy-MM-dd");
            out.write(pageSupportJson);
        } else if ("selectSell".equals(action)) {// 得到商家下拉框
            List<GoodsNew> list = goodsNewService.getSellerName();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        } else if ("selectsmall".equals(action)) { // 小分类
            List<GoodsNew> list = goodsNewService.getSmallName();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        } else if ("selectDiscRate".equals(action)) { // 折扣
            List<GoodsNew> list = goodsNewService.getDiscount();
            String listJson = JSON.toJSONString(list);
            out.write(listJson);
        } else if ("selectid".equals(action)) {
            String id = request.getParameter("id"); // 获取 ID
            GoodsNew goodsNew = goodsNewService.getIdGoods(Integer.parseInt(id));
            String pageSupportJson= JSON.toJSONStringWithDateFormat(goodsNew,"yyyy-MM-dd");
            out.write(pageSupportJson);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String goodsName = request.getParameter("goodsName");
            int goodsSmalId = Integer.parseInt(request.getParameter("goodsSmalId"));
            Double goodsMoney = Double.parseDouble(request.getParameter("goodsMoney"));
            int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
            //String goodsImage = request.getParameter("goodsImage");
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
            //good.setGoodsImage(goodsImage);
            good.setGoodsCarriage(goodsCarriage);
            good.setGoodsType(goodsType);
            good.setGoodsSeId(goodsSeId);
            good.setGoodsDiscId(goodsDiscId);
            int i = goodsNewService.updateGoods(good, id);
            boolean flag = false;
            if (i > 0) {
                flag = true;
            }
            String upJion = "{\"flag\":\"" + flag + "\"}";
            out.write(upJion);
        } else if ("delect".equals(action)) {
            String id = request.getParameter("id");
            int i = goodsNewService.delectgoods(Integer.parseInt(id));
            boolean flag = false;
            if (i > 0) {
                flag = true;
            }
            String deleJion = "{\"flag\":\"" + flag + "\"}";
            out.write(deleJion);
        } else if ("adddd".equals(action)) {

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
            if (i > 0) {
                flag = true;
            }
            String addJion = "{\"flag\":\"" + flag + "\"}";
            out.write(addJion);
        } else if ("add".equals(action)) {
            //接收增加的新闻信息，并调用后台方法，将新闻信息插入数据库
            String uploadFileName = "";
            String fieldName = "";
            GoodsNew goods = new GoodsNew();
            //解析请求之前先判断请求类型是否为文件上传类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //指定上传位置
            String uploadFilePath = request.getSession().getServletContext().getRealPath("GoodsImage/");
            File saveDir = new File(uploadFilePath);
            //如果目录不存在，就创建目录
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            if (isMultipart) {
                //创建文件上传核心类
                FileItemFactory factory = new DiskFileItemFactory(); // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
                ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
                try {
                    //处理表单请求
                    List<FileItem> items = upload.parseRequest(request);
                    Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) {
                        FileItem item = (FileItem) iter.next();
                        if (item.isFormField()) {// 如果是普通表单控件
                            fieldName = item.getFieldName();// 获得该字段名称
                            if (fieldName.equals("goodsName")) {
                                goods.setGoodsName(item.getString("UTF-8"));//获得该字段值
                            } else if (fieldName.equals("goodsSmalId")) {
                                goods.setGoodsSmalId(Integer.parseInt(item.getString("utf-8")));
                            } else if (fieldName.equals("goodsMoney")) {
                                goods.setGoodsMoney(Double.parseDouble(item.getString("UTF-8")));
                            } else if (fieldName.equals("goodsNumber")) {
                                goods.setGoodsNumber(Integer.parseInt(item.getString("UTF-8")));
                            } else if (fieldName.equals("goodsCarriage")) {
                                goods.setGoodsCarriage(Double.parseDouble(item.getString("UTF-8")));
                            } else if (fieldName.equals("goodsType")) {
                                goods.setGoodsType(Integer.parseInt(item.getString("UTF-8")));
                            } else if (fieldName.equals("goodsSeId")) {
                                goods.setGoodsSeId(Integer.parseInt(item.getString("UTF-8")));
                            } else if (fieldName.equals("goodsDiscId")) {
                                goods.setGoodsDiscId(Integer.parseInt(item.getString("UTF-8")));
                            }
                        } else {// 如果为文件域
                            String fileName = item.getName();// 获得文件名(全路径)
                            if (fileName != null && !fileName.equals("")) {
                                File fullFile = new File(fileName);
                                File saveFile = new File(uploadFilePath, fullFile.getName());//将文件保存到指定的路径
                                item.write(saveFile);
                                uploadFileName = fullFile.getName();
                                goods.setGoodsImage(uploadFileName);
                            }
                        }
                    }
                    int i = goodsNewService.addGoods(goods);

                    boolean flag = false;
                    if (i > 0) {
                        flag = true;
                    }
                    request.getRequestDispatcher("/page/goods/goodsAdd.jsp?flag="+flag).forward(request,response);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            out.flush();
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
