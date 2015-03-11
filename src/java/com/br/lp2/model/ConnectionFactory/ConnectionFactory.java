package com.br.gilson.model.ConnectionFactory;

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
    private final String DB = "meudb";
    private Connection connection;
    
    public ConnectionFactory() {
        
    }
    
    public Connection getConnection(String tipo) {
        if(tipo.equalsIgnoreCase("derby")) {
            try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(PROTOCOL + DOMAIN + DB, "root", "root");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ex.printStackTrace();
        }
        }
        return connection;
    }
}
