package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Antonio Nunes
 * @version 1.0
 */
public interface ClienteDAO {

    //CRUD
    //C - Create

    public boolean insertCliente(Cliente c);

    //R - Read

    public ArrayList<Cliente> readClientes();

    public Cliente readClienteById(int id);

    public Cliente readClienteByNome(String nome);

    //U - Update
    public boolean updateCliente(int id, Cliente c);

    //D - Delete
    public boolean deleteCliente(int id);

    public boolean deleteCliente(Cliente c);
}
