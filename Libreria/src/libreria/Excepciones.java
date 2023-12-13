/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

/**
 *
 * @author Ciro
 */
public class Excepciones {
    public boolean controlNumeros(Long numero){
        return numero instanceof Long; 
    }
    
    
    public boolean chequearString(String nombre){
        return nombre instanceof String;
    }
    
 
}
