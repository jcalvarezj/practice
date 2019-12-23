/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import pkgHeaps.HeapNodo;

/**
 * Clase que modela un Nodo como abstracción de una casilla
 * del espacio del juego, para construir una solución a la 
 * busqueda del camino
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Nodo implements Comparable, Cloneable {
    
    public final static int N = 0;
    public final static int S = 4;
    public final static int E = 7;
    public final static int W = 3;
    public final static int NW = 2;
    public final static int NE = 1;
    public final static int SW = 6;
    public final static int SE = 5;
    public final static int AR = 8;
    public final static int AB = 9;
    public final static int ARN = 11;
    public final static int ARS = 13;
    public final static int ARW = 12;
    public final static int ARE = 10;    
    public final static int ABN = 15;
    public final static int ABS = 17;
    public final static int ABW = 16;
    public final static int ABE = 14;
    
    private int id;
    
    /**
     * Nodos hijos (adyacentes candidatos), y padre, respectivamente
     */
    /*private Nodo norte = new Nodo(-1, altura, espacio, i, j, k),
    norEste = new Nodo(-2, altura, espacio, i, j, k),
    norOeste = new Nodo(-3, altura, espacio, i, j, k),
    oeste = new Nodo(-4, altura, espacio, i, j, k),
    sur = new Nodo(-5, altura, espacio, i, j, k),
    surEste = new Nodo(-6, altura, espacio, i, j, k),
    surOeste = new Nodo(-7, altura, espacio, i, j, k),
    este = new Nodo(-8, altura, espacio, i, j, k),
    arriba = new Nodo(-9, altura, espacio, i, j, k),
    abajo = new Nodo(-10, altura, espacio, i, j, k),
    arribaEste = new Nodo(-11, altura, espacio, i, j, k),
    arribaNorte = new Nodo(-12, altura, espacio, i, j, k),
    arribaOeste = new Nodo(-13, altura, espacio, i, j, k),
    arribaSur = new Nodo(-14, altura, espacio, i, j, k),
    abajoEste = new Nodo(-15, altura, espacio, i, j, k),
    abajoNorte = new Nodo(-16, altura, espacio, i, j, k),
    abajoOeste = new Nodo(-17, altura, espacio, i, j, k),
    abajoSur = new Nodo(-18, altura, espacio, i, j, k),*/
    
    private Nodo norte, sur, este, oeste, norOeste, norEste, surEste, surOeste, 
            arribaNorte, arribaSur, arribaEste, arribaOeste, abajoNorte, abajoSur,
            abajoEste, abajoOeste, arriba, abajo, padre;
    
    /**
     * Posicion de la casilla del mapa a la que refiere esta abstracción
     */
    private Point posicion;
    /**
     * Altura de la casilla del mapa a la que refiere esta abstracción
     */
    private int altura;
    /**
     * Mapa relacionado
     */
    private Nodo[][][] espacio;
    
    /**
     * Aeropuerto relacionado al nodo que indica que se trata de un Nodo llegada
     */
    private Aeropuerto aeropuerto;
    
    /**
     * Indices de posicion del Nodo en el espacio
     */
    private int i, j, k;
    
    /**
     * Valor que indica si el nodo se encuentra ocupada
     */
    private int ocupado;
    
    /**
     * Diccionario de relacion de id de aeronave y valores f, g, h para considerar
     */
    private HashMap<Integer,Float[]> diccionario;

    /**
     * Crea un nuevo Nodo con la posición dada
     * @param posicion 
     */
    public Nodo(int id, Point posicion, int altura, Nodo[][][] espacio, int i, int j, int k) {
        this.id = id;
        this.posicion = posicion;
        this.espacio = espacio;
        this.altura = altura;
        this.i = i;
        this.j = j;
        this.k = k;
        diccionario = new HashMap<>();  
        ocupado = -1;
        
    }
        
    /**
     * Crea un nuevo Nodo con la posición dada
     * @param posicion 
     */
    public Nodo(int id, int altura, Nodo[][][] espacio, int i, int j, int k) {
        this.id = id;
        this.espacio = espacio;
        this.altura = altura;
        this.i = i;
        this.j = j;
        this.k = k;
        posicion = new Point(30+60*(j),30+60*(i)-11);
        altura = (k+1)*50;
        diccionario = new HashMap<>();
        ocupado = -1;
    
    }
    
    /**
     * Metodo que calcula la heurística estimada por "distancia directa al objetivo"
     * (Heurística de Manhattan)
     * @param objetivo Nodo objetivo
     * @return Valor de heurística estimado
     */
    public static int pasosManhattan(Nodo i, Nodo f){
        return Math.abs(i.getPosicion().x - f.getPosicion().x) + Math.abs(i.getPosicion().y - f.getPosicion().y
                + i.getAltura() - f.getAltura());
    }
    
/*7    
    private void ponerNodos(){
        
        LinkedList<Nodo> a = new LinkedList<>();
        for (int l = 1; l < 19; l++) 
            a.add(new Nodo(l, altura, espacio, i, j, k));
                
        norte = a.get(0);
        norEste = a.get(1);
        norOeste = a.get(2);
        oeste = a.get(3);
        sur = a.get(4);
        surEste = a.get(5);
        surOeste = a.get(6);
        este = a.get(7);
        arriba = a.get(8);
        abajo = a.get(9);
        arribaEste = a.get(10);
        arribaNorte = a.get(11);
        arribaOeste = a.get(12);
        arribaSur = a.get(13);
        abajoEste = a.get(14);
        abajoNorte = a.get(15);
        abajoOeste = a.get(16);
        abajoSur = a.get(17);
    }
   */
    
    /*
     * public int pasosManhattan(Nodo objetivo){
        return Math.abs(posicion.x - objetivo.getPosicion().x) + Math.abs(posicion.y - objetivo.getPosicion().y);
    }
     */
    
    /**
     * Actualiza el valor de evaluacion 'f' por medio de la mínima heurística
     * PRE! inicio != null && otros!=null && otros.size()>0
     *      se haya seteado el valor 'g'
     * Post se ha actualizado el valor de la heurística con la mínima (si no se ha
     * calculado) y de la función de evaluación
     * @param llegadas 
     */
    //public void actualizarHeuristicaOptima(LinkedList<Nodo> otros){
    public void actualizarHeuristicaOptima(Integer idAvion, LinkedList<Nodo> llegadas){ 
        //if(getHAeronave(idAvion) == 0)
        //{
            LinkedList<Float> heuristicas = new LinkedList<>();
            int menor = 0;
            for (Nodo nodo : llegadas) {
                
                heuristicas.add(calcularHeuristica(nodo));
            }
            for (int l = 1; l < heuristicas.size(); l++)
               if(heuristicas.get(l) < heuristicas.get(menor))
                   menor = l;
    
            if(heuristicas.size() == 0)
                JOptionPane.showMessageDialog(null, "PROBLEMA! NO HAY SALIDA PARA ALGUNA NAVE!");
            
            setHAeronave(idAvion, heuristicas.get(menor));
            
            setFAeronave(idAvion, getGAeronave(idAvion) + getHAeronave(idAvion));
        //}
        //else
          //  setFAeronave(idAvion, getGAeronave(idAvion) + getHAeronave(idAvion));
    }
    
    public static float pasosDiagonales(Nodo i, Nodo f){
        float dx = Math.abs(i.getPosicion().x - f.getPosicion().x);
        float dy = Math.abs(i.getPosicion().y - f.getPosicion().y);
        float dz = Math.abs(i.getAltura() - f.getAltura());
        
        float menor = dx;
        if(dy < menor)
            menor = dy;
        if(dz < menor)
            menor = dz;
        return menor;
    }
    
    public static float pasosOrtogonales(Nodo i, Nodo f){
        return pasosManhattan(i,f) - 2*pasosDiagonales(i,f);
    }
    
//    public void actualizarHeuristica(Nodo llegada){
//        diccionario.get(llegada.getId())[2] = (float) (pasosOrtogonales(this, llegada) + 103.923*pasosDiagonales(this, llegada));
//        diccionario.get(llegada.getId())[1] = diccionario.get(llegada.getId())[0] + diccionario.get(llegada.getId())[2];
//    }
    
    public float calcularHeuristica(Nodo llegada){
        return (float) (pasosOrtogonales(this, llegada) + 103.923*pasosDiagonales(this, llegada));
    }
    
    //public int costoAdyacentesBasico(){
      //  return 40;
    //}
    
    public static float costoSucesor(int cual){
        float costo = 0;
        if(cual == N || cual == S || cual == E || cual == W || cual == AR || cual == AB)
            costo = 60;
        if(cual == NW || cual == SW || cual == NE || cual == SE || cual == ARN || cual == ARS || cual == ARE
                || cual == ARW || cual == ABN || cual == ABS || cual == ABE || cual == ABW)
            costo = (float) 84.853;
        return costo;
    }
    
    /**
     * Método que calcula la evaluación de la heurística respecto al costo
     * @param g
     * @param h
     * @return 
     */
    public int evaluacion(int g, int h){
        return g+h;
    }
    
    public void setFAeronave(int id, float f){
        if(!diccionario.containsKey(id)) {
            Float[] vector = {(float)0, (float)0, (float)0};
            diccionario.put(id, vector);
        }
        diccionario.get(id)[1] = f;
    }
    
    public float getFAeronave(int id){
        if(diccionario.containsKey(id)) {
            //System.out.println("Es el id null?: "+diccionario.get(id)[0]+" "+diccionario.get(id)[1]+ " "+ diccionario.get(id)[2]);
            return diccionario.get(id)[1];
        }
        return 0;
    }
    
    public void setGAeronave(int id, float g){
        if(!diccionario.containsKey(id)) {
            Float[] vector = {(float)0, (float)0, (float)0}; 
            diccionario.put(id, vector);
        }
        diccionario.get(id)[0] = g;
    }
    
    public float getGAeronave(int id){
        if(diccionario.containsKey(id))
            return diccionario.get(id)[0];
        return 0;
    }
    
    public void setHAeronave(int id, float h){
        if(!diccionario.containsKey(id)) {
            Float[] vector = {(float)0, (float)0, (float)0};
            diccionario.put(id, vector);
        }
        diccionario.get(id)[2] = h;
    }
    
    public float getHAeronave(int id){
        if(diccionario.containsKey(id)) 
            return diccionario.get(id)[2];
        return 0;
    }
    
    //Respectivos getters y setters que modifican y retornan atributos

    public Nodo getNorte() {
        return norte;
    }

    public Nodo getSur() {
        return sur;
    }

    public Nodo getEste() {
        return este;
    }

    public Nodo getOeste() {
        return oeste;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setNorte(Nodo norte) {
        this.norte = norte;
    }

    public Nodo getNorOeste() {
        return norOeste;
    }

    public void setNorOeste(Nodo norOeste) {
        this.norOeste = norOeste;
    }

    public Nodo getNorEste() {
        return norEste;
    }

    public void setNorEste(Nodo norEste) {
        this.norEste = norEste;
    }

    public Nodo getSurEste() {
        return surEste;
    }

    public void setSurEste(Nodo surEste) {
        this.surEste = surEste;
    }

    public Nodo getSurOeste() {
        return surOeste;
    }

    public void setSurOeste(Nodo surOeste) {
        this.surOeste = surOeste;
    }

    public Nodo getArribaNorte() {
        return arribaNorte;
    }

    public void setArribaNorte(Nodo arribaNorte) {
        this.arribaNorte = arribaNorte;
    }

    public Nodo getArribaSur() {
        return arribaSur;
    }

    public void setArribaSur(Nodo arribaSur) {
        this.arribaSur = arribaSur;
    }

    public Nodo getArribaEste() {
        return arribaEste;
    }

    public void setArribaEste(Nodo arribaEste) {
        this.arribaEste = arribaEste;
    }

    public Nodo getArribaOeste() {
        return arribaOeste;
    }

    public void setArribaOeste(Nodo arribaOeste) {
        this.arribaOeste = arribaOeste;
    }

    public Nodo getAbajoNorte() {
        return abajoNorte;
    }

    public void setAbajoNorte(Nodo abajoNorte) {
        this.abajoNorte = abajoNorte;
    }

    public Nodo getAbajoSur() {
        return abajoSur;
    }

    public void setAbajoSur(Nodo abajoSur) {
        this.abajoSur = abajoSur;
    }

    public Nodo getAbajoEste() {
        return abajoEste;
    }

    public void setAbajoEste(Nodo abajoEste) {
        this.abajoEste = abajoEste;
    }

    public Nodo getAbajoOeste() {
        return abajoOeste;
    }

    public void setAbajoOeste(Nodo abajoOeste) {
        this.abajoOeste = abajoOeste;
    }

    public Nodo getArriba() {
        return arriba;
    }

    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    public void setSur(Nodo sur) {
        this.sur = sur;
    }

    public void setEste(Nodo este) {
        this.este = este;
    }

    public void setOeste(Nodo oeste) {
        this.oeste = oeste;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Nodo[][][] getEspacio() {
        return espacio;
    }

    public void setEspacio(Nodo[][][] espacio) {
        this.espacio = espacio;
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
        if(id == ((Nodo)o).getId())
            return 0;
        return -1;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }
    
    public LinkedList<Nodo> getSucesores(HeapNodo anotados){
        LinkedList<Nodo> l = new LinkedList<>();
        LinkedList<Nodo> lista = anotados.getLista();
        if(!lista.contains(norte))
            l.add(norte);
        else
            l.add(null);
        if(!lista.contains(norEste))
            l.add(norEste);
        else
            l.add(null);
        if(!lista.contains(norOeste))
            l.add(norOeste);
        else
            l.add(null);
        if(!lista.contains(oeste))
            l.add(oeste);
        else
            l.add(null);
        if(!lista.contains(sur))
            l.add(sur);
        else
            l.add(null);
        if(!lista.contains(surEste))
            l.add(surEste);
        else
            l.add(null);
        if(!lista.contains(surOeste))
            l.add(surOeste);
        else
            l.add(null);
        if(!lista.contains(este))
            l.add(este);
        else
            l.add(null);
        if(!lista.contains(arriba))
            l.add(arriba);
        else
            l.add(null);
        if(!lista.contains(abajo))
            l.add(abajo);
        else
            l.add(null);
        if(!lista.contains(arribaEste))
            l.add(arribaEste);
        else
            l.add(null);
        if(!lista.contains(arribaNorte))
            l.add(arribaNorte);
        else
            l.add(null);
        if(!lista.contains(arribaOeste))
            l.add(arribaOeste);
        else
            l.add(null);
        if(!lista.contains(arribaSur))
            l.add(arribaSur);
        else
            l.add(null);
        if(!lista.contains(abajoEste))
            l.add(abajoEste);
        else
            l.add(null);
        if(!lista.contains(abajoNorte))
            l.add(abajoNorte);
        else
            l.add(null);
        if(!lista.contains(abajoOeste))
            l.add(abajoOeste);
        else
            l.add(null);
        if(!lista.contains(abajoSur))
            l.add(abajoSur);
        else
            l.add(null);
        return l;
    }
    
    public LinkedList<Nodo> getSucesores(HeapNodo anotados, int id){
        LinkedList<Nodo> l = new LinkedList<>();
        LinkedList<Nodo> lista = anotados.getLista();
        if(!lista.contains(norte)){
            if(norte != null && (norte.getOcupado() == -1 || norte.getOcupado() == id))
                l.add(norte);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(norEste)){
            if(norEste != null && (norEste.getOcupado() == -1 || norEste.getOcupado() == id))
                l.add(norEste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(norOeste)){
            if(norOeste != null && (norOeste.getOcupado() == -1 || norOeste.getOcupado() == id))
                l.add(norOeste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(oeste)){
            if(oeste != null && (oeste.getOcupado() == -1 || oeste.getOcupado() == id))
                l.add(oeste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(sur)){
            if(sur != null && (sur.getOcupado() == -1 || sur.getOcupado() == id))
                l.add(sur);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(surEste)){
            if(surEste != null && (surEste.getOcupado() == -1 || surEste.getOcupado() == id))
                l.add(surEste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(surOeste)){
            if(surOeste != null && (surOeste.getOcupado() == -1 || surOeste.getOcupado() == id))
                l.add(surOeste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(este)){
            if(este != null && (este.getOcupado() == -1 || este.getOcupado() == id))
                l.add(este);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(arriba)){
            if(arriba != null && (arriba.getOcupado() == -1 || arriba.getOcupado() == id))
                l.add(arriba);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(abajo)){
            if(abajo != null && (abajo.getOcupado() == -1 || abajo.getOcupado() == id))
                l.add(abajo);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(arribaEste)){
            if(arribaEste != null && (arribaEste.getOcupado() == -1 || arribaEste.getOcupado() == id))
                l.add(arribaEste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(arribaNorte)){
            if(arribaNorte != null && (arribaNorte.getOcupado() == -1 || arribaNorte.getOcupado() == id))
                l.add(arribaNorte);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(arribaOeste)){
            if(arribaOeste != null && (arribaOeste.getOcupado() == -1 || arribaOeste.getOcupado() == id))
                l.add(arribaOeste);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(arribaSur)){
            if(arribaSur != null && (arribaSur.getOcupado() == -1 || arribaSur.getOcupado() == id))
                l.add(arribaSur);
            else
                l.add(null);
        }
        else
            l.add(null);
        if(!lista.contains(abajoEste)){
            if(abajoEste != null && (abajoEste.getOcupado() == -1 || abajoEste.getOcupado() == id))
                l.add(abajoEste);
            else
                l.add(null);
        }
        else
            l.add(null);
            if(!lista.contains(abajoNorte)){
            if(abajoNorte != null && (abajoNorte.getOcupado() == -1 || abajoNorte.getOcupado() == id))
                l.add(abajoNorte);
            else
                l.add(null);
        }
        else
            l.add(null);
            if(!lista.contains(abajoOeste)){
            if(abajoOeste != null && (abajoOeste.getOcupado() == -1 || abajoOeste.getOcupado() == id))
                l.add(abajoOeste);
            else
                l.add(null);
        }
        else
            l.add(null);
            if(!lista.contains(abajoSur)){
            if(abajoSur != null && (abajoSur.getOcupado() == -1 || abajoSur.getOcupado() == id))
                l.add(abajoSur);
            else
                l.add(null);
        }
        else
            l.add(null);
        
        /*        
        if(!lista.contains(norEste) && norEste.getOcupado() < 0)
            l.add(norEste);
        else
            l.add(null);
        if(!lista.contains(norOeste) && norOeste.getOcupado() < 0)
            l.add(norOeste);
        else
            l.add(null);
        if(!lista.contains(oeste)  && norOeste.getOcupado() == 0)
            l.add(oeste);
        else
            l.add(null);
        if(!lista.contains(sur) && sur.getOcupado() == 0)
            l.add(sur);
        else
            l.add(null);
        if(!lista.contains(surEste) && surEste.getOcupado() == 0)
            l.add(surEste);
        else
            l.add(null);
        if(!lista.contains(surOeste) && surOeste.getOcupado() == 0)
            l.add(surOeste);
        else
            l.add(null);
        if(!lista.contains(este) && este.getOcupado() == 0)
            l.add(este);
        else
            l.add(null);
        if(!lista.contains(arriba) && arriba.getOcupado() == 0)
            l.add(arriba);
        else
            l.add(null);
        if(!lista.contains(abajo) && abajo.getOcupado() == 0)
            l.add(abajo);
        else
            l.add(null);
        if(!lista.contains(arribaEste) && arribaEste.getOcupado() == 0)
            l.add(arribaEste);
        else
            l.add(null);
        if(!lista.contains(arribaNorte) && arribaNorte.getOcupado() == 0)
            l.add(arribaNorte);
        else
            l.add(null);
        if(!lista.contains(arribaOeste) && arribaOeste.getOcupado() == 0)
            l.add(arribaOeste);
        else
            l.add(null);
        if(!lista.contains(arribaSur) &&  arribaSur.getOcupado() == 0)
            l.add(arribaSur);
        else
            l.add(null);
        if(!lista.contains(abajoEste) && abajoEste.getOcupado() == 0)
            l.add(abajoEste);
        else
            l.add(null);
        if(!lista.contains(abajoNorte)  && abajoNorte.getOcupado() == 0)
            l.add(abajoNorte);
        else
            l.add(null);
        if(!lista.contains(abajoOeste) && abajoOeste.getOcupado() == 0)
            l.add(abajoOeste);
        else
            l.add(null);
        if(!lista.contains(abajoSur) && abajoSur.getOcupado() == 0)
            l.add(abajoSur);
        else
            l.add(null);*/
        return l;
    }
    
//    public LinkedList<Nodo> getSucesores(HeapNodo anotados){
//        LinkedList<Nodo> l = new LinkedList<>();
//        LinkedList<Nodo> lista = anotados.getLista();
//        if(!lista.contains(norte) && norte.getOcupado() < 0)
//            l.add(norte);
//        else
//            l.add(new Nodo(-1, altura, espacio, i, j, k));
//            l.add(null);
//        if(!lista.contains(norEste) && norEste.getOcupado() < 0)
//            l.add(norEste);
//        else
//            l.add(new Nodo(-2, altura, espacio, i, j, k));
//        if(!lista.contains(norOeste) && norOeste.getOcupado() < 0)
//            l.add(norOeste);
//        else
//            l.add(new Nodo(-3, altura, espacio, i, j, k));;
//        if(!lista.contains(oeste)  && norOeste.getOcupado() == 0)
//            l.add(oeste);
//        else
//            l.add(new Nodo(-4, altura, espacio, i, j, k));;
//        if(!lista.contains(sur) && sur.getOcupado() == 0)
//            l.add(sur);
//        else
//            l.add(new Nodo(-5, altura, espacio, i, j, k));;
//        if(!lista.contains(surEste) && surEste.getOcupado() == 0)
//            l.add(surEste);
//        else
//            l.add(new Nodo(-6, altura, espacio, i, j, k));;
//        if(!lista.contains(surOeste) && surOeste.getOcupado() == 0)
//            l.add(surOeste);
//        else
//            l.add(new Nodo(-7, altura, espacio, i, j, k));;
//        if(!lista.contains(este) && este.getOcupado() == 0)
//            l.add(este);
//        else
//            l.add(new Nodo(-8, altura, espacio, i, j, k));;
//        if(!lista.contains(arriba) && arriba.getOcupado() == 0)
//            l.add(arriba);
//        else
//            l.add(new Nodo(-9, altura, espacio, i, j, k));;
//        if(!lista.contains(abajo) && abajo.getOcupado() == 0)
//            l.add(abajo);
//        else
//            l.add(new Nodo(-10, altura, espacio, i, j, k));;
//        if(!lista.contains(arribaEste) && arribaEste.getOcupado() == 0)
//            l.add(arribaEste);
//        else
//            l.add(new Nodo(-11, altura, espacio, i, j, k));;
//        if(!lista.contains(arribaNorte) && arribaNorte.getOcupado() == 0)
//            l.add(arribaNorte);
//        else
//            l.add(new Nodo(-12, altura, espacio, i, j, k));;
//        if(!lista.contains(arribaOeste) && arribaOeste.getOcupado() == 0)
//            l.add(arribaOeste);
//        else
//            l.add(new Nodo(-13, altura, espacio, i, j, k));;
//        if(!lista.contains(arribaSur) &&  arribaSur.getOcupado() == 0)
//            l.add(arribaSur);
//        else
//            l.add(new Nodo(-14, altura, espacio, i, j, k));;
//        if(!lista.contains(abajoEste) && abajoEste.getOcupado() == 0)
//            l.add(abajoEste);
//        else
//            l.add(new Nodo(-15, altura, espacio, i, j, k));;
//        if(!lista.contains(abajoNorte)  && abajoNorte.getOcupado() == 0)
//            l.add(abajoNorte);
//        else
//            l.add(new Nodo(-16, altura, espacio, i, j, k));;
//        if(!lista.contains(abajoOeste) && abajoOeste.getOcupado() == 0)
//            l.add(abajoOeste);
//        else
//            l.add(new Nodo(-17, altura, espacio, i, j, k));;
//        if(!lista.contains(abajoSur) && abajoSur.getOcupado() == 0)
//            l.add(abajoSur);
//        else
//            l.add(new Nodo(-18, altura, espacio, i, j, k));;
//        return l;
//    }
 
    public boolean isLlegadaAvion(Aeronave a){
        if(aeropuerto == null)
           return false;
       else
           return aeropuerto.puedeAterrizar(a);
    }
    
    @Override
    public String toString() {
        return id+":("+i+","+j+","+k+")";
    }
    
}