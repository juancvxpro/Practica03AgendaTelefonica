/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Juanc
 */
public class Prueba {

    public static void main(String[] args) {
        //Entrada de datos para menu
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        // vista
        VistaUsuario vistaU = new VistaUsuario();
        VistaTelefono vistaT = new VistaTelefono();
        //Daos
        UsuarioDao usuarioDao = new UsuarioDao();
        TelefonoDao telefonoDao = new TelefonoDao();
        //  Controlador
        ControladorUsuario controlUsuario = new ControladorUsuario(vistaU, vistaT, usuarioDao, telefonoDao);
        ControladorTelefono controlTelefono = new ControladorTelefono(vistaT, telefonoDao);

        int opcion; //Guardaremos la opcion del usuario
        //Se crea menu
        while (!salir) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Agenda Telefonica ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

            System.out.println("1. Registrarse ");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Salir");
            try {// Si exixte un error o se ingreso mal un dato regresa al menu
                System.out.println("Escribe una de las opciones");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        controlUsuario.registrarUsuario();
                        break;
                    case 2:
                        boolean log,
                         out = false;
                        controlUsuario.ingresoUsuario();
                        log = controlUsuario.isLog();
                        if (log == true) {
                            System.out.println("Inicio de sesion existoso");
                            while (!out) {
                                System.out.println("1. Actualizar Datos Personales");
                                System.out.println("2. Registrar Telefono");
                                System.out.println("3. Actualizar Telefono");
                                System.out.println("4. Buscar Telefono");
                                System.out.println("5. Listar Telefonos");
                                System.out.println("6. Eliminar Telefono");
                                System.out.println("7. Eliminar Cuenta");
                                System.out.println("8. Cerrar Sesion");
                                try {// Si exixte un error o se ingreso mal un dato regresa al menu
                                    System.out.println("Escribe una de las opciones");
                                    int op = entrada.nextInt();
                                    switch (op) {
                                        case 1:
                                            controlUsuario.actualizarUsuario();
                                            break;
                                        case 2:
                                            controlTelefono.registrarTelefono();
                                            controlUsuario.agregarTelefono();
                                            break;
                                        case 3:
                                            controlTelefono.actualizarTelefono();
                                            break;
                                        case 4:
                                            controlTelefono.verTelefono();
                                            break;
                                        case 5:
                                            controlTelefono.verTelefonos();
                                            break;
                                        case 6:
                                            controlTelefono.eliminarTelefono();
                                            break;
                                        case 7:
                                            controlUsuario.eliminarUsuario();
                                            out = true;
                                            break;
                                        case 8:
                                            //Si se escoge esta opcion sale del bucle 
                                            out = true;
                                            break;
                                        default:
                                            //Se imprime cuando el usuario no ingresa los valores establecidos
                                            System.out.println("Solo números del 1 al 3");
                                            break;
                                    }

                                } catch (InputMismatchException e) {/*Se imprime si el usuario inserta valores que no sean numericos o diferentes al tipo de dato
                                     */
                                    System.out.println("Debes insertar un número");
                                    entrada.next();
                                }
                            }
                        }

                        break;
                    case 3:
                        //Si se escoge esta opcion sale del bucle 
                        salir = true;
                        break;
                    default:
                        //Se imprime cuando el usuario no ingresa los valores establecidos
                        System.out.println("Solo números del 1 al 3");
                }

            } catch (InputMismatchException e) {/*Se imprime si el usuario inserta valores que no sean numericos o diferentes al tipo de dato
                 */
                System.out.println("Debes insertar un número");
                entrada.next();
            }
        }
    }

}
