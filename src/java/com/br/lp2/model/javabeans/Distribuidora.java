package com.br.lp2.model.javabeans;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Distribuidora  {
    private int pk;
    private String nome;

    public Distribuidora(int pk, String nome) {
        this.pk = pk;
        this.nome = nome;
    }

    public int getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Distribuidora{" + "pk=" + pk + ", nome=" + nome + '}';
    }
    
}

