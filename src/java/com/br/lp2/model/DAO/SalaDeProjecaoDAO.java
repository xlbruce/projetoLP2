package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.SalaDeProjecao;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface SalaDeProjecaoDAO {


     //CRUD
    //C - Create
    
    public boolean insertSalaDeProjecao(SalaDeProjecao d);
    
    //R - Read
    public ArrayList<SalaDeProjecao> readSalaDeProjecoes();
    public SalaDeProjecao readSalaDeProjecaoById(int id);
    public SalaDeProjecao readSalaDeProjecaoByNum(int num);
    
    //U - Update
    public boolean updateSalaDeProjecao(int id, SalaDeProjecao d);
    
    //D - Delete
    public boolean deleteSalaDeProjecao(int id);
    public boolean deleteSalaDeProjecao(SalaDeProjecao d);
    
}




