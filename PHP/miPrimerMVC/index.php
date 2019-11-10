<!DOCTYPE html>
<html>
<head>
	<title>Mi primer programa MVC en PHP</title>
	<link rel="stylesheet" type="text/css" href="./estilos/estilo.css">
	<!-- RECORDAR JS AL FINAL PARA QUE PUEDA ACCEDER A LOS ELEMENTOS DE LA
	PAGINA UNA VEZ ÉSTA HAYA ACABADO DE CARGAR -->
	<script type="text/javascript">
		function clickEstudiantes() {
			var accion = document.getElementById("accion");
			accion.value = "ESTUDIANTES";
			return false;
		}

		function clickSecciones() {
			var accion = document.getElementById("accion");
			accion.value = "SECCIONES";
			return false;
		}

		function clickGrados() {
			var accion = document.getElementById("accion");
			accion.value = "GRADOS";
			return false;
		}
		
	</script>
	<meta charset="utf-8" />
</head>
<body>
	<h2>Página de Inicio</h2>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./grados.php">CRUD de Grados</a></p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./secciones.php">CRUD de Secciones</a></p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./estudiantes.php">CRUD de Estudiantes</a></p>
	<form method="post" action="./index.php">
		<input type="hidden" name="accion" id="accion" />
		<button onclick="return clickGrados();" id="1" title="◘◘◘">LISTAR TODOS LOS GRADOS</button>
		<button onclick="return clickSecciones();" id="2" title="♦♦♦">LISTAR TODAS LAS SECCIONES</button>
		<button onclick="return clickEstudiantes();" id="3" title="♣♣♣">LISTAR TODOS LOS ESTUDUANTES</button>
	</form>
	<br/>
	<?php 
		require "./Librerias/funcionesAutoload.php";
		importarEnRaiz();

		$vista = new Vista\Principal();
		echo $vista->respuesta($_POST);
	?>	
</body>
</html>