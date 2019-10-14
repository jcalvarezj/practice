/*
 * Based on John Freddy Vega's examples from Platzi
 */
var x = 0;
var y = 0;
var xMov = 0;
var yMov = 0;

var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

canvas.addEventListener("mousedown",drawWithMouse);
canvas.addEventListener("mouseup",drawWithMouse);
canvas.addEventListener("mousemove",drawWithMouse);

var posX = canvas.offsetLeft;
var posY = canvas.offsetTop;

var draw = false;

var events = {
	MOUSEUP: "mouseup",
	MOUSEDOWN: "mousedown",
	MOUSEMOVE: "mousemove"
};

function drawWithMouse(evt) {
	var theColor = document.getElementById("selectColor").value;
	console.log(theColor);
	switch(evt.type) {
		case events.MOUSEDOWN:
			draw = true;
			x = evt.x - posX;
			y = evt.y - posY;
			break;
		case events.MOUSEUP:
			draw = false;
			break;
		case events.MOUSEMOVE:
			if(draw) {
				xMov = evt.movementX;
				yMov = evt.movementY;
				drawLine(theColor, x, y, x+xMov, y+yMov, context);
				x += xMov;
				y += yMov;
			}
			break;
	}

}

function drawLine(color, xin, xfin, yin, yfin, paper) {
	paper.beginPath();
	paper.strokeStyle = color;
	paper.lineWidth = 3;
	paper.moveTo(xin,xfin);
	paper.lineTo(yin,yfin);
	paper.stroke();
	paper.closePath();
}
