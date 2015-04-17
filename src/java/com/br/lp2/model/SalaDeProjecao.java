package com.br.lp2.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class SalaDeProjecao implements Serializable {

    private int pk, num;
    private ArrayList<Poltrona> poltronas;
    private Estados estado;

    public enum Estados {
        MANUTENCAO, OCUPADA, LIVRE
    };

    /**
     *
     * @param pk Primary key
     * @param num Número da sala
     * @param poltronas As poltronas da Sala de Projeção
     * @param estado Estado em que a sala se encontra(<b>Manutenção</b>,
     * <b>Ocupada</b>, <b>Livre</b>)
     */
    public SalaDeProjecao(int pk, int num, ArrayList<Poltrona> poltronas, Estados estado) {
        this.pk = pk;
        this.num = num;
        this.poltronas = poltronas;
        this.estado = estado;
    }

    public int getPk() {
        return pk;
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Poltrona> getPoltronas() {
        return poltronas;
    }

    public Estados getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "SalaDeProjecao{" + "pk=" + pk + ", num=" + num + ", poltronas=" + poltronas + ", estado=" + estado + '}';
    }
    
}
