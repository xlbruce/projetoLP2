package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Cargo;
import java.util.ArrayList;

/**
 *
 * @author 31409695
 * @version 1.0
 */
public interface CargoDAO {
    //CRUD
    //C - Create
    public boolean insertCargo(Cargo c);
    
    //R - Read
    public ArrayList<Cargo> readCargos();
    public Cargo readCargoById(int id);
    public Cargo readCargoByNome(String nome);
    
    //U - Update
    public boolean updateCargo(int id, Cargo c);
    
    //D - Delete
    public boolean deleteCargo(int id);
    public boolean deleteCargo(Cargo c);
    
}
