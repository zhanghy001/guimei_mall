package cn.guimei_mall.controller;

import cn.guimei_mall.entity.SuperUser;

import cn.guimei_mall.service.SuperUserService;
import cn.guimei_mall.service.Impl.SuperUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doUserServlet",urlPatterns = "/doUser")
public class doUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action=request.getParameter("action");
            SuperUserService sus=new SuperUserServiceImpl();
            //管理员登录
            if("userLogin".equals(action)){
                String userLoginName=request.getParameter("userLoginName");
                String userPassword=request.getParameter("userPassword");
                SuperUser superUser=sus.login(userLoginName,userPassword);
                if (userLoginName.equals(superUser.getUserLoginName())){
                    request.setAttribute("User",superUser);
                    request.getRequestDispatcher(request.getContextPath()+"/page/index.jsp").forward(request,response);
                 //   System.out.println("登录成功");
                }else {
                 //     System.out.println("登录失败");
                    request.getRequestDispatcher(request.getContextPath()+"/Login.jsp?msg=1").forward(request,response);

                }
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
