package com.br.gilson.model.javabeans;

/**
 *
 * @author 31409695
 */
public class Funcionario {
    private int id;
    private String nome, rg;
    private int id_cargo, id_departamento;

    public Funcionario(int id, String nome, String rg, int id_cargo, int id_departamento) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.id_cargo = id_cargo;
        this.id_departamento = id_departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", id_cargo=" + id_cargo + ", id_departamento=" + id_departamento + '}';
    }
    
    
 
    
}
