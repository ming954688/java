import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletConfig 可以获取servlet在配置的一些信息
        ServletConfig servletConfig = getServletConfig();

        //获取serlvet的名字
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

        //获取配置的默认参数
        String address = servletConfig.getInitParameter("address");
        System.out.println(address);

        //获取配置的默认参数的参数名枚举
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        int i = 1;
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            System.out.println("第" + i + "个参数的名称是--" + element + "***** 参数值为--" + servletConfig.getInitParameter(element));
            i++;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
