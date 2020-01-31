package com.FilterDemo.autoLogin.servlet;

import com.FilterDemo.autoLogin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession().getAttribute("user") == null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String auto_login = request.getParameter("auto_login");
            User user = new User(username,password);
            request.getSession().setAttribute("user",user);
            if(auto_login.equals("on")){
                Cookie users = new Cookie("user",user.toString());
                users.setMaxAge(60*60);
                response.addCookie(users);
                response.sendRedirect("/autoLogin/success.jsp");
            }else{
                response.sendRedirect("/autoLogin/success.jsp");
            }
        }else{
            response.sendRedirect("/autoLogin/success.jsp");
        }




    }
}
