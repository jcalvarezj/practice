class Pakiman {
	constructor(name,hp,atk,type) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.type = type;

		this.image = new Image();
		this.image.src = images[this.name];
	}

	speak() {
		alert(this.name);
	}

	show() {
		document.body.appendChild(this.image);
		document.write("<p>");
		document.write("<strong>"+this.name+"</strong><br/>");
		document.write("HP: "+this.hp+"<br/>");
		document.write("ATK: "+this.atk+"<br/>");
		document.write("</p><hr/>");
	}
}
