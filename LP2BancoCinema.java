/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2bancocinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31440983
 */
public class LP2BancoCinema {

    public static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String protocol = "jdbc:derby:";
    public static final String dbname = "cinema_db";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CreateDB();
        insertGenero();
        readGenero();
        CloseDB();
    }

    public static void CreateDB() {

        try {
            System.out.println("--CREATE--");
            System.out.println("generos");
            //1.Declarar o drive
            Class.forName(driver).newInstance();
            //2.Criar a conexão;
            connection = DriverManager.getConnection(protocol + dbname + ";create=true");
            //3a.Criar o statement para executar o sql.
            statement = connection.createStatement();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }

        try {
            //Apagar as tabelas antes de criar.
            String sqlDrop = "drop table generos";
            statement.execute(sqlDrop);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //3.b Execução SQL .
        try {
            String sqlCreate = "create table generos (id int, nome varchar(20))";
            statement.execute(sqlCreate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertGenero() {
        String sqlInsert = "insert into generos values(1,'Acção'),(2,'Animação'),(3,'Biografias'),(4,'Comédia'),(5,'Documentário')"
                + ",(6,'Erótico'),(7,'Ficção'),(8,'Guerra'),(9,'Musical'),(10,'Policial'),(11,'Romance'),(12,'Suspense'),(13,'Terror')";
        try {
            statement.execute(sqlInsert);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void readGenero() {
        System.out.println("--READ--");
        System.out.println("Generos: ");
        String sqlRead = "select * from generos";
       try{
        rs = statement.executeQuery(sqlRead);
        while(rs.next())
        {
            System.out.println(rs.getInt("id")+" - " + rs.getString("nome"));
        }
    }catch(SQLException ex){
    ex.printStackTrace();
    }
    }

    public static void CloseDB() {
        //4. Fechar tudo 

        System.out.println("--CLOSE--");
        try {
            DriverManager.getConnection(protocol + ";shutdown=true");
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 50000 && ex.getSQLState().equals("XJ015")) {
                System.out.println("Desconectado corretamente");
            } else {
                System.out.println("Erro ao desconectar");
            }
        }
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
