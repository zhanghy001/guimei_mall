package cn.guimei_mall.controller;

        import cn.guimei_mall.entity.Seller;
        import cn.guimei_mall.entity.User;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.net.URLEncoder;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userLoginName");
        String pwd = request.getParameter("userPassword");
        User user = new User();
        user.setSellerName(name);
        user.setSellerPwd(pwd);
        if(name == "" || name == null){
            String msg = "登陆失败";
            msg = URLEncoder.encode(msg,"utf-8");
            request.getRequestDispatcher(request.getContextPath() + "/Login.jsp?action=select").forward(request, response);
        }else{
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher(request.getContextPath() + "/doSet?action=select").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
