/*
 * NodeJS Express Server test
 */

var express = require("express");
var application = express();

application.get("/", hello);
application.get("/asdf",asdf);

function hello(request, response) {
	response.send("<p>Hello world</p>");
}

function asdf(request, response) {
	response.send("<a href='https://www.youtube.com/watch?v=CWBnMBz-zZU'>"
			+"ASDF MOVIE</a>");
}

application.listen(8080);
