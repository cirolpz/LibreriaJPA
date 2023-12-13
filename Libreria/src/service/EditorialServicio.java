package service;

import entity.Autor;
import entity.Editorial;
import entity.Libro;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import persistencia.DAOEditorial;

public class EditorialServicio {

    /*
    EntityManagerFactory entityManagerFactory = PersistenceConfig.getEntityManagerFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
     */
    private EntityManager em;
    DAOEditorial DAOe = new DAOEditorial();

    public EditorialServicio() {
    }

    //PERSIST
    public void crearEditorial(String nombre) {
        Editorial e = new Editorial();
        e.setAlta(Boolean.TRUE);
        e.setNombre(nombre);
        DAOe.crearEditorial(e);

    }

    //FIND
    public Editorial buscarEditorial(String id) {
        Editorial e = DAOe.buscarEditorial(id);
        return e;

    }

    //DELETE
    public void borrarEditorial(String id) {
        Editorial ed = DAOe.buscarEditorial(id);
        String id2 = "" + ed.getId();
        DAOe.borrarEditorial(id2);
    }

    //MERGE
    public void actualizarEditorial(String id, String nombre) {
        Editorial ed = DAOe.buscarEditorial(id);
        ed.setNombre(nombre);
        DAOe.actualizarEditorial(ed);
    }

    public void darDeAlta(String id) {
        Editorial ed = DAOe.buscarEditorial(id);
        DAOe.darDeAlta(ed);
    }
}
