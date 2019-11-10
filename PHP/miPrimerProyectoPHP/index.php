<!DOCTYPE html>
<!--
********************************************************************************
PROYECTO PARA PROBAR UNIDADES BASICAS DE PHP, VA DESDE CERO HASTA SOLICITUDES
(c) J. Alvarez. 2016
********************************************************************************
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>MI PRIMER PROGRAMA PHP</title>
        <style>
            table, tr, td, th {
                border: 2px solid black;
            }
        </style>
    </head>
    <body>
        <p>Probando lo del calendario</p>
        <?php 
        $mes = date("m");
        echo "".$mes;
        
        $meses = array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
            "Agosto","Septiembre","Octubre","Noviembre","Diciembre");
        
        $posicion = intval(date("n"));
        echo "EL MES::: ".$meses[$posicion-1];
        
        echo "<br/>";       
        
        $laFecha = mktime(intval(date("H")), intval(date("M")),
                intval(date("S")), intval(date("n")), 1, intval(date("Y"))); 
            // Fecha personalizada al dia 1 de este mes
        echo "EL DIA::: ".intval(date("N",$laFecha));
        
        echo "<br/>";
        ?>
        <br/>
        <hr/>
        <a href="indexFunciones.php" target="_self">FUNCIONES</a> <br/>
        <a href="indexGetRequests.php?valor1=20&valor2=45" target="none">
            SOLICITUDES</a> <br/>
        <a href="indexTeatroForm.php" target="none">TEATRO</a>
        <?php 
        // Importación de librerías
        require './indexFunciones.php';
        
        echo "<br/><p>Prueba llamado funcion del archivo importado...</p>".  operaciones(5, 5, R)."<br/>";
        echo "<p>Prueba 2 llamado funcion del archivo importado...</p>".  operaciones(5, 2, M)."<br/>";
        
        // Declaración de constantes y variables
        define("NUMERO_ASDF",12345);
        $a = 1;
        $aFuturo = &$a;
        $datosPersonales = array(
            "id"=>NUMERO_ASDF,
            "nombre"=>"pepe",
            "especie"=>"guanabana"
        );
        ?>
        
        <?php
        // Uso de constantes y variables
        $clave = "nombre";
        $clave2 = "especie";
        echo "Hola mundo"."<br/>".'<p>$a '."$a</p>".
                "<br/>NOMBRE: $datosPersonales[$clave]"
                . " ESPECIE: $datosPersonales[$clave2]";
        
        $a += NUMERO_ASDF;
        echo " $a <br/> Se suma el futuro, queda $aFuturo y $a";
        
        $aFuturo += NUMERO_ASDF;     
        echo "<br/>Se sumó, queda $aFuturo y $a";                
        ?>
        
        <?php
        // Uso de E. de control
        if($a<10000)
            echo "uno";
        elseif ($a<20000) 
            echo "dos";
        else
            echo "tres";
        $i = 0;
        
        while($i < 8){
            echo "".$i++."<br/>";
        }
        
        foreach ($datosPersonales as $d) {
            echo "".$d."<br/>";
        }
        
        foreach ($datosPersonales as $key => $value) {
            echo $key." ... ".$value."</br>";
        }
        ?>
        
        <br/> EJERCICIO!!! <br/>
        
        <?php
        // Array bidimensional
        $directorio = array(
            array("Nombre","Dirección","Teléfono","Fecha de cumpleaños"),
            array("Juan","Clle 1234","123456","2/2/1222"),
            array("Pedro","Cra 5","321654","2/5/1234"),
            array("Alberta","?????","999999","5/5/1999"),
            array("Papa","BajoLaTierra","455954","9/4/2424")
        );
        
        echo "<table>";
        foreach ($directorio as $indice=>$fila) {
            echo "<tr>";
            foreach ($fila as $celda) {
                if($indice == 0)
                    echo "<th>$celda</th>";
                else
                    echo "<td>$celda</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
        
        echo "<br/>";
        
        echo "<table>";
        for ($j = 0; $j<sizeof($directorio); $j++) {
            echo "<tr>";
            foreach ($directorio[$j] as $celda) {
                if($j == 0)
                    echo "<th>$celda</th>";
                else
                    echo "<td>$celda</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
        
        $colores = array("rojo"=>"pasion","azul"=>"mar","verde"=>"aguacate","amarillo"=>"pollito");
        
        $color = "rojo";
        
        switch($color){
           case "rojo":{
               echo $colores["rojo"];
               break;
           }
           case "azul":{
               echo $colores["rojo"];
               break;
           }
           case "verde":{
               echo $colores["rojo"];
               break;
           }
           case "amarillo":{
               echo $colores["rojo"];
               break;
           }
           default:{
               echo "NO HAY!!!!";
           }
        }
        
        // bobada referencia:
        $cosa = 1;
        asd($cosa);
        
        function asd(&$aaaa){
           $b = &$aaaa;
           $b += 54;
        }
        
        echo "<br/>COSA!! $cosa";
        
        // bobada referencia 2:
        $cosa2 = array("A","B","C");
        echo "ORIGINAL: ";
        print_r($cosa2);
        asdf($cosa2);
        
        function asdf(&$aaaa){
           $b = &$aaaa;
           $modificar = &$b[1];
           $modificar = "X";
        }
        
        echo "<br/>COSA2!!<br/>";
        print_r($cosa2);
        ?>
        
    </body>
</html>
