package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Essa classe é responsável por persistir os dados na tabela Cargo no banco de dados
 * @author 31409695
 * @version 1.0
 */
public class CargoDAOConcreto implements CargoDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CargoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    /**
     * Insere um novo cargo no banco
     * @param c Objeto cargo à ser inserido
     * @return true se inserido com sucesso. false caso contrário.
     */
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

    /**
     * Faz a leitura de todos os cargos da tabela cargo
     * @return Um arraylist com todos os cargos
     */
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
