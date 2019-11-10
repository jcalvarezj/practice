<?php
	namespace Vista;

	require "./Librerias/funcionesAutoload.php";
	importarEnSubcarpeta();

	class Principal extends CRUD {
		//Atributos (heredados: $controlador y $mensaje)

		//Metodos
		function __construct() {
			$controlEstudiantes = new Controlador\CRUDEstudiantes($this);
			$controlGrados = new Controlador\CRUDGrados($this);
			$controlSecciones = new Controlador\CRUDSecciones($this);
		}

		function respuesta($post) {
			$html = "";

			if (!isset($post) || empty($post['accion'])) {	
				$html .= "<p>AQUI VA LA RESPUESTA</p>";
			}
			else {
				switch ($post['accion']) {
					case 'ESTUDIANTES':{
						$controlEstudiantes->listar(); ###### CORREGIR?
						$html .= 
						break;
					}
					default: {	
						break;
					}
				}
			}
		}

	}