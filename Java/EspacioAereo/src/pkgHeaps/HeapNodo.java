/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgHeaps;

import java.util.LinkedList;
import pkgModelo.Aeronave;
import pkgModelo.Nodo;

/**
 * Modela la estructura de Nodos basandose en el valor 'f'
 * @author Juan Camilo Alvarez J.
 */
public class HeapNodo {
    
    LinkedList<Nodo> lista;

    public HeapNodo() {
        lista = new LinkedList<>();
    }

    public HeapNodo(LinkedList<Nodo> lista) {
        this.lista = lista;
    }
    
    /**
     * cambia la posicion de dos elementos en una lista
     * @param posicionA
     * @param posicionB
     * @param lista 
     */
    private void exChange(int posicionA, int posicionB) {
        Nodo auxiliar = lista.get(posicionA);
        lista.set(posicionA, lista.get(posicionB));
        lista.set(posicionB, auxiliar);
    }
    
    /**
     * me retorna la posicion del padre desde la posicion del hijo
     * @param posicionHijo
     * @return 
     */
    private int parent(int posicionHijo) {
        return posicionHijo/2;
    }
    
    /**
     * me retorna la posicion del hijo izquierdo desde la posicion del padre
     * @param posicionPadre
     * @return 
     */
    private int left(int posicionPadre) {
        return 2*posicionPadre;
    }
    
    /**
     * me retorna la posicion del hijo derecho desde la posicion del padre
     * @param posicionPadre
     * @return 
     */
    private int right(int posicionPadre) {
        return 2*posicionPadre + 1;
    }
    
    /**
     * metodo que mantiene la propiedad del heap minimo desde una posicion determinada en adelante
     * @param lista
     * @param posicionInicial
     * @param heapSize 
     */
    private void minHeapify(int posicionInicial, int heapSize, Aeronave aero) {
        int left = left(posicionInicial);
        int right = right(posicionInicial);
        int shortest;
        if((left <= heapSize) && (lista.get(left).getFAeronave(aero.getId()) < lista.get(posicionInicial).getFAeronave(aero.getId())))
            shortest = left;
        else
            shortest = posicionInicial;
        if((right <= heapSize) && (lista.get(right).getFAeronave(aero.getId()) < lista.get(shortest).getFAeronave(aero.getId())))
            shortest = right;
        if(shortest != posicionInicial){
            exChange(posicionInicial, shortest);
            minHeapify(shortest, heapSize, aero);
        }
    }
    
    /**
     * metodo que mantiene la propiedad del heap maximo desde una posicion determinada en adelante
     * @param lista
     * @param posicionInicial 
     */
    private void maxHeapify(int posicionInicial, int heapSize, Aeronave aero) {
        int left = left(posicionInicial);
        int right = right(posicionInicial);
        int largest;
        if((left <= heapSize) && (lista.get(left).getFAeronave(aero.getId()) > lista.get(posicionInicial).getFAeronave(aero.getId())))
            largest = left;
        else
            largest = posicionInicial;
        if((right <= heapSize) && (lista.get(right).getFAeronave(aero.getId()) > lista.get(largest).getFAeronave(aero.getId())))
            largest = right;
        if(largest != posicionInicial){
            exChange(posicionInicial, largest);
            maxHeapify(largest, heapSize, aero);
        }
    }
    
    /**
     * metodo que me construye el heap minimo
     * @param lista
     * @param heapSize 
     */
    private void buildMinHeap(int heapSize, Aeronave aero) {
        for(int i = ((lista.size()-1)/2); i >= 0; i--)
            minHeapify(i, heapSize, aero);
    }
    
    /**
     * metodo que me construye el heap maximo
     * @param lista
     * @param heapSize 
     */
    private void buildMaxHeap(int heapSize, Aeronave aero) {
        for(int i = ((lista.size()-1)/2); i >= 0; i--)
            maxHeapify(i, heapSize, aero);
    }
    
    /**
     * metodo heapsort minimo, los valores quedan en orden descendente
     * @param lista 
     */
    public void heapSortDescendente(Aeronave aero) {
        int heapSize = lista.size()-1;
        buildMinHeap(heapSize, aero);
        for(int i = lista.size()-1; i >= 1; i--){
            exChange(0, i);
            heapSize = heapSize - 1;
            minHeapify(0, heapSize, aero);
        }
    }
    
    /**
     * metodo heapsort maximo, los valores quedan en orden ascendente
     * @param lista 
     */
    public void heapSortAscendente(Aeronave aero) {
        int heapSize = lista.size()-1;
        buildMaxHeap(heapSize, aero);
        for(int i = lista.size()-1; i >= 1; i--){
            exChange(0, i);
            heapSize = heapSize - 1;
            maxHeapify(0, heapSize, aero);
        }
    }
    
    /**
     * me retorna el primer elemento del heap
     * @return 
     */
    public Nodo cabeza() {
        return lista.getFirst();
    }
    
    /**
     * me retorna el ultimo elemento del heap
     * @return 
     */
    public Nodo ultimo() {
        return lista.getLast();
    }
    
    /**
     * descencola para un heap minimo
     * @return 
     */
    public Nodo dequeueMinimo(Aeronave aero) {
        buildMinHeap(lista.size()-1, aero);
        Nodo cabeza = cabeza();
        lista.removeFirst();
        return cabeza;
    }
    
    /**
     * descencola para un heap maximo
     * @return 
     */
    public Nodo dequeueMaximo(Aeronave aero) {
        buildMaxHeap(lista.size()-1, aero);
        Nodo cabeza = cabeza();
        lista.removeFirst();
        return cabeza;
    }
    
    /**
     * encola para un heap minimo
     * @param unNodo 
     */
    public void enqueue(Nodo unNodo) {
        lista.add(unNodo);
    }
    
    /**
     * verdadero si la cola esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return(lista.size() == 0);
    }
    
    
//    /**
//     * ¿Agregar en la posicion correcta?
//     * <b>se puede mejorar como agregación binaria</b>
//     * @param n 
//     */
//    public void agregar(Nodo n, Aeronave a){
//        if(lista.size() == 0)
//            lista.add(n);
//        else{
//            int i=0;
//            boolean agregado = false;
//            while(i < lista.size() && !agregado){
//                System.out.println("se supone que el nodo"+n+" con nave "+a.getId()+" ... "+n.getFAeronave(a.getId())+" : "+lista.get(i).getFAeronave(a.getId()));
//                if(n.getFAeronave(a.getId()) < lista.get(i).getFAeronave(a.getId())){
//                    
//                    lista.add(i, n);
//                    agregado = true;
//                }
//                i++;
//            }
//            if(!agregado)
//                lista.add(n);
//            System.out.println("El estado es "+lista);
//        }
//    }
//    
//    /**
//     * Buscar si el nodo se encuentra en la estructura
//     * @param n
//     * @return -1 si no está, valor > 0 en caso contrario
//     *//*
//    public int buscaNodoPorG(Nodo n){
//        return 0;
//    }*/
    
    /**
     * Buscar nodo en la estructura
     * @param n
     * @return Posicion del nodo si existe, -1 en caso contrario
     */
    public int buscarNodo(int id){
        int i = 0;
        int posicion = -1;
        while(i < lista.size() && posicion == -1){
            if(lista.get(i).getId() == id)
                posicion = i;
            i++;
        }
        return posicion;
    }

    public LinkedList<Nodo> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Nodo> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return lista.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
       
}