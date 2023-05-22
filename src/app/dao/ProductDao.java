package app.dao;

import app.recod.ProductRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public List<ProductRecord> findByld(int id) {
        final var SQL = "SELECT id, FROM products";

        var list = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var ID = new ProductRecord(rs.getInt(id));
                list.add(ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<ProductRecord> findByld() {
        return null;
    }
}
