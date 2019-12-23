/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgExcepciones;

/**
 *
 * @author Juan Camilo Alvarez J.
 */
public class ArchivoNoValidoExcepion extends Exception{

    public ArchivoNoValidoExcepion() {
        super("Archivo de texto de formato no válido, verificar");
    }

    public ArchivoNoValidoExcepion(String message) {
        super("Archivo de texto de formato no válido por "+message+", verificar");
    }
    
}
