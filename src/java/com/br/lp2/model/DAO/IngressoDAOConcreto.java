package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.Ingresso;
import com.br.lp2.model.javabeans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Lucas
 * @version 1.0
 */
public class IngressoDAOConcreto implements IngressoDAO{
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public IngressoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertIngresso(Ingresso d) {
        String sql = "INSERT INTO ingresso (numero, inteira, tipo) VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getNumero());
            ps.setBoolean(2, d.isInteira());
            ps.setObject(3, d.getTipo());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean insertIngresso(int numero, boolean inteira, Cliente.Especiais tipo) {
        String sql = "INSERT INTO ingresso (numero, inteira, tipo) VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setBoolean(2, inteira);
            ps.setObject (3, tipo);
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Ingresso> readIngressos() {
        String sql = "SELECT * FROM ingresso";
        ArrayList<Ingresso> ingressos = new ArrayList<>();
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();            
            while(rs.next()) {
                ingressos.add(new Ingresso(rs.getInt("pk"), rs.getInt("numero"), rs.getBoolean("inteira"), (Cliente.Especiais)rs.getObject("tipo")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ingressos;
    }

    @Override
    public Ingresso readIngressoByPk(int pk) {
        String sql = "SELECT * FROM ingresso WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ingresso(rs.getInt("pk"), rs.getInt("numero"), rs.getBoolean("inteira"), (Cliente.Especiais)rs.getObject("tipo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Ingresso readIngressoByNum(int num){
        String sql = "SELECT * FROM ingresso WHERE numero = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ingresso(rs.getInt("pk"), rs.getInt("numero"), rs.getBoolean("inteira"), (Cliente.Especiais)rs.getObject("tipo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Ingresso readIngressoByInteira(Boolean inteira){
        String sql = "SELECT * FROM ingresso WHERE inteira = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setBoolean(1, inteira);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ingresso(rs.getInt("pk"), rs.getInt("numero"), rs.getBoolean("inteira"), (Cliente.Especiais)rs.getObject("tipo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Ingresso readIngressoByTipo(Cliente.Especiais tipo){
        String sql = "SELECT * FROM ingresso WHERE tipo = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, tipo);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ingresso(rs.getInt("pk"), rs.getInt("numero"), rs.getBoolean("inteira"), (Cliente.Especiais)rs.getObject("tipo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public boolean updateIngresso(int id, Ingresso d) {
        String sql = "UPDATE ingresso SET (numero, inteira, tipo) = (?,?,?) WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getNumero());
            ps.setBoolean(2, d.isInteira());
            ps.setObject(3, d.getTipo());
            ps.setInt(4, id);
            if(ps.executeUpdate() != 0) { //Verifica se foi atualizado
                return true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false; 
    }

    @Override
    public boolean deleteIngresso(int id) {
        String sql = "DELETE FROM ingresso WHERE id = ?";
        
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
    public boolean deleteIngresso(Ingresso d) {
        String sql = "DELETE FROM ingresso WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getId());
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false; 
    }
    
}
