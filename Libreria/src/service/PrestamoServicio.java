/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Cliente;
import entity.Libro;
import entity.Prestamo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import persistencia.DAOLibro;
import persistencia.DAOPrestamo;

/**
 *
 * @author Ciro
 */

public class PrestamoServicio {
    DAOLibro DaoL = new DAOLibro();
    LibroServicio libSer = new LibroServicio();
    DAOPrestamo daop = new DAOPrestamo();
    ClienteServicio clsv = new ClienteServicio();
    
    public void PrestamoServicio(){  
    }
    
    
    public void crearPrestamo(Date fecha,Date fechaDevolucion,String idlibro,String idcliente) {//Pasar por parametro el Autor
        Prestamo pres = new Prestamo();
        pres.setFecha(fecha);
        pres.setFechaDevolucion(fechaDevolucion);
        Libro lib = libSer.buscarLibro(idlibro);
        Cliente cli = clsv.buscarCliente(idcliente);
        
        pres.setLibro(lib);
        pres.setCliente(cli);
        
        if(pres.getLibro().getEjemplares_Restantes()<1){
            lib.prestamoLibros(lib);
            daop.crearPrestamo(pres);
        }
        else{
            System.out.println("NO HAY EJEMPLARES RESTANTES");
        }
        System.out.println("-> Prestamo Creado <-");
    }
    public void devolucionDelLibro(String id, Date fechActual){
        Prestamo pr = daop.buscarPrestamo(id);
        if(fechActual.compareTo(pr.getFechaDevolucion())<0){
            daop.borrarPrestamo(id);
        }
        else{
            daop.borrarPrestamo(id);
            System.out.println("Su tiempo de devolucion se pasó >:{");
        }
    }
    
    
}
