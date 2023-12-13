package libreria;

import entity.Autor;
import entity.Editorial;
import entity.Libro;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import service.AutorServicio;
import service.ClienteServicio;
import service.EditorialServicio;
import service.LibroServicio;
import service.PrestamoServicio;
/*yo lo use en un proyecto de alumnos que estaba haciendo pero sirve para poner Date y te rellena con la fecha actual
por ejemplo si necesitas cargar una Base de datos con nombre, apellido etc de alumno al poner fecha de nacimiento te rellena con la fecha actual asi no tenes que andar pensando que 
fecha de nacimiento tiene una persona ( obviamente sirve para ejercicios en mi caso)*/
public class Libreria {

    public static void main(String[] args) {
        AutorServicio autorServicio = new AutorServicio();
        LibroServicio libroServicio = new LibroServicio();
        ClienteServicio clsv = new ClienteServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        PrestamoServicio psv = new PrestamoServicio();
        Scanner sc = new Scanner(System.in);
        Excepciones checkExcep = new Excepciones();
        Long idAutor = 701L;
        Long idEditorial = 1001L;
        int opc1 = 0;
        do {
            switch (menu()) {
                case 1 -> {
                    try {
                        //AUTOR
                        System.out.println("---AUTORES---");
                        System.out.println(" -1- CREAR AUTOR \n -2- BUSCAR AUTOR \n -3- ACTUALIZAR AUTOR \n -4- BORRAR AUTOR \n -5- DAR DE ALTA \n -6- BUSCAR NOMBRE \n -7- ATRAS");
                        int opcAut = sc.nextInt();
                        if (opcAut == 1) {
                            try {
                                System.out.println("Ingresar nombre del autor: ");
                                String nombre = sc.next();
                                if(checkExcep.chequearString(nombre)){
                                     autorServicio.crearAutor(nombre);
                                }else{
                                    System.out.println("Error. ingresa Letras!!!");
                                }
                           } catch (Exception e) { // Imprime la traza de la excepción
                                // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcAut == 2) {
                            try {
                                System.out.println("Id del Autor que quiere buscar: ");
                                idAutor = sc.nextLong();
                                if(checkExcep.controlNumeros(idAutor)){
                                    autorServicio.buscarAutor(idAutor.toString());}
                                else{
                                    System.out.println("Ingrese NUMEROS!!!");
                                }
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcAut == 3) {
                            try {
                                System.out.println("Id del Autor que quiere actualizar: ");
                                Long id = sc.nextLong();
                                System.out.println("Nuevo nombre del Autor: ");
                                String nombreAutor = sc.next();
                                
                                autorServicio.actualizarAutor(id.toString(), nombreAutor);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcAut == 4) {
                            try {
                                System.out.println("Id del Autor que quiere borrar: ");
                                Long id = sc.nextLong();
                                autorServicio.borrarAutor(id.toString());
                                } catch (Exception e) {
                                    e.printStackTrace(); // Imprime la traza de la excepción
                                    System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                                }               
                        } else if (opcAut == 5) {
                            try {
                                System.out.println("Id del Autor que quiere dar de alta: ");
                                Long id = sc.nextLong();
                                autorServicio.darDeAlta(id.toString());
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcAut == 6) {
                            try {
                                System.out.println("Nombre del Autor que quiere buscar: ");
                                String nombreAutor = sc.next();
                                autorServicio.buscarNombre(nombreAutor);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcAut == 7) {
                            menu();
                        } else {
                            System.out.println("INGRESA EL NÚMERO BIEN");
                        }
                    } catch (Exception e) {
                        e.printStackTrace(); // Imprime la traza de la excepción
                        System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                    }   
                }
                case 2 -> {
                    try {
                        System.out.println("---EDITORIAL---");
                        System.out.println(" -1- CREAR EDITORIAL \n -2- BUSCAR EDITORIAL \n -3- ACTUALIZAR EDITORIAL \n -4- BORRAR EDITORIAL \n -5- DAR DE ALTA \n -6- ATRAS");
                        int opcEdit = sc.nextInt();
                        if (opcEdit == 1) {
                            try {
                                System.out.println("Ingrese el nombre de la editorial: ");
                                String nombre = sc.next();
                                editorialServicio.crearEditorial(nombre);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcEdit == 2) {
                            try {
                                System.out.println("Buscar Editorial por id: ");
                                Long id = sc.nextLong();
                                editorialServicio.buscarEditorial(id.toString());
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcEdit == 3) {
                            try {
                                System.out.println("Id de la editorial que quiere actualizar el nombre: ");
                                Long id = sc.nextLong();
                                System.out.println("Nuevo nombre: ");
                                String nombre = sc.next();
                                editorialServicio.actualizarEditorial(id.toString(), nombre);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcEdit == 4) {
                            try {
                                System.out.println("Id de la editorial que quieres borrar: ");
                                Long id = sc.nextLong();
                                editorialServicio.borrarEditorial(id.toString());
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcEdit == 5) {
                            try {
                                System.out.println("Id de la editorial que quiere dar de alta: ");
                                Long id = sc.nextLong();
                                editorialServicio.darDeAlta(id.toString());
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcEdit == 6) {
                            menu();
                        } else {
                            System.out.println("INGRESA EL NÚMERO BIEN");
                        }
                    } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                }

                case 3 -> {
                    try {
                        System.out.println("---LIBRO---");
                        System.out.println(" -1- CREAR LIBRO \n -2- BUSCAR LIBRO \n -3- ACTUALIZAR LIBRO \n -4- BORRAR LIBRO \n -5- DAR DE ALTA \n -6- BUSCAR POR TITULO \n -7- BUSCAR POR ISBN \n -8- BUSCAR POR NOMBRE DEL AUTOR \n -9- BUSCAR POR NOMBRE DE EDITORIAL \n -10-ATRAS");
                        int opcLib = sc.nextInt();
                        if (opcLib == 1) {
                            try {
                                System.out.println("Ingrese el nombre del libro nuevo: ");
                                String nombre = sc.next();
                                System.out.println("Ingrese el año del libro: ");
                                int anio = sc.nextInt();
                                System.out.println("Ingrese la cantidad de ejemplares del libro: ");
                                int ejemplares = sc.nextInt();
                                System.out.println("Ingrese la cantidad de ejemplares del libro prestado: ");
                                int prestados = sc.nextInt();
                                Autor autor = autorServicio.buscarAutor(idAutor.toString());
                                Editorial editorial = editorialServicio.buscarEditorial(idEditorial.toString());
                                libroServicio.crearLibro(nombre, editorial, autor, anio, ejemplares, prestados);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 2) {
                            try {
                                System.out.println("Id del libro a buscar: ");
                                String idLibro = sc.next();
                                libroServicio.buscarLibro(idLibro);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 3) {
                            try {
                                System.out.println("Id del libro a actualizar: ");
                                String idLibro = sc.next();
                                System.out.println("Nombre del libro a actualizar: ");
                                String nombre = sc.next();
                                libroServicio.actualizarLibro(idLibro, nombre);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 4) {
                            try {
                                System.out.println("Id del libro a borrar: ");
                                String idLibro = sc.next();
                                libroServicio.borrarLibro(idLibro);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 5) {
                            try {
                                System.out.println("Id del libro a dar de Alta: ");
                                String idLibro = sc.next();
                                libroServicio.darDeAlta(idLibro);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 6) {
                            try {
                                System.out.println("Ingrese el titulo que quiere buscar: ");
                                String titulo = sc.next();
                                libroServicio.buscarTitulo(titulo);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 7) {
                            try {
                                System.out.println("Ingrese el titulo que quiere buscar por ISBN: ");
                                String isbn = sc.next();
                                libroServicio.buscarPorISBN(isbn);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 8) {
                            try {
                                System.out.println("Ingrese el nombre del autor: ");
                                String autor = sc.next();
                                List<Libro> libros = libroServicio.buscarPorNombreDelAutor(autor);
                                for (Libro libro : libros) {
                                    System.out.println(libro.getTitulo());
                                }
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcLib == 9) {
                            try {
                                System.out.println("Ingrese el nombre de la editorial: ");
                                String editorial = sc.next();
                                List<Libro> libros2 = libroServicio.buscarPorNombreEditorial(editorial);
                                for (Libro libro : libros2) {
                                    System.out.println(libro.getTitulo());
                                }
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }

                        } else if (opcLib == 10) {
                            menu();
                        } else {
                            System.out.println("INGRESA EL NÚMERO BIEN");
                        }
                    } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                }
                case 4 -> {
                    System.out.println("Cliente: \n -1- Crear cliente \n -2- Crear prestamo \n -3- Devolver el libro \n -4- Buscar prestamos del cliente ");
                    int opcClie = sc.nextInt();
                        if (opcClie == 1) {
                            try {
                                System.out.println("Ingrese el documento del cliente: ");
                                Long documento = sc.nextLong();
                                System.out.println("Ingrese el nombre del cliente: ");
                                String nombre = sc.next();
                                System.out.println("Ingrese el documento del apellido: ");
                                String apellido = sc.next();
                                System.out.println("Ingrese el nombre del telefono: ");
                                String telefono = sc.next();
                                clsv.crearCliente(documento,nombre,apellido,telefono);
                            } catch (Exception e) {
                            }
                        } else if (opcClie == 2) {
                            try {
                                
                                System.out.println("Ingresar id libro: ");
                                String idLibro = sc.next();            
                                System.out.println("Ingresar id cliente: ");
                                String idCliente = sc.next();   
                                System.out.println("Ingresar fecha: dia, mes, anio");
                                String fechaString = sc.next();
                                // Parsear la fecha ingresada por el usuario al formato dd/mm/aaaa
                                String[] partesFecha = fechaString.split("/");
                                int dia = Integer.parseInt(partesFecha[0]);
                                int mes = Integer.parseInt(partesFecha[1]);
                                int anio = Integer.parseInt(partesFecha[2]);
                                // Crear el objeto Date con la fecha ingresada
                                Date fecha = new Date(anio - 1900, mes - 1, dia);  // Los meses en Date se representan desde 0 (enero) hasta 11 (diciembre)
                                System.out.println("Ingresar fechaDevolucion: dia, mes, anio");
                                String fechaString2 = sc.next();
                                // Parsear la fecha ingresada por el usuario al formato dd/mm/aaaa
                                String[] partesFecha2 = fechaString2.split("/");
                                int diaDevolucion = Integer.parseInt(partesFecha2[0]);
                                int mesDevolucion = Integer.parseInt(partesFecha2[1]);
                                int anioDevolucion = Integer.parseInt(partesFecha2[2]);
                                Date fechaDevolucion = new Date(anioDevolucion - 1900, mesDevolucion - 1, diaDevolucion);
                                psv.crearPrestamo(fecha, fechaDevolucion, idLibro, idCliente);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcClie == 3) {
                            try {
                                System.out.println("Ingrese id del cliente: ");
                                String id = sc.next();
                                System.out.println("Ingresar fecha Actual: dia, mes, anio");
                                String fechaString3 = sc.next();
                                String[] partesFecha2 = fechaString3.split("/");
                                int diaDevolucion2 = Integer.parseInt(partesFecha2[0]);
                                int mesDevolucion2 = Integer.parseInt(partesFecha2[1]);
                                int anioDevolucion2 = Integer.parseInt(partesFecha2[2]);
                                Date fechActual = null;
                                Date fechaActual = new Date(anioDevolucion2 - 1900, mesDevolucion2 - 1, diaDevolucion2);
                                psv.devolucionDelLibro(id,fechActual);
                                //devolver el libro
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        } else if (opcClie == 4) {
                            try {
                                System.out.println("Ingresar documento del cliente: ");
                                String documento = sc.next();
                                clsv.prestamosDelCliente(documento);
                            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
                        }
                }
                 default ->
                    System.out.println("Gracias");
            }
            try {
                System.out.println("Quiere salir? \n -1- NO \n -2- SI");
                opc1 = sc.nextInt();
            } catch (Exception e) {
                                e.printStackTrace(); // Imprime la traza de la excepción
                                System.out.println("Ocurrió un error: " + e.getMessage()); // Muestra el mensaje de error
                            }
        } while (opc1 == 1);
    }

    public static int menu() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Que base de datos quieres modificar? 1- Autor 2- Editorial 3- Libro 4- Salir");
            int opc = sc.nextInt();
            return opc;
        } catch (Exception e) {
            return 4;
        }
    }

}
