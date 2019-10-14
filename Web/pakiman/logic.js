/*
 * Logic of farm.html for pig movement with arrow keys goes here
 * Based on John Freddy Vega's examples from Platzi
 */

var images = [];
images["Cauchin"] = "vaca.png";
images["Pokacho"] = "pollo.png";
images["Tocinauro"] = "cerdo.png";

var collection = [];
collection.push(new Pakiman("Pokacho", 80, 50, "volador"));
collection.push(new Pakiman("Cauchin", 100, 30, "tierra"));
collection.push(new Pakiman("Tocinauro", 120, 40, "tierra"));

for(pakiman of collection) { 
	pakiman.show();
}

console.log(pokacho,cauchin,tocinauro);



/*
var canvas = document.getElementById("villaplatzi");
var paper = canvas.getContext("2d");

var keys = {
	LEFT: 37,
	UP: 38,
	RIGHT: 39,
	DOWN: 40
};

var map = {
	url: "tile.png",
	loaded: false
}
map.image = new Image();
map.image.src = map.url;
map.image.addEventListener("load",loadMap);

var pig = {
	url: "cerdo.png",
	loaded: false,
	x: 0,
	y: 0
}
pig.image = new Image();
pig.image.src = pig.url;
pig.image.addEventListener("load",loadPig);

document.addEventListener("keydown",move);

function loadMap() {
	map.loaded = true;
	draw();
}

function loadPig() {
	pig.loaded = true;
	draw();
}

function draw() {
	if(map.loaded)
		paper.drawImage(map.image,0,0);
	if(pig.loaded)
		paper.drawImage(pig.image,pig.x,pig.y);
}

function move(evt) {
	var step = 10;
	switch(evt.keyCode) {
		case keys.LEFT:
			pig.x -= step;
			break;
		case keys.UP:
			pig.y -= step;
			break;
		case keys.RIGHT:
			pig.x += step;
			break;
		case keys.DOWN:
			pig.y += step;
			break;
	}
	draw();
}
*/
