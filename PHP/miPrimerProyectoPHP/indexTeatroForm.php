<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>RESERVA DE SILLAS DEL TEATRO</title>
        <style type="text/css">
            table, tr, td, th {
                border: 1px solid black;
                margin-left: auto;
                margin-right: auto;
            }
            
            .vacio {
                border: none;
            }
            
            #todo {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="todo">
            <?php
            require './funcionesTeatro.php';
            
            if(isset($_POST['txaSillas']) && !empty($_POST['txaSillas'])) {
                $filas = explode(";",$_POST['txaSillas']);
                $n = count($filas);
                for ($i=0; $i<$n; $i++) {
                    $sillas[$i] = explode(",",$filas[$i]);
                }
                
                unset($_POST['txaSillas']);
            }
            else {
                //OJO, ESTO CADA QUE ACTUALIZABA LA PAGINA VOLVIA A HACERCE
                $sillas = array(
                    array(LIBRE,LIBRE,LIBRE,LIBRE,LIBRE),
                    array(LIBRE,LIBRE,LIBRE,LIBRE,LIBRE),
                    array(LIBRE,LIBRE,LIBRE,LIBRE,LIBRE),
                    array(LIBRE,LIBRE,LIBRE,LIBRE,LIBRE),
                    array(LIBRE,LIBRE,LIBRE,LIBRE,LIBRE)
                );
            }            
            
            $operacionCorrecta = FALSE;
            $solicitudRealizada = FALSE;
            
            if (isset($_POST['radOpcion']) && isset($_POST['selFila']) &&
                isset($_POST['selSilla'])) {
                
                $solicitudRealizada = TRUE;                
                
                $operacionCorrecta = realizarOperacion($sillas, 
                        $_POST['radOpcion'], $_POST['selFila'], 
                        $_POST['selSilla']);
                                
                unset($_POST['radOpcion']);
                unset($_POST['selFila']);
                unset($_POST['selSilla']);
            }
                        
            ?>
            <p>Este es el sistema para reserva de sillas en el teatro.</p><br/>
            <p>L: Libre. R: Reservada. V: Vendida.</p>
            <p>Libre: Puede Comprar o Reservar.</p>
            <p>Vendida: Nada que hacer.</p>
            <p>Reservada: Puede Comprar o Liberar.</p><br/>
            <p>El estado del teatro es el siguiente: </p>
            
            <?php
            // put your code here
            
            imprimirSillas($sillas);            
            ?>

            <form action="indexTeatroForm.php" method="POST" onsubmit="">
                <p><label>Nombre:</label></p>
                <p><label>Fila: <select name="selFila">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select></label></p>
                <p><label>Silla: <select name="selSilla">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select></label></p>                
                <p><label>Reservar: <input type="radio" name="radOpcion" value=
                                           "R" checked="true"/>
                    </label></p>
                <p><label>Comprar: <input type="radio" name="radOpcion" value=
                                          "V"/>
                    </label></p>
                <p><label>Liberar: <input type="radio" name="radOpcion" value=
                                          "L"/>
                    </label></p>                
                <!--Este textarea es para paso de información larga, en este
                    caso se pasa la representación en string de la matriz de
                    sillas del teatro. En este caso se usa el oculto, claro, y
                    con esto, mediante POST, permite mantener la información a
                    la página de respuesta (que en este caso es la misma).-->
                </p>
                <p><textarea style="resize: none;" hidden="true" rows="10" cols=
                             "54" name="txaSillas"><?php
                             echo "".sillasATexto($sillas);
                             ?></textarea></p>
                
                <p><input type="submit" value="Aceptar"/></p>
            </form>
            
            <?php 
            // Acción a realizar cuando se obtenga la solicitud POST
       
            if($solicitudRealizada) {
                if($operacionCorrecta)
                        echo "<p>Operación realizada con éxito</p>";
                    else
                        echo "<p>Operación fallida</p>";
            }
            else
                echo "<p>En el momento no se ha realizado operación alguna"
                . "</p>";
            ?>
        </div>
    </body>
</html>