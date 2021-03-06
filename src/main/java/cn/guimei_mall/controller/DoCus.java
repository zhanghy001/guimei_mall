
package cn.guimei_mall.controller;

import cn.guimei_mall.dao.BaseDao;
import cn.guimei_mall.entity.Customer;
import cn.guimei_mall.entity.Goods;
import cn.guimei_mall.entity.Orderse;
import cn.guimei_mall.service.customerService.CustomerLogin;
import cn.guimei_mall.util.StringToDate;
import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "DoCus",urlPatterns = "/doCus")
public class DoCus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            response.setStatus(404);
            return;
        }
        switch (action){
            case "cusLogin":{
                CustomerLogin customerLogin=new CustomerLogin();
                customerLogin.setCusLoginNme(request.getParameter("cusLoginName"));
                customerLogin.setCusPassword(request.getParameter("cusPassword"));
                Customer customer=customerLogin.ifCustomerLogin();
                if(customer==null){
                    request.getRequestDispatcher("/Cuslogin.jsp?isLoginSuccessful=false").forward(request,response);
                    return;
                }else{
                    HttpSession httpSession=request.getSession();
                    httpSession.setAttribute("customer",customer);
                    response.sendRedirect("/BeforePage/GUIMEI/homepage.jsp");
                }
                break;
            }
            case "regCus":{
                Customer customer = new Customer();
                // Check that we have a file upload request
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if(isMultipart){
                    // Create a new file upload handler
                    ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

                    // Parse the request

                    try {
                        StringBuilder hobby=new StringBuilder();
                        Iterator<FileItem> iter=upload.parseRequest(request).iterator();
                        while (iter.hasNext()) {
                            FileItem    item = iter.next();

                            if (item.isFormField()) {
                                String name = item.getFieldName();
                                String itemString = item.getString("utf-8");
                                switch (name) {
                                    case "C_name": {
                                        customer.setCusName(itemString);
                                        break;
                                    }
                                    case "C_loginName": {
                                        customer.setCusLoginName(itemString);
                                        break;
                                    }
                                    case "C_pwd": {
                                        customer.setCusPassword(itemString);
                                        break;
                                    }
                                    case "C_email": {
                                        customer.setCusEmail(itemString);
                                        break;
                                    }
                                    case "C_sex": {
                                        customer.setCusSex(itemString);
                                        break;
                                    }
                                    case "C_hobby": {
                                        customer.setCusHobby(hobby.append(itemString).append(",").toString());
                                        break;
                                    }
                                    case "C_birthday": {
                                        customer.setCusBirthday(StringToDate.stringToDate(itemString));
                                        break;
                                    }
                                    case "C_code": {
                                        customer.setCusCode(itemString);
                                        break;
                                    }
                                }
                            } else {
                                String fileString=request.getServletContext().getRealPath("/upload/img/customerImg/"+item.getName());
                                customer.setCusPhoto(item.getName());
                                File file = new File(fileString);
                                File dir=new File(request.getServletContext().getRealPath("/upload/img/customerImg"));
                                if(!dir.exists()){
                                    dir.mkdirs();
                                }
                                if(!file.exists()){
                                    file.createNewFile();
                                }
                                item.write(file);
                            }
                        }
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                BaseDao baseDao=new BaseDao();

                String updateSql="insert into customer values(null,?,?,?,?,?,?,?,?,?)";
                Object[] objects=new Object[9];
                objects[0]=customer.getCusName();
                objects[1]=customer.getCusLoginName();
                objects[2]=customer.getCusPassword();
                objects[3]=customer.getCusEmail();
                objects[4]=customer.getCusSex();
                objects[5]=customer.getCusPhoto();
                objects[6]=customer.getCusHobby();
                objects[7]=customer.getCusCode();
                objects[8]=customer.getCusBirthday();
                int isAddtrue=baseDao.excutUpdateRows(updateSql,objects);
                if(isAddtrue==0){
                    request.getRequestDispatcher("/register.jsp?isAddTrue=false").forward(request,response);
                    return;
                }
                response.sendRedirect("/Cuslogin.jsp");
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException{
       // System.out.println(request.getServletContext().getRealPath("/src/main/java/resources/img/customerImg/"));
        String action=request.getParameter("action");

        switch (action){
            case "out":{
                request.getSession().removeAttribute("customer");
                response.sendRedirect("/BeforePage/GUIMEI/homepage.jsp");
                break;
            }
            case "QueryById":{
                response.sendRedirect("/Customer/GUIMEI/customerInfomation.jsp");
                break;
            }
        }
    }

}
