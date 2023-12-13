package service;

import entity.Autor;
import entity.Libro;
import entity.Editorial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import persistencia.DAOLibro;

public class LibroServicio {

    /*
    EntityManagerFactory entityManagerFactory = PersistenceConfig.getEntityManagerFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
     */
    private EntityManager em;
    DAOLibro DaoL = new DAOLibro();

    public LibroServicio() {
        // Obtener una instancia de EntityManager utilizando el nombre de persistencia definido en persistence.xml
        em = Persistence.createEntityManagerFactory("Libreria").createEntityManager();
    }

    public LibroServicio(EntityManager entityManager) {

        this.em = Persistence.createEntityManagerFactory("Libreria").createEntityManager();
    }

    //PERSIST
    public void crearLibro(String nombre, Editorial editorial, Autor autor, int anio, int ejemplares, int prestados) {
        Libro libro = new Libro();
        libro.setAlta(Boolean.TRUE);
        libro.setTitulo(nombre);
        libro.setAnio(anio);
        libro.setEjemplares_Restantes(ejemplares - prestados);
        libro.setEjemplares_Prestados(prestados);
        libro.setEjemplares(ejemplares);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        DaoL.crearLibro(libro);
    }

    //FIND
    public Libro buscarLibro(String id) {
        try {
            Libro lib = DaoL.buscarLibro(id);
            System.out.println(lib.toString());
            return lib;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el libro. ");
             return null;
        }
    }

    //DELETE
    public void borrarLibro(String id) {
        Libro lib = DaoL.buscarLibro(id);
        String id2 = "" + lib.getId();
        DaoL.borrarLibro(id2);
    }

    //MERGE
    public void actualizarLibro(String id, String nombre) {
        Libro lib;
        lib = DaoL.buscarLibro(id);
        lib.setTitulo(nombre);
        DaoL.actualizarLibro(lib);
    }

    public void darDeAlta(String id) {
        Libro lib = DaoL.buscarLibro(id);
        DaoL.darDeAlta(lib);
    }

    public void buscarTitulo(String titulo) {
        String consulta = "SELECT a FROM Autor a WHERE a.nombre = :nombre";
        DaoL.buscarNombre(titulo, consulta);
    }

    public void buscarPorISBN(String id) {
        String query = "SELECT l" + " FROM Libro l " + "WHERE l.id =:id";
        DaoL.buscarPorISBN(id, query);
    }

    public List<Libro> buscarPorNombreDelAutor(String nombreAutor) {
        String query = "SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor";
        return DaoL.buscarPorNombreDelAutor(nombreAutor, query);
    }

    public List<Libro> buscarPorNombreEditorial(String nombreEditorial) {
        String query = "SELECT l FROM Libro l WHERE l.editorial.nombre = :nombreEditorial";
        return DaoL.buscarPorNombreEditorial(nombreEditorial, query);
    }
    public void prestamoLibros(Libro lib) {
        Integer prest =lib.getEjemplares_Prestados+1;
        lib.setEjemplares_Prestados(prest);
    }
    
}
