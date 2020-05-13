/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.idao.ITelefonoDao;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class ControladorTelefono {
    //objetos vista
    private VistaTelefono vistaTelefono;
    private Telefono telefono;
    private ITelefonoDao telefonoDao;
    //constructor

    public ControladorTelefono(VistaTelefono vistaTelefono,  TelefonoDao telefonoDao) {
        this.vistaTelefono = vistaTelefono;
        this.telefonoDao = telefonoDao;
    }
     public void registrarTelefono(){
     telefono=vistaTelefono.registrarTelefono();
     telefonoDao.create(telefono);
   
     }
    public void verTelefono(){
    int id=vistaTelefono.buscarTelefono();
    telefono=telefonoDao.read(id);
    vistaTelefono.verTelefono(telefono);
    vistaTelefono.validarRegistro(telefono);
    
    }
    public void actualizarTelefono(){
    telefono=vistaTelefono.actualizarTelefono();
    telefonoDao.update(telefono);
    vistaTelefono.validarRegistro(telefono);
    vistaTelefono.verTelefono(telefono);
    
    }
    
    public void eliminarTelefono(){
    telefono=vistaTelefono.eliminarTelefono();
    telefonoDao.delete(telefono);
    vistaTelefono.validarRegistro(telefono);
    }
   
    public void verTelefonos(){
        List<Telefono> telefonos;
        telefonos=telefonoDao.findAll();
        vistaTelefono.verTelefonos(telefonos);
    }
}
