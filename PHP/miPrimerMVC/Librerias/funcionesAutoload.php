<?php
	/*
		Esta librería define funciones para implementar el autoload, de modo que
		lo empleen archivos en la raíz del proyecto o en subdirectorios
	*/
	
	function importarEnRaiz() {
		spl_autoload_register("autoloadExterno");
	}
	
	function importarEnSubcarpeta() {
		spl_autoload_register("autoloadInterno");
	}

	/*
		Método para la importación de clases con namespaces desde la respectiva
		carpeta del proyecto del namespace
		@param $clase Clase parametrizada por el intérprete al intentar usar una
			   clase que no se ha importado
	*/
	function autoloadExterno($clase) {
		$ruta = "./".str_replace("\\", "/", $clase).".php";

		echo "Se intenta cargar a: $ruta porque ".getcwd();

		if (file_exists($ruta))
			require $ruta;
		else
			echo "PROBLEMA... ARCHIVO A IMPORTAR NO ENCONTRADO!";
	}

	/*
		Método para la importación de clases con namespaces desde la respectiva
		carpeta del proyecto del namespace
		@param $clase Clase parametrizada por el intérprete al intentar usar una
			   clase que no se ha importado
	*/
	function autoloadInterno($clase) {
		$ruta = "../".str_replace("\\", "/", $clase).".php";

		//echo "Se intenta cargar a: $ruta porque directorio actual:".getcwd();

		if (file_exists($ruta))
			require $ruta;
		else
			echo "<p>PROBLEMA... ARCHIVO A IMPORTAR NO ENCONTRADO!</p>";
	}