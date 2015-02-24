/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author bruce
 */
public class ListaDeAtores implements Serializable {
    ArrayList<Ator> atores;

    public ListaDeAtores() {
        atores = new ArrayList<>();
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    @Override
    public String toString() {
        String out = "Lista de atores:\n";
        for (Ator i : atores)
            out += "\t" + i;
        return out;
    }
    
}
