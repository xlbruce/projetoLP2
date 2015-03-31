package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ator;
import com.br.lp2.model.ConnectionFactory.ConnectionFactory;
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
public class AtorDAOConcreto implements AtorDAO {

    Connection connection;
    ResultSet rs;
    PreparedStatement ps;

    public AtorDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertAtor(Ator a) {
        String sql = "INSERT INTO ator (nome, nacionalidade, nascimento) "
                + "VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNacionalidade());
            ps.setDate(3, (Date) a.getNascimento());
            if (ps.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * Faz a consulta de todos os atores cadastrados sem critério de pesquisa.
     *
     * @return ArrayList com os objetos do tipo Ator cadastrados
     */
    @Override
    public ArrayList<Ator> readAtors() {
        String sql = "SELECT * FROM ator";
        ArrayList<Ator> atores = new ArrayList<>();

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                atores.add(new Ator(rs.getString("nome"),
                        rs.getString("nacionalidade"), rs.getDate("nascimento")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return atores;
    }

    /**
     * Faz a consulta de um ator cadastrado através de seu ID.
     *
     * @param id
     * @return Um objeto ator com o id passado, ou null se o id for inválido.
     */
    @Override
    public Ator readAtorById(int id) {
        String sql = "SELECT * FROM ator WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ator(rs.getString("nome"), rs.getString("nacionalidade"),
                    rs.getDate("nascimento"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Faz a consulta de um ator cadastrado através de seu nome.
     *
     * @param nome
     * @return Um objeto ator com o nome passado, ou null se o nome for
     * inválido.
     */
    @Override
    public Ator readAtorByNome(String nome) {
        String sql = "SELECT * FROM ator WHERE nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next(); //Posiciona o 'cursor' para a primeira posição valida da consulta
            return new Ator(rs.getString("nome"), rs.getString("nacionalidade"),
                    rs.getDate("nascimento"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Atualiza um ator já cadastrado
     *
     * @param id O ID do ator a ser atualizado
     * @param a Um ator com as novas informações
     * @return true se a atualização for executada com sucesso. false caso
     * contrário.
     */
    @Override
    public boolean updateAtor(int id, Ator a) {
        String sql = "UPDATE ator SET nome = ?, nacionalidade = ?, "
                + "nascimento = ? WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNacionalidade());
            ps.setDate(3, (Date) a.getNascimento()); //Deve-se fazer o cast para java.sql.Date
            ps.setInt(4, id);
            if(ps.executeUpdate() != 0) { //Verifica se foi atualizado
                return true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;        
    }

    /**
     * Apaga um ator já cadastrado, através de seu ID.
     * @param id
     * @return true se deletado com sucesso, false caso contrário.
     */
    @Override
    public boolean deleteAtor(int id) {
        String sql = "DELETE FROM ator WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Apaga um ator já cadastrado, através de um objeto ator.
     * @param a O ator a ser apagado
     * @return true se deletado com sucesso, false caso contrário.
     */
    @Override
    public boolean deleteAtor(Ator a) {
        String sql = "DELETE FROM ator WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getId());
            if(ps.execute()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;        
    }
}
