<?php
	namespace Modelo;

	abstract class DAO {

		// Atributos

		protected $conexion;

		// Metodos

		function __construct() {
			$conexion = Conexion::getConexion();
		}

		/*
			Funcion que registra en la base de datos a la entidad con sus datos
			en su respectiva tabla
			@param $entidad El objeto entidad con info. de su respectiva tabla
			@pre Base de datos creada, tabla creada, $entidad configurada
			@post Se ha registrado la entidad en la base de datos
			@return TRUE con éxito, FALSE con fracaso de la operación
		*/
		abstract function registrar($entidad);

		/*
			Funcion que ejecuta consulta en la base de datos para la tabla a la
			que refiere la especialización de esta clase, empleando el objeto de
			información de la tabla, el tipo de consulta a realizar y datos
			adicionales.
			@pre Base de datos creada, tabla creada, $entidad configurada
			@post Sistema sin cambios, consulta obtenida
			@param $entidad El objeto entidad con info. de su respectiva tabla
			@param $tipoConsulta Un entero que indica qué consulta se realiza
			@return Conjunto resultado (tipo mysql_result) en caso de éxito, 
					FALSE en caso contrario
		*/
		abstract function consultar($entidad,$tipoConsulta);

		/*
			Funcion que edita en la base de datos a la entidad con sus datos
			en su respectiva tabla, identificada con una clave primaria
			@pre Base de datos creada, tabla creada, $entidad configurada
				  $clave no vacía o nula
			@post Se ha editado la entidad en la base de datos
			@return TRUE con éxito, FALSE con fracaso de la operación
		*/
		abstract function actualizar($entidad,$clave);

		/*
			Funcion que borra en la base de datos a la entidad identificada por
			la clave primaria ingresada
			@pre Base de datos creada, tabla creada, $clave no vacía o nula
			@post Se ha registrado la entidad en la base de datos
			@return TRUE con éxito, FALSE con fracaso de la operación
		*/
		abstract function borrar($clave);

		/*
			Funcion que ejecuta consulta en la base de datos para conocer las
			columnas de la tabla a la que refiere la especialización de esta 
			clase
			@pre Base de datos creada, tabla creada
			@post Sistema sin cambios, consulta obtenida			
			@return Conjunto resultado (tipo mysql_result) en caso de éxito, 
					FALSE en caso contrario
		*/
		abstract function listarColumnas();

		//abstract function ejecutarSQL($entidad);
	}