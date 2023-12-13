/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Autor;
import entity.Cliente;
import entity.Libro;
import entity.Prestamo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import persistencia.DAOCliente;

/**
 *
 * @author Ciro
 */
public class ClienteServicio {
    DAOCliente daoc = new DAOCliente();
    public void ClienteServicio(){  
    }
    
    
    public void crearCliente(Long documento,String nombre,String apellido,String telefono) {//Pasar por parametro el Autor
        Cliente cli = new Cliente();
        cli.setDocumento(documento);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setTelefono(telefono);
        daoc.crearCliente(cli);
        System.out.println("-> Cliente Creado <-");
    }
    public void prestamosDelCliente(String documento){
    
        // Obtener el cliente de la base de datos
        
        Cliente cl = daoc.buscarCliente(documento);
        
        if (cl != null) {
            // Obtener los préstamos del cliente
            List<Prestamo> prestamos = cl.getPrestamos();

            // Mostrar los préstamos del cliente
            System.out.println("Préstamos del cliente " + cl.getNombre() + ":");
            for (Prestamo prestamo : prestamos) {
                System.out.println("ID: " + prestamo.getId() + ", Fecha: " + prestamo.getFecha());
            }
        } else {
            System.out.println("Cliente no encontrado en la base de datos.");
        }
    }
    public Cliente buscarCliente(String id){
        try {
            Cliente cli = daoc.buscarCliente(id);
            System.out.println(cli.toString());
            return cli;
        } catch (Exception e) {
            System.out.println("Error a la hora de buscar el libro. ");
             return null;
        }
    }
 }


