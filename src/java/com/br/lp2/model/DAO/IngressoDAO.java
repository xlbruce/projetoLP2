/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ingresso;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IngressoDAO {

    //CRUD
    //C - Create
    public boolean insertIngresso(Ingresso d);
    
    //R - Read
    public ArrayList<Ingresso> readIngressos();

    public Ingresso readIngressoByInteira(Boolean inteira);
            
    public Ingresso readIngressoById(int id);

    //U - Update
    public boolean updateIngresso(int id, Ingresso d);

    //D - Delete
    public boolean deleteIngresso(int id);

    public boolean deleteIngresso(Ingresso d);

}
