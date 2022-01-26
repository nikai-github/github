package com.it.jdbc;

import com.it.emp.Emp;
import com.it.util.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcSelect
 * @Description TODO
 * @Author nikai
 * @Date 2022/1/26 9:43
 * @Version 1.0
 **/
public class JdbcSelect {
    public static void main(String[] args) {
        List<Emp> list = new JdbcSelect().findAll();
        System.out.println(list);
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            conn = Utils.getconnection();
            String sql = "select * from account";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            list = new ArrayList<Emp>();
            Emp emp = new Emp();
            while (rs.next()) {
                int id = rs.getInt("id");
                String NAME = rs.getString("NAME");
                double balance = rs.getDouble("balance");
                emp = new Emp();
                emp.setId(id);
                emp.setNAME(NAME);
                emp.setBalance(balance);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Utils.close(rs, stat, conn);
        return list;
    }
}
