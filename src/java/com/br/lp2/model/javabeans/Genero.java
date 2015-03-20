package com.br.lp2.model.javabeans;

public class Genero  {
    
    private transient int pk;
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }
    
    /**
     * Cria uma instancia com chave primária.
     * @param pk Primary Key
     * @param nome 
     */
    public Genero(int pk, String nome) {
        this.pk = pk;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "px=" + pk + ", nome=" + nome + '}';
    }
    
}
