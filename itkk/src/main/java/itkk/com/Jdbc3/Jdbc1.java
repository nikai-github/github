package itkk.com.Jdbc3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Jdbc1
 * @Description
 * @Author nikai
 * @Date 2022/1/23 19:07
 * @Version 1.0
 **/
public class Jdbc1 {
    public static void main(String[] args) {
        List<Emp> list = new Jdbc1().findAll();
        System.out.println(list);
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            String sql = "select * from emp";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            list = new ArrayList<Emp>();
            Emp emp = new Emp();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
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
        return list;
    }
}
