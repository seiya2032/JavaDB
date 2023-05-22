package app.service;

import app.dao.ProductDao;
import app.recod.ProductRecord;
import app.util.DBUtil;

import java.sql.SQLException;
import java.util.List;
public class ProductService {

    public List<ProductRecord> findByid() {
        try(var connection = DBUtil.getConnection();) {
            var userDao = new ProductDao(connection);
            return userDao.findByld();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
