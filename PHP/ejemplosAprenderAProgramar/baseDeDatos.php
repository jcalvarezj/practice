<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Programa prueba CRUD Base de Datos</title>
	<style type="text/css">
		table, td, th {
			border: solid black 1px;
		}

		.todo {
			background-color: #77bbbb;
			border-style: outset;
		}
	</style>
</head>
<body>
	<?php
		require "funcionesBaseDeDatos.php";
	?>
	<p>Este es un ejemplo de conexión con la base de datos a nivel local. Para efecto de funcionamiento debe existir la base de datos en el servidor local.</p>

	<div class="todo">
		<p>A continuación se presenta un CRUD para la base de datos de personas y empresas, especificamente solo para personas según las empresas que ya hay en la base de datos:</p>

		<div id="infoTabla" class="operacion">
			<p>Empresas ya registradas en la base de datos</p>
			<form action="./baseDeDatos.php" method="POST">
				<label>Cedula</label>
			</form>
		</div>
		<div class="operacion">
			<p>Inserción</p>
			<form action="./baseDeDatos.php" method="POST">
				<label>Cedula</label>
			</form>
		</div>
	</div>
	<br/>
	<div class="todo">
		<p>La siguiente es una prueba de listado de una tabla de una base de datos local (empresas):</p>

		<div class="infoTabla">
			<?php 
			##### Ojo: Probando con GET
				if (isset($_GET['accion']) && $_GET['accion'] == "completa")
					echo leerTablaCompleta("empresas");
				else
					echo "<p>Aqui respuesta</p>";
			?>
		</div>

		<form method="POST" action="baseDeDatos.php?accion=completa">
			<input type="submit" name="accion" value="MOSTRAR!"/>
		</form>
	</div>
	<br/>
	<div class="todo">
		<p>La siguiente es una prueba de listado de una tabla de una base de datos remota:</p>

		<div class="infoTabla">
		<?php

		$conexion = mysqli_connect("sql103.byethost16.com","b16_19013890","MaestroDragon77");

		if($conexion)
			echo "<p><b>CONEXION LOCAL EN REMOTA CORRECTA!!!</b></p>";
		else
			echo "<p><b>FALLO!!!</b></p>";

		myslqi_close($conexion);

		?>
		</div>
	</div>
	<br/>
	<a href="index.php">VOLVER</a>
</body>
</html>