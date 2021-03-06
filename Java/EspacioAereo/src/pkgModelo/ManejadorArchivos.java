/*
 * Proyecto de Análisis y Diseño de Algoritmos
 */
package pkgModelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import pkgExcepciones.AeropuertoNombreExistenteException;
import pkgExcepciones.ArchivoNoValidoExcepion;
import pkgVista.PanelJuego;

/**
 * Clase que modela un "Manejador de Archivos" que se encargará de guardar y
 * cargar respectivamente los archivos de texto.
 * @author Juan Camilo Alvarez, Andres Roberto Alvarez
 */
public class ManejadorArchivos {

    private PanelJuego panel;
    
    /**
     * Método que permite configurar un juego de la cadena de texto leída
     * @param ruta Ruta de la cadena de texto del archivo a cargar
     * @param juego Referencia al objeto juego a configurar
     * @throws FileNotFoundException Si no se ha hallado el archivo especificado
     * @throws ArchivoNoValidoExcepion Si el archivo a cargar no es valido por alguna razón
     */
    public Juego cargarConfiguracion(String ruta, Juego juego) throws FileNotFoundException, ArchivoNoValidoExcepion, AeropuertoNombreExistenteException{
       
        File f = new File(ruta);
        Juego configurado = juego;

        String linea = "";
        String[] partido;

        boolean leerAeropuerto = false;
        int lineaLanzamiento = 0, i = 0, j = 0;
        String nombre = "";
        boolean permisos[] = new boolean[5];
        
        Scanner s = new Scanner(f);
        
        while(s.hasNextLine()) {
            linea=s.nextLine();
            if(!leerAeropuerto) {
                if(!linea.equals(""))
                {
                    try{
                        lineaLanzamiento = Integer.parseInt(linea);
                        if(lineaLanzamiento < 1 || lineaLanzamiento > 4)
                            throw new ArchivoNoValidoExcepion("valor no válido para línea de lanzamiento");
                    } catch (NumberFormatException ne) {
                        throw new ArchivoNoValidoExcepion("primera linea no numerica");
                    }
                    leerAeropuerto = true;
                }
                else
                    throw new ArchivoNoValidoExcepion("archivo vacio");
            }
            else {
                partido = linea.split("_");
                if(partido.length == 8) {
                    nombre = partido[0];
                    try {
                        i = Integer.parseInt(partido[1]);
                        j = Integer.parseInt(partido[2]);                        
                        
                        for (int k = 0; k < permisos.length; k++)
                            permisos[k] = partido[k+3].equals("1");

                        configurado.agregarAeropuerto(new Aeropuerto(nombre, configurado.getEspacio().getMapa()[0][i][j].getPosicion(), permisos, panel),juego.getEspacio().getMapa()[0][i][j]);
                    } catch (NumberFormatException numberFormatException) {
                        throw new ArchivoNoValidoExcepion("valor no numérico en alguno de los parámetros de posición");
                    } catch (ArrayIndexOutOfBoundsException ae) {
                        System.out.println("i: "+i+"  j:"+j+"");
                        throw new ArchivoNoValidoExcepion("valor en alguno de los parámetros de posición no correcto, sobrepasa límites");
                    }
                    
                }
                else
                    throw new ArchivoNoValidoExcepion();
            }
        }
        configurado.setLineaSalida(lineaLanzamiento);
        
        return configurado;
    }
    
    public PanelJuego getPanel() {
        return panel;
    }

    public void setPanel(PanelJuego panel) {
        this.panel = panel;
    }
 
}
