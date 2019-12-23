/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import pkgModelo.Aeronaves.Aeroplano;
import pkgModelo.Aeronaves.Carga;
import pkgModelo.Aeronaves.Helicoptero;
import pkgModelo.Aeronaves.Militar;
import pkgModelo.Aeronaves.Transporte;
import pkgVista.PanelJuego;

/**
 * Clase que modela un Aeropuerto
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Aeropuerto {
    
    /**
     * Nombre del aeropuerto
     */
    private String nombre;
    
    /**
     * Posición x,y que ocupa en gráficamente en el juego el aeropuerto
     */
    private Point posicion;
    
    private LinkedList<Aeronave> aeronaves;
    
    /**
     * Vector de permisos a Aeroplanos, Aviones de Carga Comercial, Aviones de Transporte, Helicópteros
     * y Aviones Militares respectivamente
     */
    private boolean[] aterrizajesActivos;
    private Dimension dimension;
    private ImageIcon imagen;
    private boolean seleccion;
    private PanelJuego panel;

    public Aeropuerto() {
    }

    public Aeropuerto(String nombre, Point posicion, boolean[] aterrizajesActivos, PanelJuego panel) {
        this.nombre = nombre;
        this.posicion = posicion;
        aeronaves = new LinkedList<>();
        this.aterrizajesActivos = aterrizajesActivos.clone();
        dimension = new Dimension();
        this.dimension.setAncho(58);
        this.dimension.setAlto(36);
        this.imagen = new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Aeropuerto/hangar.png"));
        seleccion = false;
        this.panel = panel;
    }
    
    public Aeropuerto(String nombre, Point posicion, LinkedList<Aeronave> aeronaves, boolean[] aterrizajesActivos, PanelJuego panel) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.aeronaves = aeronaves;
        this.aterrizajesActivos = aterrizajesActivos.clone();
        dimension = new Dimension();
        this.dimension.setAncho(58);
        this.dimension.setAlto(36);
        this.imagen = new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Aeropuerto/hangar.png"));
        seleccion = false;
        this.panel = panel;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the aeronaves
     */
    public LinkedList<Aeronave> getAeronaves() {
        return aeronaves;
    }

    /**
     * @param aeronaves the aeronaves to set
     */
    public void setAeronaves(LinkedList<Aeronave> aeronaves) {
        this.aeronaves = aeronaves;
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

    /**
     * @return the aterrizajesActivos
     */
    public boolean[] getAterrizajesActivos() {
        return aterrizajesActivos;
    }

    /**
     * @param aterrizajesActivos the aterrizajesActivos to set
     */
    public void setAterrizajesActivos(boolean[] aterrizajesActivos) {
        this.aterrizajesActivos = aterrizajesActivos;
    }
    
    public boolean contienePunto(Point punto) {
        return (getBounds().contains(punto));
    }
    
    public boolean puedeAterrizar(Aeronave aeronave) {
        if(aeronave.isOrdenAterrizaje())
        {
            if((aterrizajesActivos[0] == true) && (aeronave instanceof Aeroplano))
                return true;
            else if((aterrizajesActivos[1] == true) && (aeronave instanceof Carga))
                return true;
            else if((aterrizajesActivos[2] == true) && (aeronave instanceof Transporte))
                return true;
            else if((aterrizajesActivos[3] == true) && (aeronave instanceof Helicoptero))
                return true;
            else if((aterrizajesActivos[4] == true) && (aeronave instanceof Militar))
                return true;
        }
        return false;
    }
    
    public boolean aterrizar(Aeronave aeronave) {
        if(puedeAterrizar(aeronave) && getBounds().contains(aeronave.getPosicionFinal()) &&
                (getBounds().intersects(aeronave.getBounds()))) {
                aeronave.setDetenerHilo(true);
                //aeronaves.add(aeronave);
                return true;
        }
        return false;
    }
    
    protected Rectangle getBounds() {
        return new Rectangle((int)posicion.getX() - dimension.getAncho()/2, 
                (int)posicion.getY() - dimension.getAlto()/2, 
                dimension.getAncho(), dimension.getAlto());
    }
    
    public void paint(Graphics2D g) {
        imagen.paintIcon(panel, g, (int)posicion.getX()-(dimension.getAncho()/2), (int)posicion.getY()-(dimension.getAlto()/2)+13);
        if(isSeleccion()) {
            g.setColor(Color.black);
            g.drawOval((int)posicion.getX() - dimension.getAncho()/2, 
            (int)posicion.getY() - dimension.getAlto()/2 + 13, 
            dimension.getAncho(), dimension.getAlto());
        }
    }

    /**
     * @return the selecccion
     */
    public boolean isSeleccion() {
        return seleccion;
    }

    /**
     * @param seleccion the seleccion to set
     */
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    @Override
    public String toString() {
        return ""+nombre;
    }

}
