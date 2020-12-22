package com.mason.alpha.infra;

import java.sql.*;

public class DB {

    public static PreparedStatement prepare(String statement) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "mycat123");
        return connection.prepareStatement(statement);
    }

    public static void cleanUp(PreparedStatement stmt, ResultSet resultSet) {
        try {
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cleanUp(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
