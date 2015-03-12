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
    
    //R - Read
    public ArrayList <Funcionario> readFuncionario();
    public Funcionario readFuncionario(Funcionario f);
    public Funcionario readFuncionario (int codigo);
    public Funcionario readFuncionario (String rg); 
    
    //U - Update
    public boolean updateFuncionario (int codigo, Funcionario f);
    
    //D - Delete
    public boolean deleteFuncionario(Funcionario f);
    public boolean deleteFuncionario (int codigo);
    public boolean deleteFuncionario (String rg); 
}
