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
	
$cuenta = new Account("Andres Herrera", 8888, "a@email.com", "1234");

echo "<b>Datos de Cuenta:</b> ".$cuenta->toString()."<br/>";

$carro = new Car();
$carro->driver = $cuenta;
$carro->license = "AMQ123";
$carro->passenger = 4;

$info = $carro->driver->toString();

echo generarMensaje("Datos del carro","$info maneja $carro->license");


function generarMensaje($titulo, $mensaje) {
	return "<p><b>$titulo</b> $mensaje<br/></p>";
}
?>
		</div>
	</body>
</html>

