package cn.guimei_mall.controller;

import cn.guimei_mall.entity.BigClass;
import cn.guimei_mall.entity.SuperUser;
import cn.guimei_mall.service.Impl.SuperUserServiceImpl;
import cn.guimei_mall.service.SuperUserService;

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
                    request.getSession().setAttribute("User",superUser);
                   // request.setAttribute("User",superUser);
                    request.getRequestDispatcher(request.getContextPath()+"/page/index.jsp").forward(request,response);
                 //   System.out.println("登录成功");
                }else {
                 //     System.out.println("登录失败");
                    request.getRequestDispatcher(request.getContextPath()+"/Login.jsp?msg=1").forward(request,response);

                }
            }

//            //根据ID查询管理员
//            if ("QueryById".equals(action)){
//                int id= Integer.parseInt(request.getParameter("id"));//             SuperUser superUser=sus.QueryById(id);
//                request.setAttribute("User",superUser);
//                request.getRequestDispatcher(request.getContextPath()+"/page/user/userQuery.jsp").forward(request,response);
//            }
            if ("userUpdate".equals(action)){
                SuperUser superUser=new SuperUser();
                int id= Integer.parseInt(request.getParameter("id"));
                String userName=request.getParameter("userName");
                String userID=request.getParameter("userID");
                String userLoginName=request.getParameter("userLoginName");
                superUser.setId(id);
                superUser.setUserName(userName);
                superUser.setUserID(userID);
                superUser.setUserLoginName(userLoginName);
                //修改成功后 删除之前session 重新创建session
                if (sus.userUpdate(superUser)){
                   // request.setAttribute("User",superUser);
                    request.getSession().invalidate();
                    SuperUser sessionUser=sus.QueryById(superUser.getId());
                    request.getSession().setAttribute("User",sessionUser);
                    request.getRequestDispatcher(request.getContextPath()+"/page/user/userUpdate.jsp?msg=0").forward(request,response);
                }else {
                    request.getRequestDispatcher(request.getContextPath()+"/page/user/userUpdate.jsp?msg=1").forward(request,response);
                }

            }
              //根据ID修改管理员密码
            if ("userUpdatePwd".equals(action)){
                int id= Integer.parseInt(request.getParameter("id"));
                String userPassWord=request.getParameter("userPassWord");


                //修改成功后 删除之前session 重新创建session
                if (sus.userUpdatePwd(userPassWord,id)){
                    // request.setAttribute("User",superUser);
                    request.getSession().invalidate();
                    SuperUser sessionUser=sus.QueryById(id);
                    request.getSession().setAttribute("User",sessionUser);
                    request.getRequestDispatcher(request.getContextPath()+"/page/user/userUpdatePwd.jsp?msg=0").forward(request,response);
                }else {
                    request.getRequestDispatcher(request.getContextPath()+"/page/user/userUpdatePwd.jsp?msg=1").forward(request,response);
                }

            }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
