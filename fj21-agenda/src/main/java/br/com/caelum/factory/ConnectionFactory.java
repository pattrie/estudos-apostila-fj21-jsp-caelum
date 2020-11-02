package br.com.caelum.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/fj21", "root", "devmysql");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Deu ruim." + e);
        }
    }
}
