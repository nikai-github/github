package itkk.com.Jdbc;

import java.sql.*;

/**
 * @ClassName JdbcSelect
 * @Description
 * @Author nikai
 * @Date 2022/1/21 9:40
 * @Version 1.0
 **/
public class JdbcSelect {
    /*
     * @description:
     * @param jdbc查询数据库中的数据
     * @return 返回数据
     * @author nikai
     * @date 2022/1/21 9:41
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet re = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "select * from account";
            stat = conn.createStatement();
            re = stat.executeQuery(sql);
            while (re.next()) {
                int id = re.getInt("id");
                String name = re.getString("NAME");
                double balance = re.getDouble("balance");
                System.out.println("id：" + id + "  " + "name：" + name + "  " + "balance：" + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (re != null){
                try {
                    re.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
