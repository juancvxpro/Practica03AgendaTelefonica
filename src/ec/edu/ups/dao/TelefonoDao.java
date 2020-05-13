/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class TelefonoDao implements ITelefonoDao {
    
    private  List <Telefono> listaTelefonos;

    public TelefonoDao() {
        listaTelefonos= new ArrayList<>();
    }
    
    @Override
    public void create(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    @Override
    public Telefono read(int id) {
          for (Telefono telefono : listaTelefonos) {
            if (telefono.getId()==id) {
                return telefono;
            }
        }
        return null;
        
    }

    @Override
    public void update(Telefono telefono) {
          for (int i = 0; i < listaTelefonos.size(); i++) {
            Telefono t= listaTelefonos.get(i);
            if (t.getId()==telefono.getId()) {
                listaTelefonos.set(i, telefono);
                break;
            }
        }
    }

    @Override
    public void delete(Telefono telefono) {
          Iterator<Telefono> it = listaTelefonos.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getId()==telefono.getId()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Telefono> findAll() {
        return listaTelefonos;
        
    }
    
}
