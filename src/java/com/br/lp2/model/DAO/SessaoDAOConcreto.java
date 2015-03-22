package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.ListaIngresso;
import com.br.lp2.model.Sessao;
import com.br.lp2.model.javabeans.Filme;
import com.br.lp2.model.SalaDeProjecao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Lucas
 * @version 1.0
 */
public class SessaoDAOConcreto implements SessaoDAO{
private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public SessaoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    @Override
    public boolean insertSessao(Sessao d) {
        String sql = "INSERT INTO sessao (id_saladeprojecao,id_filme,diahora,legenda,id_listaingresso) "
                + "VALUES (?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, d.getSala());
            ps.setObject(2, d.getFilme());
            ps.setDate(3, new Date(d.getDiaHora().getTime()));
            ps.setBoolean(4, d.isLegenda());
            ps.setObject(5, d.getLista());
            if (ps.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Sessao> readSessaos() {
        String sql = "SELECT * FROM sessao";
        ArrayList<Sessao> sessoes = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sessoes.add(new Sessao(rs.getInt("id"), (SalaDeProjecao) rs.getObject("id_saladeprojecao"), (Filme) rs.getObject("id_filme"),
                        rs.getDate("diahora"), rs.getBoolean("legenda"), (ListaIngresso)rs.getObject("id_listaingresso")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sessoes;
    }

    @Override
    public Sessao readSessaoById(int id) {
        String sql = "SELECT * FROM sessao WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new Sessao(rs.getInt("id"), (SalaDeProjecao) rs.getObject("id_saladeprojecao"), (Filme) rs.getObject("id_filme"),
                        rs.getDate("diahora"), rs.getBoolean("legenda"), (ListaIngresso)rs.getObject("id_listaingresso")); 

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    @Override
//    public Sessao readSessaoByNome(String nome) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean updateSessao(int id, Sessao d) {
        String sql = "UPDATE sessao SET id_saladeprojecao = ?, id_filme = ?, diahora = ?, legenda = ? WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, d.getSala());
            ps.setObject(2, d.getFilme());
            ps.setDate(3, new Date(d.getDiaHora().getTime()));
            ps.setBoolean(4, d.isLegenda());
            ps.setObject(5, d.getLista());
            ps.setInt(6, id);
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSessao(int id) {
        String sql = "DELETE FROM sessao WHERE id = ?";

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
    public boolean deleteSessao(Sessao d) {
        String sql = "DELETE FROM cliente WHERE id = ?";

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
}
