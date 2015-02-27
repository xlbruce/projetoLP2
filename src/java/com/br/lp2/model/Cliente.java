/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Cliente implements Serializable{
    private int pk;
    private String nome;
    private int nascimento;
    private Especiais tipo;

    public int getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    public Especiais getTipo() {
        return tipo;
    }
    
    public enum Especiais {
        CADEIRANTE, OBESO, GERAL
    };

    
    public Cliente(int pk, String nome, int nascimento, Especiais tipo) {
        this.pk = pk;
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }

    public Cliente(int pk, String nome, int nascimento) {
        this.pk = pk;
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = Especiais.GERAL;
    }

    @Override
    public String toString() {
        return "Cliente{" + "pk=" + pk + ", nome=" + nome + ", nascimento=" + nascimento + ", tipo=" + tipo + '}';
    }
    
    
    
    
}
