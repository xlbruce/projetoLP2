package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Genero;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface GeneroDAO {

    //CRUD
    //C - Create
    public boolean insertGenero(Genero g);

    public boolean insertGenero(String nome);

    //R - Read
    public ArrayList<Genero> readGeneros();

    public Genero readGeneroById(int id);

    public Genero readGeneroByNome(String nome);

    //U - Update
    public boolean updateGenero(int id, Genero g);

    //D - Delete
    public boolean deleteGenero(int id);

    public boolean deleteGenero(Genero g);

}
