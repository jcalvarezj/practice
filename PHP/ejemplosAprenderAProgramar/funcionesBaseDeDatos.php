<?php

require "funcionesArchivos.php";

define("LOCAL",1);
define("REMOTA",2);

/*
Esta funcion retorna un arreglo con las credenciales de conexion en el archivo
en la ruta especificada.
@pre: El archivo existe
@post: No hay cambio en el sistema
@param: $ruta: La ruta del archivo de credenciales
@return: Array con las credenciales [$host,$usuario,$contraseña,$baseDeDatos]
*/
function leerCredenciales($ruta) {
	$lectura = leerArchivo($ruta);
	$tokens = explode(" ", $lectura);
	return $tokens;
}

/*
Esta funcion retorna un string con el html de una tabla, con la informacion de 
la tabla de la base de datos especificada (por defecto la local)
@pre: La tabla especificada se encuentra creada en la base de datos
@post: No hay cambios en el sistema
@param: $tabla: String que especifica la tabla a leer
@return: String con la tabla HTML de la tabla en la base de datos
*/
function leerTablaCompleta($tabla) {
	$html = "<table>";

	$info = leerCredenciales("./hidden/credenciales.txt");

	$conexion = mysqli_connect($info[0],$info[1],$info[2]);
	$seleccion = mysqli_select_db($conexion,"b16_19013890_mibasededatos");
	break;	
	
	$tildes = $conexion -> query("SET NAMES 'utf-8'");

	// Con esta sentencia se obtienen nombres de columnas
	$resultado = mysqli_query($conexion,"DESCRIBE $tabla");

	$html .= "<tr>";
	while($fila = mysqli_fetch_array($resultado)) 
		$html .= "<th>".$fila[0]."</th>";
	$html .= "</tr>";

	// Sentencia para el contenido de la tabla
	$resultado = mysqli_query($conexion,"SELECT * FROM $tabla;");

	while($fila = mysqli_fetch_array($resultado)) {
		$html .= "<tr>";

		$cols = count($fila)/2; //Porque tiene dos claves (# y nombre)
		for ($i=0; $i < $cols; $i++) 
			$html .= "<td>".$fila[$i]."</td>";

		$html .= "</tr>";
	}

	mysqli_close($conexion);

	$html .= "</table>";

	return $html;
}