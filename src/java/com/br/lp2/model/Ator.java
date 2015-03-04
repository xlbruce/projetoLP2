package com.br.lp2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class Ator implements Serializable {

    private String nome, nacionalidade;
    private Date nascimento;
    private int pk;

    /**
     * Instancia um objeto ator sem sua data de nascimento
     *
     * @param nome
     * @param nacionalidade
     */
    public Ator(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
    
    /**
     * Instancia um objeto ator com todos os seus atributos
     * @param nome
     * @param nacionalidade
     * @param nascimento
     * @param pk Primary key
     */
    public Ator(String nome, String nacionalidade, Date nascimento, int pk) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.nascimento = nascimento;
        this.pk = pk;
    }
    
    

    /**
     * Instancia um objeto ator
     *
     * @param nome
     * @param nacionalidade
     * @param nascimento
     */
    public Ator(String nome, String nacionalidade, Date nascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public int getPk() {
        return pk;
    }
    
    /**
     * Faz a comparação entre 2 atores
     * @param ator
     * @return <b>true</b>, se os 2 atores forem iguais, <b>false</b>, caso contrario.
     */
    public boolean compara(Ator ator) {
        return ator.getPk() == this.pk && ator.getNacionalidade().equalsIgnoreCase(this.nacionalidade)
                && ator.getNascimento().equals(this.nascimento) && ator.getNome().equalsIgnoreCase(this.nome);
    }    
    
    @Override
    public String toString() {
        return "Ator{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", nascimento=" + nascimento + '}';
    }

}
