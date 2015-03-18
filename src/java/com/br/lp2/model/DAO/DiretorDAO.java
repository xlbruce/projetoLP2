/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Diretor;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface DiretorDAO {
   
     //CRUD
    //C - Create
    
    public boolean insertDiretor(Diretor d);
    public boolean insertDiretor(String nome);
    
    //R - Read
    public ArrayList<Diretor> readDiretor();
    public Diretor readDiretorById(int id);
    public Diretor readDiretorByNome(String nome);
    
    //U - Update
    public boolean updateDiretor(int id, Diretor d);
    
    //D - Delete
    public boolean deleteDiretor(int id);
    public boolean deleteDiretor(Diretor d);
    
}


