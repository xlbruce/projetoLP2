package com.br.lp2.model;

import com.br.lp2.model.javabeans.Filme;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class ListaDeAtores implements Serializable {
    ArrayList<InfoAtor> atores;
    int pk;
    Filme filme;

   
    public ListaDeAtores(ArrayList<InfoAtor> atores, int pk,Filme filme) {
        this.atores = atores;
        this.pk = pk;
        this.filme = filme;
    }

    public int getPk() {
        return pk;
    }

    public Filme getFilme() {
        return filme;
    }

    
    public ArrayList<InfoAtor> getAtores() {
        return atores;
    }

    public void addAtor(Ator ator, String papel, String part) {
        atores.add(new InfoAtor(ator, papel, part));
    }    
    
    public void removeAtor(Ator ator) {
        for (InfoAtor infoAtor : atores) {
            if(ator.compara(infoAtor.getAtor()))
                atores.remove(infoAtor);
        }
    }
    
    /**
     * 
     * @param ator1 O ator a ser removido
     * @param ator2 O novo ator
     * @param papel Papel do novo ator
     * @param part  Participaão do novo ator
     */
    public void trocaAtor (Ator ator1, Ator ator2, String papel, String part) {
        removeAtor(ator1);
        addAtor(ator2, papel, part);
    }
    
    public boolean procuraAtor (Ator ator) {
        for (InfoAtor i : atores) {
            if(ator.compara(i.getAtor()))
                return true;
        }
        return false;
    }
    
    public ArrayList<InfoAtor> getLista() {
        return atores;
    }
    
    @Override
    public String toString() {
        String out = "Lista de atores:\n";
        for (InfoAtor i : atores)
            out += "\t" + i;
        return out;
    } 
}
