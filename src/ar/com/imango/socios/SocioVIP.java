package ar.com.imango.socios;

public class SocioVIP extends Socio {

    private static final Integer cantidadLibrosDisponibles = 15;
    private Integer valorCuotaMensual;


    public SocioVIP(String nombre, String apellido, Integer codigoIdentificacion, Integer valorCuotaMensual) {
        super(nombre, apellido, codigoIdentificacion);
        this.valorCuotaMensual = valorCuotaMensual;
        this.setLibrosARetirar(cantidadLibrosDisponibles);
    }

    public Integer getValorCuotaMensual() {
        return valorCuotaMensual;
    }

    @Override
    public String toString() {
        return "SocioVIP{" +
                super.toString() +
                "valorCuotaMensual=" + valorCuotaMensual +
                '}';
    }


}
