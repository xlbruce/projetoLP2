package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.SalaDeProjecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bruce
 */
public class SalaDeProjecaoDAOConcreto implements SalaDeProjecaoDAO {
    
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public SalaDeProjecaoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }    

    @Override
    public boolean insertSalaDeProjecao(SalaDeProjecao s) {
        try {
            String sql = "INSERT INTO saladeprojecao(num, lotacao, postesp, estados)"
                    + " VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, s.getNum());
            ps.setInt(2, s.getLotacao());
            ps.setInt(3, s.getPoltEsp());
            ps.setString(4, s.getEstado().toString());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<SalaDeProjecao> readSalaDeProjecoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SalaDeProjecao readSalaDeProjecaoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SalaDeProjecao readSalaDeProjecaoByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSalaDeProjecao(int id, SalaDeProjecao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSalaDeProjecao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSalaDeProjecao(SalaDeProjecao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
