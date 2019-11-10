<?php

function cadenaArchivo() {
	$ruta = "./prueba2.txt";
	$cadena = "";

	if (!file_exists($ruta))
		$cadena = "El archivo no existe!!!";
	else {
		$cadena .= "El archivo si existe y contiene:\n";
		$archivo = fopen($ruta, "r");
		while (!feof($archivo)) {
			$cadena .= fgets($archivo);		
		}
		fclose($archivo);
	}

	return $cadena;
}

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

function escribirArchivo($cadena) {
	$archivo = fopen("./prueba1.txt", "w");
	fputs($archivo,$cadena);
	fclose($archivo);
}