package ar.com.imango.libros;

import ar.com.imango.ejemplar.Ejemplar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libro {

    private String nombre;
    private Integer codigoISBN;
    private String autor;
    private List<Ejemplar> ejemplares;

    public Libro(String nombre, Integer codigoISBN, String autor) {
        this.nombre = nombre;
        this.codigoISBN = codigoISBN;
        this.autor = autor;
        this.ejemplares = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoISBN() {
        return codigoISBN;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", codigoISBN=" + codigoISBN +
                ", autor='" + autor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(codigoISBN, libro.codigoISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoISBN);
    }

    public void agregarNuevoEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }

    public Boolean tieneEjemplaresDisponibles() {
        //Agregamos logueo para que me diga que pasa
        if(this.ejemplares.size() > 0) {
            return true;
        } else {
            System.out.println("No hay ejemplares disponibles");
            return false;
        }
    }

    public Ejemplar prestarEjemplar() {
        Ejemplar ejemplarAPrestar = this.ejemplares.remove(0);
        System.out.println("Ejemplar prestado con exito");
        return ejemplarAPrestar;
    }

    public void reingresarEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
        System.out.println(String.format("Ejemplar reingresado con exito %s", ejemplar));
    }

    public void agregarEjemplar(List<Ejemplar> ejemplares){
        ejemplares.forEach(e -> this.agregarNuevoEjemplar(e));
    }

}
