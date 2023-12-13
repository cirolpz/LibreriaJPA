/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Ciro
 */

public abstract class DAO {
   protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("Libreria");
    protected EntityManager em = emf.createEntityManager();
   
    protected void desconectarBase() {
        em.close();
    }  
    public void crear(Object object) {
        em.getTransaction().begin();
        em.persist(object); // Utiliza el objeto 'em' para realizar la operación de persistencia
        em.getTransaction().commit();   
    }

    public void borrar(Object object) {
        em.getTransaction().begin();
        em.remove(object); // Utiliza el objeto 'em' para realizar la operación de eliminación
        em.getTransaction().commit();
    }

    public void actualizar(Object object) {
        em.getTransaction().begin();
        em.merge(object); // Utiliza el objeto 'em' para realizar la operación de actualización
        em.getTransaction().commit();
    }
}






