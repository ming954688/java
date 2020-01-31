package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseDemo",urlPatterns = "/ResponseDemo")
public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.getWriter().write("<h1>年后</h1>");*/
        response.setHeader("Content-Type","text/html;charset=utf-8");
        response.getOutputStream().write("<h1>你好<h1>".getBytes());
    }
}
