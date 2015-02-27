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
public class SalaDeProjecao implements Serializable {
    private int pk, num, lotacao, poltEsp;
    private Estados estado;
    
    public enum Estados {
        MANUTENCAO, OCUPADA, LIVRE
    };

    /**
     * 
     * @param pk Primary key
     * @param num Número da sala 
     * @param lotacao Lotação da sala
     * @param poltEsp Número de poltronas especiais
     * @param estado Estado em que a sala se encontra(<b>Manutenção</b>, <b>Ocupada</b>, <b>Livre</b>)
     */
    public SalaDeProjecao(int pk, int num, int lotacao, int poltEsp, Estados estado) {
        this.pk = pk;
        this.num = num;
        this.lotacao = lotacao;
        this.poltEsp = poltEsp;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "SalaDeProjecao{" + "numero=" + pk + '}';
    }
    
}
