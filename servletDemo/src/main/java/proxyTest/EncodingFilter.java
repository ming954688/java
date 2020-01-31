package proxyTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements javax.servlet.Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将req对象转换为httpServletRequest
        final HttpServletRequest request = (HttpServletRequest) req;

        //让jdk在内存中生成一个代理对象， 增强request对象上的getParameter(name); 这个API
        HttpServletRequest myReq = (HttpServletRequest) Proxy.newProxyInstance(EncodingFilter.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object object = null;

                if (method.getName().equals("getParameter")) {
                    //获取本地请求的方式
                    String md = request.getMethod();
                    if ("get".equalsIgnoreCase(md)) {
                        object = method.invoke(request,args);
                    } else {
                        //post请求
                        request.setCharacterEncoding("utf-8");
                        object = method.invoke(request, args);
                    }
                } else {
                    object = method.invoke(request, args);
                }
                return object;
            }
        });

        chain.doFilter(myReq, resp);
    }


}
