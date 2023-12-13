package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String titulo;
    private Boolean alta;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplares_Prestados;
    private Integer ejemplares_Restantes;
    @OneToOne
    private Editorial editorial;
    @OneToOne
    private Autor autor;
    public int getEjemplares_Prestados;

    public Libro() {
    }

    public Libro(String id, String titulo, Boolean alta, Integer anio, Integer ejemplares, Integer ejemplares_Prestados, Integer ejemplares_Restantes, Editorial editorial, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.alta = alta;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplares_Prestados = ejemplares_Prestados;
        this.ejemplares_Restantes = ejemplares_Restantes;
        this.editorial = editorial;
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.entidades.Libro[ id=" + id + " ]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplares_Prestados() {
        return ejemplares_Prestados;
    }

    public void setEjemplares_Prestados(Integer ejemplares_Prestados) {
        this.ejemplares_Prestados = ejemplares_Prestados;
    }

    public Integer getEjemplares_Restantes() {
        return ejemplares_Restantes;
    }

    public void setEjemplares_Restantes(Integer ejemplares_Restantes) {
        this.ejemplares_Restantes = ejemplares_Restantes;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void prestamoLibros(Libro lib) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
