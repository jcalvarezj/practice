/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgExcepciones;

/**
 *
 * @author Juan Camilo Alvarez J.
 */
public class AeropuertoNombreExistenteException extends Exception{

    public AeropuertoNombreExistenteException() {
        super("Ya existe un aeropuerto con el nombre dado.");
    }
    
}
