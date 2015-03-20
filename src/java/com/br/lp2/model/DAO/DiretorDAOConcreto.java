package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Diretor;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Diretor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class DiretorDAOConcreto implements DiretorDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public DiretorDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDiretor(Diretor d) {
        String sql = "INSERT INTO diretor (nome) VALUES (?)";
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
    public boolean insertDiretor(String nome) {
        String sql = "INSERT INTO diretor (nome) VALUES (?)";
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
    public ArrayList<Diretor> readDiretor() {
        String sql = "SELECT * FROM diretor";
        ArrayList<Diretor> diretores = new ArrayList<>();
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();            
            while(rs.next()) {
                diretores.add(new Diretor(rs.getString("nome"), rs.getInt("pk")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return diretores;
    }

    @Override
    public Diretor readDiretorById(int id) {
        String sql = "SELECT * FROM diretor WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Diretor(rs.getString("nome"), rs.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Diretor readDiretorByNome(String nome) {
        String sql = "SELECT * FROM diretor WHERE nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Diretor(rs.getString("nome"), rs.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateDiretor(int id, Diretor d) {
        String sql = "UPDATE diretor SET nome = ?";

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
    public boolean deleteDiretor(int id) {
        String sql = "DELETE FROM diretor WHERE id = ?";
        
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
    public boolean deleteDiretor(Diretor d) {
        String sql = "DELETE FROM ator WHERE id = ?";
        
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
