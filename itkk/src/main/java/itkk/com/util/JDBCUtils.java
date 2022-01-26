package itkk.com.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description
 * @Author nikai
 * @Date 2022/1/24 10:55
 * @Version 1.0
 **/
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
     *文件的读取，只需要读取一次即可拿到这些值，使用静态代码块。
     * */
    static {

        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件的方式--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //2.加载文件
            pro.load(new FileReader(path));
            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * @description:
     * @param 获取连接
     * @return 返回连接对象
     * @author nikai
     * @date 2022/1/24 11:52
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /*
     * @description:
     * @param 释放资源
     * @return stat conn
     * @author nikai
     * @date 2022/1/24 14:30
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * @description:
     * @param 释放资源 rs stat conn
     * @return 释放资源返回
     * @author nikai
     * @date 2022/1/24 14:36
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
