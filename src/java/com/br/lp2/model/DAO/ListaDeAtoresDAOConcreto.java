package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.ListaDeAtores;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ListaDeAtoresDAOConcreto implements ListaDeAtoresDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public ListaDeAtoresDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertListaDeAtores(ListaDeAtores d) {

        boolean resultado = false;
        String sql = "INSERT INTO funcionario (id_filme,id_ator) VALUES (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getFilme());
            ps.setArray(2, (Array) d.getAtores());
            ps.execute();
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<ListaDeAtores> readListaDeAtoress() {
        ArrayList<ListaDeAtores> lista = new ArrayList<>();
        String sql = "SELECT * FROM listadeatores";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ListaDeAtores(rs.getArray("id_ator"), rs.getInt("id"), rs.getInt("id_filme")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public ListaDeAtores readListaDeAtoresById(int id) {
String sql = "SELECT * FROM listaingresso WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new ListaDeAtores(rs.getArray("id_ator"),rs.getInt("id_filme"),rs.getInt("id"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    

    @Override
    public boolean updateListaDeAtores(int id, ListaDeAtores d) {

        String sql = "UPDATE listadeatores SET ingresso=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setArray(1, (Array) d.getLista());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteListaDeAtores(int id) {

        String sql = "DELETE FROM listadeatores WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public boolean deleteListaDeAtores(ListaDeAtores d) {

        String sql = "DELETE FROM listadeatores WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getPk());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ListaDeAtores readListaDeAtoresByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

}
