/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo.Aeronaves;

import java.awt.Point;
import javax.swing.ImageIcon;
import pkgModelo.Aeronave;
import static pkgModelo.Aeronave.NORTE;
import pkgModelo.Dimension;
import pkgModelo.Nodo;
import pkgModelo.Sprite;
import pkgVista.PanelJuego;

/**
 * Clase que hereda de Aeronave y modela un avion de Carga
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Carga extends Aeronave {

    public Carga() {
        super();
    }
    
    public Carga(int altura, int velocidad, Point posicionInicial, Point posicionFinal, int direccionSprite, PanelJuego panel, Nodo casillaEspacio) {
        super(altura, 5300, velocidad, 580, 50, posicionInicial, posicionFinal, direccionSprite, panel, casillaEspacio);
    }
    
    @Override
    protected void definirSprites() {
        sprites = new Sprite[16];
        sprites[0] = new Sprite(NORTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/norte.png")), new Dimension(48, 43));
        sprites[1] = new Sprite(NORESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/noreste.png")), new Dimension(43, 43));
        sprites[2] = new Sprite(NOROESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/noroeste.png")), new Dimension(43, 43));
        sprites[3] = new Sprite(NORTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/norte.png")), new Dimension(48, 43));
        sprites[4] = new Sprite(NORTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/norte.png")), new Dimension(48, 43));
        sprites[5] = new Sprite(SUR, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/sur.png")), new Dimension(48, 43));
        sprites[6] = new Sprite(SURESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/sureste.png")), new Dimension(43, 43));
        sprites[7] = new Sprite(SUROESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/suroeste.png")), new Dimension(43, 43));
        sprites[8] = new Sprite(SUR_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/sur.png")), new Dimension(48, 43));
        sprites[9] = new Sprite(SUR_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/sur.png")), new Dimension(48, 43));
        sprites[10] = new Sprite(ESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/este.png")), new Dimension(43, 48));
        sprites[11] = new Sprite(ESTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/este.png")), new Dimension(43, 48));
        sprites[12] = new Sprite(ESTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/este.png")), new Dimension(43, 48));
        sprites[13] = new Sprite(OESTE, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/oeste.png")), new Dimension(43, 48));
        sprites[14] = new Sprite(OESTE_ARRIBA, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/oeste.png")), new Dimension(43, 48));
        sprites[15] = new Sprite(OESTE_ABAJO, new ImageIcon(this.getClass().getClassLoader().getResource("pkgSprites/Carga/oeste.png")), new Dimension(43, 48));
    }
    
}
