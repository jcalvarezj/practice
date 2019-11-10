<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Programa calendario del mes</title>
        <style type="text/css">
            table, td, tr {
                border: solid black 1px;
                margin: 45px;
            }
        </style>
    </head>
    <body>
        <p>Este ejemplo muestra el uso de las funciones PHP para fechas.</p>
        <h1>CALDENDARIO DEL MES</h1>
        <?php
        // put your code here
        
        $dia = intval(date("j"));
        $mes = intval(date("n"));
        $anio = intval(date("Y"));
        
        $diaSemana = intval(date("N")); // Numero del nombre actual
        $laFecha = mktime(intval(date("H")), intval(date("M")),
                intval(date("S")), intval(date("n")), 1, intval(date("Y"))); 
        // Fecha personalizada al dia 1 de este mes
        
        $elDia = intval(date("N",$laFecha)); // # de nombre dia 1 este mes
                
        $iniciales = array("L","M","M","J","V","S","D");
        $dias = array("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado",
            "Domingo");
        $meses = array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
            "Agosto","Septiembre","Octubre","Noviembre","Diciembre");
        
        $nombreDia = $dias[$diaSemana-1];
        $nombreMes = $meses[$mes-1];        
        
        echo "<br/>";        
               
        echo "<table>";
        echo "<th colspan='7'>";        
        echo "$nombreMes de $anio";
        echo "</th>";        
        
        $contador = 1;
        
        for ($i = 0; $i < 7; $i++) {
            echo "<tr>";
            
            for ($j = 0; $j < 7; $j++) {
                echo "<td>";
                
                if ($i == 0)
                    echo $iniciales[$j];
                else if ($i == 1 && $j+1 >= $elDia)
                    echo $contador++;
                else
                    if ($i > 1) {
                        if ($contador == $dia) {
                            echo "<b>";
                            echo $contador++;
                            echo "</b>";
                        }
                        else
                            if ($contador <= 31)
                                echo $contador++;
                    }
                    
                echo "</td>";
            }
            
            echo "</tr>";
        }
        
        echo "</table>";
        
        echo "<p>Hoy estamos a $nombreDia $dia de $nombreMes del año $anio";
        echo "</p>";

        // Prueba con la forma facil:

        echo "<p>".strftime("Hoy es %A, %d de %B de %Y. La hora es %H:%M:%S")."</p>";

        date_default_timezone_set("America/Bogota");

        echo "<p>".strftime("Cambiado a zona horaria local: Hoy es %A, %d de %B de %Y. La hora es %H:%M:%S")."</p>";

        date_default_timezone_set("America/Bogota");

        ?>
    </body>
</html>
