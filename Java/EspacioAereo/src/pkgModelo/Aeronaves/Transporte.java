/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo.Aeronaves;

import java.awt.Point;
import javax.swing.ImageIcon;
import pkgModelo.Aeronave;
import pkgModelo.Dimension;
import pkgModelo.Nodo;
import pkgModelo.Sprite;
import pkgVista.PanelJuego;

/**
 * Clase que hereda de Aeronave y modela un avion comercial de Transporte
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Transporte extends Aeronave {

    public Transporte() {
    }

    public Transporte(int altura, int velocidad, Point posicionInicial, Point posicionFinal, int direccionSprite, PanelJuego panel, Nodo casillaEspacio) {
        super(altura, 10000, velocidad, 800, 80, posicionInicial, posicionFinal, direccionSprite, panel, casillaEspacio);
    }

    @Override
    protected void definirSprites() {
        sprites = new Sprite[16];
        sprites[0] = new Sprite(NORTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/norte.png")), new Dimension(50, 50));
        sprites[1] = new Sprite(NORESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/noreste.png")), new Dimension(41, 41));
        sprites[2] = new Sprite(NOROESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/noroeste.png")), new Dimension(41, 41));
        sprites[3] = new Sprite(NORTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/norte.png")), new Dimension(50, 50));
        sprites[4] = new Sprite(NORTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/norte.png")), new Dimension(50, 50));
        sprites[5] = new Sprite(SUR, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/sur.png")), new Dimension(50, 50));
        sprites[6] = new Sprite(SURESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/sureste.png")), new Dimension(41, 41));
        sprites[7] = new Sprite(SUROESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/suroeste.png")), new Dimension(41, 41));
        sprites[8] = new Sprite(SUR_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/sur.png")), new Dimension(50, 50));
        sprites[9] = new Sprite(SUR_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/sur.png")), new Dimension(50, 50));
        sprites[10] = new Sprite(ESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/este.png")), new Dimension(50, 50));
        sprites[11] = new Sprite(ESTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/este.png")), new Dimension(50, 50));
        sprites[12] = new Sprite(ESTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/este.png")), new Dimension(50, 50));
        sprites[13] = new Sprite(OESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/oeste.png")), new Dimension(50, 50));
        sprites[14] = new Sprite(OESTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/oeste.png")), new Dimension(50, 50));
        sprites[15] = new Sprite(OESTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Transporte/oeste.png")), new Dimension(50, 50));
    }

    
}
