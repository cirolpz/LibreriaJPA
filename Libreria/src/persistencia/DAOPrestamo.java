/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entity.Prestamo;

/**
 *
 * @author Ciro
 */
public class DAOPrestamo extends DAO{
    public void crearPrestamo(Prestamo pre) {
        try {
            crear(pre);
            System.out.println("-> Prestamo Creado <-");
        } catch (Exception e) {
            System.out.println("Error a la hora de crear el prestamo ");
        }
    }

    public Prestamo buscarPrestamo(String id) {
        try {
            Prestamo pre = em.find(Prestamo.class, Long.parseLong(id));
            System.out.println(pre.toString());
            return pre;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el cliente ");
            return null;
        }
    }

    public void borrarPrestamo(String id) {
        try {
            Prestamo pre = em.find(Prestamo.class, Long.parseLong(id));
            borrar(pre);
            System.out.println("Se eliminó la prestamo: " + id);
        } catch (Exception e) {
            System.out.println("Error a la hora de borrar el prestamo. ");
        }
    }

    public void actualizarClientePrestamo(Prestamo pre) {
        try {
            actualizar(pre);
            System.out.println("Se agregó el nuevo nombre " + pre.getCliente());

        } catch (Exception e) {
            System.out.println("Error a la hora de actualizar la editorial");
        }
    }

}
