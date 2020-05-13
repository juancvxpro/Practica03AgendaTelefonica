/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.Scanner;

/**
 *
 * @author Juanc
 */
public class VistaUsuario {
    private Scanner leer;

    public VistaUsuario() {
        leer= new Scanner(System.in);
    }
    public Usuario registrarUsuario(){
        leer= new Scanner(System.in);
        System.out.println("Ingrese su cedula");
        String cedula=leer.next();
        System.out.println("Ingrese su nombre");
        String nombre=leer.next();
        System.out.println("Ingrese su apellido");
        String apellido=leer.next();
        System.out.println("Ingrese su correo");
        String correo=leer.next();
        System.out.println("Ingrese su contrasena");
        String contra=leer.next();
        return new Usuario (cedula,nombre,apellido,correo,contra);
    }
   public Usuario actualizarUsuario(){
       leer= new Scanner(System.in);
       System.out.println("Ingrese su cedula");
        String cedula=leer.next();
        System.out.println("Ingrese nuevo nombre");
        String nombre=leer.next();
        System.out.println("Ingrese nuevo apellido");
        String apellido=leer.next();
        System.out.println("Ingrese nuevo correo");
        String correo=leer.next();
        System.out.println("Ingrese nueva contresena");
        String contra=leer.next();
        return new Usuario (cedula,nombre,apellido,correo,contra);
   
   }
     public void verUsuario(Usuario usuario) {
        System.out.println("Datos del Cliente: " + usuario);
    }
   public Usuario eliminarUsuario(){
       leer= new Scanner(System.in);
       System.out.println("Ingrese su cedula");
       String cedula=leer.next();
        return new Usuario (cedula,null,null,null,null);
   }
     public String retornaCorreo (){
     leer= new Scanner(System.in);
         System.out.println("Ingrese su correo");
         String correo=leer.next();
         
        return correo;
    }
     
     public String retornaContra(){
         leer= new Scanner(System.in);
     System.out.println("Ingrese su contrasena");
         String contra=leer.next();
         return contra;
     }
     public void validarLogeo(Usuario usuario){
         
     if (usuario==null){
         System.out.println("Correo y contrasena incorrecta");
         System.out.println("Es posible que usted no se haya registrado aun");
     }
     
       
     }
     public boolean logeoUsuario(Usuario usuario){
         boolean log=false;
         if (usuario!=null){
             log=true;
         return log;
         }else {
         return log;
         }
     }
     public void verDatosUser(Usuario usuario){
         System.out.println(" Datos :"+usuario);
         
        
     }
}
