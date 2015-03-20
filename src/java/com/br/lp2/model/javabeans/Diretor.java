package com.br.lp2.model.javabeans;

/**
 *
 * @author User
 */
public class Diretor {


    private String nome;
    private int pk;

    public Diretor(String nome, int pk) {
        this.nome = nome;
        this.pk = pk;
    }

    public String getNome() {
        return nome;
    }

    public int getPk() {
        return pk;
    }

    @Override
    public String toString() {
        return "Diretor{" + "nome=" + nome + ", pk=" + pk + '}';
    }
    
}
    

