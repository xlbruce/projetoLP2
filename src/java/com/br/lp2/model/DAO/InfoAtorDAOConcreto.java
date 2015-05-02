package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ator;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.InfoAtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Lucas
 */
public class InfoAtorDAOConcreto implements InfoAtorDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public InfoAtorDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertInfoAtor(InfoAtor i) {
        String sql = "INSERT INTO ator (papel, part, id_ator) "
                + "VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, i.getPapel());
            ps.setString(2, i.getPart());
            ps.setObject(3, i.getAtor());
            if (ps.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<InfoAtor> readInfoAtors() {
        String sql = "SELECT * FROM infoator";
        ArrayList<InfoAtor> infoAtores = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                infoAtores.add(new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"), rs.getString("papel"),
                        rs.getString("part")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return infoAtores;
    }

    @Override
    public InfoAtor readInfoAtorById(int id) {
        String sql = "SELECT * FROM infoator WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"), rs.getString("papel"),
                    rs.getString("part"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public InfoAtor readInfoAtorByAtor(Ator ator) {
        String sql = "SELECT * FROM infoator WHERE id_ator = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, ator);
            rs = ps.executeQuery();
            rs.next();
            return new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"), rs.getString("papel"),
                    rs.getString("part"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public InfoAtor readInfoAtorByPapel(String papel) {
        String sql = "SELECT * FROM infoator WHERE papel = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, papel);
            rs = ps.executeQuery();
            rs.next();
            return new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"), rs.getString("papel"),
                    rs.getString("part"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public InfoAtor readInfoAtorByNome(String nome) {
        String sql = "SELECT * FROM infoator WHERE nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next();
            return new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"),
                    rs.getString("papel"),
                    rs.getString("part"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public InfoAtor readInfoAtorByPart(String part) {
        String sql = "SELECT * FROM infoator WHERE part = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, part);
            rs = ps.executeQuery();
            rs.next();
            return new InfoAtor(rs.getInt("id"), (Ator) rs.getObject("id_ator"), rs.getString("papel"),
                    rs.getString("part"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateInfoAtor(int id, InfoAtor i) {
        String sql = "UPDATE infoator SET papel = ?, part = ?, id_ator = ? WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, i.getPapel());
            ps.setString(2, i.getPart());
            ps.setObject(3, i.getAtor());
            ps.setInt(4, id);
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteInfoAtor(int id) {
        String sql = "DELETE FROM infoator WHERE id = ?";

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
    public boolean deleteInfoAtor(InfoAtor i) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, i.getId());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
