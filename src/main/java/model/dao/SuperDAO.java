package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuperDAO {

    private static final String CONNECT_STRING
            = "jdbc:mysql://localhost:3306/sip_a?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true";
    private static final String USER_ID = "root";
    private static final String PASSWORD = "lovekayo";
    protected Connection con = null;

    protected void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONNECT_STRING, USER_ID, PASSWORD);
            System.out.println("データベースへの接続に成功しました。");
        } catch (SQLException e) {
            System.err.println("データベースへの接続時に問題が発生しました。");
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    protected void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("データベースからの切断に成功しました。");
        } catch (SQLException e) {
            System.err.println("データベースからの切断時に問題が発生しました。");
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        SuperDAO sd = new SuperDAO();

        PreparedStatement ps = null;

        sd.connect();

        sd.close(ps);

    }
}
