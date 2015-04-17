package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Distribuidora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class DistribuidoraDAOConcreto implements DistribuidoraDAO {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps; 

    public DistribuidoraDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDistribuidora(Distribuidora d) {
        String sql = "INSERT INTO distribuidora (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, d.getNome());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean insertDistribuidora(String nome) {
        String sql = "INSERT INTO distribuidora (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Distribuidora> readDistribuidoras() {
        String sql = "SELECT * FROM distribuidora";
        ArrayList<Distribuidora> distribuidoras = new ArrayList<>();
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();            
            while(rs.next()) {
                distribuidoras.add(new Distribuidora(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return distribuidoras;
    }

    @Override
    public Distribuidora readDistribuidoraById(int id) {
        String sql = "SELECT * FROM distribuidora WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Distribuidora(rs.getInt("id"), rs.getString("nome"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Distribuidora readDistribuidoraByNome(String nome) {
        String sql = "SELECT * FROM distribuidora WHERE nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Distribuidora(rs.getInt("id"), rs.getString("nome"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateDistribuidora(int id, Distribuidora d) {
        String sql = "UPDATE distribuidora SET nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, d.getNome());
            if(ps.executeUpdate() != 0) { //Verifica se foi atualizado
                return true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false; 
    }

    @Override
    public boolean deleteDistribuidora(int id) {
        String sql = "DELETE FROM distribuidora WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteDistribuidora(Distribuidora d) {
       String sql = "DELETE FROM distribuidora WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getPk());
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false; 
    }
    
}
