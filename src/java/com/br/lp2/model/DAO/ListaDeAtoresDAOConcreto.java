package com.br.lp2.model.DAO;

import com.br.lp2.model.Ator;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.ListaDeAtores;
import com.br.lp2.model.javabeans.Filme;
import com.br.lp2.model.javabeans.InfoAtor;
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
    public boolean insertListaDeAtores(Ator a, Filme f) {
        String sql = "INSERT INTO listadeatores (id_filme, id_ator) VALUES (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setInt(2, f.getId());
            if (ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //FIX ME
    @Override
    public ListaDeAtores readListaDeAtoresByFilme(Filme f) {
        String sql = "SELECT * FROM listadeatores INNER JOIN infoator ON "
                + "listadeatores.id_filme = ? AND "
                + "listadeatores.id_ator = infoator.id_ator JOIN ator ON "
                + "infoator.id_ator = ator.id;";
        ArrayList<InfoAtor> atores = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, f.getId());
            rs = ps.executeQuery();
            
            Ator atorTmp;
            while (rs.next()) {
                atorTmp = new Ator(rs.getInt("id_ator"), rs.getString("nome"), 
                        rs.getString("nacionalidade"), rs.getDate("nascimento"));
                atores.add(new InfoAtor(rs.getInt("id_ator"), atorTmp, 
                        rs.getString("papel"), rs.getString("part")));  
            }
            return new ListaDeAtores(rs.getInt("id"), atores);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return null;
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
    public ArrayList<Filme> readFilmeByAtor(Ator a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAtorByFilme(Filme f, Ator a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFilme(Filme f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
