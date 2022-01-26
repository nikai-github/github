package itkk.com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcDelete
 * @Description
 * @Author nikai
 * @Date 2022/1/18 11:06
 * @Version 1.0
 **/
public class JdbcDelete {

    /*
     * @description:
     * @param Jdbc连接数据库删除数据表中数据
     * @return 1.返回受影响的行数:1成功,0失败;2.返回成功与否;
     * @author nikai
     * @date 2022/1/18 11:20
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "delete from account where id = 3";
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("删除成功");
            } else if (count == 0) {
                System.out.println("删除失败");
            } else if (count < 0) {
                System.out.println("程序出问题了");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
