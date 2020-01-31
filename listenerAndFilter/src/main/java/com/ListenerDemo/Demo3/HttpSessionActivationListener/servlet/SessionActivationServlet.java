package com.ListenerDemo.Demo3.HttpSessionActivationListener.servlet;

import com.ListenerDemo.Demo3.HttpSessionActivationListener.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionActivationServlet",urlPatterns = "/SessionActivationServlet")
public class SessionActivationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Person person = new Person("tong",24,"hefei");
        session.setAttribute("person",person);


    }
}
