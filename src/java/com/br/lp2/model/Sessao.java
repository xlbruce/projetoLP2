package com.br.lp2.model;

import com.br.lp2.model.javabeans.Filme;
import java.util.Date;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Sessao {
    private int pk;
    private SalaDeProjecao sala;
    private Filme filme;
    private Date diaHora;    
    private boolean legenda;
    private ListaIngresso listaIngresso;

    //Construtor
    public Sessao(int pk, SalaDeProjecao sala, Filme filme, Date diaHora, boolean legenda) {
        this.pk = pk;
        this.sala = sala;
        this.filme = filme;
        this.diaHora = diaHora;
        this.legenda = legenda;
        listaIngresso = new ListaIngresso();
    }
    
    //Getters e Setters
    public int getPk() {
        return pk;
    }

    public SalaDeProjecao getSala() {
        return sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public Date getDiaHora() {
        return diaHora;
    }
    
    public ListaIngresso getLista(){
        return listaIngresso;
    }

    public boolean isLegenda() {
        return legenda;
    }
    
    //Fim dos Getters e Setters

    //To String
    @Override
    public String toString() {
        return "Sessao{" + "pk=" + pk + ", sala=" + sala + ", filme=" + filme + ", diaHora=" + diaHora + ", legenda=" + legenda + ", listaIngresso=" + listaIngresso + '}';
    }
}
