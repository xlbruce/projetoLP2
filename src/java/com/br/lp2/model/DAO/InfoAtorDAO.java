/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.InfoAtor;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface InfoAtorDAO {


     //CRUD
    //C - Create
    
    public boolean insertInfoAtor(InfoAtor i);
    
    //R - Read
    public ArrayList<InfoAtor> readInfoAtors();
    public InfoAtor readInfoAtorById(int id);
    public InfoAtor readInfoAtorByNome(String nome);
    
    //U - Update
    public boolean updateInfoAtor(int id, InfoAtor i);
    
    //D - Delete
    public boolean deleteInfoAtor(int id);
    public boolean deleteInfoAtor(InfoAtor i);
    
}




