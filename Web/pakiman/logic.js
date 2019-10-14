/*
 * Logic of pakiman.html for the Pakidex goes here
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
