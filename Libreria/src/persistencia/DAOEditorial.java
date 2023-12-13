/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entity.Autor;
import entity.Editorial;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ciro
 */
public class DAOEditorial extends DAO {

    public void crearEditorial(Editorial edi) {
        try {
            crear(edi);
            System.out.println("-> Editorial Creada <-");
        } catch (Exception e) {
            System.out.println("Error a la hora de crear la editorial ");
        }
    }

    public Editorial buscarEditorial(String id) {
        try {
            Editorial edi = em.find(Editorial.class, Long.parseLong(id));
            System.out.println(edi.toString());
            return edi;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar la editorial ");
            return null;
        }
    }

    public void borrarEditorial(String id) {
        try {
            Editorial edi = em.find(Editorial.class, Long.parseLong(id));
            borrar(edi);
            System.out.println("Se eliminó la editorial: " + id);
        } catch (Exception e) {
            System.out.println("Error a la hora de borrar el autor. ");
        }
    }

    public void actualizarEditorial(Editorial edi) {
        try {
            actualizar(edi);
            System.out.println("Se agregó el nuevo nombre " + edi.getNombre());

        } catch (Exception e) {
            System.out.println("Error a la hora de actualizar la editorial");
        }
    }

    public void darDeAlta(Editorial edi) {
        try {
            edi.setAlta(true);
            System.out.println("Se dio de Alta: " + edi.getNombre() + " " + edi.getAlta());
        } catch (Exception e) {
            System.out.println("Error a la hora de dar de alta");
        }
    }

}
