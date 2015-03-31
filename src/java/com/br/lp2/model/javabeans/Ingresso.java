package com.br.lp2.model.javabeans;

import com.br.lp2.model.javabeans.Cliente;
import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Ingresso implements Serializable {

    private int id;
    private int numero;
    private boolean inteira;
    private Cliente.Especiais tipo;

    /**
     *
     * @param id Primary key
     * @param numero Número do ingresso
     * @param inteira true, se o ingresso é meia entrada, false, caso contrário
     * @param tipo Tipo de ingresso vendido
     */
    public Ingresso(int id, int numero, boolean inteira, Cliente.Especiais tipo) {
        this.id = id;
        this.numero = numero;
        this.inteira = inteira;
        this.tipo = tipo;
    }

    /**
     *
     * @param id Primary key
     * @param numero Número do ingresso
     * @param inteira true, se o ingresso é meia entrada, false, caso contrário
     */
    public Ingresso(int id, int numero, boolean inteira) {
        this.id = id;
        this.numero = numero;
        this.inteira = inteira;
        this.tipo = Cliente.Especiais.GERAL;
    }


    public Ingresso(int id, int num) {
        this.id = id;
        this.numero = num;
        this.inteira = true;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isInteira() {
        return inteira;
    }

    public Cliente.Especiais getTipo() {
        return tipo;
    }

    public boolean compara(Ingresso ingresso) {
        return (this.id == ingresso.getId() && this.numero == ingresso.getNumero() && this.inteira == ingresso.isInteira() && this.tipo == ingresso.getTipo());
    }

    @Override
    public String toString() {
        return "Ingresso{" + "id=" + id + ", numero=" + numero + ", inteira=" + inteira + ", tipo=" + tipo + '}';
    }
}
