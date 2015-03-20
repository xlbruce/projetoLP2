package com.br.lp2.model.javabeans;

import java.util.Date;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Cliente {

    private int pk;
    private String nome;
    private Date nascimento;
    private Especiais tipo;

    public enum Especiais {

        CADEIRANTE, OBESO, GERAL
    };

    public Cliente(int pk, String nome, Date nascimento, Especiais tipo) {
        this.pk = pk;
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }

    public Cliente(int pk, String nome, Date nascimento) {
        this.pk = pk;
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = Especiais.GERAL;
    }

    public int getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Especiais getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "pk=" + pk + ", nome=" + nome + ", nascimento=" + nascimento + ", tipo=" + tipo + '}';
    }
}
