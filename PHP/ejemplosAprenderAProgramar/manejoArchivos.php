<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Ejemplo de manejo de archivos en PHP</title>
	<style type="text/css">
		#cosa {
			resize: none;
		}
	</style>
	<script type="text/javascript">
		function borrarTextArea() {
			document.getElementById("cosa").innerHTML = "[[ROBOTNIK MEME]]";
			return false;
		}
	</script>
</head>
<body>
	<?php 
	
	require "./funcionesArchivos.php";
	if (isset($_POST['accion']) && $_POST['accion'] === '¡ESCRIBIR!') {
		if (empty($_POST['textarea1']))
			echo "<script>alert(\"NO HAY COSAS EN EL TEXTAREA!!!\");</script>";
		else {
			escribirArchivo($_POST['textarea1']);
			echo "<script>alert(\"SE HA ESCRITO, REVISAR ARCHIVO!\");</script>";
		}
	}


	?>
	<p>
	Este es un ejemplo de escritura de archivos que intentará guardar lo que hay en el textarea1 en el archivo prueba1.txt, y mostrará lo que hay en el archivo prueba2.txt en el textarea2 (si no existe muestra el error en el último).
	</p>
	<form action="manejoArchivos.php" method="post">
		<textarea id="cosa" name="textarea1" cols="50" rows="10"></textarea>
		<textarea name="textarea2" cols="50" rows="10" readonly="true"><?php 
		if (isset($_POST['accion']) && $_POST['accion'] === '¡LEER!') {
			echo cadenaArchivo();
			unset($_POST['accion']);
		}
		?></textarea><br/>
		<input type="submit" name="accion" value="¡ESCRIBIR!" />
		<input type="submit" name="accion" value="¡LEER!" />
		<button onclick="return borrarTextArea()">BORRAR TEXTAREA 1</button>
	</form>

</body>
</html>