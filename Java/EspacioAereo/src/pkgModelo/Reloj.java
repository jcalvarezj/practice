/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el temporizador del juego
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Reloj implements Runnable{

    private int minuto;
    private int segundo;
    private Juego juego;
    

    public Reloj(int minuto, Juego juego) {
        this.minuto = minuto;
        this.juego = juego;
        segundo = 0;
    }
    
    @Override
    public void run() {
        while(!(minuto == 0 && segundo == 0))
            
            try {
                Thread.sleep(1000);
                if(segundo == 0)
                {
                    segundo = 59;
                    minuto--;
                }
                else
                    segundo--;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        juego.gameOver();
    }
    
    public int tiempoBruto() {
        return 60*minuto + segundo;
    }
    
    @Override
    public String toString() {
        if(segundo >= 10)
            return ""+minuto+":"+segundo;
        else
            return ""+minuto+":0"+segundo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
}
