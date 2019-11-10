<?php
	namespace Controlador;

	function autoload($clase) {
		$ruta = '../controlador/'.$clase.'.php';

		if(file_exists($ruta))
			require '../controlador/'.$clase.".php";

		$ruta = '../modelo/'.$clase.".php";

		if(file_exists($ruta))
			require '../modelo/'.$clase.".php";
	}

	spl_autoload_register('autoload');

	/*
		Esta la clase del controlador que se encarga de intermediar las
		peticiones de la vista, con las operaciones a nivel de base de datos de 
		la correspondiente tabla, de modo que se entregue a la vista información
		que ésta pueda manejar de acuerdo a la petición solicitada
	*/
	class CRUD {
		// Atributos

		protected $vista;
		protected $dao;

		// Métodos

		function __construct($vista) {
			$this->$vista = $vista;
		}

		/*
			Lista registros de una consulta sobre la tabla a la que corresponde
			la especialización del controlador en formato matriz y se lo pasa a
			la vista para que le de formato de tabla
			@param $entidad El objeto entidad con info. de su respectiva tabla
			@param $tipoConsulta El tipo de consulta a ejecutar
			@pre Base de datos creada, tabla creada, $entidad configurada
			@post Sin cambios en el sistema, solo el mensaje de la vista
		*/		
		function consultar($entidad,$tipoConsulta) {
			$resultSet = $dao->consultar($entidad,$tipoConsulta);

			if ($resultSet === FALSE) 
				$vista->setMensaje("No se encontró registro alguno...");
			else {
				$matriz = [];
				$registro = [];
				$numCols = -1; // Meh, para optimizar y no haya que contar cada vez

				while ($fila = $resultSet->fetch_row()) {
					if ($numCols == -1)
						$numCols = count($fila);

					for ($i = 0; $i < $numCols; $i++)
						$registro[$i] = $fila[$i];

					$matriz[] = $registro;
				}

				$respuesta = "<p>La consulta indicada ha retornado :</p><br/>";
				$respuesta .= $vista->generarTabla($matriz);
				$vista->setMensaje($respuesta);
			}
		}

		/*
			Igual que consultar, pero retorna la matriz resultado sin modificar
			la vista
			@return Array matriz del conjunto resultado, o NULL si no hay
					registro alguno en la consulta
		*/
		function consultaLight($entidad,$tipoConsulta) {
			$resultSet = $dao->consultar($entidad,$tipoConsulta);
			$matriz;

			if ($resultSet === FALSE) 
				$matriz = NULL;
			else {
				$matriz = [];
				$registro = [];
				$numCols = -1; // Meh, para optimizar y no haya que contar cada vez

				while ($fila = $resultSet->fetch_row()) {
					if ($numCols == -1)
						$numCols = count($fila);

					for ($i = 0; $i < $numCols; $i++)
						$registro[$i] = $fila[$i];

					$matriz[] = $registro;
				}
			}
			return $matriz;
		}

		/*
			Registra en la base de datos la entidad configurada
			@param $entidad El objeto entidad con info. de su respectiva tabla
			@pre Base de datos creada, tabla creada, $entidad configurada
			@post Registro exitoso, o no hay cambios en caso contrario además de
				  el mensaje de la vista
		*/
		function registrar($entidad) {
			$resultado = $dao->registrar($entidad);

			if ($resultado === FALSE)
				$vista->setMensaje("No se puede insertar registro, ya existe un"
					." registro con los datos ingresados...");
			else
				$vista->setMensaje("Se ha realizado el registro correctamente");
		}

		/*
			Actualiza en la base de datos la entidad configurada al registro
			identificado con la clave primaria ingresada
			@param $entidad El objeto entidad con info. de su respectiva tabla
			@pre Base de datos creada, tabla creada, $entidad configurada
			@post Registro exitoso, o no hay cambios en caso contrario además 
				  del mensaje de la vista
		*/
		function actualizar($entidad,$clave) {
			$resultado = $dao->actualizar($entidad,$clave);

			if ($resultado === FALSE) 
				$vista->setMensaje("No se puede actualizar; algún problema...");
			else
				$vista->setMensaje("Se ha realizado la edición correctamente");
		}

		/*
			Maneja la solicitud de borrado, realizando la operación y actualiza
			la vista respectivamente del éxito
			@param $clave La clave primaria del registro a borrar
		*/
		function borrar($clave) {
			$resultado = $dao->actualizar($entidad,$clave);

			if ($resultado === FALSE) 
				$vista->setMensaje("No existe el registro para borrar...");
			else
				$vista->setMensaje("Se ha realizado el borrado correctamente");
		}

		/*
			Devuelve matriz ("array") de todos los registros de la tabla que 
			corresponde al controlador especializado
			@return Matriz ("array") de los registros
		*/		
		function listar() {
			$entidad;
			$consulta;

			if ($this instanceof CRUDEstudiantes) {
				$entidad = new Modelo\Estudiante(0,"","",0,0,"");
				$consulta = Modelo\EstudianteDAO::QTODO;
				
			}
			else
				if ($this instanceof CRUDGrados) {
					$entidad = new Modelo\Grado(0,"","");
					$consulta = Modelo\GradoDAO::QTODO;					
				}
				else
					if ($this instanceof CRUDSecciones) {
						$entidad = new Modelo\Seccion(0,"",0);
						$consulta = Modelo\SeccionDAO::QTODO;
					}
					else {
						printf("Error! Objeto debe ser una especialización!!!");
						exit(1);
					}

			return $this->consultaLight($entidad,$consulta);
		}

		/*
			Retorna la lista de nombres de columnas de la tabla
		*/
		function listarColumnas() {
			$columnas = [];
			$resultSet = $dao->listarColumnas();

			while($fila = $resultSet->fetch_row())
				$columnas[] = $fila[0];

			return $columnas;
		}
	}