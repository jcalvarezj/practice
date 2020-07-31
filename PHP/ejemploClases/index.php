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
	
$account = new Account("Andres Herrera", 8888, "a@email.com", "1234");

echo "<b>Datos de Cuenta:</b> ".$account->toString()."<br/>";

$car = new Car();
$car->driver = $account;
$car->license = "AMQ123";
$car->passenger = 4;

$info = $car->driver->toString();

echo generarMensaje("Datos del car","$info maneja $car->license");


function generarMensaje($title, $message) {
	return "<p><b>$title</b> $message<br/></p>";
}
?>
		</div>
	</body>
</html>

