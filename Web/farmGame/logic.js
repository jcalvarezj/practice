/*
 * Logic of farm.html (random positions for animals) goes here
 * Based on John Freddy Vega's examples from Platzi
 */
var canvas = document.getElementById("villaplatzi");
var paper = canvas.getContext("2d");

var map = {
	url: "tile.png",
	loaded: false
}
map.image = new Image();
map.image.src = map.url;
map.image.addEventListener("load",loadMap);

var chicken = {
	url: "pollo.png",
	loaded: false
}
chicken.image = new Image();
chicken.image.src = chicken.url;
chicken.image.addEventListener("load",loadChicken);

var cow = {
	url: "vaca.png",
	loaded: false

}
cow.image = new Image();
cow.image.src = cow.url;
cow.image.addEventListener("load",loadCow);

var pig = {
	url: "cerdo.png",
	loaded: false
}
pig.image = new Image();
pig.image.src = pig.url;
pig.image.addEventListener("load",loadPig);

var nCows = randomNumber(5,20);
var nPigs = randomNumber(5,9);
var nChickens = randomNumber(7,12);

function randomNumber(min, max) {
	var result = Math.floor(Math.random()*(max-min+1))+min;
	return result;
}

function loadMap() {
	map.loaded = true;
	draw();
}

function loadPig() {
	pig.loaded = true;
	draw();
}

function loadCow() {
	cow.loaded = true;
	draw();
}

function loadChicken() {
	chicken.loaded = true;
	draw();
}

function draw() {
	if(map.loaded)
		paper.drawImage(map.image,0,0);

	if(pig.loaded) {
		for(var i=0; i<nPigs; i++) { 			
			var x = randomNumber(0,7);
			x *= 60;
			var y = randomNumber(0,7);
			y *= 60;
			paper.drawImage(pig.image,x,y);
		}
	}

	if(cow.loaded) {
		for(var i=0; i<nCows; i++) { 			
			var x = randomNumber(0,7);
			x *= 60;
			var y = randomNumber(0,7);
			y *= 60;
			paper.drawImage(cow.image,x,y);
		}
	}

	if(chicken.loaded) {
		for(var i=0; i<nChickens; i++) { 			
			var x = randomNumber(0,7);
			x *= 60;
			var y = randomNumber(0,7);
			y *= 60;
			paper.drawImage(chicken.image,x,y);
		}
	}
}
