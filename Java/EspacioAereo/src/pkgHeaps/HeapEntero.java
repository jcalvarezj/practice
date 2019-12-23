/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgHeaps;

import java.util.LinkedList;

/**
 *
 * @author andres
 */
public class HeapEntero {
    private LinkedList<Integer> lista;
    

    public HeapEntero() {
        lista = new LinkedList<>();
    }

    public HeapEntero(LinkedList<Integer> lista) {
        this.lista = lista;
    }

    /**
     * @return the lista
     */
    public LinkedList<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<Integer> lista) {
        this.lista = lista;
    }
    
    /**
     * cambia la posicion de dos elementos en una lista
     * @param posicionA
     * @param posicionB
     * @param lista 
     */
    private void exChange(int posicionA, int posicionB) {
        int auxiliar = lista.get(posicionA);
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
    private void minHeapify(int posicionInicial, int heapSize) {
        int left = left(posicionInicial);
        int right = right(posicionInicial);
        int shortest;
        if((left <= heapSize) && (lista.get(left) < lista.get(posicionInicial)))
            shortest = left;
        else
            shortest = posicionInicial;
        if((right <= heapSize) && (lista.get(right) < lista.get(shortest)))
            shortest = right;
        if(shortest != posicionInicial){
            exChange(posicionInicial, shortest);
            minHeapify(shortest, heapSize);
        }
    }
    
    /**
     * metodo que mantiene la propiedad del heap maximo desde una posicion determinada en adelante
     * @param lista
     * @param posicionInicial 
     */
    private void maxHeapify(int posicionInicial, int heapSize) {
        int left = left(posicionInicial);
        int right = right(posicionInicial);
        int largest;
        if((left <= heapSize) && (lista.get(left) > lista.get(posicionInicial)))
            largest = left;
        else
            largest = posicionInicial;
        if((right <= heapSize) && (lista.get(right) > lista.get(largest)))
            largest = right;
        if(largest != posicionInicial){
            exChange(posicionInicial, largest);
            maxHeapify(largest, heapSize);
        }
    }
    
    /**
     * metodo que me construye el heap minimo
     * @param lista
     * @param heapSize 
     */
    private void buildMinHeap(int heapSize) {
        for(int i = ((lista.size()-1)/2); i >= 0; i--)
            minHeapify(i, heapSize);
    }
    
    /**
     * metodo que me construye el heap maximo
     * @param lista
     * @param heapSize 
     */
    private void buildMaxHeap(int heapSize) {
        for(int i = ((lista.size()-1)/2); i >= 0; i--)
            maxHeapify(i, heapSize);
    }
    
    /**
     * metodo heapsort minimo, los valores quedan en orden descendente
     * @param lista 
     */
    public void heapSortDescendente() {
        int heapSize = lista.size()-1;
        buildMinHeap(heapSize);
        for(int i = lista.size()-1; i >= 1; i--){
            exChange(0, i);
            heapSize = heapSize - 1;
            minHeapify(0, heapSize);
        }
    }
    
    /**
     * metodo heapsort maximo, los valores quedan en orden ascendente
     * @param lista 
     */
    public void heapSortAscendente() {
        int heapSize = lista.size()-1;
        buildMaxHeap(heapSize);
        for(int i = lista.size()-1; i >= 1; i--){
            exChange(0, i);
            heapSize = heapSize - 1;
            maxHeapify(0, heapSize);
        }
    }
    
    /**
     * me retorna el primer elemento del heap
     * @return 
     */
    public int cabeza() {
        return lista.getFirst();
    }
    
    /**
     * descencola para un heap minimo
     * @return 
     */
    public int dequeueMinimo() {
        buildMinHeap(lista.size()-1);
        int cabeza = cabeza();
        lista.removeFirst();
        return cabeza;
    }
    
    /**
     * descencola para un heap maximo
     * @return 
     */
    public int dequeueMaximo() {
        buildMaxHeap(lista.size()-1);
        int cabeza = cabeza();
        lista.removeFirst();
        return cabeza;
    }
    
    /**
     * encola para un heap minimo
     * @param valor 
     */
    public void enqueue(int valor) {
        lista.add(valor);
    }
    
    /**
     * verdadero si la cola esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return(lista.size() == 0);
    }
}