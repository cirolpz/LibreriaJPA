/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entity.Autor;
import java.util.List;

/**
 *
 * @author Ciro
 */
public class DAOAutor extends DAO {

    public void crearAutor(Autor aut) {
        try {
            crear(aut);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("Error a la hora de crear el autor. ");
        }
    }

    public Autor buscarAutor(String id) {
        try {
            Autor aut = em.find(Autor.class, Long.parseLong(id));
            System.out.println(aut.toString());
            return aut;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el autor. ");
            return null;
        }
    }

    public void borrarAutor(String id) {
        try {
            Autor aut = em.find(Autor.class, Long.parseLong(id));
            borrar(aut);
            System.out.println("Se eliminó el autor: " + id);
        } catch (Exception e) {
            System.out.println("Error a la hora de borrar el autor. ");
        }
    }

    public void actualizarAutor(Autor aut) {
        try {
            actualizar(aut);
            System.out.println("Se agregó el nuevo nombre " + aut.getNombre());
        } catch (Exception e) {
            System.out.println("Error a la hora de actualizar el autor");
        }
    }

    public void darDeAlta(Autor aut) {
        try {
            aut.setAlta(true);
            System.out.println("Se dio de Alta: " + aut.getNombre() + " " + aut.getAlta());
        } catch (Exception e) {
            System.out.println("Error a la hora de dar de alta");
        }
    }

    public void buscarNombre(String nombre, String consultaGenerica) {
        try {
            List<Autor> resultados = em.createQuery(consultaGenerica).setParameter("nombre", nombre).getResultList();
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron autores con el nombre: " + nombre);
            } else {
                for (Autor autor : resultados) {
                    System.out.println("-Id: " + autor.getId() + " -Nombre: " + autor.getNombre() + " -Alta: " + autor.getAlta());
                }
            }
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el nombre ");
        }
    }
}
