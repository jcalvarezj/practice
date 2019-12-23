/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.awt.Point;

/**
 * Clase que que representa el mapa de juego en forma de cubo
 * @author Juan C. Alvarez & Andres R. Alvarez
 */
public class Espacio {
    /**
     * Matriz de nodos (casillas) del mapa
     */
    private Nodo[][][] mapa;
    
    /**
     * Constructor que crea un nuevo objeto Espacio
     */
    public Espacio() {
        mapa = new Nodo[240][11][15];
        int id = 0;
        for (int k = 0; k < mapa.length; k++) 
            for (int i = 0; i < mapa[0].length; i++) 
                for (int j = 0; j < mapa[0][0].length; j++)
                    mapa[k][i][j] = new Nodo(id++, new Point(30+60*(j),30+60*(i)-11), (k+1)*50, mapa, i, j, k);
        
        for (int k = 0; k < mapa.length; k++)
            for (int i = 0; i < mapa[0].length; i++)
                for (int j = 0; j < mapa[0][0].length; j++) {
                    Point n = new Point(i-1, j),s = new Point(i+1, j),e = new Point(i, j+1),
                          o = new Point(i, j-1),ne = new Point(i-1, j+1),no = new Point(i-1, j-1),
                          se = new Point(i+1, j+1),so = new Point(i+1, j-1);
                    int arriba = k+1, abajo = k-1;
                    if(n.x >= 0)
                    {
                        mapa[k][i][j].setNorte(mapa[k][n.x][j]);
                        mapa[k][n.x][j].setSur(mapa[k][i][j]);
                    }
                    if(s.x < mapa[0].length)
                    {
                        mapa[k][i][j].setSur(mapa[k][s.x][j]);
                        mapa[k][s.x][j].setNorte(mapa[k][i][j]);
                    }
                    if(e.y < mapa[0][0].length)
                    {
                        mapa[k][i][j].setEste(mapa[k][i][e.y]);
                        mapa[k][i][e.y].setOeste(mapa[k][i][j]);
                    }
                    if(o.y >= 0)
                    {
                        mapa[k][i][j].setOeste(mapa[k][i][o.y]);
                        mapa[k][i][o.y].setEste(mapa[k][i][j]);
                    }
                    if(ne.x >= 0 && ne.y < mapa[0][0].length)
                    {
                        mapa[k][i][j].setNorEste(mapa[k][ne.x][ne.y]);
                        mapa[k][ne.x][ne.y].setSurOeste(mapa[k][i][j]);
                    }
                    if(no.x >= 0 && no.y >= 0)
                    {
                        mapa[k][i][j].setNorOeste(mapa[k][no.x][no.y]);
                        mapa[k][no.x][no.y].setSurEste(mapa[k][i][j]);
                    }
                    if(se.x < mapa[0].length && se.y < mapa[0][0].length)
                    {
                        mapa[k][i][j].setSurEste(mapa[k][se.x][se.y]);
                        mapa[k][se.x][se.y].setNorOeste(mapa[k][i][j]);
                    }
                    if(so.x < mapa[0].length && so.y >= 0)
                    {
                        mapa[k][i][j].setSurEste(mapa[k][so.x][so.y]);
                        mapa[k][so.x][so.y].setNorOeste(mapa[k][i][j]);
                    }
                    if(abajo >= 0)
                    {
                        mapa[k][i][j].setAbajo(mapa[abajo][i][j]);
                        mapa[abajo][i][j].setArriba(mapa[k][i][j]);
                        
                        if(n.x >= 0)
                        {
                            mapa[k][i][j].setAbajoNorte(mapa[abajo][n.x][j]);
                            mapa[abajo][n.x][j].setArribaSur(mapa[k][i][j]);
                        }
                        if(s.x < mapa[0].length)
                        {
                            mapa[k][i][j].setAbajoSur(mapa[abajo][s.x][j]);
                            mapa[abajo][s.x][j].setArribaNorte(mapa[k][i][j]);
                        }
                        if(e.y < mapa[0][0].length)
                        {
                            mapa[k][i][j].setAbajoEste(mapa[abajo][i][e.y]);
                            mapa[abajo][i][e.y].setArribaOeste(mapa[k][i][j]);
                        }
                        if(o.y >= 0)
                        {
                            mapa[k][i][j].setAbajoOeste(mapa[abajo][i][o.y]);
                            mapa[abajo][i][o.y].setArribaEste(mapa[k][i][j]);
                        }
                    }
                    if(arriba < mapa.length)
                    {
                        mapa[k][i][j].setArriba(mapa[arriba][i][j]);
                        mapa[arriba][i][j].setAbajo(mapa[k][i][j]);
                        
                        if(n.x >= 0)
                        {
                            mapa[k][i][j].setArribaNorte(mapa[arriba][n.x][j]);
                            mapa[arriba][n.x][j].setAbajoSur(mapa[k][i][j]);
                        }
                        if(s.x < mapa[0].length)
                        {
                            mapa[k][i][j].setArribaSur(mapa[arriba][s.x][j]);
                            mapa[arriba][s.x][j].setAbajoNorte(mapa[k][i][j]);
                        }
                        if(e.y < mapa[0][0].length)
                        {
                            mapa[k][i][j].setArribaEste(mapa[arriba][i][e.y]);
                            mapa[arriba][i][e.y].setAbajoOeste(mapa[k][i][j]);
                        }
                        if(o.y >= 0)
                        {
                            mapa[k][i][j].setArribaOeste(mapa[arriba][i][o.y]);
                            mapa[arriba][i][o.y].setAbajoEste(mapa[k][i][j]);
                        }
                    }
                }
    }
    
    
    private void bloquear(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j][8].setOcupado(999);
            }
        }
        for (int i = 0; i < mapa.length; i++) {
            
                mapa[i][1][8].setOcupado(-1);
            
        }
    }

    /**
     * Método que permite retornar la casilla de la matriz asociada a una posición
     * (entiéndase por asociada: "cercana" respecto de su posición a la posición en cuestión)
     * @param posicion Posición respecto a la cual buscar casilla
     * @return La casilla (Nodo) asociada a la posición dada
     */
    public static Nodo buscarCasillaPosicion(Point posicion, Nodo mapa[][][]){
        int x = 0 , y = 0;
        if(posicion.x >= 60)
            x = ((posicion.x/60));
        if(posicion.y >= 60)
            y = ((posicion.y/60));
        return mapa[0][y][x];
    }
    
    public Nodo[][][] getMapa() {
        return mapa;
    }

    public void setMapa(Nodo[][][] mapa) {
        this.mapa = mapa;
    }
    
}
