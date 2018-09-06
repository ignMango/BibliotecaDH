package ar.com.imango.biblioteca;

import ar.com.imango.ejemplar.Ejemplar;
import ar.com.imango.libros.Libro;
import ar.com.imango.prestamos.Prestamo;
import ar.com.imango.socios.Socio;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;
    private List<Socio> socios;
    private List<Prestamo>prestamos;

    public Biblioteca(List<Libro> libros, List<Socio> socios) {
        this.libros = libros;
        this.socios = socios;
        this.prestamos = new ArrayList<>();
    }


    public void prestar(Integer codigoISBN, Integer numeroIdentificacion){
        Libro libroEnCuestion = this.getLibroByCodigo(codigoISBN);
        Socio socioEnCuestion = this.getSocioByCodigo(numeroIdentificacion);
        // ver try catch esto posiblemente explote
        try {
            if(libroEnCuestion.tieneEjemplaresDisponibles() && socioEnCuestion.tieneCupoDisponible()) {
                Ejemplar ejemplar = libroEnCuestion.prestarEjemplar();
                socioEnCuestion.tomarPrestadoUnEjemplar(ejemplar);
                Prestamo p = new Prestamo(ejemplar, socioEnCuestion);
                prestamos.add(p);
                System.out.println(p);
            } else {
                System.out.println("no podes recibir el libro mostro...");
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Socio o libro no encontrado");
        }

    }

    public void prestar(List<Integer> listaISBN, Integer numeroIdentificacion ) {
        for(Integer codigo: listaISBN) {
            this.prestar(codigo, numeroIdentificacion);
        }
    }

    public void devolver(Ejemplar ejemplar, Integer numeroIdentificacion) {
        Socio socio = this.getSocioByCodigo(numeroIdentificacion);
        // validar null;
        try {
            socio.devolverUnEjemplar(ejemplar);

            for (Libro libro : this.libros) {
                if(libro.equals(ejemplar.getLibro())){
                    libro.reingresarEjemplar(ejemplar);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Socio no encontrado");
        }
    }

    public void devolver(List<Ejemplar> ejemplares, Integer numeroIdentificacion) {
        for(Ejemplar ejemplar: ejemplares) {
            this.devolver(ejemplar, numeroIdentificacion);
        }
    }

    private Libro getLibroByCodigo(Integer codigoISBN) {
        Libro libroEnCuestion = null;
        for (Libro libro : libros) {
            if (libro.getCodigoISBN().equals(codigoISBN)) {
                libroEnCuestion = libro;
            }
        }
        return libroEnCuestion;
    }

    private Socio getSocioByCodigo(Integer numeroIdentificacion) {
        Socio socioEnCuestion = null;
        for (Socio socio :this.socios) {
            if (socio.getCodigoIdentificacion().equals(numeroIdentificacion)) {
                socioEnCuestion = socio;
            }
        }
        return socioEnCuestion;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                ", socios=" + socios +
                ", prestamos=" + prestamos +
                '}';
    }
}
