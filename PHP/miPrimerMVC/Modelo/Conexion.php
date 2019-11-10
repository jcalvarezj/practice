<?php
	namespace Controlador;

	require "../librerias/funcionesArchivos.php";

	/*
		Esta corresponde a la clase de conexion con la base de datos
	*/
	
	class Conexion {
		//Atributos
		//private $credenciales = array("localhost","usuario","********",
														//"mibasededatos");

		private $credenciales = leerCredenciales("../oculto/credenciales.txt");
		private $objetoConexion; // Tipo mysqli
		private static $singleton; // Referencia a si mismo (tipo Conexion)

        //Metodos         
        private function __construct() { // Sólo getConextion puede usarla
            $objetoConexion = new \mysqli($this->$credenciales[0],
            	$this->$credenciales[1], $this->$credenciales[2],
            	$this->$credenciales[3]);
		}

		function getObjetoConexion() {
			return $this->$objetoConexion;
		}

		/*
			Obtiene el objeto único que si no existe lo crea, asegurando que
			siga siendo único y pueda compartirse de forma estática
		*/
		static function getConexion() {
			if (is_null($singleton))
				$singleton = new Conexion();
			return $singleton;
		}
	} 