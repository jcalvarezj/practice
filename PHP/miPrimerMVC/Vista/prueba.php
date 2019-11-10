<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script type="text/javascript">
		function evento(elemento) {
			var seleccion = elemento.value;
			if(seleccion == '1')
				document.getElementById("cambia").style.fontSize = "34px";
			else
				document.getElementById("cambia").style.fontSize = "12px";
		}

		function habilitar() {
			var abled = document.getElementById("combobox").disabled;
//			alert("El estado ANTERIOR es: "+abled + "... "+(abled=='false')+" . "+(abled=='true'));

			if(document.getElementById("combobox").disabled == true)
				document.getElementById("combobox").disabled = false;
			else
				document.getElementById("combobox").disabled = true;
		}

		function perra() {
			alert("JS ES UNA PERRA");
			return false;
		}
	</script>
</head>
<body>
	<p id="cambia" onclick="habilitar()">ESTO CAMBIA; SI SE CLICKEA DESHABILITA EL COMBOBOX</p>&nbsp;&nbsp;&nbsp;&nbsp;
	<select id="combobox" onchange="evento(this)">
		<option disabled selected>--ELIJA UNA OPCION--</option>
		<option value='0'>
			aaaaaaaaaaaa
		</option>
		<option value='1'>
			bbbbbbbbbbbb
		</option>
	</select>
	<form name="miFormulario">
		<input type="text" name="miTxt" />
		<button onclick="return perra();">aaa</button>
	</form>
	<!--?php 
		require "../Librerias/funcionesAutoload.php";

		importarEnSubcarpeta();

		$pepe = new Vista\Principal();
	?-->
	
</body>

</html>