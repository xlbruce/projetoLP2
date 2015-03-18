/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.SalaDeProjecao;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface SalaDeProjecaoDAO {


     //CRUD
    //C - Create
    
    public boolean insertSalaDeProjecao(SalaDeProjecao d);
    
    //R - Read
    public ArrayList<SalaDeProjecao> readSalaDeProjecaos();
    public SalaDeProjecao readSalaDeProjecaoById(int id);
    public SalaDeProjecao readSalaDeProjecaoByNome(String nome);
    
    //U - Update
    public boolean updateSalaDeProjecao(int id, SalaDeProjecao d);
    
    //D - Delete
    public boolean deleteSalaDeProjecao(int id);
    public boolean deleteSalaDeProjecao(SalaDeProjecao d);
    
}




