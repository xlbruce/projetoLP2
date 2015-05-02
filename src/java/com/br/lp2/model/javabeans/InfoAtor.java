package com.br.lp2.model.javabeans;

import com.br.lp2.model.javabeans.Ator;


public class InfoAtor {
 
    private int id;
    private Ator ator;
    private String papel, part;
    
    /**
     * 
     * @param ator Ator
     * @param papel Personagem representado
     * @param part Participação no filme (coadjuvante, principal ou figurante)
     */
    public InfoAtor(Ator ator, String papel, String part) {
        this.ator = ator;
        this.papel = papel;
        this.part = part;
        this.id = 0;
    }

    /**
     * 
     * @param id
     * @param ator
     * @param papel
     * @param part 
     */
    public InfoAtor(int id, Ator ator, String papel, String part) {
        this.id = id;
        this.ator = ator;
        this.papel = papel;
        this.part = part;
    }

    public int getId() {
        return id;
    }    
    
    public Ator getAtor() {
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
        return "InfoAtor{" + "id=" + id + ", ator=" + ator + ", papel=" + papel + ", part=" + part + '}';
    }    
}
  

