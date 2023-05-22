import java.sql.*;

import app.service.ProductService;

public class Main2 {

    public static void main(String[] args) {
        // JDBCドライバの読み込み
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            return;
        }

        // 接続
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "testuser", "test");
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM products");) {

            // SQL実行
            ResultSet rs = stmt.executeQuery();

            System.out.println("id | name | price");

            // 結果の取得
            while (rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("name");
                var price = rs.getString("price");

                System.out.println(id + " | " + name + " | " + price);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}