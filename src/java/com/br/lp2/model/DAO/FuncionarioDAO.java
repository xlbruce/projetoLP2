package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author AndreLucas
 * @version 1.0
 */

public interface FuncionarioDAO {
    //CRUD
    //C - Create
    
    public boolean insertFuncionario (Funcionario f);
    public boolean insertFuncionario (String nome, String rg, int id_cargo, int id_departamento);
    
    //R - Read
    public ArrayList <Funcionario> readFuncionarios();
    public Funcionario readFuncionario(Funcionario f);
    public Funcionario readFuncionarioById (int codigo);
    public Funcionario readFuncionarioByRg (String rg); 
    
    //U - Update
    public boolean updateFuncionario (int codigo, Funcionario f);
    
    //D - Delete
    public boolean deleteFuncionario(Funcionario f);
    public boolean deleteFuncionarioById (int codigo);
    public boolean deleteFuncionarioByRg (String rg); 
}
