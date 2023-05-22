//package textapp.service;
//
//import textapp.ProductNotFoundException;
//import textapp.dao.ProductDao;
//import textapp.record.ProductRecord;
//import textapp.util.DBUtil;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class ProductService {
//    // フィールド
//    private ProductDao productDao;
//
//    // コンストラクタ
//    public  ProductService() {
//        this.productDao = new ProductDao(DBUtil.getConnection());
//    }
//
//    // findByIdメソッド
//    public ProductRecord findById(int id) {
//        try{
//            return productDao.findById(id);
//        } catch (NegativeArraySizeException e) {
//            throw new ProductNotFoundException("Product not found with ID: " + id);
//        }
//    }
//}
