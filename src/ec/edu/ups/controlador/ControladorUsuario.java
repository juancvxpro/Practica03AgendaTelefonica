/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;

/**
 *
 * @author Juanc
 */
public class ControladorUsuario {
    //objetos vista
    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    //objetos modelo
    private Usuario usuario;
    private Telefono telefono;
    //objetos DAO
    private IUsuarioDao usuarioDao;
    private ITelefonoDao telefonoDao;
    //variables para logeoUsuario
    private boolean log;
    
    //constructor

    public ControladorUsuario(VistaUsuario vistaUsuario, VistaTelefono vistaTelefono,  IUsuarioDao usuarioDao, ITelefonoDao telefonoDao) {
        this.vistaUsuario = vistaUsuario;
        this.vistaTelefono = vistaTelefono;
        this.usuarioDao = usuarioDao;
        this.telefonoDao = telefonoDao;
    }

    
    //llama al Dao para registrar un usuario
    public void registrarUsuario(){
    usuario= vistaUsuario.registrarUsuario();
    usuarioDao.create(usuario);
    
    }
     
    public void ingresoUsuario(){
   String correo= vistaUsuario.retornaCorreo();
   String contra= vistaUsuario.retornaContra();
   usuario=usuarioDao.read(correo, contra);
   vistaUsuario.validarLogeo(usuario);
    log = vistaUsuario.logeoUsuario(usuario);
    vistaUsuario.verUsuario(usuario);
        
    }
    public void actualizarUsuario(){
    usuario=vistaUsuario.actualizarUsuario();
    usuarioDao.update(usuario);
    vistaUsuario.validarLogeo(usuario);
    }
    public void eliminarUsuario(){
    usuario=vistaUsuario.eliminarUsuario();
    usuarioDao.delete(usuario);
    }
    
    public void agregarTelefono(){
    int id = vistaTelefono.buscarTelefono();
    telefono=telefonoDao.read(id);
  
    usuario.agregarTelefono(telefono);
    usuarioDao.update(usuario);
    
    vistaTelefono.verTelefono(telefono);
    }
  
    public boolean isLog() {
        return log;
    }

    
    
}
