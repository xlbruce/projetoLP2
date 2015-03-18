/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Distribuidora;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface DistribuidoraDAO {


     //CRUD
    //C - Create
    
    public boolean insertDistribuidora(Distribuidora d);
    public boolean insertDistribuidora(String nome);
    
    //R - Read
    public ArrayList<Distribuidora> readDistribuidoras();
    public Distribuidora readDistribuidoraById(int id);
    public Distribuidora readDistribuidoraByNome(String nome);
    
    //U - Update
    public boolean updateDistribuidora(int id, Distribuidora d);
    
    //D - Delete
    public boolean deleteDistribuidora(int id);
    public boolean deleteDistribuidora(Distribuidora d);
    
}


