package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieDemo3", urlPatterns = "/CookieDemo3")
public class CookieDemo3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String value = sdf.format(date);
        boolean flag = true;

        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("loginTime")){
                    cookie.setValue(value);
                    String lastTime = cookie.getValue();
                    response.getWriter().write("上一次的登录时间是 <h2>"+lastTime+"</h2>");
                    flag = false;
                }
            }

        }
        if(flag){
            Cookie loginTime = new Cookie("loginTime", value);
            response.addCookie(loginTime);
            response.getWriter().write("这是第一次登录");
        }


    }
}
