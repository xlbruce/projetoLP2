/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.ListaDeAtores;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ListaDeAtoresDAO {


     //CRUD
    //C - Create
    
    public boolean insertListaDeAtores(ListaDeAtores d);
    
    //R - Read
    public ArrayList<ListaDeAtores> readListaDeAtoress();
    public ListaDeAtores readListaDeAtoresById(int id);
    
    //U - Update
    public boolean updateListaDeAtores(int id, ListaDeAtores d);
    
    //D - Delete
    public boolean deleteListaDeAtores(int id);
    public boolean deleteListaDeAtores(ListaDeAtores d);
    
}
