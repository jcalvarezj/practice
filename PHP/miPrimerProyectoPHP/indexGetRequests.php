<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>        
    </head>
    <?php
    // put your code here
    require './indexFunciones.php';
    
    if(isset($_GET['colorFondo'])) {
        $colorFondo = $_GET['colorFondo'];
        echo "<body bgcolor='$colorFondo'>";
        unset($_GET);        
    }
    else
        echo "<body>";
    
    echo "<p>Aqui el resultado de los datos obtenidos por GET</p>";
    echo "<p>";
    if(isset($_GET['valor1']) && isset($_GET['valor2'])) {
        $valor1 = $_GET['valor1'];
        $valor2 = $_GET['valor2'];
        $resultado = operaciones($valor1, $valor2);
        echo "$resultado";
        unset($_GET['valor2']);
        unset($_GET['valor1']);
    }
    else
        echo "NO HAY VALORES ESPECIFICADOS";
    echo "</p>";
    
    echo "<a href='indexGetRequests.php?colorFondo=red'>ROJO</a><br/>";
    echo "<a href='indexGetRequests.php?colorFondo=blue'>AZUL</a><br/>";
    echo "<a href='indexGetRequests.php?colorFondo=yellow'>AMARILLO</a><br/>";
    echo "<a href='indexGetRequests.php?colorFondo=orange'>NARANJA</a><br/>";
    echo "<a href='indexGetRequests.php?colorFondo=green'>VERDE</a><br/>";
    echo "<a href='indexGetRequests.php?colorFondo=magenta'>MAGENTA</a><br/><br/>";
    
    if(isset($_GET['fuente'])) {
        $fuente = $_GET['fuente'];
        switch ($fuente) {
            case '1':
                echo "<p style='font-weight: bold;'>";
                break;
            case '2':
                echo "<p style='font-style: italic;'>";
                break;
            case '3':
                echo "<p style='text-decoration: underline;'>";
                break;
            case '4':
                echo "<p style='text-decoration: line-through;'>";
                break;
            default:
                echo "<p>";
                break;
        }        
        unset($_GET);        
    }
    else
        echo "<p>";
    echo "CAMBIO DE FUENTE</p><br/>";
    
    echo "<a href='indexGetRequests.php?fuente=1'>Negrita</a><br/>";
    echo "<a href='indexGetRequests.php?fuente=2'>Cursiva</a><br/>";
    echo "<a href='indexGetRequests.php?fuente=3'>Subrayado</a><br/>";    
    echo "<a href='indexGetRequests.php?fuente=4'>Tachado</a><br/>";
    
    echo "</body>"; 
    
    ?>

    <p style="font-weight: bold;"> prueba </p>
    <p style="font-size: 2em;"> De aquí para abajo es para el ejemplo de
    POST</p>
    
    <form action="indexPostRequests.php" method="POST">
        Ingrese nombre: &Tab; <input type="text" name="txtNombre" /><br/>
        Ingrese género:&Tab;M:<input type="radio" name="radGenero" value="M" />        
        F: <input type="radio" name="radGenero" value="F" />
        <br/>
        Ingrese descripción: &Tab; <textarea name="tarDescripcion" rows="5"
        cols="30" style="resize: none"></textarea>
        <br/>
        <select name="selDinero">
            <option value="mucho">MUCHO</option>
            <option value="poquito">POQUITO</option>
        </select><br/>
        <input type="submit" value="AGREGAR"/>
    </form>
</html>
