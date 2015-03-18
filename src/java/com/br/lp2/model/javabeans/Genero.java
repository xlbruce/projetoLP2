/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

public class Genero  {
    
    private transient int px;
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }
    
    /**
     * Cria uma instancia com chave primária.
     * @param px
     * @param nome 
     */
    public Genero(int px, String nome) {
        this.px = px;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "px=" + px + ", nome=" + nome + '}';
    }
    
}
