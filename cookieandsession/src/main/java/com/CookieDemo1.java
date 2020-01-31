package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieDemo1",urlPatterns = "/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("来了一个请求.....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //给响应添加一个cookie
        response.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("name","ming");
        response.addCookie(cookie);
        response.getWriter().write("请求成功了...");

        //第二次请求的时候, 客户端会带过来cookies, 可以使用request对象获取
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie1 : cookies) {
                System.out.println(cookie1.getName()+" = "+cookie1.getValue());
            }
        }


    }
}
