package app2.util;

import java.sql.Connection;
import java.sql.DriverManager;

// データベースのアクセス（接続している）
public class DbUtil {
    // データベースに接続してConnection(コネクションをもらってくる)
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "testuser", "test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
