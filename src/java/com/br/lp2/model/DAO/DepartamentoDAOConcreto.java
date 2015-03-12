/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Departamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31409695
 */
public class DepartamentoDAOconcreto implements DepartamentoDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement pst;

    public DepartamentoDAOconcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDepartamento(Departamento d) {
        boolean resultado = false;
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, d.getNome());
            pst.execute();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ArrayList<Departamento> readDepartamentos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                departamentos.add(new Departamento(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    @Override
    public Departamento readDepartamento(Departamento d) {
        Departamento departamento = null;
        String sql = "SELECT * FROM departamento WHERE id=?";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento readDepartamento(int codigo) {
        Departamento departamento = null;

        String sql = "SELECT * FROM departamento WHERE id=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setInt(1, codigo);
            rs = pst.executeQuery();

            while (rs.next()) {

                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOconcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
    }

    @Override
    public boolean updateDepartamento(int codigo, Departamento d) {

        boolean resultado = false;
        try {
            String sql = "UPDATE departamento SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, d.getNome());
            pst.setInt(2, codigo);

            int r = pst.executeUpdate();

            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOconcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteDepartamento(int codigo) {
        
            boolean resultado = false;
           try {
               String sql = "DELETE * FROM departamento WHERE id=?";
            
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, codigo);
            resultado = pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAOconcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteDepartamento(Departamento d) {
        boolean resultado = false;
        try {
            String sql = "DELETE * FROM departamento WHERE id=?";
            
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, d.getId());
            
            resultado = pst.execute();
        } catch (SQLException sQLException) {
        }
        return resultado;
    }

}
