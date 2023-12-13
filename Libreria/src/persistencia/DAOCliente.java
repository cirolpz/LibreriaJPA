/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entity.Cliente;

/**
 *
 * @author Ciro
 */
public class DAOCliente extends DAO{
    public void crearCliente(Cliente cli) {
        try {
            crear(cli);
            System.out.println("-> Cliente Creado <-");
        } catch (Exception e) {
            System.out.println("Error a la hora de crear el cliente ");
        }
    }

    public Cliente buscarCliente(String dni) {
        try {
            Cliente cli = em.find(Cliente.class, Long.parseLong(dni));
            System.out.println(cli.toString());
            return cli;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar al cliente ");
            return null;
        }
    }

    public void borrarCliente(String id) {
        try {
            Cliente cli = em.find(Cliente.class, Long.parseLong(id));
            borrar(cli);
            System.out.println("Se eliminó la editorial: " + id);
        } catch (Exception e) {
            System.out.println("Error a la hora de borrar el autor. ");
        }
    }

    public void actualizarCliente(Cliente cli) {
        try {
            actualizar(cli);
            System.out.println("Se agregó el nuevo nombre " + cli.getNombre());

        } catch (Exception e) {
            System.out.println("Error a la hora de actualizar la editorial");
        }
    }



}
