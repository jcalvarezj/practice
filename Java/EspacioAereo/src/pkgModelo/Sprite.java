/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import javax.swing.ImageIcon;

/**
 * Clase que me representa el Sprite de un objeto
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Sprite {
    private int direccion;
    private ImageIcon imagen;
    private Dimension dimension;

    /**
     * Constructor por defecto para la clase Sprite
     */
    public Sprite() {
    }

    /**
     * Constructor parametrizable para la clase Sprite
     * @param direccion, de tipo int, me sirve para relacionar la direccion de una imagen
     * @param imagen, de tipo String
     */
    public Sprite(int direccion, ImageIcon imagen, Dimension dimension) {
        this.direccion = direccion;
        this.imagen = imagen;
        this.dimension = dimension;
    }

    /**
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the imagen
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    
}
