package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Genero implements Serializable {
    
    private transient int id;
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }
    
    /**
     * Cria uma instancia com chave primária.
     * @param id
     * @param nome 
     */
    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "px=" + id + ", nome=" + nome + '}';
    }
    
}
