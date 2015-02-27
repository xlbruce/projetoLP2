/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.1
 */
public class Filme implements Serializable {
    
    private String titulo, situacao, idioma;
    private ListaDeAtores listaAtores;
    private Distribuidora distribuidora;
    private Diretor diretor;
    private int classificacao;
    private int ano, pk, duracao;
    private boolean legenda;
    
    // Esta enum representa as possiveis situações em que um filme pode se encontrar
    public enum TiposSituacao {
        CARTAZ, ESTREIA, LANCAMENTO
    }
    
    public Filme(int pk, String titulo, String situacao, String idioma, ListaDeAtores listaAtores, Distribuidora distribuidora, Diretor diretor, int classificacao, int ano, int duracao, boolean legenda) {
        this.titulo = titulo;
        this.situacao = situacao;
        this.idioma = idioma;
        this.listaAtores = listaAtores;
        this.distribuidora = distribuidora;
        this.diretor = diretor;
        this.classificacao = classificacao;
        this.ano = ano;
        this.pk = pk;
        this.duracao = duracao;
        this.legenda = legenda;
    }  

    //Getters e Setters
    
    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the listaAtores
     */
    public ListaDeAtores getListaAtores() {
        return listaAtores;
    }

    /**
     * @param listaAtores the listaAtores to set
     */
    public void setListaAtores(ListaDeAtores listaAtores) {
        this.listaAtores = listaAtores;
    }

    /**
     * @param distribuidora the distribuidora to set
     */
    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the classificacao
     */
    public int getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the pk
     */
    public int getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(int pk) {
        this.pk = pk;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the legenda
     */
    public boolean isLegenda() {
        return legenda;
    }

    /**
     * @param legenda the legenda to set
     */
    public void setLegenda(boolean legenda) {
        this.legenda = legenda;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public String getSituacao() {
        return situacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getCensura() {
        return getClassificacao();
    }
    //-- Fim dos Getters e Setters

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", situacao=" + situacao + ", idioma=" + idioma + ", listaAtores=" + listaAtores + ", distribuidora=" + distribuidora + ", diretor=" + diretor + ", classificacao=" + classificacao + ", ano=" + ano + ", pk=" + pk + ", duracao=" + duracao + ", legenda=" + legenda + '}';
    }

    
    
    
    
    
}
