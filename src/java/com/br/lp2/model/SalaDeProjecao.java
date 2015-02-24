/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author bruce
 * @version 1.0
 */
public class SalaDeProjecao implements Serializable {
    private int numero;

    public SalaDeProjecao(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "SalaDeProjecao{" + "numero=" + numero + '}';
    }
    
}
