<!DOCTYPE html>
<html>
<head>
	<title>Mi primer programa MVC en PHP</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="./estilos/estilo.css">
	<script type="text/javascript">
		var expRegLetras = new RegExp("^([A-Za-zñÑ])$");
		var expRegNumeros = new RegExp("^([0-9])$");

		function eventoConsulta(comboBox) {
			var seleccion = comboBox.value;
			if (seleccion == '3')
				document.getElementById("txtConsulta").disabled = true;
			else
				document.getElementById("txtConsulta").disabled = false;
		}

		function validarConsulta() {
			var form = "frmConsultar";
			var cmbConsulta = document.forms[form]["cmbConsulta"].value;
			var txtConsulta = document.forms[form]["txtConsulta"].value;
			if (cmbConsulta != '-1') {
				if (txtConsulta != "") {
					if (expRegNumeros.test(txtConsulta))
						return true;
					else {
						alert("Solo se admiten numeros!!!");
						return false;
					}
				}
				else {
					alert("No dejar campos en blanco!");
					return false
				}
			}
			else {
					alert("Debe seleccionar una opcion de consulta!!");
					return false;
			}
		}

		function validarRegistro() {
			var form = "frmRegistrar";
			var txtNumeroReg = document.forms[form]["txtNumeroReg"].value;
			var txtAsesorReg = document.forms[form]["txtAsesorReg"].value;

			if (txtNumeroReg != "" && txtAsesorReg != "") {				
				if (expRegLetras.test(txtAsesorReg)) {
					if (expRegNumeros.test(txtNumeroReg))
						return true;
					else {
						alert("Sólo se admiten números!!!!")
						return false;
					}
				}
				else {
					alert("Sólo se admiten letras y sin tildes!!!!")
					return false;
				}

			}
			else {
					alert("No dejar campos en blanco!!");
					return false;
			}
		}

		function validarConsultaEdicion() {
			var form = "frmEditar";
			var txtClaveEdi = document.forms[form]["txtClaveEdi"].value;
			
			if (txtClaveEdi != "") {
				if (expRegNumeros.test(txtClaveEdi))
					return true;
				else {
					alert("Sólo se admiten números!!!!")
					return false;
				}
			}
			else {
					alert("No dejar campo en blanco!!");
					return false;
			}
		}

		function validarEdicion() {
			var form = "frmRegistrar";
			var txtNumeroEdi = document.forms[form]["txtNumeroEdi"].value;
			var txtNombreEdi = document.forms[form]["txtNombreEdi"].value;
			
			if (txtNumeroEdi != "" && txtNombreEdi != "") {
				if (expRegLetras.test(txtNombreEdi)) {
					if (expRegNumeros.test(txtNumeroEdi))
						return true;
					else {
						alert("Sólo se admiten números!!!!")
						return false;
					}
				}
				else {
					alert("Sólo se admiten letras y sin tildes!!!!")
					return false;
				}

			}
			else {
					alert("No dejar campos en blanco!!");
					return false;
			}
		}

		function validarBorrado() {
			var form = "frmBorrar";
			var txtClaveBor = document.forms[form]["txtClaveBor"].value;
			
			if (txtClaveBor != "") {
				if (expRegNumeros.test(txtClaveBor))
					return true;
				else {
					alert("Sólo se admiten números!!!!")
					return false;
				}
			}
			else {
					alert("No dejar campo en blanco!!");
					return false;
			}
		}
	</script>
</head>
<body>
	<h2>CRUD de Grados</h2>
	<!-- Aqui formulario dinamico -->
	
	<?php 
		require './vista/CRUDGrados.php';

		$vista = new Vista\CRUDGrados();
		echo $vista->respuesta($_POST);
	?>
</body>
</html>

	<!--form name='frmConsultar' method='post' action='estudiantes.php' onsubmit='return validarConsulta()'>
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
	</form-->