<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

define("RESERVADA", "R");
define("VENDIDA", "V");
define("LIBRE", "L");

    function imprimirSillas($sillas){
        echo "<table>";
        for ($i=0; $i<7; $i++){
            echo "<tr>";
            for ($j=0; $j<6; $j++){
                if ($i==0){
                    if ($j==0)
                        echo "<th colspan='6'>ESCENARIO</th>";
                }
                else if ($i==1)
                        switch ($j) {
                            case 0:
                                echo "<td class='vacio'></td>";
                                break;
                            default:
                                echo "<td>".($j)."</td>";
                                break;
                        }
                else if ($j==0)
                    echo "<td>".($i-1)."</td>";
                else {
                    $fila = $sillas[$i-2];
                    $silla = $fila[$j-1];
                    echo "<td>$silla</td>";
                }
            }
            echo "</tr>";
        }
        echo "</table>";
    }
    
    function sillasATexto($sillas){
        $resultado = "";
        foreach ($sillas as $i => $fila) {
            $filaString = implode(",", $fila);
            $resultado .= $filaString;
            if($i<sizeof($fila)-1)
                $resultado .= ";";
        }        
        return $resultado;
    }
    
    function realizarOperacion(&$sillas,$operacion,$numFila,$numSilla){
        $correcto = TRUE;
        
        $fila = &$sillas[intval($numFila)-1];
        $silla = &$fila[intval($numSilla)-1];
        
        switch ($silla) {
            case LIBRE:
                switch ($operacion) {
                    case LIBRE:
                        echo "<script type='text/javascript'>"
                        . "alert('No pasa cosa alguna.');</script>";
                        $correcto = FALSE;
                        break;
                    case RESERVADA:
                        echo "<script type='text/javascript'>"
                        . "alert('Se ha reservado la silla en la "
                            . "fila $numFila silla $numSilla.');</script>";
                        $silla = RESERVADA;
                        break;
                    case VENDIDA:
                        echo "<script type='text/javascript'>"
                        . "alert('Se ha vendido la silla en la "
                            . "fila $numFila silla $numSilla.');</script>";
                        $silla = VENDIDA;
                        break;
                    default:
                        echo "ERROR";
                        $correcto = FALSE;
                        break;
                }
                break;
            case RESERVADA:
                switch ($operacion) {
                    case LIBRE:
                        echo "<script type='text/javascript'>"
                        . "alert('Se ha liberado la silla en la "
                            . "fila $numFila silla $numSilla.');</script>";
                        $silla = LIBRE;
                        break;
                    case RESERVADA:
                        echo "<script type='text/javascript'>"
                        . "alert('No pasa cosa alguna.');</script>";
                        $correcto = FALSE;
                        break;
                    case VENDIDA:
                        echo "<script type='text/javascript'>"
                        . "alert('Se ha vendido la silla en la "
                            . "fila $numFila silla $numSilla.');</script>";
                        $silla = VENDIDA;
                        break;
                    default:
                        echo "ERROR";
                        $correcto = FALSE;
                        break;
                }
                break;
            case VENDIDA:
                echo "<script type='text/javascript'>". "alert('No pasa cosa "
                    . "alguna. Operacion no válida.');</script>";
                break;
            default:
                echo "ERROR";
                $correcto = FALSE;
                break;
        }
        
        return $correcto;
    }
?>