<!DOCTYPE html>
<!--Description goes here.
	@author J. Alvarez-->
<html>
	<head>
		<title>Ejemplo de Orientacion a Objetos</title>
		<meta charset="UTF-8" />
	</head>
	<body>
		<div id="content">
<?php
require "Account.php";
require "Car.php";

echo "<b>Ejemplo muy basico de Orientacion a Objetos</b><br/><br/>";
	
$cuentaConstruc = new Account(8888,"nombre");

echo "<b>Datos de Cuenta:</b> ".$cuentaConstruc->toString()."<br/>";

$carro = new Car();
$carro->driver = "Andres Herrera";
$carro->license = "AMQ123";
$carro->passenger = 4;

echo generarMensaje("Datos del carro","$carro->driver maneja $carro->license");


function generarMensaje($titulo, $mensaje) {
	return "<p><b>$titulo</b> $mensaje<br/></p>";
}
?>
		</div>
	</body>
</html>

