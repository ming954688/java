import javax.servlet.*;
import java.io.IOException;

/**
 * servlet 创建实例的时机提前
 */
public class HellowServlet4 implements Servlet {

    //创建实例的时候, 执行这个方法. 初次访问的时候创建实例
    //init方法只会执行一次
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("hellowServlet4 初始化了...");
    }



    @Override
    //只要有请求,就会执行service方法
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("执行service方法");
    }

    @Override
    //当服务器关闭的时候,会执行该方法
    public void destroy() {
        System.out.println("HellowServlet4 销毁");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}
