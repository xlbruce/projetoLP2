package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 31409695
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
    public ArrayList<Departamento> readDepartamentos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
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
            rs = ps.executeQuery();
            while(rs.next()) {
                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento readDepartamento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDepartamento(int codigo, Departamento d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDepartamento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDepartamento(Departamento d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
