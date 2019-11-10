<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Prueba basica de manejo de funciones en PHP</title>
    </head>
    <body>
        <?php
        // put your code here
        
        define('S','S');
        define('R','R');
        define('M','M');
        define('D','D');
        
        echo "<p>Este ejemplo llama a la función operaciones</p><br/>";
        echo "<p>".operaciones(5,5)."</p>";
        
        // Ojo, nótese la mala práctica de programación: pelea de break y return
        function operaciones($a,$b,$operacion = S){
            switch ($operacion) {
                case S:
                    return $a + $b;
                    break;
                case R:
                    return $a - $b;
                    break;
                case M:
                    return $a * $b;
                    break;
                case D:
                    return $a / $b;
                    break;
                default:
                    break;
            }
        }
        ?>
    </body>
</html>
