package ar.com.imango.socios;

public class SocioClasico extends Socio{

    private static final Integer cantidadLibrosDisponibles = 3;

    public SocioClasico(String nombre, String apellido, Integer codigoIdentificacion) {
        super(nombre, apellido, codigoIdentificacion);
        this.setLibrosARetirar(cantidadLibrosDisponibles);
    }


    @Override
    public Integer getLibrosARetirar() {
        return super.getLibrosARetirar();
    }

}
