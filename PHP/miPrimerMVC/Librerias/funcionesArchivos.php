<?php

/*     
	Esta librería maneja lectura/escritura de archivos 
*/

/*     
	Esta funcion retorna un arreglo con las credenciales de conexion en el
	archivo en la ruta especificada.
    @pre: El archivo existe
    @post: No hay cambio en el sistema
    @param: $ruta: La ruta del archivo de credenciales
	@return: Array con las credenciales 
			 [$host,$usuario,$contraseña,$baseDeDatos]
*/
	function leerCredenciales($ruta) {     
		$lectura = leerArchivo($ruta);
		$tokens = explode(" ", $lectura);     
		return $tokens; 
	}

/*
	Esta funcion retorna un String con lo leido del archivo
	@pre: $ruta no nulo/vacío
	@post: No hay cambio en el sistema
	@param: $ruta: La ruta del archivo a leer
	@return: String con el contenido del archivo 
*/
	function leerArchivo($ruta) {     
		$cadena = "";

		if (!file_exists($ruta)) {
			$cadena = "El archivo no existe!!!"; 
			exit; 
		} 
		else { 
			$archivo = fopen($ruta, "r"); 
			while (!feof($archivo)) {
				$cadena .= fgets($archivo);
			} 
			fclose($archivo); 
		}
		
		return $cadena; 
	}

/*
	Función que (sobre)escribe un String en un archivo
	@pre: $ruta y $cadena no nulos ni vacíos
	@post: Se genera el archivo si no existe con la cadena, o se sobreescribe
	el archivo si existe
*/ 
	function escribirArchivo($ruta, $cadena) {
		$archivo = fopen($ruta, "w");
		fputs($archivo,$cadena);
		fclose($archivo); 
	}