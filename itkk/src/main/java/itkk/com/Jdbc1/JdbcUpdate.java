package itkk.com.Jdbc1;

import java.sql.*;

/**
 * @ClassName JdbcUpdate
 * @Description
 * @Author nikai
 * @Date 2022/1/19 10:11
 * @Version 1.0
 **/
public class JdbcUpdate {
    /*
     * @description:
     * @param jdbc修改方法
     * @return 返回受影响的行数与成功与否
     * @author nikai
     * @date 2022/1/19 10:13
     */
    public static void main(String[] args) {
        Connection coon = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "update account set name = '张三' where id =1";
            stat = coon.createStatement();
            int count = stat.executeUpdate(sql);
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
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
            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
