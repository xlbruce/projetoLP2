package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AndreLucas
 * @version 1.0
 */
public class FuncionarioDAOConcreto implements FuncionarioDAO{
    
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public FuncionarioDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertFuncionario(Funcionario f) {
        boolean resultado = false;
        String sql = "INSERT INTO funcionario (nome, rg, id_cargo, id_funcionario) VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getRg());
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    @Override
    public boolean insertFuncionario (String nome, String rg, int id_cargo, int id_departamento){
        boolean resultado = false;
        String sql = "INSERT INTO funcionario (nome, rg, id_cargo, id_funcionario) VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, rg);
            ps.setInt(3, id_cargo);
            ps.setInt(4, id_departamento);
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Funcionario> readFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                funcionarios.add(new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("rg"), rs.getInt("id_cargo"), rs.getInt("id_departamento")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionarios;
    }

    @Override
    public Funcionario readFuncionario(Funcionario f) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, f.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
               funcionario = (new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("rg"), rs.getInt("id_cargo"), rs.getInt("id_departamento")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }

    @Override
    public Funcionario readFuncionarioById(int codigo) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
               funcionario = (new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("rg"), rs.getInt("id_cargo"), rs.getInt("id_departamento")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }

    @Override
    public Funcionario readFuncionarioByRg(String rg) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM departamento WHERE rg=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, rg);
            rs = ps.executeQuery();
            while (rs.next()) {
               funcionario = (new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("rg"), rs.getInt("id_cargo"), rs.getInt("id_departamento")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }

    @Override
    public boolean updateFuncionario(int codigo, Funcionario f) {
        String sql = "UPDATE funcionario SET nome=?, rg=?, id_cargo=?,id_departamento=? WHERE id=?";
        int resultado = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getRg());
            ps.setInt(3, f.getId_cargo());
            ps.setInt(4, f.getId_departamento());
            ps.setInt(5, codigo);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado > 0 ? true : false;
    }

    @Override
    public boolean deleteFuncionario(Funcionario f) {
        boolean resultado = false;
        String sql = "DELETE FROM funcionario WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, f.getId());
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteFuncionarioById(int codigo) {
        boolean resultado = false;
        String sql = "DELETE FROM funcionario WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteFuncionarioByRg(String rg) {
        boolean resultado = false;
        String sql = "DELETE FROM funcionario WHERE rg=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, rg);
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }   
}
