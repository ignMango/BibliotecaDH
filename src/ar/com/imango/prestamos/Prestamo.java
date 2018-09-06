package ar.com.imango.prestamos;

import ar.com.imango.ejemplar.Ejemplar;
import ar.com.imango.socios.Socio;

import java.util.Date;

public class Prestamo {

    private Ejemplar ejemplar;
    private Socio socio;
    private Date fecha;

    public Prestamo(Ejemplar ejemplar, Socio socio) {
        this.ejemplar = ejemplar;
        this.socio = socio;
        this.fecha = new Date();
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public Socio getSocio() {
        return socio;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "ejemplar=" + ejemplar +
                ", socio=" + socio +
                ", fecha=" + fecha +
                '}';
    }

}
