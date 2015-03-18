/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.ListaIngresso;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ListaIngressoDAO {


     //CRUD
    //C - Create
    
    public boolean insertListaIngresso(ListaIngresso d);
    
    //R - Read
    public ArrayList<ListaIngresso> readListaIngressos();
    public ListaIngresso readListaIngressoById(int id);
    public ListaIngresso readListaIngressoByNome(String nome);
    
    //U - Update
    public boolean updateListaIngresso(int id, ListaIngresso d);
    
    //D - Delete
    public boolean deleteListaIngresso(int id);
    public boolean deleteListaIngresso(ListaIngresso d);
    
}




