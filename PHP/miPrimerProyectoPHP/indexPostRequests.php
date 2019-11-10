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
    <body>
        <?php
        // put your code here
        
        if(isset($_POST['txtNombre']) && isset($_POST['radGenero']) &&
        isset($_POST['tarDescripcion']) && isset($_POST['selDinero']) && 
        !empty($_POST['txtNombre']) && !empty($_POST['tarDescripcion'])) {
            $nombre = $_POST['txtNombre'];
            $genero = $_POST['radGenero'];
            $descripcion = $_POST['tarDescripcion'];
            $dinero = $_POST['selDinero'];
            
            echo "La persona que se ha ingresado es: \"$nombre\" de genero \""
                    . "$genero\" que se describe como: \"$descripcion\" y que "
                    . "tiene \"$dinero\" dinero";
            
            echo "<br/>Probando print_r:<br/>";
            print_r($_POST);
            
            unset($_POST['txtNombre']);
            unset($_POST['radGenero']);
            unset($_POST['tarDescripcion']);
            unset($_POST['selDinero']);
        }
        else
            echo "Esta página solo sirve para procesar la solicitud que se "
            . "envíe de <a href='indexGetRequests.php'>esta otra página</a>, o"
                . "bien faltaron datos por ingresar.";
        
        echo "<p style='font-size: 2em;'>En 5 segundos será redireccionado a la página de inicio...";
        header("Refresh: 5; URL=index.php");
        echo "</p>";
        ?>
    </body>
</html>
