package core.sql;

import java.sql.*;

public class SQLConnector {

    private String result;
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "NikBar82!";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hometask16_table?serverTimezone=UTC&useSSL=false";

    public String getDBResult(String query, String columnLabel) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                result = resultSet.getString(columnLabel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
