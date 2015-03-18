/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.Sessao;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface SessaoDAO {


     //CRUD
    //C - Create
    
    public boolean insertSessao(Sessao d);
    
    //R - Read
    public ArrayList<Sessao> readSessaos();
    public Sessao readSessaoById(int id);
    public Sessao readSessaoByNome(String nome);
    
    //U - Update
    public boolean updateSessao(int id, Sessao d);
    
    //D - Delete
    public boolean deleteSessao(int id);
    public boolean deleteSessao(Sessao d);
    
}




