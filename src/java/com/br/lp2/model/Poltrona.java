package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Poltrona implements Serializable {
    private boolean ocupada;
    private Tipo tipo;
    
    public enum Tipo {
        ESPECIAL, COMUM
    }

    public Poltrona(boolean ocupada, Tipo tipo) {
        this.ocupada = ocupada;
        this.tipo = tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Poltrona{" + "ocupada=" + ocupada + ", tipo=" + tipo + '}';
    }
}
