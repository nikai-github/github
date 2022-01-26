package com.it.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author nikai
 * @Date 2022/1/26 9:45
 * @Version 1.0
 **/
public class Utils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
     * 文件的读取 只需读取一次即可拿到这些值 使用静态代码块
     * */
    static {

        try {
            //创建Properties集合类
            Properties pro = new Properties();
            //获取src下路径的方式--->ClassLoader类加载器
            ClassLoader classLoader = Utils.class.getClassLoader();
            //获取绝对路径
            URL rs = classLoader.getResource("jdbc.properties");
            //把路径转换成字符串形式
            String path = rs.getPath();
            //加载字符串 抓取FileReader异常
            pro.load(new FileReader(path));
            //获取数据 赋值
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
     * @description: TODO
     * @param 获取连接数据库连接
     * @return 返回获取的数据库连接-账号-密码
     * @author nikai
     * @date 2022/1/26 10:12
     */
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /*
     * @description: TODO
     * @param 释放资源方法
     * @return 执行sql返回的是resultset的类型 获取执行sql的对象 获取数据库的连接
     * @author nikai
     * @date 2022/1/26 10:14
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closes(Statement stat, Connection conn) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
