package itkk.com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcInsert
 * @Description
 * @Author nikai
 * @Date 2022/1/18 11:40
 * @Version 1.0
 **/
public class JdbcInsert {
    /*
     * @description:
     * @param Jdbc链接数据库进行新增操作
     * @return 返回受影响的行数与是否成功
     * @author nikai
     * @date 2022/1/18 11:40
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "insert into account values('3','宋六','3000')";
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("新增成功");
            } else if (count == 0) {
                System.out.println("受影响的行数为0新增失败");
            } else if (count < 0) {
                System.out.println("新增失败");
            } else {
                System.out.println("程序有问题");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
