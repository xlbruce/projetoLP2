package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class GeneroDAOConcreto implements GeneroDAO {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public GeneroDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertGenero(Genero g) {
        String sql = "INSERT INTO genero (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, g.getNome());
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean insertGenero(String nome) {
        String sql = "INSERT INTO genero (nome) VALUES (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Genero> readGeneros() {
        String sql = "SELECT * FROM genero";
        ArrayList<Genero> generos = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                generos.add(new Genero(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return generos;
    }

    @Override
    public Genero readGeneroById(int id) {
        String sql = "SELECT * FROM genero WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new Genero(rs.getInt("id"), rs.getString("nome"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Genero readGeneroByNome(String nome) {
        String sql = "SELECT * FROM genero WHERE nome = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next();
            return new Genero(rs.getInt("id"), rs.getString("nome"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateGenero(int id, Genero g) {
        String sql = "UPDATE genero SET nome = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, g.getNome());
            if(ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteGenero(int id) {
        String sql = "DELETE FROM genero WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteGenero(Genero g) {
        String sql = "DELETE FROM genero WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, g.getPk());
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
