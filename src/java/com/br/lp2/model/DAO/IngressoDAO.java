package com.br.lp2.model.DAO;

import com.br.lp2.model.Ingresso;
import com.br.lp2.model.javabeans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IngressoDAO {


     //CRUD
    //C - Create
    
    public boolean insertIngresso(Ingresso d);
    public boolean insertIngresso(int numero, boolean inteira, Cliente.Especiais tipo);
    
    //R - Read
    public ArrayList<Ingresso> readIngressos();
    public Ingresso readIngressoByPk(int pk);
    public Ingresso readIngressoByNum(int num);
    public Ingresso readIngressoByInteira(Boolean inteira);
    public Ingresso readIngressoByTipo(Cliente.Especiais tipo);
    
    //U - Update
    public boolean updateIngresso(int id, Ingresso d);
    
    //D - Delete
    public boolean deleteIngresso(int id);
    public boolean deleteIngresso(Ingresso d);
    
}




