/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author bruce
 * @version 1.0
 */
public class Filme implements Serializable {
    /* Deixei os atributos "diretor" e "distribuidora" pois não acho que valha
     * a pena criar classes para tal, pois não é necessário guardar informações
     * sobre esses campos.
    */
    private String titulo, diretor, distribuidora, situacao;
    float duracao;
    int censura;
    
    
    // Esta enum representa as possiveis situações em que um filme pode se encontrar
    private enum TiposSituacao {
        CARTAZ, ESTREIA, LANCAMENTO
    }    

    public Filme(String titulo, String diretor, String distribuidora, String situacao, float duracao, int censura) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.distribuidora = distribuidora;
        this.situacao = situacao;
        this.duracao = duracao;
        this.censura = censura;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public String getSituacao() {
        return situacao;
    }

    public float getDuracao() {
        return duracao;
    }

    public int getCensura() {
        return censura;
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", diretor=" + diretor + ", distribuidora=" + distribuidora + ", situacao=" + situacao + ", duracao=" + duracao + ", censura=" + censura + '}';
    }
    
    
    
    
}
