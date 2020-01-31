package com.FilterDemo;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器4初始化了...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("经过过滤器4了......");
        chain.doFilter(request,response);
        System.out.println("4 after....");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器4销毁了.....");
    }
}
