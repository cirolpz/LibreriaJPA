package service;

import entity.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import persistencia.DAOAutor;

public class AutorServicio {

    DAOAutor DaoAut = new DAOAutor();

    public AutorServicio() {
    }

    public void crearAutor(String nombre) {//Pasar por parametro el Autor
        Autor e = new Autor();
        e.setAlta(Boolean.TRUE);
        e.setNombre(nombre);
        DaoAut.crearAutor(e);
        System.out.println("-> Autor Creado <-");
    }

    public Autor buscarAutor(String id) {
        try {
            Autor aut = DaoAut.buscarAutor(id);
            System.out.println(aut.toString());
            return aut;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el autor. ");
            return null;
        }
    }

    public void borrarAutor(String id) {
        Autor aut = DaoAut.buscarAutor(id);
        String id2 = "" + aut.getId();
        DaoAut.borrarAutor(id2);
    }

    public void actualizarAutor(String id, String nombre) {
        Autor aut = buscarAutor(id);
        aut.setNombre(nombre);
        DaoAut.actualizarAutor(aut);
    }

    public void darDeAlta(String id) {
        Autor aut = buscarAutor(id);
        DaoAut.darDeAlta(aut);
    }

    public void buscarNombre(String nombre) {
        String consulta = "SELECT a FROM Autor a WHERE a.nombre = :nombre";
        DaoAut.buscarNombre(nombre, consulta);
    }
}
