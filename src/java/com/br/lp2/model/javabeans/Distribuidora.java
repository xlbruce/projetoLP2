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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

