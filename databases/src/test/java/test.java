import com.utils.JDBCUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class test {

    @Test
    public void demo() throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql = "select * from account";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name") + "==" + rs.getInt("money"));
        }


    }

    @Test
    public void demo2(){
        Properties properties = new Properties();
        //properties.load(Demo1.class.getClassLoader().getResourceAsStream("dbcp.properties"));
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/dbcp.properties");
            properties.load(fileInputStream);
            BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            String sql = "select * from account";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "==" + resultSet.getInt("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
