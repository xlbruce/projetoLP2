package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
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
    /* attr - titulo, idioma, situação, listaAtores, distribuidora, diretor
     classificação, ano, pk, dureção
     */

    @Override
    public boolean insertFilme(Filme d) {
        String sql = "INSERT INTO filme (titulo, idioma, "
                + "situacao, id_distribuidora,"
                + " id_diretor,classificacao, "
                + "ano, duracao)" +
"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, d.getTitulo());
            ps.setString(2, d.getIdioma());
            ps.setString(3, d.getSituacao().toString());
            ps.setInt(4, d.getDistribuidora().getPk());
            ps.setInt(5, d.getDiretor().getPk());
            ps.setInt(6, d.getClassificacao());
            ps.setInt(7, d.getAno());
            ps.setInt(8, d.getDuracao());
            if(ps.execute()) {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Filme> readFilmes() {
        String sql = "SELECT * FROM filme";
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                //FIXME
                //filmes.add(new Filme(rs.getInt("id"), rs.getString("titulo"), Filme.TipoSituacao.valueOf(rs.getString("situacao")), rs.getString("idioma"), null, null, null, classificacao, ano, duracao))
            }
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filme readFilmeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filme readFilmeByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateFilme(int id, Filme d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFilme(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFilme(Filme d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
