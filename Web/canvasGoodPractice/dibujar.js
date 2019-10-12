var texto = document.getElementById("texto_lineas");
var boton = document.getElementById("boton");

boton.addEventListener("click", dibujarPorClick);

var canvas = document.getElementById("dibujo");
var lienzo = canvas.getContext("2d");
var ancho = canvas.width;

function dibujarLinea(color, xin, xfin, yin, yfin) {
	lienzo.beginPath();
	lienzo.strokeStyle = color;
	lienzo.moveTo(xin,xfin);
	lienzo.lineTo(yin,yfin);
	lienzo.stroke();
	lienzo.closePath();
}

function dibujarPorClick() {
	var contenido = texto.value;
	var numLineas = parseInt(contenido);
	var l = 1;

	var espacio = ancho/numLineas;

	do {
		var x1 = l*espacio;
		var y1 = ancho-(l-1)*espacio;

		dibujarLinea("green",0,y1,x1,0);
		l++;
	} while (l <= numLineas);

	dibujarLinea("black",1,1,1,canvas.width-1);
	dibujarLinea("black",1,canvas.width-1,canvas.width-1,canvas.width-1);
}
