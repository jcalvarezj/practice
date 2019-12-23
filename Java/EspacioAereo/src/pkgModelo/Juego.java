/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgExcepciones.AeropuertoNombreExistenteException;
import pkgExcepciones.AeropuertoPosicionSobreLineaException;
import pkgHeaps.HeapAeronave;
import pkgHeaps.HeapEntero;
import pkgModelo.Aeronaves.Aeroplano;
import pkgModelo.Aeronaves.Carga;
import pkgModelo.Aeronaves.Helicoptero;
import pkgModelo.Aeronaves.Militar;
import pkgModelo.Aeronaves.Transporte;
import pkgVista.PanelJuego;

/**
 * Clase que modela la instancia de tipo Juego
 * Es la clase principal
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Juego implements Runnable{
    
    public final static int NORTE = 1;
    public final static int SUR = 2;
    public final static int ESTE = 3;
    public final static int OESTE = 4;
    
    public final static int TEMPORIZADOR_OLEADA = 10;
    
    private LinkedList<Aeropuerto> aeropuertos;
    private LinkedList<Explosion> explosiones;
    private HeapAeronave aeronaves;
    private int puntajeTotal;
    private PanelJuego panel;
    private Espacio espacio;
    private int lineaSalida;

    private Reloj reloj;
    
    private boolean gameOver;
    
    private boolean pilotoAutomatico;
    
    Queue<Aeronave> oleada = new LinkedList<>();
    HeapEntero tiemposOleada = new HeapEntero();
    int lanzamiento = -1;
    private LinkedList<Nodo> llegadas = new LinkedList<>();

    public Juego(PanelJuego panel, Reloj reloj) {
        gameOver = false;
        espacio = new Espacio();
        aeropuertos = new LinkedList<>();
        explosiones = new LinkedList<>();
        aeronaves = new HeapAeronave();
        puntajeTotal = 0;
        lineaSalida = NORTE;
        this.panel = panel;
        this.reloj = reloj;
        pilotoAutomatico = false;
    }
    
    public void agregarAeropuerto(Aeropuerto a, Nodo n) throws AeropuertoNombreExistenteException{
        if(buscarAeropuerto(a.getNombre()) == null)
        {
            aeropuertos.add(a);
            relacionarColumnaNodosAeropuerto(a, n);
        }
        else
            throw new AeropuertoNombreExistenteException();
    }
    
    public Aeropuerto buscarAeropuerto(String nombre){
        Aeropuerto buscado = null;
        for (Aeropuerto a : aeropuertos)
            if (a.getNombre().equals(nombre))
                buscado = a;
        return buscado;
    }
    
    public Aeropuerto buscarAeropuerto(Point posicion){
        Aeropuerto buscado = null;
        for (Aeropuerto a : aeropuertos)
            if (a.getPosicion().equals(posicion))
                buscado = a;
        return buscado;
    }
    
    private Aeronave buscarAeronave(Aeronave buscar) {
        for(Aeronave a : aeronaves.getLista()) {
            if(a.compareTo(buscar) == 0)
                return buscar;
        }
        return null;
    }
    
    public Aeronave buscarAeronaveSeleccionada() {
        for(Aeronave a : aeronaves.getLista()) {
            if(a.isSeleccion())
                return a;
        }
        return null;
    }
    
    public boolean aterrizarAeronaves() {
        for(Aeropuerto aeropuerto : aeropuertos) {
            for( int i = 0; i < aeronaves.getLista().size(); i++)
                if(aeropuerto.aterrizar(aeronaves.getLista().get(i))) {
                    puntajeTotal = puntajeTotal + aeronaves.getLista().get(i).getPuntosAterrizaje();
                    aeronaves.getLista().remove(aeronaves.getLista().get(i));
                    return true;
                }
        }
        return false;
    }
    
    public boolean posicionCorrecta(Point posicion) throws AeropuertoPosicionSobreLineaException {
        posicion = Espacio.buscarCasillaPosicion(posicion, espacio.getMapa()).getPosicion();
        if(lineaSalida == OESTE) {
            for(int i = 0; i < espacio.getMapa()[0].length; i++)
                if(posicion.equals(espacio.getMapa()[0][i][0].getPosicion()))
                    throw new AeropuertoPosicionSobreLineaException();
        }
        else if(lineaSalida == ESTE) {
            for(int i = 0; i < espacio.getMapa()[0].length; i++)
                if(posicion.equals(espacio.getMapa()[0][i][14].getPosicion()))
                    throw new AeropuertoPosicionSobreLineaException();
        }
        else if(lineaSalida == NORTE) {
            for(int i = 0; i < espacio.getMapa()[0][0].length; i++)
                if(posicion.equals(espacio.getMapa()[0][0][i].getPosicion()))
                    throw new AeropuertoPosicionSobreLineaException();
        }
        else if(lineaSalida == SUR) {
            for(int i = 0; i < espacio.getMapa()[0][0].length; i++)
                if(posicion.equals(espacio.getMapa()[0][10][i].getPosicion()))
                    throw new AeropuertoPosicionSobreLineaException();
        }
        return true;
    }
    
    public void subirAlturaAeronave() {
        buscarAeronaveSeleccionada().subirAltura();
    }
    
    public void bajarAlturaAeronave() {
        buscarAeronaveSeleccionada().bajarAltura();
    }
    
    public void subirVelocidadAeronave() {
        buscarAeronaveSeleccionada().subirVelocidad();
    }
    
    public void bajarVelocidadAeronave() {
        buscarAeronaveSeleccionada().bajarVelocidad();
    }
    
    private void oleada(Queue<Aeronave> oleada) {
        if((reloj.getSegundo() == 0) || (reloj.getSegundo()%TEMPORIZADOR_OLEADA == 0)) {
            oleada = aeronavesOleada();
            while(!oleada.isEmpty()) {
                aeronaves.enqueue(oleada.remove());
                Aeronave a = aeronaves.ultimo();
                Thread hiloAeronave = new Thread(a);
                hiloAeronave.start();
                aeronaves.heapSortAscendente();
            }
        }
    }
    
    private Queue<Aeronave> aeronavesOleada() {
        int numeroAeronaves = (int)(Math.random()*4+1);
        Queue<Aeronave> oleada = new LinkedList<>();
        LinkedList<Nodo> nodosOcupados = new LinkedList<>();
        while(numeroAeronaves > 0) {
            Aeronave a = crearAeronaveAleatoria(nodosOcupados);
            if(a != null) {
                oleada.add(a);
                numeroAeronaves--;
            }
        }
        return oleada;
    }
    
    private Aeronave crearAeronaveAleatoria(LinkedList<Nodo> ocupados) {
        int n = (int)(Math.random()*5);
        int velocidad;
        if(n == 0) {
            Nodo nodo = nodoAleatorio(1200/50);
            velocidad = (int) Math.floor(Math.random()*6+1) * 50;
            if(!ocupados.contains(nodo)){
                ocupados.add(nodo);
                return new Aeroplano(nodo.getAltura(), velocidad, nodo.getPosicion(), nodo.getPosicion(), direccionar(), panel, nodo);
            }
        }
        else if(n == 1) {
            Nodo nodo = nodoAleatorio(5300/50);
            velocidad = (int) Math.floor(Math.random()*11+1) * 50;
            if(!ocupados.contains(nodo)) {
                ocupados.add(nodo);
                return new Carga(nodo.getAltura(), velocidad, nodo.getPosicion(), nodo.getPosicion(), direccionar(), panel, nodo);
            }
        }
        else if(n == 2) {
            Nodo nodo = nodoAleatorio(10000/50);
            velocidad = (int) Math.floor(Math.random()*16+1) * 50;
            if(!ocupados.contains(nodo)) {
                ocupados.add(nodo);
                return new Transporte(nodo.getAltura(), velocidad, nodo.getPosicion(), nodo.getPosicion(), direccionar(), panel, nodo);
            }
        }
        else if(n == 3) {
            Nodo nodo = nodoAleatorio(250/50);
            velocidad = (int) Math.floor(Math.random()*5+1) * 50;
            if(!ocupados.contains(nodo)) {
                ocupados.add(nodo);
                return new Helicoptero(nodo.getAltura(), velocidad, nodo.getPosicion(), nodo.getPosicion(), direccionar(), panel, nodo);
            }
        }
        else if(n == 4) {
            Nodo nodo = nodoAleatorio(12000/50);
            velocidad = (int) Math.floor(Math.random()*24+1) * 50;
            if(!ocupados.contains(nodo)) {
                ocupados.add(nodo);
                return new Militar(nodo.getAltura(), velocidad, nodo.getPosicion(), nodo.getPosicion(), direccionar(), panel, nodo);
            }
        }
        
        return null;
    }
    
    private int direccionar() {
        if(lineaSalida == NORTE)
            return Aeronave.SUR;
        else if(lineaSalida == SUR)
            return Aeronave.NORTE;
        else if(lineaSalida == ESTE)
            return Aeronave.OESTE;
        else if(lineaSalida == OESTE)
            return Aeronave.ESTE;
        return -1;
    }
    
    private Nodo nodoAleatorio(int nivelLimite) {
        int nivel = (int)(Math.random()*nivelLimite);
        int columna = (int)(Math.random()*15);
        int fila = (int)(Math.random()*11);
        if(lineaSalida == NORTE)
            return espacio.getMapa()[nivel][0][columna];
        else if(lineaSalida == SUR) 
            return espacio.getMapa()[nivel][10][columna];
        else if(lineaSalida == ESTE)
            return espacio.getMapa()[nivel][fila][14];
        else if(lineaSalida == OESTE)
            return espacio.getMapa()[nivel][fila][0];
        return null;
    }
    
    public Aeronave seleccionarAeronave(Point punto) {
        int i = 240;
        while(i >= 1) {
            int altura = i*50;
            for(Aeronave a : aeronaves.getLista()) {
                if((a.getAltura() == altura) && a.getBounds().contains(punto)) {
                    a.setSeleccion(true);
                    return a;
                }
                else
                    a.setSeleccion(false);
            }
            i--;
        }
        return null;
    }
    
    public Aeropuerto seleccionarAeropuerto(Point punto) {
        Aeropuerto seleccionado = null;
        for (Aeropuerto a : aeropuertos) {
            if(a.contienePunto(punto)) {
                a.setSeleccion(true);
                seleccionado = a;
            }
            else
                a.setSeleccion(false);
        }
        return seleccionado;
    }
    
    private void eliminarColisionados() {
        for(Aeronave a : aeronaves.getLista()) {
            if(a.colisionDestruir(aeronaves.getLista()))
                explosiones.add(new Explosion(a.getPosicionInicial(), reloj.tiempoBruto(), panel));
        }
        int size = aeronaves.getLista().size();
        int i = 0;
        while(i < size) {
            if(aeronaves.getLista().get(i).isDestruir()) {
                aeronaves.getLista().remove(i);
                size--;
            }
            i++;
        }
    }
    
    private void actualizarExplosiones(int tiempoActual) {
        if(!explosiones.isEmpty()) {
        for(Explosion e : explosiones)
            e.setTiempoTranscurrido(tiempoActual);
        int size = explosiones.size();
        int i = 0;
        while(i < size) {
            if(explosiones.get(i).eliminar()) {
                explosiones.remove(i);
                size--;
            }
            i++;
        }
        }
    }

    @Override
    public void run() {
        Thread r = new Thread(reloj);
        r.start();
        int cambio = -1;
        //while(true){
        while(!gameOver){
            try {
                panel.getPadre();
                panel.getPadre().getLblTiempo().setText(""+reloj.toString());
                panel.getPadre().getLblPuntaje().setText(""+puntajeTotal);
                //Aqui todo lo del juego
                //oleada(oleada, tiemposOleada, lanzamiento);
                if(cambio != reloj.getSegundo()) {
                //if(aeronaves.isEmpty()) {
                    oleada(oleada);
                    cambio = reloj.getSegundo();
                }
                eliminarColisionados();
                actualizarExplosiones(reloj.tiempoBruto());
                aterrizarAeronaves();
                panel.repaint();
                
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }

    public LinkedList<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(LinkedList<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public int getLineaSalida() {
        return lineaSalida;
    }

    public void setLineaSalida(int lineaSalida) {
        this.lineaSalida = lineaSalida;
    }
    
    public void dibujarLinea(Graphics2D g) {
        g.setColor(Color.red);
        if(lineaSalida == NORTE)
            g.fillRect(0, 0, 899, 3);
        else if(lineaSalida == SUR)
            g.fillRect(0, 657, 899, 3);
        else if(lineaSalida == ESTE)
            g.fillRect(896, 0, 3, 659);
        else if(lineaSalida == OESTE)
            g.fillRect(0, 0, 3, 659);
        g.setColor(Color.black);
    }
    
    public void paint(Graphics2D g) {
        dibujarLinea(g);
        int x, y; 
        for (Aeropuerto a : aeropuertos)
        {
            x = a.getPosicion().x-29;
            y = a.getPosicion().y-18;
            g.setColor(new Color(73,224,78));
            g.fillRect(x, y, 60, 60);
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
            for (int i = 0; i < a.getAterrizajesActivos().length; i++)
                if(a.getAterrizajesActivos()[i])
                    g.drawString(""+(i+1), x+2+i*12, y+11);
            a.paint(g);
        }
        for (int i = 0; i < aeronaves.getLista().size(); i++)
            aeronaves.getLista().get(i).paint(g);
        
        for (int i = 0; i < explosiones.size(); i++)
            explosiones.get(i).paint(g);
        
    }
    
    private void relacionarColumnaNodosAeropuerto(Aeropuerto a, Nodo nodo){
        int x = nodo.getI();
        int y = nodo.getJ();
        for (int i = 0; i < espacio.getMapa().length; i++)
        {
            espacio.getMapa()[i][x][y].setAeropuerto(a);
            llegadas.add(espacio.getMapa()[i][x][y]);
        }
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    public void gameOver() {
        gameOver = true;
    }

    public PanelJuego getPanel() {
        return panel;
    }

    public void setPanel(PanelJuego panel) {
        this.panel = panel;
    }

    public Reloj getReloj() {
        return reloj;
    }

    public void setReloj(Reloj reloj) {
        this.reloj = reloj;
    }

    /**
     * @return the aeronaves
     */
    public HeapAeronave getAeronaves() {
        return aeronaves;
    }

    /**
     * @param aeronaves the aeronaves to set
     */
    public void setAeronaves(HeapAeronave aeronaves) {
        this.aeronaves = aeronaves;
    }

    /**
     * @return the puntajeTotal
     */
    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    /**
     * @param puntajeTotal the puntajeTotal to set
     */
    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public boolean getPilotoAutomatico() {
        return pilotoAutomatico;
    }

    public void setPilotoAutomatico(boolean pilotoAutomatico) {
        this.pilotoAutomatico = pilotoAutomatico;
    }

    public LinkedList<Explosion> getExplosiones() {
        return explosiones;
    }

    public void setExplosiones(LinkedList<Explosion> explosiones) {
        this.explosiones = explosiones;
    }

    public Queue<Aeronave> getOleada() {
        return oleada;
    }

    public void setOleada(Queue<Aeronave> oleada) {
        this.oleada = oleada;
    }

    public HeapEntero getTiemposOleada() {
        return tiemposOleada;
    }

    public void setTiemposOleada(HeapEntero tiemposOleada) {
        this.tiemposOleada = tiemposOleada;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public LinkedList<Nodo> getLlegadas() {
        return llegadas;
    }

    public void setLlegadas(LinkedList<Nodo> llegadas) {
        this.llegadas = llegadas;
    }
    
}
