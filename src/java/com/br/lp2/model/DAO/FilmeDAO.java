package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Filme;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface FilmeDAO {

     //CRUD
    //C - Create
    public boolean insertFilme(Filme d);

    //R - Read
    public ArrayList<Filme> readFilmes();

    public Filme readFilmeById(int id);

    public Filme readFilmeByNome(String nome);

    //U - Update
    public boolean updateFilme(int id, Filme d);

    //D - Delete
    public boolean deleteFilme(int id);

    public boolean deleteFilme(Filme d);

}
