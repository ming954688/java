package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "CookieDemo2", urlPatterns = "/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取客户端发送过来的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie1 : cookies) {
                System.out.println(cookie1.getName() + "=" + cookie1.getValue());
            }
        }

        //添加cookie
        Cookie cookie = new Cookie("name", "zhangsan");
        Cookie cookie1 = new Cookie("age","18");

        //设置cookie的有效期  (默认情况下,cookie的有效期是浏览器关闭就清除)
        cookie.setMaxAge(60*60*24*5);
        response.addCookie(cookie);
        response.addCookie(cookie1);



    }
}
