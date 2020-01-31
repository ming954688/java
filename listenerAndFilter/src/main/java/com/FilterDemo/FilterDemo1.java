package com.FilterDemo;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    // 初始化的时候调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化了...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("经过过滤器了......");

        //放行
        chain.doFilter(request,response);

        System.out.println("1 after...");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁了.....");
    }
}
