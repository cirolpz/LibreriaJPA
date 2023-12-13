/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entity.Autor;
import entity.Libro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ciro
 */
public class DAOLibro extends DAO {

    public void crearLibro(Libro lib) {
        crear(lib);
    }

    public Libro buscarLibro(String id) {
        try {
            Libro lib = em.find(Libro.class, Long.parseLong(id));
            System.out.println(lib.toString());
            return lib;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el autor. ");
            return null;
        }
    }

    public void borrarLibro(String id) {
        try {
            Libro lib = em.find(Libro.class, Long.parseLong(id));
            borrar(lib);
            System.out.println("Se eliminó el autor: " + id);
        } catch (Exception e) {
            System.out.println("Error a la hora de borrar el autor. ");
        }
    }

    public void actualizarLibro(Libro lib) {
        try {
            actualizar(lib);
            System.out.println("Se agregó el nuevo nombre " + lib.getTitulo());
        } catch (Exception e) {
            System.out.println("Error a la hora de actualizar el autor");
        }
    }

    public void darDeAlta(Libro lib) {
        try {
            lib.setAlta(true);
            System.out.println("Se dio de Alta: " + lib.getTitulo() + " " + lib.getAlta());
        } catch (Exception e) {
            System.out.println("Error a la hora de dar de alta");
        }
    }

    public void buscarNombre(String nombre, String consultaGenerica) {
        try {
            List<Libro> resultados = em.createQuery(consultaGenerica).setParameter("nombre", nombre).getResultList();
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron autores con el nombre: " + nombre);
            } else {
                for (Libro libro : resultados) {
                    System.out.println("-Id: " + libro.getId() + " -Nombre: " + libro.getTitulo() + " -Alta: " + libro.getAlta());
                }
            }
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el nombre ");
        }
    }

    public void buscarPorISBN(String id, String consultaGenerica) {
        try {
            List<Libro> resultados = em.createQuery(consultaGenerica).setParameter("id", id).getResultList();
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron autores con el nombre: " + id);
            } else {
                for (Libro libro : resultados) {
                    System.out.println("-Id: " + libro.getId() + " -Nombre: " + libro.getTitulo() + " -Alta: " + libro.getAlta());
                }
            }
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el nombre ");
        }
    }

    public List<Libro> buscarPorNombreDelAutor(String nombreAutor, String consultaGenerica) {
        try {
            TypedQuery<Libro> query = em.createQuery(consultaGenerica, Libro.class);
            query.setParameter("nombreAutor", nombreAutor);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar por nombre del autor");
            return null;
        }
    }

    public List<Libro> buscarPorNombreEditorial(String nombreEditorial, String query) {
        try {
            TypedQuery<Libro> querys = em.createQuery(query, Libro.class);
            querys.setParameter("nombreEditorial", nombreEditorial);
            return querys.getResultList();
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar por nombre de editorial");
            return null;
        }
    }

}
