package com.it.jdbc;

import com.it.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcInsert
 * @Description TODO
 * @Author nikai
 * @Date 2022/1/26 9:44
 * @Version 1.0
 **/
public class JdbcInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            conn = Utils.getconnection();
            String sql = "insert into account values ('5','张国荣','3000')";
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            if (count > 0) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Utils.closes(stat, conn);
    }
}
