package edu.javacourse.city.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBulder implements ConnectionBuilder {
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/city_register",
                "postgres", "Ryqagezyb1488");
    }
}
