import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "ServletContextDemo",urlPatterns = "/ServletContextDemo")

public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAddress();


    }

    public void getAddress() throws IOException {
        //得到servletContext对象
        ServletContext servletContext = getServletContext();
        //过去全局配置参数的值
        String aa = servletContext.getInitParameter("aa");
        System.out.println(aa);

        Properties properties = new Properties();
        String realPath = servletContext.getRealPath("config.properties");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        properties.load(fileInputStream);
        String name = properties.getProperty("address");
        System.out.println(name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
