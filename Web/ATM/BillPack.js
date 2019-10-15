class BillPack {
	constructor(value, quantity) {
		this.value = value;
		this.quantity = quantity;

		this.image = new Image();
		this.image.src = value+".png";
	}

	show() {
		for(var i=0; i<this.quantity; i++){
			document.getElementById("answer")
				.appendChild(this.image.cloneNode());
		}
	}
}
