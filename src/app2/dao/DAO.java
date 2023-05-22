package app2.dao;

import app2.record.usersRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// データアクセスオブジェクト
public class DAO {

    // フィールド
    private Connection connection;

    // コンストラクタ
    public DAO(Connection connection) {
        this.connection = connection;
    }

    // メソッド　1が選択されたときユーザー一覧
    public List<usersRecord> fildAll() {
        final var SQL = "SELECT * FROM users";

        var list = new ArrayList<usersRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var user = new usersRecord(rs.getInt("id"), rs.getInt("company_id"), rs.getString("name"), rs.getInt("score"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public int insert(usersRecord users) {
        // サービスクラスから受けったと値を？に入れてSQL文をDBに渡している
        final var SQL = "INSERT INTO users (company_id, name, score) VALUES ( ?, ?, ?)";
    try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
                stmt.setInt(1, users.company_id());
                stmt.setString(2, users.name());
                stmt.setInt(3, users.score());
                var result = stmt.executeUpdate();
                return result;
    } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int delete(usersRecord users) {
        // サービスクラスから受けったと値を？に入れてSQL文をDBに渡している
        final var SQL = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1, users.id());

            var result = stmt.executeUpdate();
            return result;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

