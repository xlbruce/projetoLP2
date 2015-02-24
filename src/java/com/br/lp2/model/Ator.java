/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bruce
 * @version 1.0
 */
public class Ator implements Serializable {

    private String nome, nacionalidade;
    private Date nascimento;

    /**
     * Instancia um objeto ator sem sua data de nascimento
     *
     * @param nome
     * @param nacionalidade
     */
    public Ator(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    /**
     * Instancia um objeto ator
     * @param nome
     * @param nacionalidade
     * @param nascimento
     */
    public Ator(String nome, String nacionalidade, Date nascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Date getNascimento() {
        return nascimento;
    }

    @Override
    public String toString() {
        return "Ator{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", nascimento=" + nascimento + '}';
    }
    
    
    

}
