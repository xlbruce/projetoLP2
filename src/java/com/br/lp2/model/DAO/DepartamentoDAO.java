package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Departamento;
import java.util.ArrayList;

/**
 *
 * @author 31409695
 */
public interface DepartamentoDAO {
    //CRUD
    //C - Create
    public boolean insertDepartamento(Departamento d);
    
    //R - Read
    public ArrayList<Departamento> readDepartamentos();
    public Departamento readDepartamento(Departamento d);
    public Departamento readDepartamento(int codigo);
    
    //U - Update
    public boolean updateDepartamento(int codigo, Departamento d);
    
    //D - Delete
    public boolean deleteDepartamento(int codigo);
    public boolean deleteDepartamento(Departamento d);
    
}
