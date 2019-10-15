/*
 * Logic of atm.html for the ATM example
 * Based on John Freddy Vega's examples from Platzi
 * @author J. Alvarez
 */
var button = document.getElementById("btnGo");
button.addEventListener("click",calculate);

var machine = [];
machine.push(new BillPack(50,3));
machine.push(new BillPack(20,2));
machine.push(new BillPack(10,2));

var totalMoney = 0;
var textTotal = document.getElementById("totalMoney");
var textBills = document.getElementById("currentBills");

printMachineBills();

textTotal.innerHTML = "$"+totalMoney;

var resultTag = document.getElementById("answer");

function printMachineBills() {
	textBills.innerHTML = "";
	totalMoney = 0;

	for(var entry of machine) {
		totalMoney += entry.value*entry.quantity;
		textBills.innerHTML += entry.quantity+" bills of $"+entry.value+"<br/>";
	}
}

function calculate() {
	var money = parseInt(document.getElementById("txtAmount").value);
	var remainder = money;

	var result = [];

	for(var b of machine) {
		if(remainder > 0) {
			var div = Math.floor(remainder/b.value);
			var neededBills = 0;
	
			if(b.quantity < div)
				neededBills = b.quantity;
			else 
				neededBills = div;	
	
			result.push(new BillPack(b.value,neededBills));
			remainder -= b.value*neededBills;
		}
	}

	if (remainder > 0) {
		resultTag.innerHTML += "I don't have enough bills for $" + money
			+ ", sorry :(<br/><hr/>";
	}
	else {
		totalMoney -= money;
		textTotal.innerHTML = "$"+totalMoney;
		resultTag.innerHTML += "Ka-ching! For the requested $" + money 
			+" This session returned:<br/>";

		for(var packIndex in result) { 
			result[packIndex].show();
			machine[packIndex].quantity -= result[packIndex].quantity;
		}

		printMachineBills();

		resultTag.innerHTML += "<br/><hr/>"
	}
}
