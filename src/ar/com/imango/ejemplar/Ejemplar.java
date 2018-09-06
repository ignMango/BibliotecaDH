package ar.com.imango.ejemplar;

import ar.com.imango.libros.Libro;

import java.util.Objects;

public class Ejemplar {

    private Libro libro;
    private Integer numeroEdicion;
    private String ubicacion;

    public Ejemplar(Libro libro, Integer numeroEdicion, String ubicacion) {
        this.libro = libro;
        this.numeroEdicion = numeroEdicion;
        this.ubicacion = ubicacion;
    }

    public Libro getLibro() {
        return libro;
    }

    public Integer getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "libro=" + libro +
                ", numeroEdicion=" + numeroEdicion +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ejemplar ejemplar = (Ejemplar) o;
        return Objects.equals(numeroEdicion, ejemplar.numeroEdicion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroEdicion);
    }
}
