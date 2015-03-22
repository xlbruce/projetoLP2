/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GeneroDAOConcreto implements GeneroDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public GeneroDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    /**
     * Insere um novo genero no banco
     *
     * @param c Objeto genero à ser inserido
     * @return true se inserido com sucesso. false caso contrário.
     */
    @Override
    public boolean insertGenero(Genero g) {

        try {
            String sql = "INSERT INTO genero(nome) VALUES (?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, g.getNome());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean insertGenero(String nome) {

        try {
            String sql = "INSERT INTO genero(nome) VALUES (?)";
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

    /**
     * Faz a leitura de todos os generos da tabela genero
     *
     * @return Um arraylist com todos os generos
     */
    @Override
    public ArrayList<Genero> readGeneros() {

        String sql = "SELECT * FROM genero";
        ArrayList<Genero> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Genero(rs.getInt("id"), rs.getString("nome")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Genero readGeneroById(int id) {
        String sql = "SELECT * FROM genero WHERE id=?";
        Genero g = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return g;

    }

    @Override
    public Genero readGeneroByNome(String nome) {
        String sql = "SELECT * FROM genero WHERE nome = ?";
        Genero g = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt(1), rs.getString(2));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return g;
    }

    @Override
    public boolean updateGenero(int id, Genero g) {
        String sql = "UPDATE genero SET nome=? WHERE id=?";
        int resultado = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, g.getNome());
            ps.setInt(2, id);
            resultado = ps.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return resultado > 0 ? true : false;
    }

    @Override
    public boolean deleteGenero(int id) {
        String sql = "DELETE  FROM genero WHERE id=?";
        boolean resultado = false;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;

    }

    @Override
    public boolean deleteGenero(Genero g) {
  boolean resultado = false;
        String sql = "DELETE FROM genero WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, g.getPk());
            ps.executeQuery();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

}
