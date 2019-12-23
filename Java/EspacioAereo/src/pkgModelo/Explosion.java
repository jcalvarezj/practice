/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.applet.AudioClip;
import pkgVista.PanelJuego;

/**
 * Clase que modela un objeto de tipo Explosion
 * busqueda del camino
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Explosion {
    private ImageIcon imagen;
    private AudioClip sonido;
    private Dimension dimension;
    private Point posicion;
    private int tiempoVida;
    private int tiempoCreacion;
    private int tiempoTranscurrido;
    private PanelJuego panel;

    public Explosion(Point posicion, int tiempoCreacion, PanelJuego panel) {
        imagen = new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Explosion/boom.gif"));
        sonido = java.applet.Applet.newAudioClip(this.getClass().getClassLoader().getResource("pkgSonidos/boom.wav"));
        
        dimension = new Dimension(50, 67);
        this.posicion = posicion;
        tiempoVida = 1;
        this.tiempoCreacion = tiempoCreacion;
        sonido.play();
        this. panel = panel;
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
     * @return the tiempoVida
     */
    public int getTiempoVida() {
        return tiempoVida;
    }

    /**
     * @param tiempoVida the tiempoVida to set
     */
    public void setTiempoVida(int tiempoVida) {
        this.tiempoVida = tiempoVida;
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

    /**
     * @return the posicion
     */
    public Point getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the panel
     */
    public PanelJuego getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(PanelJuego panel) {
        this.panel = panel;
    }
    
    public boolean eliminar() {
        if((tiempoCreacion - tiempoTranscurrido) == tiempoVida)
            return true;
        return false;
    }
    
    public void paint(Graphics2D g) {
        imagen.paintIcon(getPanel(), g, (int)posicion.getX()-(dimension.getAncho()/2), (int)posicion.getY()-(dimension.getAlto()/2)+13);
    }

    /**
     * @return the tiempoCreacion
     */
    public int getTiempoCreacion() {
        return tiempoCreacion;
    }

    /**
     * @param tiempoCreacion the tiempoCreacion to set
     */
    public void setTiempoCreacion(int tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    /**
     * @return the tiempoTranscurrido
     */
    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    /**
     * @param tiempoTranscurrido the tiempoTranscurrido to set
     */
    public void setTiempoTranscurrido(int tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }
    
}
