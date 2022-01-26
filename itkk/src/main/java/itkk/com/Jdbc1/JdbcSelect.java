package itkk.com.Jdbc1;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * @ClassName JdbcSelect
 * @Description
 * @Author nikai
 * @Date 2022/1/20 9:47
 * @Version 1.0
 **/
public class JdbcSelect {
    /*
     * @description:
     * @param jdbc查询数据库中数据
     * @return 返回数据库中要查询的数据
     * @author nikai
     * @date 2022/1/20 9:48
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "select * from account";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double balance = rs.getDouble(3);
                System.out.println("id：" + id + "  " + "name：" + name + "   " + "balance：" + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
