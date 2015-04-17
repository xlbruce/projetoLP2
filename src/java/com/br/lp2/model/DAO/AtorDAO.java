package com.br.lp2.model.DAO;

import java.util.ArrayList;
import com.br.lp2.model.Ator;

/**
 *
 * @author Antonio Nunes
 * @version 1.0
 */
public interface AtorDAO {

    //CRUD
    //C - Create    

    public boolean insertAtor(Ator a);

    //R - Read
    public ArrayList<Ator> readAtors();

    public Ator readAtorById(int id);

    public Ator readAtorByNome(String nome);

    //U - Update
    public boolean updateAtor(int id, Ator a);

    //D - Delete
    public boolean deleteAtor(int id);

    public boolean deleteAtor(Ator a);

}
