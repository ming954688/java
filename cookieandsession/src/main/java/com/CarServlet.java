package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CarServlet",urlPatterns = "/CarServlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String[] names = {"iphone7","小米6","三星","华为","pos"};
        String name = names[id];
        //获取购物车存放东西的session 定义为一个map集合 Map<String,Integer>  eg: iphone7 3
        //将一个map对象传到session里面, 并且保证只有一次
        HttpSession session = request.getSession();
        Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("cart");
        //session中没有任何东西
        if(map == null){
            map = new LinkedHashMap<String,Integer>();
            session.setAttribute("cart",map);
        }

        //判断购物车中有没有这个商品
        if(map.containsKey(name)){
            //如果有, 则在原来的数量基础上加1
            map.put(name,map.get(name)+1);
        }else{
            //如果没有, 直接添加到购物车
            map.put(name,1);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+"="+value);
        }



        response.getWriter().write("<a href=\"product_list.jsp\">继续购物</a>\n");
        response.getWriter().write("<a href=\"cart.jsp\">去购物车结算</a>\n");

    }
}
