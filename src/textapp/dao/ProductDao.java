//package textapp.dao;
//
//import textapp.record.ProductRecord;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
////　データベースアクセスをするクラス
//public class ProductDao {
//    // フィールド
//    private Connection connection;
//
//    // コンストラクタ
//    public ProductDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    // メソッドById
//    public ProductRecord findById(int id) {
//        final var SQL = "SELECT id FROM products WHERE id = ?";
//
//        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return new ProductRecord(rs.getInt("id"),"","");
//            }
//        } catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//
//        return null;
//    }
//
//    // メソッドByName
//    public List<ProductRecord> findByName(String name) {
//        final var SQL = "SELECT id, name, price FROM products WHERE name LIKE ?";
//
//        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
//            stmt.setString(1, "%" + name + "%");
//            ResultSet rs = stmt.executeQuery();
//
//            List<ProductRecord> productList = new ArrayList<>();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String productName = rs.getString("name");
//                String price = rs.getString("price");
//
//                ProductRecord productRecord = new ProductRecord(id, productName);
//                productList.add(productRecord);
//            }
//
//            return productList;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//
