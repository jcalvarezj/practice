/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

/**
 * Clase que almacena la dimension de aeropuertos y aeronaves
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Dimension {
    private int ancho;
    private int alto;

    public Dimension() {
    }

    public Dimension(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }    
    
}
