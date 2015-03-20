package com.br.lp2.model.DAO;

import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Cliente;
import com.br.lp2.model.javabeans.Cliente.Especiais;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class ClienteDAOConcreto implements ClienteDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public ClienteDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertCliente(Cliente c) {
        String sql = "INSERT INTO cliente (nome, nascimento, tipo) "
                + "VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setDate(2, (Date) c.getNascimento());
            ps.setObject(3, (Especiais) c.getTipo());
            if (ps.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Cliente> readClientes() {
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("pk"), rs.getString("nome"),
                        rs.getDate("nascimento"), (Especiais) rs.getObject("tipo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente readClienteById(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("pk"), rs.getString("nome"),
                        rs.getDate("nascimento"), (Especiais) rs.getObject("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public Cliente readClienteByNome(String nome) {
        String sql = "SELECT * FROM cliente WHERE nome = ?";
        Cliente cliente = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("pk"), rs.getString("nome"),
                        rs.getDate("nascimento"), (Especiais) rs.getObject("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public boolean updateCliente(int id, Cliente c) {
        String sql = "UPDATE cliente SET nome = ?, nascimento = ?, tipo = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setDate(2, (Date) c.getNascimento());
            ps.setObject(3, (Especiais) c.getTipo());
            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCliente(Cliente c) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getPk());
            if (ps.execute()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
