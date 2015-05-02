package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ator;
import com.br.lp2.model.ListaDeAtores;
import com.br.lp2.model.javabeans.Filme;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ListaDeAtoresDAO {

    //CRUD
    //C - Create    
    public boolean insertListaDeAtores(Ator a, Filme f);

    //R - Read
    public ListaDeAtores readListaDeAtoresByFilme(Filme f);

    public ArrayList<Filme> readFilmeByAtor(Ator a);

    //U - Update
    //Deixarei em branco por enquanto
    
    //D - Delete
    public boolean deleteListaDeAtores(int id);

    /**
     * Remove um Ator da Lista de Atores de um dado Filme.
     * @param f O Filme em questão
     * @param a O Ator a ser apagado
     * @return 
     */
    public boolean deleteAtorByFilme(Filme f, Ator a);

    /**
     * Remove todos os registros relacionados ao Filme da tabela "listadeatores".
     * Deve ser usado quando um Filme for apagado do sistema.
     * @param f Filme
     * @return 
     */
    public boolean deleteFilme(Filme f);

}
