package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31409695
 * @version 1.0
 */
public class DepartamentoDAOConcreto implements DepartamentoDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public DepartamentoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDepartamento(Departamento d) {
        boolean resultado = false;
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean insertDepartamento(String nome) {
        boolean resultado = false;
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
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
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
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
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamento;
    }

    @Override
    public Departamento readDepartamentoById(int codigo) {
        Departamento departamento = null;

        String sql = "SELECT * FROM departamento WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamento;
    }

    @Override
    public boolean updateDepartamento(int codigo, Departamento d) {

        boolean resultado = false;
        try {
            String sql = "UPDATE departamento SET nome=? WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.setInt(2, codigo);

            int r = ps.executeUpdate();

            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    @Override
    public boolean deleteDepartamento(Departamento d) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM departamento WHERE id=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getId());

            resultado = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteDepartamentoById(int codigo) {

        boolean resultado = false;
        try {
            String sql = "DELETE FROM departamento WHERE id=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            resultado = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

