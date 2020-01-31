package com.ListenerDemo.Demo3.httpSessionBindingListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BindSessionServlet",urlPatterns = "/BindSessionServlet")
public class BindSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bean bean = new Bean();
        bean.setName("张三");
        HttpSession session = request.getSession();
        session.setAttribute("bean", bean);
        session.removeAttribute("bean");
    }
}
