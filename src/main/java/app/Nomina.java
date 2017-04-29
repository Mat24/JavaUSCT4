package app;

import DAOs.NominaNormDAO;
import pojos.Nominanorm;

import javax.swing.*;
import java.sql.Timestamp;

/**
 * Created by laptop-server on 22/04/17.
 */
public class Nomina {
    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion...");
        int opcionMenu = 0;
        System.out.println("Cargando la DB...");
        ConectorDB.getConection();
        System.out.println("DB Conectada: "+ConectorDB.getConection().toString());
        System.out.println("Imprimiendo lista de nomina...");
        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Listar toda la nomina (SELECT)");
            System.out.println("2. Insertar un registro nuevo en la nomina (INSERT)");
            System.out.println("3. Actualizar un registro en la nomina (UPDATE)");
            System.out.println("4. Eliminar un registro en la nomina (DELETE)");
            System.out.println("5. (Extra) Consultar la vista de nomina relacionada (SELECT)");
            System.out.println("6. Salir");
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog("Digite la opcion:"));
            switch (opcionMenu) {
                case 1:
                    // Mostrar todos los registros de la tabla NominaNorm
                    for (Nominanorm nomina: NominaNormDAO.findAll()) {
                        System.out.println(nomina.toString());
                    }
                    break;
                case 2:
                    System.out.println("Insertando un nuevo registro...");
                    Nominanorm nuevoRegistro = new Nominanorm();
                    nuevoRegistro.setCodigo(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo:")));
                    nuevoRegistro.setNombre1(JOptionPane.showInputDialog("digite el nombre1"));
                    nuevoRegistro.setNombre2(JOptionPane.showInputDialog("digite el nombre2"));
                    nuevoRegistro.setApellido1(JOptionPane.showInputDialog("digite el apellido1"));
                    nuevoRegistro.setApellido2(JOptionPane.showInputDialog("digite el apellido2"));
                    nuevoRegistro.setTiposangre(JOptionPane.showInputDialog("digite el tipo de sangre"));
                    nuevoRegistro.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Digite la altura:")));
                    nuevoRegistro.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite el peso:")));
                    nuevoRegistro.setNumerocalzado(Double.parseDouble(JOptionPane.showInputDialog("Digite el numero de calzado:")));
                    nuevoRegistro.setFechanace(Timestamp.valueOf(JOptionPane.showInputDialog("Digite la fecha de nacimiento")));
                    nuevoRegistro.setZurdodiestro(JOptionPane.showInputDialog("Es zurdo o diestro? (Z/D)"));
                    nuevoRegistro.setCiudadid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de la ciudad:")));
                    nuevoRegistro.setColorojosid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de el color de ojos:")));
                    nuevoRegistro.setEstadocivilid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de el estado civil:")));
                    nuevoRegistro.setEpsid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de la EPS:")));
                    nuevoRegistro.setFondopensionid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de el fondo de pension:")));
                    nuevoRegistro.setProfesionid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de la profesion:")));
                    nuevoRegistro.setDivisionid(Long.parseLong(JOptionPane.showInputDialog("Digite el codigo de la division:")));
                    Nominanorm objetoCreado = NominaNormDAO.create(nuevoRegistro);
                    System.out.println("Registro creado con exito!");
                    System.out.println(objetoCreado.toString());
                    break;
                case 3:
                    //Actualizar registro de nomina
                    System.out.println("Actualizacion de registro en curso...");
                    Long codigoRegistro = Long.parseLong(JOptionPane.showInputDialog("Digite el codigo del registro a actualizar:"));
                    // Para mayor seguridad envuelvo la busqueda en un objeto del tipo requerido
                    Nominanorm objetoAbuscar = new Nominanorm();
                    // Seteo los parametros de busqueda
                    objetoAbuscar.setCodigo(codigoRegistro);
                    // Ejecuto la busqueda, reasignandola en un nuevo objeto para evitar la mutabilidad
                    Nominanorm objetoAActualizar = NominaNormDAO.findbyObject(objetoAbuscar);
                    //Valida si existe un registro con ese codigo
                    if (objetoAActualizar != null) {
                        //Por cuestiones de practicidad solo actualizaremos el nombre1
                        objetoAActualizar.setNombre1(JOptionPane.showInputDialog("Digite el nuevo nombre1:"));
                        //Ejecuto la actualizacion y obtengo el resultado en un nuevo objeto
                        Nominanorm objectoActualizado = NominaNormDAO.update(objetoAActualizar);
                        System.out.println("Actualizacion exitosa!");
                        System.out.println(objectoActualizado.toString());
                    } else {
                        System.out.println("No existe en registro con ese Id!");
                    }
                    break;
                case 4:
                    // Eliminar un registro
                    System.out.println("Eliminacion de un registro en curso...");
                    Long codigoRegistroAeliminar = Long.parseLong(JOptionPane.showInputDialog("Digite el codigo del registro a eliminar:"));
                    // Para mayor seguridad envuelvo la busqueda en un objeto del tipo requerido
                    Nominanorm objetoAbuscarEliminar = new Nominanorm();
                    // Seteo los parametros de busqueda
                    objetoAbuscarEliminar.setCodigo(codigoRegistroAeliminar);
                    // Ejecuto la busqueda, reasignandola en un nuevo objeto para evitar la mutabilidad
                    Nominanorm objetoAeliminar = NominaNormDAO.findbyObject(objetoAbuscarEliminar);
                    //Valida si existe un registro con ese codigo
                    if (objetoAeliminar != null) {
                        //Ejecuto la actualizacion y obtengo el resultado en un nuevo objeto
                        Nominanorm objectoEliminado= NominaNormDAO.delete(objetoAeliminar);

                        System.out.println("Actualizacion exitosa!");
                        System.out.println(objectoEliminado.toString());
                    } else {
                        System.out.println("No existe en registro con ese Id!");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Terminando el programa...");
                    System.exit(0);
            }
        }while (true);
    }

    public static void pause() {
        // Sirve para pausar hasta presionar una tecla
        System.out.println("Presione [ENTER] para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
}
