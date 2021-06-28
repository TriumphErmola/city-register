package edu.javacourse.city.dao;

import edu.javacourse.city.web.CheckPersonServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {

    public static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private DataSource dataSourse;

    public PoolConnectionBuilder() {
        try {
            Context ctx = new InitialContext();
            dataSourse = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException e) {
            logger.error("", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSourse.getConnection();
    }
}
