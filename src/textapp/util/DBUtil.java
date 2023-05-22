package textapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

// DBアクセス-1のJDBCドライバの読み込みとDBへの接続を行っている
//　DB接続に特化したクラス
public class DBUtil {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "testuser", "test");
        } catch (Exception e) {
            // 本来は専用の例外クラスを作成したほうがよい
            throw new RuntimeException(e);
        }
    }
}

