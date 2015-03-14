package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Departamento;
import java.util.ArrayList;

/**
 *
 * @author 31409695
 * @version 1.0
 */
public interface DepartamentoDAO {
    //CRUD
    //C - Create
    public boolean insertDepartamento(Departamento d);
    public boolean insertDepartamento(String nome);
    
    //R - Read
    public ArrayList<Departamento> readDepartamentos();
    public Departamento readDepartamento(Departamento d);
    public Departamento readDepartamentoById(int codigo);
    
    //U - Update
    public boolean updateDepartamento(int codigo, Departamento d);
    
    //D - Delete
    public boolean deleteDepartamento(Departamento d);
    public boolean deleteDepartamentoById(int codigo);   
}

