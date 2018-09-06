package ar.com.imango.socios;

import ar.com.imango.ejemplar.Ejemplar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Socio {

    private String nombre;
    private String apellido;
    private Integer codigoIdentificacion;
    private List<Ejemplar> ejemplaresRetirados;
    private Integer librosARetirar;

    public Socio(String nombre, String apellido, Integer codigoIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoIdentificacion = codigoIdentificacion;
        this.ejemplaresRetirados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", codigoIdentificacion=" + codigoIdentificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(codigoIdentificacion, socio.codigoIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIdentificacion);
    }

    protected void setLibrosARetirar(Integer librosARetirar) {
        this.librosARetirar = librosARetirar;
    }

    public Integer getLibrosARetirar() {
        return librosARetirar;
    }

    public Boolean tieneCupoDisponible() {
        //souts
        if(this.librosARetirar > 0) {
            return true;
        } else {
            System.out.println("Sin cupo Disponible");
            return false;
        }
    }

    public void tomarPrestadoUnEjemplar(Ejemplar ejemplar){
        if(tieneCupoDisponible()) {
            this.ejemplaresRetirados.add(ejemplar);
            this.setLibrosARetirar(this.getLibrosARetirar() - 1);
        } else {
            System.out.println("No puede retirar mas libros, excede el limite.");
        }
    }

    public void devolverUnEjemplar(Ejemplar unEjemplar) {
        this.ejemplaresRetirados.remove(ejemplaresRetirados);
        this.setLibrosARetirar(this.getLibrosARetirar() +1 );
        System.out.println("Ejemplar devuelto con exito");
    }
}
