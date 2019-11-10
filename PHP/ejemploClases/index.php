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
	echo "<b>Ejemplo muy basico de Orientacion a Objetos</b><br/>";
/*
	$cuenta = new Account();
	$cuenta->id = 123456789;
	$cuenta->name = "sadfasdfasdf";

	echo "<b>Cuenta sin constructor: "+$cuenta->toString()+"</b>";
 */
	$cuentaConstruc = new Account(8888,"nombre");

	echo "<b>Cuenta con constructor: ".$cuentaConstruc->toString()."</b>";
?>
		</div>
	</body>
</html>

