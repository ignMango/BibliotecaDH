package ar.com.imango;

import ar.com.imango.biblioteca.Biblioteca;
import ar.com.imango.ejemplar.Ejemplar;
import ar.com.imango.libros.Libro;
import ar.com.imango.socios.Socio;
import ar.com.imango.socios.SocioClasico;
import ar.com.imango.socios.SocioVIP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /* SINGLE LIBROS*/

        Libro libro1 = new Libro("El señor de los anillos", 123, "JRR tolkien");
        Libro libro2 = new Libro("Lord of the rings", 12, "Guillote");
        Libro libro3 = new Libro("El libro gordo de petete", 34, "Alguien2");

        /* SINGLE EJEMPLARES */
        Ejemplar ejemplar1 = new Ejemplar(libro1, 1,  "1° piso");
        Ejemplar ejemplar2 = new Ejemplar(libro1, 1, "1° piso");
        Ejemplar ejemplar3= new Ejemplar(libro2, 3, "2° piso");
        Ejemplar ejemplar4 = new Ejemplar(libro2, 3,  "2° piso");
        Ejemplar ejemplar5 = new Ejemplar(libro3, 2, "3° piso");
        Ejemplar ejemplar6 = new Ejemplar(libro3, 2, "3° piso");


        /* EJEMPLARES */
        List<Ejemplar> ejemplaresHarry = new ArrayList<>();
        ejemplaresHarry.addAll(Arrays.asList(ejemplar1, ejemplar2));
        List<Ejemplar> ejemplaresLOTR = new ArrayList<>();
        ejemplaresLOTR.addAll(Arrays.asList(ejemplar3, ejemplar4));
        List<Ejemplar> ejemplaresPetete = new ArrayList<>();
        ejemplaresPetete.addAll(Arrays.asList(ejemplar5, ejemplar6));

        /* AGREGAMOS EJEMPLARES A LOS LIBROS*/
        libro1.agregarEjemplar(ejemplaresHarry);
        libro1.agregarEjemplar(ejemplaresHarry);
        libro1.agregarEjemplar(ejemplaresHarry);
        libro2.agregarEjemplar(ejemplaresLOTR);
        libro3.agregarEjemplar(ejemplaresPetete);


        /* SINGLE SOCIOS */
        SocioClasico socio1 = new SocioClasico("Ignacio", "Mango", 1234);
        SocioClasico socio2 = new SocioClasico("Walter", "Peña", 5678);

        SocioVIP socio3 = new SocioVIP("Sebastian", "Nimo", 8752, 400);
        SocioVIP socio4 = new SocioVIP("Guillote", "Caputo", 456789, 800);


        /* LIBROS*/
        List<Libro> libros = new ArrayList<>();
        libros.addAll(Arrays.asList(libro1, libro2, libro3));

        /* SOCIOS */
        List<Socio> socios = new ArrayList<>();
        socios.addAll(Arrays.asList(socio1, socio2, socio3, socio4));

        /* BIBLIOTECA => NECESITA List<LIBROS> Y List<SOCIOS> */
        Biblioteca biblioteca = new Biblioteca(libros, socios);

        System.out.println("#######################################################");
        System.out.println(biblioteca);

        /*
        biblioteca.prestar(123, 1234);
        biblioteca.prestar(123, 1234);
        biblioteca.prestar(123, 1234);
        biblioteca.prestar(123, 1234);
        */

        biblioteca.devolver(ejemplar1, 1234);
        // este para probar try/catch
        //biblioteca.devolver(ejemplar6, 987535);

        //biblioteca.prestar(Arrays.asList(libro1.getCodigoISBN(), libro2.getCodigoISBN(), libro3.getCodigoISBN()), 1234);

        biblioteca.devolver(Arrays.asList(ejemplar1,ejemplar2, ejemplar3, ejemplar4), 1234);


        System.out.println("La UI paracuando");










    }
}
