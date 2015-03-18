/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;


public class InfoAtor {
 

    private com.br.lp2.model.Ator ator;
    private String papel, part;
    
    /**
     * 
     * @param ator Ator
     * @param papel Personagem representado
     * @param part Participação no filme (coadjuvante, principal ou figurante)
     */
    public InfoAtor(com.br.lp2.model.Ator ator, String papel, String part) {
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

    @Override
    public String toString() {
        return "InfoAtor{" + "ator=" + ator + ", papel=" + papel + ", part=" + part + '}';
    }
}
  

