/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgExcepciones;

/**
 * Excepción ocurrida cuando se intenta agregar una eropuerto sobre la linea de salida
 * @author Juan C. Alvarez, Andres Alvarez
 */
public class AeropuertoPosicionSobreLineaException extends Exception {

    public AeropuertoPosicionSobreLineaException() {
        super("Los aeropuertos no se pueden ubicar sobre la linea de lanzamiento!");
    }
    
}
