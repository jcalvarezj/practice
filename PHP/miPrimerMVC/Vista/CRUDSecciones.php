<?php
	namespace Vista;
	class CRUDSecciones extends CRUD {
		// Atributos (heredados: $vista, $dao)

		// Métodos (heredados:
					// consultar($entidad,$tipoConsulta) 
					// registrar($entidad)
					// actualizar($entidad,$clave) 
					// borrar($clave) 
					// listarColumnas($resultSet) 
					// listar())

		function __construct($vista) {
			parent::__construct($vista);
			$dao = new Modelo\SeccionDAO();
		}

	}