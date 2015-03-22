/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

import com.br.lp2.model.Ator;


public class InfoAtor {
 

    private com.br.lp2.model.Ator ator;
    private String papel, part;
    private int pk;
    
    /**
     * 
     * @param ator Ator
     * @param papel Personagem representado
     * @param part Participação no filme (coadjuvante, principal ou figurante)
     */
    public InfoAtor(int pk, Ator ator, String papel, String part) {
        this.pk = pk;
        this.ator = ator;
        this.papel = papel;
        this.part = part;
    }

    public com.br.lp2.model.Ator getAtor() {
        return ator;
    }

    public String getPapel() {
        return papel;
    }

    public String getPart() {
        return part;
    }
    
    public int getPk(){
        return pk;
    }

    @Override
    public String toString() {
        return "InfoAtor{" + "ator=" + ator + ", papel=" + papel + ", part=" + part + '}';
    }
}
  

