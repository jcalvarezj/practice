<?php
	namespace Vista;
	
	class CRUDEstudiantes extends CRUD {
		// Atributos (heredados: $controlador y $mensaje)

		$controlGrados;
		$controlSecciones;

		// Metodos

		function __construct() {
			$controlador = new Controlador\CRUDEstudiantes($this);
			$controlGrados = new Controlador\CRUDGrados($this);
			$controlSecciones = new Controlador\CRUDGrados($this);
		}

		/*
			Retorna un string con HTML que genera la estructura de la interfaz
			según la petición que se tenga en ésta
			@param La variable $_POST de la interfaz
		*/
		function respuesta($post) {
			$html = "";
			$listaGrados = $this->$listarGrados();

			if (!isset($post['accion'])) {
				$html = "";
			}
			else {
				switch ($post['accion']) {
					case REGISTRAR: {
						
						break;
					}
					case CONSULTAR: {
						
						break;
					}
					case ACTUALIZAR: {
						
						break;
					}
					case BORRAR: {
						
						break;
					}
					default:
						# code...
						break;
				}
			}
		}
	}

	/*
		Retorna string del html de un listado de opciones de combobox de los
		grados que hayan en la base de datos		
		@return String con HTML para las opciones de combobox con lo listado
	*/
	function listarGrados() {
		$grados = $controlGrados->listar();
		$html = "";
		$cantidad = count($grados);

		foreach ($grados as $g) {
			$html."<option value=''".$g->getNumero().">".$g->getNumero()
			."</option>";
		}

		return $html;
	}

	/*
		Retorna string del html de un listado de opciones de combobox de las
		secciones que hayan en la base de datos
		@param $grado El grado seleccionado	
		@return String con HTML para las opciones de combobox con lo listado
	*/
	function listarSecciones($grado) {
		$secciones = $controlSecciones->listar();
		$html = "";
		$cantidad = count($secciones);

		foreach ($secciones as $s) {
			$html."<option value=''".$s->getLetra().">".$s->getLetra()
			."</option>";
		}

		return $html;
	}
?>

<form method='post' action='estudiantes.php'>
	<p><label>Consultar por: <select name='cmbConsulta'>
		<option value='0'>Cedula</option>
		<option value='1'>Nombre</option>
		<option value='2'>Apellido</option>
		<option value='3'>Edad</option>
		<option value='4'>Grado</option>
		</select> <input type='text' name='txtCedulaCon' />
	</label></p>
	<p>Registrar: <label>Cedula: <input type='text' name='txtCedulaReg' /></label>
	<label>Nombre(s): <input type='text' name='txtNombreReg' />
	</label>
	<label>Apellido(s): <input type='text' name='txtApellidoReg' />
	</label>
	<label>Grado: <select name = 'cmbGradoReg'>
	".listarGrados();."
	</select>
	<select name = 'cmbSeccionReg'>
	<option value=''></option><!-- LO QUE HAYA EN LA BASE DE DATOS -->
	</select>
	</label>
	</p>
	<p>Editar: <label>Cedula: <input type='text' name='txtCedulaEdi' /></label>
	<label>Nombre(s): <input type='text' name='txtNombreEdi' />
	</label>
	<label>Apellido(s): <input type='text' name='txtApellidoEdi' />
	</label>
	<label>Grado: <select name = 'cmbGradoEdi'>
	<option value=''></option><!-- LO QUE HAYA EN LA BASE DE DATOS -->
	</select>
	<select name = 'cmbSeccionEdi'>
	<option value=''></option><!-- LO QUE HAYA EN LA BASE DE DATOS -->
	</select>
	</label>
	</p>
	<p>Borrar: <label>Cedula: <input type='text' name='txtCedulaBor' />
	</label></p>
</form>