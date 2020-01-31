import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletContextDemo1",urlPatterns = "/ServletContextDemo1")

public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAddress();


    }

    public void getAddress() throws IOException {
        getAddress1();
    }

    private void getAddress1() throws IOException {
        //得到servletContext对象
        ServletContext servletContext = getServletContext();
        //过去全局配置参数的值
        String aa = servletContext.getInitParameter("aa");
        System.out.println(aa);

        Properties properties = new Properties();
        InputStream classLoader = this.getClass().getClassLoader().getResourceAsStream("config.properties");

        properties.load(classLoader);
        String name = properties.getProperty("address");
        System.out.println(name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



}
