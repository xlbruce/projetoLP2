package com.br.lp2.model.javabeans;

/**
 *
 * @author 31409695
 */
public class Departamento {
    private int id;
    private String nome;

    public Departamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
