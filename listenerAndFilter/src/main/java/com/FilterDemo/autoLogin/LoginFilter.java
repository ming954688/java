package com.FilterDemo.autoLogin;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/autoLogin/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user1 = (User) request.getSession().getAttribute("user");


        if(user1 != null){
            chain.doFilter(request, response);
        }else{
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                boolean flag = false;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        flag = true;
                        String value = cookie.getValue();
                        String[] split = value.split(",");
                        User user = new User(split[0], split[1]);
                        request.getSession().setAttribute("user", user);
                        chain.doFilter(request, response);
                    }
                }
                if(!flag){
                    chain.doFilter(request, response);
                }
            }else{
                chain.doFilter(request, response);
            }
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
