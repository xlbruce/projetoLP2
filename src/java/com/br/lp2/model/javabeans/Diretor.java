/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

/**
 *
 * @author User
 */
public class Diretor {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    

