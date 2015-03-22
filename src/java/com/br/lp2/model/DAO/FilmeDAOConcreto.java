package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.ListaDeAtores;
import com.br.lp2.model.javabeans.Diretor;
import com.br.lp2.model.javabeans.Distribuidora;
import com.br.lp2.model.javabeans.Filme;
import com.br.lp2.model.javabeans.Filme.TipoSituacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AndreLucas
 * @version 1.0
 */
public class FilmeDAOConcreto implements FilmeDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public FilmeDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    /**
     * Insere um novo filme no banco
     *
     * @param f Objeto filme à ser inserido
     * @return true se inserido com sucesso. false caso contrário.
     */
    @Override
    public boolean insertFilme(Filme f) {
        boolean resultado = false;
        String sql = "INSERT INTO filme (titulo, situacao, idioma, classificacao,"
                + " ano, duracao, id_listaAtores, "
                + "id_distribuidora, id_diretor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, f.getTitulo());
            ps.setString(2, f.getSituacao().toString());
            ps.setString(3, f.getIdioma());
            ps.setInt(4, f.getClassificacao());
            ps.setInt(5, f.getAno());
            ps.setInt(6, f.getDuracao());
            ps.setInt(7, f.getListaAtores().getId());

            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean insertFilme(String titulo, String situacao, String idioma, int classificacao, int ano, int duracao, int id_listaAtores, int id_distribuidora, int id_diretor) {
        boolean resultado = false;
        String sql = "INSERT INTO filme (titulo, situacao, idioma, classificacao,"
                + " ano, duracao, id_listaAtores, "
                + "id_distribuidora, id_diretor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, situacao);
            ps.setString(3, idioma);
            ps.setInt(4, classificacao);
            ps.setInt(5, ano);
            ps.setInt(6, duracao);
            ps.setInt(7, id_listaAtores);
            ps.setInt(8, id_distribuidora);
            ps.setInt(9, id_diretor);

            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Filme> readFilmes() {
        String sql = "SELECT * FROM filme";
        ArrayList<Filme> filmes = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filmes.add(new Filme(rs.getInt("id"),
                        rs.getString("titulo"),
                        (TipoSituacao) rs.getObject("situacao"),
                        rs.getString("idioma"),
                        (ListaDeAtores) rs.getObject("id_listaAtores"),
                        (Distribuidora) rs.getObject("id_distribuidora"),
                        (Diretor) rs.getObject("id_diretor"),
                        rs.getInt("ano"),
                        rs.getInt("duracao"),
                        rs.getInt("classificacao")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmes;
    }

    @Override
    public Filme readFilmeById(int id) {
        String sql = "SELECT * FROM filme WHERE id = ?";
        Filme filme = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            while (rs.next()) {

                filme = (new Filme(rs.getInt("id"),
                        rs.getString("titulo"),
                        (TipoSituacao) rs.getObject("situacao"),
                        rs.getString("idioma"),
                        (ListaDeAtores) rs.getObject("id_listaAtores"),
                        (Distribuidora) rs.getObject("id_distribuidora"),
                        (Diretor) rs.getObject("id_diretor"),
                        rs.getInt("ano"),
                        rs.getInt("duracao"),
                        rs.getInt("classificacao")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filme;
    }

    @Override
    public Filme readFilmeByNome(String nome) {
        Filme filme = null;
        String sql = "SELECT * FROM filme WHERE nome=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                filme = (new Filme(rs.getInt("id"),
                        rs.getString("titulo"),
                        (TipoSituacao) rs.getObject("situacao"),
                        rs.getString("idioma"),
                        (ListaDeAtores) rs.getObject("id_listaAtores"),
                        (Distribuidora) rs.getObject("id_distribuidora"),
                        (Diretor) rs.getObject("id_diretor"),
                        rs.getInt("ano"),
                        rs.getInt("duracao"),
                        rs.getInt("classificacao")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filme;

    }

    @Override
    public boolean updateFilme(int id, Filme f) {

        String sql = "UPDATE filme SET titulo =?, situacao =?, idioma =?, classificacao =?,"
                + " ano=?, duracao=?, id_listaAtores =?, "
                + "id_distribuidora =?, id_diretor =? WHERE id=?";
        int resultado = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, f.getTitulo());
            ps.setString(2, f.getSituacao().toString());
            ps.setString(3, f.getIdioma());
            ps.setInt(4, f.getClassificacao());
            ps.setInt(5, f.getAno());
            ps.setInt(6, f.getDuracao());
            ps.setInt(7, f.getListaAtores().getId());
            ps.setInt(8, f.getDistribuidora().getPk());
            ps.setInt(9, f.getDiretor().getPk());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado > 0 ? true : false;
    }

    @Override
    public boolean deleteFilme(int id) {
        String sql = "DELETE FROM filme WHERE id = ?";

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
    public boolean deleteFilme(Filme f) {
        String sql = "DELETE FROM filme WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, f.getId());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
