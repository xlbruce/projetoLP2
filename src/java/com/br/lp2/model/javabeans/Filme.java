package com.br.lp2.model.javabeans;

import com.br.lp2.model.ListaDeAtores;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author Gilson da Silva
 * @version 1.1
 */
public class Filme implements Serializable {
    
    private String titulo, idioma, sinopse;
    private TipoSituacao situacao;
    private ListaDeAtores listaAtores;
    private Distribuidora distribuidora;
    private Diretor diretor;
    private int classificacao;
    private int ano, id, duracao;
    
    // Esta enum representa as possiveis situações em que um filme pode se encontrar
    public enum TipoSituacao {
        CARTAZ, ESTREIA, LANCAMENTO
    }
    
    public Filme(int pk, String titulo, TipoSituacao situacao, String idioma,
            String sinopse, ListaDeAtores listaAtores, Distribuidora distribuidora, 
            Diretor diretor, int classificacao, int ano, int duracao) {
        this.titulo = titulo;
        this.situacao = situacao;
        this.idioma = idioma;
        this.sinopse = sinopse;
        this.listaAtores = listaAtores;
        this.distribuidora = distribuidora;
        this.diretor = diretor;
        this.classificacao = classificacao;
        this.ano = ano;
        this.id = pk;
        this.duracao = duracao;
    }  

    //Getters e Setters

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(TipoSituacao situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the listaAtores
     */
    public ListaDeAtores getListaAtores() {
        return listaAtores;
    }

    /**
     * @param listaAtores the listaAtores to set
     */
    public void setListaAtores(ListaDeAtores listaAtores) {
        this.listaAtores = listaAtores;
    }

    /**
     * @param distribuidora the distribuidora to set
     */
    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the classificacao
     */
    public int getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }   

    public String getTitulo() {
        return titulo;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public TipoSituacao getSituacao() {
        return situacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getCensura() {
        return getClassificacao();
    }
    //-- Fim dos Getters e Setters

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", idioma=" + idioma + ", situacao=" + situacao + ", listaAtores=" + listaAtores + ", distribuidora=" + distribuidora + ", diretor=" + diretor + ", classificacao=" + classificacao + ", ano=" + ano + ", pk=" + id + ", duracao=" + duracao + '}';
    }    
}
