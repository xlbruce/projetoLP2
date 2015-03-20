package com.br.lp2.model.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 31409695
 */
public class ConnectionFactory {
    private final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String PROTOCOL = "jdbc:derby:";
    private final String DOMAIN = "//localhost:1527/";
    private final String DB = "testebd";
    private Connection connection;
    
    public ConnectionFactory() {
        
    }
    
    public Connection getConnection(String tipo) {
        if(tipo.equalsIgnoreCase("derby")) {
            try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(PROTOCOL + DOMAIN + DB, "root", "root");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        return connection;
    }
}
