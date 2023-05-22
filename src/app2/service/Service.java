package app2.service;

import app2.dao.DAO;
import app2.record.companiesRecord;
import app2.record.usersRecord;
import app2.util.DbUtil;

import java.sql.SQLException;
import java.util.List;


public class Service {

    private static List<usersRecord> userList;
    private static List<companiesRecord> companyList;

    // 下記にメソッド　やりたい処理　DAOクラスに送る
    //　ループ処理　各処理
    public List<usersRecord> fildAll() {
        // ユーザー一覧表示
        try (var connection = DbUtil.getConnection();) {
            var dao = new DAO(connection);
            return dao.fildAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insert(usersRecord users) {
        // 2の処理　ユーザー追加
        // DAOクラスにmainクラスから受け取った値を渡している
        try (var connection = DbUtil.getConnection()) {
                var dao = new DAO(connection);
                var result = dao.insert(users);
                return result;
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(usersRecord users) {

        try (var connection = DbUtil.getConnection()) {
            var dao = new DAO(connection);
            var result = dao.delete(users);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


