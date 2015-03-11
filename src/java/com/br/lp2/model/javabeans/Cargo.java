
package com.br.lp2.model.javabeans;

/**
 *
 * @author 31409695
 */
public class Cargo {
    private int id;
    private String nome;

    public Cargo(int id, String nome) {
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
        return "Cargo{" + "id=" + id + ", nome=" + nome + '}';
    }   
    
    
}
