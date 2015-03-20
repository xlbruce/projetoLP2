package com.br.lp2.model;

import com.br.lp2.model.javabeans.Cliente;
import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Ingresso implements Serializable {

    private int pk;
    private int id;
    private boolean inteira;
    private Cliente.Especiais tipo;

    /**
     *
     * @param pk Primary key
     * @param id Número do ingresso
     * @param inteira true, se o ingresso é meia entrada, false, caso contrário
     * @param tipo Tipo de ingresso vendido
     */
    public Ingresso(int pk, int id, boolean inteira, Cliente.Especiais tipo) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = tipo;
    }

    /**
     *
     * @param pk Primary key
     * @param id Número do ingresso
     * @param inteira true, se o ingresso é meia entrada, false, caso contrário
     */
    public Ingresso(int pk, int id, boolean inteira) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public Ingresso(int pk, int id) {
        this.pk = pk;
        this.id = id;
        this.inteira = true;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public int getPk() {
        return pk;
    }

    public int getId() {
        return id;
    }

    public boolean isInteira() {
        return inteira;
    }

    public Cliente.Especiais getTipo() {
        return tipo;
    }

    public boolean compara(Ingresso ingresso) {
        return (this.pk == ingresso.getPk() && this.id == ingresso.getId() && this.inteira == ingresso.isInteira() && this.tipo == ingresso.getTipo());
    }

    @Override
    public String toString() {
        return "Ingresso{" + "pk=" + pk + ", id=" + id + ", inteira=" + inteira + ", tipo=" + tipo + '}';
    }
}
