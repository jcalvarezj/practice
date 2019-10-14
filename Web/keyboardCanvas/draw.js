/*
 * Based on John Freddy Vega's examples from Platzi
 */
document.addEventListener("keyup",drawWithArrows);

var keys = {
	LEFT: 37,
	UP: 38,
	RIGHT: 39,
	DOWN: 40
};

var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

var x = canvas.width/2;
var y = canvas.height/2;

drawLine("black", x-1, y-1, x+1, y+1, context);

function drawWithArrows(evt) {
	var theColor = "blue";
	var step = 10;

	switch(evt.keyCode) {
		case keys.LEFT:
			drawLine(theColor, x, y, x-step, y, context);
			x -= step;
			console.log("Going left!");
			break;
		case keys.UP:
			drawLine(theColor, x, y, x, y-step, context);
			y -= step;
			console.log("Going up!");
			break;
		case keys.RIGHT:
			drawLine(theColor, x, y, x+step, y, context);
			x += step;
			console.log("Going right!");
			break;
		case keys.DOWN:
			drawLine(theColor, x, y, x, y+step, context);
			y += step;
			console.log("Going down!");
			break;
		default:
			console.log("BLAH");
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

