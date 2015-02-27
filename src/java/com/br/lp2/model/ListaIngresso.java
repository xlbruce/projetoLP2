package com.br.lp2.model;

import java.util.ArrayList;

/**
 *
 * @author 31409695
 * @version 1.0
 */
public class ListaIngresso {
    private int pk;
    private ArrayList<Ingresso> lista;
    
    public ListaIngresso(){
        lista=new ArrayList<Ingresso>();
    }
    
    public void addIngresso(Ingresso ingresso){
        lista.add(ingresso);
    }
    
    public void removeIngresso(Ingresso ingresso){
        for(Ingresso i:lista){
            if(i.compara(ingresso)){
                lista.remove(i);
            }
        }
    }
    
    public void trocaIngresso(Ingresso i1, Ingresso i2){
        removeIngresso(i1);
        addIngresso(i2);
    }
    
    public ArrayList <Ingresso> getLista(){
        return lista;
    }
}