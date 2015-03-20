package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Diretor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class DiretorDAOConcreto implements DiretorDAO {
    
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public DiretorDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDiretor(Diretor d) {
        String sql = "INSERT INTO diretor WHERE id = ?";        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getPk());
            
        } catch (SQLException ex) {
            Logger.getLogger(DiretorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertDiretor(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Diretor> readDiretor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diretor readDiretorById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diretor readDiretorByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDiretor(int id, Diretor d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDiretor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDiretor(Diretor d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
