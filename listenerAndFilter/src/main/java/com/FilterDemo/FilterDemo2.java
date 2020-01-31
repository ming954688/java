package com.FilterDemo;

import javax.servlet.*;
import javax.sound.midi.Soundbank;
import java.io.IOException;

public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter2执行中.....");
        chain.doFilter(req,resp);
        System.out.println("2 after....");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter2初始化....");
    }

}
