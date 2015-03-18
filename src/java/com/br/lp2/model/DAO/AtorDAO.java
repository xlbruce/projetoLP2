/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;
import java.util.ArrayList;
import com.br.lp2.model.Ator;
/**
 *
 * @author User
 */
public interface AtorDAO {
     //CRUD
    //C - Create    
    public boolean insertAtor(Ator a);
    
    //R - Read
    public ArrayList<Ator> readAtors();
    public Ator readAtorById(int id);
    public Ator readAtorByNome(String nome);
    
    //U - Update
    public boolean updateAtor(int id, Ator a);
    
    //D - Delete
    public boolean deleteAtor(int id);
    public boolean deleteAtor(Ator a);
    
}
