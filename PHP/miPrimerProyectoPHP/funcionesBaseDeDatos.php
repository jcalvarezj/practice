<?php

require "funcionesArchivos.php";

define("RUTA","./hidden/credenciales.txt");

/*
Esta funcion retorna un arreglo con las credenciales de conexion en el archivo en la ruta especificada.
@pre: El archivo existe
@post: No hay cambio en el sistema
@param: $ruta: La ruta del archivo de credenciales
@return: Array con las credenciales [$host,$usuario,$contraseña]
*/
function leerCredenciales() {
	$lectura = leerArchivo(RUTA);
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

	$info = leerCredenciales();
	$conexion = mysqli_connect($info[0],$info[1],$info[2]);
	$seleccion = mysqli_select_db($conexion,$info[3]);
		
	#$tildes = $conexion -> query("SET NAMES 'utf-8'");
	$tildes = mysqli_query($conexion,"SET NAMES 'utf-8';");

	// Con esta sentencia se obtienen nombres de columnas
	$resultado = mysqli_query($conexion,"DESCRIBE $tabla;");

	$html .= "<tr>";
	while ($fila = mysqli_fetch_array($resultado)) 
		$html .= "<th>".$fila[0]."</th>";
	$html .= "</tr>";

	// Sentencia para el contenido de la tabla
	$resultado = mysqli_query($conexion,"SELECT * FROM $tabla;");

	while ($fila = mysqli_fetch_array($resultado)) {
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

function leer($cedula){
	$lectura = "--> ";

	$info = leerCredenciales();
	$conexion = mysqli_connect($info[0],$info[1],$info[2]);
	$seleccion = mysqli_select_db($conexion,$info[3]);

	$tildes = mysqli_query($conexion,"SET NAMES 'utf-8'");
	
	$resultado = mysqli_query($conexion, "SELECT p.pk_cedula, p.nombre, p.apellido, e.nombre, e.ciudad FROM personas as p, empresas as e WHERE p.pk_cedula = ".$cedula." AND p.empresa_fk = e.pk_id_empresa;");

	if ($resultado !== FALSE) {
		$lectura .= "La persona registrada en la base de datos con la cedula ";
		while ($fila = mysqli_fetch_array($resultado)) {
			$lectura .= $fila[0]." es ".$fila[1]." ".$fila[2]." que trabaja para la empresa ".$fila[3]." en la ciudad de ".$fila[4];
		}
	}
	else
		$lectura .= "No se encuentra registro alguno de persona identificada con la cedula $cedula";

	mysqli_close($conexion);

	return $lectura;
}

function crear($cedula,$nombre,$apellido,$idEmpresa) {

}