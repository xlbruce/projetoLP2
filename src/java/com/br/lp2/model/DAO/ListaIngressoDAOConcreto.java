/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Ingresso;
import com.br.lp2.model.ListaIngresso;
import com.br.lp2.model.javabeans.Cliente.Especiais;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ListaIngressoDAOConcreto implements ListaIngressoDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public ListaIngressoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertListaIngresso(ListaIngresso d) {
        String sql = "INSERT INTO listaingresso (ingresso) VALUES (?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, d);

            if (ps.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return false;

    }

    @Override
    public ArrayList<ListaIngresso> readListaIngressos() {
 String sql = "SELECT * FROM listaingresso";
        ArrayList<ListaIngresso> ingresso = null;
       
            try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ingresso.add(new ListaIngresso());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ingresso;
    }

    @Override
    public ListaIngresso readListaIngressoById(int id) {
        
    String sql = "SELECT * FROM listaingresso WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new ListaIngresso();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    

    @Override
    public boolean updateListaIngresso(int id, ListaIngresso d) {

    String sql = "UPDATE listaingresso SET ingresso=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setArray(1, (Array) d.getLista());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteListaIngresso(int id) {
    
    String sql = "DELETE FROM listaingresso WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteListaIngresso(ListaIngresso d) {

    String sql = "DELETE FROM listaingresso WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,d.getPk());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ListaIngresso readListaIngressoByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

