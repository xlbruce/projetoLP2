package com.br.lp2.model.DAO;

import com.br.lp2.model.Ator;
import com.br.lp2.model.javabeans.InfoAtor;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface InfoAtorDAO {

     //CRUD
    //C - Create
    public boolean insertInfoAtor(InfoAtor i);

    //R - Read
    public ArrayList<InfoAtor> readInfoAtors();

    public InfoAtor readInfoAtorById(int id);

    public InfoAtor readInfoAtorByNome(String nome);

    public InfoAtor readInfoAtorByAtor(Ator ator);
    
    public InfoAtor readInfoAtorByPapel(String papel);
    
    public InfoAtor readInfoAtorByPart(String part);

    //U - Update
    public boolean updateInfoAtor(int id, InfoAtor i);

    //D - Delete
    public boolean deleteInfoAtor(int id);

    public boolean deleteInfoAtor(InfoAtor i);

}
