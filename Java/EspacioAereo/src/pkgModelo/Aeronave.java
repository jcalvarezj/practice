/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgHeaps.HeapNodo;
import pkgModelo.Aeronaves.Carga;
import pkgModelo.Aeronaves.Helicoptero;
import pkgVista.PanelJuego;

/**
 * Clase que me modela un objeto de tipo Aeronave
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public abstract class Aeronave implements Runnable, Comparable {
    
    public static int NORTE = 0;
    public static int SUR = 1;
    public static int ESTE = 2;
    public static int OESTE = 3;
    public static int NORESTE = 4;
    public static int SURESTE = 5;
    public static int NOROESTE = 6;
    public static int SUROESTE = 7;
    public static int NORTE_ARRIBA = 8;
    public static int SUR_ARRIBA = 9;
    public static int ESTE_ARRIBA = 10;
    public static int OESTE_ARRIBA = 11;
    public static int NORTE_ABAJO = 12;
    public static int SUR_ABAJO = 13;
    public static int ESTE_ABAJO = 14;
    public static int OESTE_ABAJO = 15;
    public static int ARRIBA = 16;
    public static int ABAJO = 17;
    
    protected static int SECUENCIA = 0;
    
    private int id;
    protected int altura;
    protected int alturaMaxima;
    protected int velocidad;
    protected int velocidadMaxima;
    protected int puntosAterrizaje;
    protected Point posicionInicial;
    protected Point posicionFinal;
    protected Sprite[] sprites;
    private Sprite spriteActual;
    protected boolean seleccion;
    private boolean ordenAterrizaje;
    protected PanelJuego panel;
    protected boolean destruir;
    private boolean detenerHilo;
    
    protected Nodo casillaEspacio;
    protected Stack<Nodo> ruta;
    protected LinkedList<Nodo> llegadas;
    

    public Aeronave() {
    }

    public Aeronave(int altura, int alturaMaxima, int velocidad, int velocidadMaxima, int puntosAterrizaje, Point posicionInicial, Point posicionFinal, int direccionSprite, PanelJuego panel, Nodo casillaEspacio) {
        id = Aeronave.SECUENCIA++;
        this.altura = altura;
        this.alturaMaxima = alturaMaxima;
        this.velocidad = velocidad;
        this.velocidadMaxima = velocidadMaxima;
        this.puntosAterrizaje = puntosAterrizaje;
        this.posicionInicial = posicionInicial;
        
        this.posicionFinal = posicionFinal;
        definirSprites();
        this.spriteActual = buscarSprite(direccionSprite);
        seleccion = false;
        ordenAterrizaje = panel.getJuego().getPilotoAutomatico();
        this.panel = panel;
        destruir = false;
        detenerHilo = false;
        
        this.casillaEspacio = casillaEspacio;
        this.casillaEspacio.setOcupado(id);
        llegadas = posiblesLlegadas();
        
        ruta = new Stack<>();
    }

    /**
     * Metodo que verifica si se ha ocupado algun nodo de la ruta de la aeronave
     * @pre La ruta no es nula ni vacía
     * @return 
     */
    protected int haCambiadoNodo(){
        int ha = -1;
        int i = 0;
        Nodo actual;
        while(ha != -1 && i < ruta.size())
        {
            actual = ruta.get(i);
            ha = actual.getOcupado();
            i++;            
        }
        return ha;
    }
    
    /**
     * Genera la ruta a partir del algoritmo inteligente.
     */
    protected Stack generarRuta(){
        Nodo n = nodoRutaOtro(); // OJO, probar tambien con "nodoRuta" y "nodoRutaOtro" 
        while(n != null){
            ruta.push(n);
            n = n.getPadre();
        }
        return ruta;
    }
    
    protected Nodo nodoRuta(){
        Nodo inicio = casillaEspacio;
        
        HeapNodo abierta = new HeapNodo(), cerrada = new HeapNodo();
        abierta.enqueue(inicio); 
        
        while(!abierta.getLista().getFirst().isLlegadaAvion(this)){ //Suponiendo que abierta está en orden asc.
            Nodo actual = abierta.dequeueMinimo(this);
            System.out.println("Nodo actual: "+actual);
            cerrada.enqueue(actual);
            System.out.println("En la cerrada hay: "+cerrada);
            LinkedList<Nodo> sucesores = actual.getSucesores(cerrada,id);
            System.out.println("Los sucesores de "+actual+" son "+sucesores);
            System.out.println("");
            for (int i=0; i<sucesores.size(); i++) {
                Nodo vecino = sucesores.get(i);
                if(vecino!=null){
                    float costo = actual.getGAeronave(id) + Nodo.costoSucesor(i);
                    vecino.setGAeronave(id, costo);
                    int posicionNodoAbierta = abierta.buscarNodo(vecino.getId());
                    int posicionNodoCerrada = cerrada.buscarNodo(vecino.getId());
                    if(posicionNodoAbierta>=0 && abierta.getLista().get(posicionNodoAbierta).getGAeronave(this.getId()) < vecino.getGAeronave(this.getId())){
                        abierta.getLista().remove(posicionNodoAbierta);
                    }
                    if(posicionNodoCerrada>=0 && cerrada.getLista().get(posicionNodoCerrada).getGAeronave(this.getId()) < vecino.getGAeronave(this.getId())){
                        cerrada.getLista().remove(posicionNodoAbierta);
                    }
                    if(posicionNodoAbierta == -1 && posicionNodoCerrada == -1){
                        abierta.enqueue(vecino);
                        vecino.actualizarHeuristicaOptima(id,llegadas);
                        vecino.setPadre(actual);
                    }
                }
            }
        }
        
        return abierta.getLista().getFirst();
    }
    
    protected Nodo nodoRutaOtro(){
        Nodo inicio = casillaEspacio;
        
        HeapNodo abierta = new HeapNodo(), cerrada = new HeapNodo();
        abierta.enqueue(inicio); 
        Nodo meta = null;
        do{
            Nodo actual = abierta.dequeueMinimo(this);
            cerrada.enqueue(actual);
            if(actual.isLlegadaAvion(this))
                meta = actual;
            else{
                LinkedList<Nodo> vecinos = actual.getSucesores(cerrada);
                
                for (int i=0; i<vecinos.size(); i++) {
                    Nodo vecino = vecinos.get(i);
                    if(vecino != null)
                    {
                        float costo = actual.getGAeronave(this.getId()) + Nodo.costoSucesor(i);
                        vecino.setGAeronave(id, costo);
                        vecino.actualizarHeuristicaOptima(id,llegadas);

                        int posicionNodoAbierta = abierta.buscarNodo(vecino.getId());
                        int posicionNodoCerrada = cerrada.buscarNodo(vecino.getId());


                        if(posicionNodoAbierta >= 0)
                            if(vecino.getFAeronave(this.getId()) < abierta.getLista().get(posicionNodoAbierta).getFAeronave(this.getId()))
                            {//Remueva vecino de abierta porque nuevo camino es mejor
                                cerrada.enqueue(vecino);
                                abierta.getLista().remove(posicionNodoAbierta);  }
                        if(posicionNodoCerrada >= 0)
                            if(vecino.getFAeronave(this.getId()) < cerrada.getLista().get(posicionNodoCerrada).getFAeronave(this.getId()))
                                abierta.enqueue(cerrada.getLista().remove(posicionNodoCerrada));
                        if(posicionNodoCerrada == -1 && posicionNodoAbierta == -1)
                        {
                            abierta.enqueue(vecino);
                            vecino.setPadre(actual);
                        }
                    }
                }
            }
        } while(!abierta.getLista().isEmpty() && meta == null);
        
        return meta;
    }
    
    protected Nodo nodoRutaAlternativo(){
        System.out.println("El avion en "+casillaEspacio+" busca ruta...");
        Nodo inicio = casillaEspacio;
        
        HeapNodo abierta = new HeapNodo(), cerrada = new HeapNodo();
        abierta.enqueue(inicio); 
        Nodo meta = null;
        while(!abierta.getLista().isEmpty() && meta == null){
            
            System.out.println("En abierta hay: "+abierta);
            System.out.println("En cerrada hay: "+cerrada);
            
            Nodo actual = abierta.dequeueMinimo(this); //De menor valor f, orden asc de f
            
            LinkedList<Nodo> vecinos = actual.getSucesores(cerrada,id);
            
            System.out.println("Los vecinos del actual "+actual+" son "+vecinos);
            
            for (int i = 0; i < vecinos.size(); i++) {
                Nodo vecino = vecinos.get(i);
                if( vecino != null) {
                    System.out.println("El vecino a mirar es: "+vecino);
                    vecino.setPadre(actual);
                    System.out.println("El padre de "+vecino+" es "+actual);
                    if(vecino.isLlegadaAvion(this))
                        meta = vecino;
                    else{
                        vecino.setGAeronave(id, actual.getGAeronave(id) + Nodo.costoSucesor(i));
                        vecino.actualizarHeuristicaOptima(id, llegadas);
                    
                        int posicionNodoAbierta = abierta.buscarNodo(vecino.getId());
                        int posicionNodoCerrada = cerrada.buscarNodo(vecino.getId());
                    
                        boolean cond1 = posicionNodoAbierta > 0;
                        boolean cond2 = false;
                        boolean cond3 = posicionNodoCerrada > 0;
                        boolean cond4 = false;
                    
                        if(cond1){
                            cond2 = vecino.getFAeronave(this.getId()) > abierta.getLista().get(posicionNodoAbierta).getFAeronave(this.getId());
                            System.out.println("Vecino estaba en abierta y es pero que el que estaba en abierta:"+cond2);
                        }
                        if(cond3){
                            cond4 = vecino.getFAeronave(this.getId()) > cerrada.getLista().get(posicionNodoCerrada).getFAeronave(this.getId());
                            System.out.println("Vecino estaba en cerrada y es peor que el que estaba en cerrada:"+cond4);
                        }
                        if(!(cond1 && cond2) && !(cond3 && cond4))
                            System.out.println("ni en abierta, ni en cerrada");
                            abierta.enqueue(vecino);
                        }
                    }
            }
            cerrada.enqueue(actual);
        }
        System.out.println("Lo logro??? "+(meta == null));
        return meta;
    }
    
    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the alturaMaxima
     */
    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    /**
     * @param alturaMaxima the alturaMaxima to set
     */
    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the velocidadMaxima
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * @param velocidadMaxima the velocidadMaxima to set
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * @return the puntosAterrizaje
     */
    public int getPuntosAterrizaje() {
        return puntosAterrizaje;
    }

    /**
     * @param puntosAterrizaje the puntosAterrizaje to set
     */
    public void setPuntosAterrizaje(int puntosAterrizaje) {
        this.puntosAterrizaje = puntosAterrizaje;
    }

    /**
     * @return the posicionInicial
     */
    public Point getPosicionInicial() {
        return posicionInicial;
    }

    /**
     * @param posicionInicial the posicionInicial to set
     */
    public void setPosicionInicial(Point posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    /**
     * @return the posicionFinal
     */
    public Point getPosicionFinal() {
        return posicionFinal;
    }

    /**
     * @param posicionFinal the posicionFinal to set
     */
    public void setPosicionFinal(Point posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    /**
     * @return the sprites
     */
    public Sprite[] getSprites() {
        return sprites;
    }

    /**
     * @param sprites the sprites to set
     */
    public void setSprites(Sprite[] sprites) {
        this.sprites = sprites.clone();
    }

    /**
     * @return the seleccion
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
    
    protected abstract void definirSprites();
    
    private int identificarDireccion(Point inicial, Point fin) {
        if(inicial.getX() == fin.getX()) {
            if(inicial.getY() == fin.getY())
                return -1;
            else if(inicial.getY() > fin.getY())
                return NORTE;
            else
                return SUR;
        }
        else if(inicial.getY() == fin.getY()) {
            if(inicial.getX() < fin.getX())
                return ESTE;
            else
                return OESTE;
        }
        else if(inicial.getX() < fin.getX()) {
            if(inicial.getY() > fin.getY())
                return NORESTE;
            else
                return SURESTE;
        }
        else if(inicial.getX() > fin.getX()) {
            if(inicial.getY() > fin.getY())
                return NOROESTE;
            else
                return SUROESTE;
        }
        return -1;
    }
    
    private Sprite buscarSprite(int direccion) {
        for(int i = 0; i < sprites.length; i++)
            if(direccion == sprites[i].getDireccion())
                return sprites[i];
        return null;
    }
    
    private Sprite spriteActual() {
        if(!posicionInicial.equals(posicionFinal)) {
            int buscar = identificarDireccion(posicionInicial, posicionFinal);
            for(int i = 0; i < sprites.length; i++)
                if(buscar == sprites[i].getDireccion())
                    return sprites[i];
        }
        return spriteActual;
    }
    
    private boolean colisionPanel(Point colision) {
        if((spriteActual.getDireccion() == NORTE) && 
                ((colision.getY()-spriteActual.getDimension().getAlto()/2) <= 0)) {
            spriteActual = buscarSprite(SUR);
            return true;
        }
        else if((spriteActual.getDireccion() == SUR) && 
                ((colision.getY()+spriteActual.getDimension().getAlto()/2) >= panel.getHeight())) {
            spriteActual = buscarSprite(NORTE);
            return true;
        }
        else if((spriteActual.getDireccion() == ESTE) && 
                ((colision.getX()+spriteActual.getDimension().getAncho()/2) >= panel.getWidth())) {
            spriteActual = buscarSprite(OESTE);
            return true;
        }
        else if((spriteActual.getDireccion() == OESTE) && 
                ((colision.getX()-spriteActual.getDimension().getAncho()/2) <= 0)) {
            spriteActual = buscarSprite(ESTE);
            return true;
        }
        else if(spriteActual.getDireccion() == NORESTE) {
            if((colision.getY()-spriteActual.getDimension().getAlto()/2) <= 0) {
                spriteActual = buscarSprite(SURESTE);
                return true;
            }
            else if((colision.getX()+spriteActual.getDimension().getAncho()/2) >= panel.getWidth()) {
                spriteActual = buscarSprite(NOROESTE);
                return true;
            }
        }
        else if(spriteActual.getDireccion() == NOROESTE) {
            if((colision.getY()-spriteActual.getDimension().getAlto()/2) <= 0) {
                spriteActual = buscarSprite(SUROESTE);
                return true;
            }
            else if((colision.getX()-spriteActual.getDimension().getAncho()/2) <= 0) {
                spriteActual = buscarSprite(NORESTE);
                return true;
            }
        }
        else if(spriteActual.getDireccion() == SURESTE) {
            if((colision.getY()+spriteActual.getDimension().getAlto()/2) >= panel.getHeight()) {
                spriteActual = buscarSprite(NORESTE);
                return true;
            }
            else if((colision.getX()+spriteActual.getDimension().getAncho()/2) >= panel.getWidth()) {
                spriteActual = buscarSprite(SUROESTE);
                return true;
            }
        }
        else if(spriteActual.getDireccion() == SUROESTE) {
            if((colision.getY()+spriteActual.getDimension().getAlto()/2) >= panel.getHeight()) {
                spriteActual = buscarSprite(NOROESTE);
                return true;
            }
            else if((colision.getX()-spriteActual.getDimension().getAncho()/2) <= 0) {
                spriteActual = buscarSprite(SURESTE);
                return true;
            }
        }
        return false;
    }
    
    public boolean colisionDestruir(LinkedList<Aeronave> aeronaves) {
        for(Aeronave a : aeronaves) 
            if((a.compareTo(this) == -1) && (getBounds().intersects(a.getBounds())) && (altura == a.getAltura())) {
                detenerHilo = true;
                destruir = true;
                return true;
            }
        return false;
    }
    
    private Point puntoExplosion(Aeronave a) {
        Point explosion = getBounds().union(a.getBounds()).getLocation();
        explosion.setLocation(explosion.getX()/2, explosion.getY()/2);
        return explosion;
    }
    
    private Point continuarMovimiento(Point fin) { {
        if(spriteActual.getDireccion() == NORTE)
            fin.setLocation(fin.getX(), fin.getY()-1);
        else if(spriteActual.getDireccion() == SUR)
            fin.setLocation(fin.getX(), fin.getY()+1);
        else if(spriteActual.getDireccion() == ESTE)
            fin.setLocation(fin.getX()+1, fin.getY());
        else if(spriteActual.getDireccion() == OESTE)
            fin.setLocation(fin.getX()-1, fin.getY());
        else if(spriteActual.getDireccion() == NORESTE)
            fin.setLocation(fin.getX()+1, fin.getY()-1);
        else if(spriteActual.getDireccion() == NOROESTE)
            fin.setLocation(fin.getX()-1, fin.getY()-1);
        else if(spriteActual.getDireccion() == SURESTE)
            fin.setLocation(fin.getX()+1, fin.getY()+1);
        else if(spriteActual.getDireccion() == SUROESTE)
            fin.setLocation(fin.getX()-1, fin.getY()+1);
        }
        return fin;
    }
    
    private Point mover(Point inicial, Point fin) {
        if(identificarDireccion(inicial, fin) != -1) {
            if(identificarDireccion(inicial, fin) == NORTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX(), inicial.getY()-1);
            }
            else if(identificarDireccion(inicial, fin) == SUR) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX(), inicial.getY()+1);
            }
            else if(identificarDireccion(inicial, fin) == ESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()+1, inicial.getY());
            }
            else if(identificarDireccion(inicial, fin) == OESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()-1, inicial.getY());
            }
            else if(identificarDireccion(inicial, fin) == NORESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()+1, inicial.getY()-1);
            }
            else if(identificarDireccion(inicial, fin) == NOROESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()-1, inicial.getY()-1);
            }
            else if(identificarDireccion(inicial, fin) == SURESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()+1, inicial.getY()+1);
            }
            else if(identificarDireccion(inicial, fin) == SUROESTE) {
                spriteActual = spriteActual();
                inicial.setLocation(inicial.getX()-1, inicial.getY()+1);
            }
        }
        return inicial;
    }
    
    private void moverAutomatico() {
        if(posicionInicial.equals(posicionFinal) && ruta.size()>0) {
            casillaEspacio.setOcupado(-1);
            Nodo actual = ruta.pop();
            posicionFinal = actual.getPosicion();
            casillaEspacio.setOcupado(id);
        }
        posicionInicial = mover(posicionInicial, posicionFinal);
    }
    
    private void moverManual() {
            if(posicionInicial.equals(posicionFinal)) {
                if(!colisionPanel(posicionFinal)) {
                    posicionFinal = continuarMovimiento(posicionFinal);
                    posicionInicial = mover(posicionInicial, posicionFinal);
                }
            }
            else {
                if(colisionPanel(posicionInicial))
                    posicionFinal = posicionInicial;
                posicionInicial = mover(posicionInicial, posicionFinal);
            }
    }
    
    protected void mover() {
        if(!panel.getJuego().getPilotoAutomatico())
            moverManual();
        else
            moverAutomatico();
    }
    
    public void subirAltura() {
        if((altura + 50) <= alturaMaxima)
            altura = altura + 50;
    }
    
    public void bajarAltura() {
        if((altura - 50) > 0)
            altura = altura - 50;
    }
    
    public void subirVelocidad() {
        if((velocidad + 50) <= velocidadMaxima)
            velocidad = velocidad + 50;
    }
    
    public void bajarVelocidad() {
        if((velocidad - 50) > 0)
            velocidad = velocidad - 50;
    }
     
    protected Rectangle getBounds() {
        return new Rectangle((int)posicionInicial.getX() - spriteActual.getDimension().getAncho()/2, 
                (int)posicionInicial.getY() - spriteActual.getDimension().getAlto()/2, 
                spriteActual.getDimension().getAncho(), spriteActual.getDimension().getAlto());
    }
    
    protected void paint(Graphics2D g) {
        spriteActual.getImagen().paintIcon(panel, g, (int)posicionInicial.getX()-spriteActual.getDimension().getAncho()/2,
                (int)posicionInicial.getY()-spriteActual.getDimension().getAlto()/2);
        if(isSeleccion()) {
            g.setColor(Color.red);
            g.drawOval((int)posicionInicial.getX() - spriteActual.getDimension().getAncho()/2, 
            (int)posicionInicial.getY() - spriteActual.getDimension().getAlto()/2, 
            spriteActual.getDimension().getAncho(), spriteActual.getDimension().getAlto());
            if(this instanceof Carga || this instanceof Helicoptero)
                g.setColor(Color.black);
            else
                g.setColor(Color.white);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
            //g.drawString(""+(altura), posicionInicial.x, posicionInicial.y-15);
        }
        g.drawString(""+(altura), posicionInicial.x, posicionInicial.y-15);
        g.drawString(""+(velocidad), posicionInicial.x, posicionInicial.y+15);
    }

    /**
     * @return the spriteActual
     */
    public Sprite getSpriteActual() {
        return spriteActual;
    }

    /**
     * @param spriteActual the spriteActual to set
     */
    public void setSpriteActual(Sprite spriteActual) {
        this.spriteActual = spriteActual;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if(id == ((Aeronave)o).getId())
            return 0;
        return -1;
    }
    
    @Override
    public void run() {
        while(!detenerHilo){
            try {
                if(panel.getJuego().getPilotoAutomatico()){
                    if(casillaEspacio.isLlegadaAvion(this))
                        detenerHilo = true;
                    if(haCambiadoNodo() != -1 || ruta.isEmpty())
                        generarRuta();
                }
                mover();
                Thread.sleep((5000/velocidad));
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeronave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the destruir
     */
    public boolean isDestruir() {
        return destruir;
    }

    /**
     * @param destruir the destruir to set
     */
    public void setDestruir(boolean destruir) {
        this.destruir = destruir;
    }

    /**
     * @return the detenerHilo
     */
    public boolean isDetenerHilo() {
        return detenerHilo;
    }

    /**
     * @param detenerHilo the detenerHilo to set
     */
    public void setDetenerHilo(boolean detenerHilo) {
        this.detenerHilo = detenerHilo;
    }
    
    private LinkedList<Nodo> posiblesLlegadas(){
        Juego j = panel.getJuego();
        LinkedList<Nodo> nodoes = new LinkedList<>();

        for (Nodo n : j.getLlegadas())
            if(n.isLlegadaAvion(this))
                nodoes.add(n);        
        
        return nodoes;
    }

    /**
     * @return the ordenAterrizaje
     */
    public boolean isOrdenAterrizaje() {
        return ordenAterrizaje;
    }

    /**
     * @param ordenAterrizaje the ordenAterrizaje to set
     */
    public void setOrdenAterrizaje(boolean ordenAterrizaje) {
        this.ordenAterrizaje = ordenAterrizaje;
    }

}
