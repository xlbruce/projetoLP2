package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.SalaDeProjecao;
import com.br.lp2.model.javabeans.SalaDeProjecao.Estados;
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
        String sql = "SELECT * FROM saladeprojecao";
        ArrayList<SalaDeProjecao> salaDeProjecoes = new ArrayList<>();
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();            
            while(rs.next()) {
                salaDeProjecoes.add(new SalaDeProjecao(rs.getInt("pk"), rs.getInt("num"), rs.getInt("lotacao"), rs.getInt("PoltEsp"), (Estados) rs.getObject("estados")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return salaDeProjecoes;
    }

    @Override
    public SalaDeProjecao readSalaDeProjecaoById(int id) {
        String sql = "SELECT * FROM saladeprojecao WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new SalaDeProjecao(rs.getInt("pk"), rs.getInt("num"), 
                    rs.getInt("lotacao"), rs.getInt("PoltEsp"), (Estados) rs.getObject("estados"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public SalaDeProjecao readSalaDeProjecaoByNum(int num) {
        String sql = "SELECT * FROM saladeprojecao WHERE num = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            rs.next();
            return new SalaDeProjecao(rs.getInt("pk"), rs.getInt("num"), 
                    rs.getInt("lotacao"), rs.getInt("PoltEsp"), (Estados) rs.getObject("estados"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateSalaDeProjecao(int id, SalaDeProjecao d) {
        String sql = "UPDATE saladeprojecap SET num = ?, lotacao = ?, polestp = ? estado = ? WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, d.getNum());
            ps.setInt(2, d.getLotacao());
            ps.setInt(3, d.getPoltEsp());
            ps.setObject(4, (Estados)d.getEstado());
            ps.setInt(5, id);
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSalaDeProjecao(int id) {
        String sql = "DELETE FROM saladeprojecao WHERE id = ?";

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
    public boolean deleteSalaDeProjecao(SalaDeProjecao d) {
        String sql = "DELETE FROM saladeprojecao WHERE id = ?";

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
