<?php
	namespace Vista;
	
	function autoload($clase) {
		$ruta = str_replace("\\", "/", $clase);
		require '../controlador/'.$clase.".php";
	}

	spl_autoload_register('autoload');

	abstract class CRUD {
		// Constantes

		define("REGISTRAR",0);
		define("CONSULTAR",1);
		define("ACTUALIZAR",2);
		define("BORRAR",3);

		// Atributos
		
		protected $controlador;
		protected $mensaje = "";

		// Métodos

		/*
			Retorna la respuesta HTML en un string de acuerdo a la solicitud
			POST que se haya recibido en la interfaz
		*/
		abstract function respuesta($post);

		/*
			Función que genera un string con el HTML de una tabla, dados los
			registros y campos de ésta
			@pre $matriz no vacía, $campos no vacía
			@post No hay cambios en el sistema, solo se genera string
			@param $matriz Matriz de registros
			@param $campos Lista de campos
			@return String con el HTML de la tabla parametrizada
		*/
		static function generarTabla($matriz,$campos) {
			$tabla = "<table>";
			$numCampos = count($campos);
			$numRegistros = count($matriz);

			for ($i = 0; $i < $numRegistros; $i++) { 
				$tabla .= "<tr>";
				
				for ($j = 0; $j < $numCampos; $j++) {
					if ($i == 0)
						$tabla .= "<th>".$campos[j]."</th>";
					else
						$tabla .= "<td>".$matriz[i][j]."</td>";
				}

				$tabla .= "</tr>";
			}

			$tabla .= "</table>"

			return $tabla;
		}

		function getMensaje() {
			return $mensaje;
		}

		function setMensaje($mensaje) {
			$this->$mensaje = $mensaje;
		}

	}