<?php
	namespace Vista;

	function autoload($clase) {
		if (file_exists("./Controlador/".$clase.".php"))
			require "./Controlador/".$clase.".php";
		if (file_exists("./Modelo/".$clase.".php"))
			require "./Controlador/".$clase.".php";
	}

	spl_autoload_register("autoload");

	class CRUDGrados extends CRUD {
		//Atributos (heredados: $controlador y $mensaje)

		//Metodos
		
		function __construct() {
			$controlador = new Controlador\CRUDGrados($this);			
		}

		/*
			Retorna un string con HTML que genera la estructura de la interfaz
			según la petición que se tenga en ésta
			@param La variable $_POST de la interfaz
			@return Un string con el HTML a mostrar
		*/
		function respuesta($post) {
			$html = "";
			$listaGrados = $this->$listarGrados();

			if (!isset($post['accion']) || empty($post['accion'])) {
				$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />
			<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' disabled='true' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' disabled='true' />
			</label>
			<input type='submit' name='accion' value='EDITAR' disabled='true' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";
			}
			else {
				switch ($post['accion']) {
					case 'CONSULTAR': {
						$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />
			<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' disabled='true' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' disabled='true' />
			</label>
			<input type='submit' name='accion' value='EDITAR' disabled='true' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";
						$cmbConsulta = intval($post['cmbConsulta']);
						$txtConsulta;

						if ($cmbConsulta == 0)
							$txtConsulta = intval($post['txtConsulta']);
						else
							$txtConsulta = $post['txtConsulta'];

						$grado = new Modelo\Grado($txtConsulta,$txtConsulta,$txtConsulta);

						$html .= "<br/><hr/><br/>";
						$controlador->consultar($grado,$cmbConsulta);
						$html .= $mensaje;

						break;
					}
					case 'REGISTRAR': {
						$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />
			<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' disabled='true' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' disabled='true' />
			</label>
			<input type='submit' name='accion' value='EDITAR' disabled='true' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";
						$txtNumeroReg = intval($post['txtNumeroReg']);
						$txtAsesorReg = intval($post['txtAsesorReg']);						

						$grado = new Modelo\Grado($txtNumeroReg,$txtAsesorReg,"");

						$html .= "<br/><hr/><br/>";
						$controlador->registrar($grado);
						$html .= $mensaje;

						break;
					}
					case '>>': {
						$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />";

						$txtClaveEdi = intval($post['txtClaveEdi']);

						$grado = new Modelo\Grado($txtClaveEdi,$txtClaveEdi,$txtClaveEdi);

						$registro = $controlador->consultaLight($grado,Modelo\GradoDAO::QTODO);

						if (empty($registro)) { 
							echo "<script>"; ###### REVISAR
							echo "alert('NO EXISTE EL REGISTRO!!! Redirigiendo al comienzo...');";
							echo "</script>";
							header("Refresh: 2; URL=grados.php");
						}

						$fila = $registro->fetch_row();

	$html .= "<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' value='".$fila[0]."' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' value='".$fila[1]."' />
			</label>
			<input type='submit' name='accion' value='EDITAR' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";						

						break;
					}
					case 'EDITAR': {
						$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />
			<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' disabled='true' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' disabled='true' />
			</label>
			<input type='submit' name='accion' value='EDITAR' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";
						$txtClaveEdi = intval($post['txtClaveEdi']);
						$txtNumeroEdi = intval($post['txtNumeroEdi']);
						$txtNombreEdi = $post['txtNombreEdi'];

						$grado = new Modelo\Grado($txtNumeroEdi,$txtNombreEdi,"");

						$html .= "<br/><hr/><br/>";
						$controlador->actualizar($grado,$txtClaveEdi);
						$html .= $mensaje;

						break;
					}
					case 'BORRAR': {
						$html = "<form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
		<p><label>Consultar por:<select name='cmbConsulta' onchange='eventoConsulta(this)'>
			<option selected disabled value='-1'>**ELIJA UNA OPCION**</option>
			<option value='0'>Numero</option>
			<option value='1'>Asesor</option>
			<option value='2'>Letra</option>
			<option value='3'>Todo</option>
			</select> <input type='text' name='txtConsulta' id='txtConsulta' />
			</label>
			<input type='submit' name='accion' value='CONSULTAR' />
		</p>
	</form>
	<form name='frmRegistrar' method='post' action='estudiantes.php' onsubmit='return validarRegistro()'>
		<p>Registrar: <label>Numero grado: <input type='text' name='txtNumeroReg' placeholder='Numero Grado' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtAsesorReg' placeholder='Nombre Asesor' />
			</label>
			<input type='submit' name='accion' value='REGISTRAR' />
		</p>
	</form>
	<form name='frmEditar' method='post' action='estudiantes.php' onsubmit='return validarEdicion()'>
		<p>Editar registro con clave:<label>Clave: <input type='text' name='txtClaveEdi' placeholder='Numero Grado' disabled='true' /></label>
			<input type='submit' name='accion' value='>>' onclick='return validarConsultaEdicion()' />
			<label>Grado numero: <input type='text' name='txtNumeroEdi' placeholder='Numero Grado' disabled='true' /></label>
			<label>Nombre completo asesor: <input type='text' name='txtNombreEdi' placeholder='Nombre Asesor' disabled='true' />
			</label>
			<input type='submit' name='accion' value='EDITAR' />
		</p>
	</form>
	<form name='frmBorrar' method='post' action='estudiantes.php' onsubmit='return validarBorrado()'>
		<p>Borrar: <label>Clave: <input type='text' name='txtClaveBor' placeholder='Numero Grado' /></label>			
		</p>
		<input type='submit' name='accion' value='BORRAR' />
	</form>";
						$txtClaveBor = intval($txtClaveBor);

						$html .= "<br/><hr/><br/>";
						$controlador->borrar($txtClaveBor);
						$html .= $mensaje;

						break;
					}
					default:
						printf("Error! No existe esa opcion");
						exit(1);
						break;
				}

				unset($post['accion']);
			}
		}
	}