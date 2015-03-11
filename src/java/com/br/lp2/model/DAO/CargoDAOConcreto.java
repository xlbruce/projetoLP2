/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.gilson.model.DAO;

import com.br.gilson.model.ConnectionFactory.ConnectionFactory;
import com.br.gilson.model.javabeans.Cargo;
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
public class CargoDAOConcreto implements CargoDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CargoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertCargo(Cargo c) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO cargo(nome) VALUES (?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            resultado = ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ArrayList<Cargo> readCargos() {
        String sql = "SELECT * FROM cargo";
        ArrayList<Cargo> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cargo(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cargo readCargoById(int id) {
        String sql = "SELECT * FROM cargo WHERE id=?";
        Cargo c = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cargo(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public Cargo readCargoByNome(String nome) {
        String sql = "SELECT * FROM cargo WHERE nome=?";
        Cargo c = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cargo(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean updateCargo(int id, Cargo c) {
        String sql = "UPDATE cargo SET nome=? WHERE id=?";
        int resultado = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setInt(2, id);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado > 0 ? true : false;
    }

    @Override
    public boolean deleteCargo(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM cargo WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteCargo(Cargo c) {
        boolean resultado = false;
        String sql = "DELETE FROM cargo WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.executeQuery();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

}
