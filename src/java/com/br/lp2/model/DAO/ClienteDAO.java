/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;
import java.util.ArrayList;
import com.br.lp2.model.javabeans.Cliente;
/**
 *
 * @author User
 */
public interface ClienteDAO {
    //CRUD
    //C - Create
    public boolean insertCliente(ClienteDAO c);
    //R - Read
    public ArrayList<ClienteDAO> readCliente();
    public ClienteDAO readClienteById(int id);
    public ClienteDAO readClienteByNome(String nome);
    
    //U - Update
    public boolean updateCliente(int id, ClienteDAO c);
    
    //D - Delete
    public boolean deleteCliente(int id);
    public boolean deleteCliente(ClienteDAO c);
}
