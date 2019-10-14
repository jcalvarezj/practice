/*
 * Example of the ATM algorithm. Change machine's bills in code.
 * Not following best practice of separating class files for a quick example
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>
#include <cstring>

class BillPack {
	private:
		int quantity;
		int value;
	public:
		BillPack(): value(-1), quantity(-1) {};
		BillPack(int value, int quantity): value(value), quantity(quantity) {};
		
		int getQuantity() {
			return quantity;
		}
		
		int getValue() {
			return value;
		}

		std::string toString() {
			std::stringstream ss;
			ss << "$" << value << " (" << quantity << ")";
			return ss.str();
		}
};

void cleanBillPacks(BillPack * b) {
	delete [] b;
}

int main(int argc, char ** args) {
	const unsigned int ENTRIES = 3;

	BillPack * machine = new BillPack[ENTRIES];
	machine[0] = BillPack(50,3);
	machine[1] = BillPack(20,2);
	machine[2] = BillPack(10,2);
	
	int combinations = 1;

	std::cout << "The ATM has the following entries:" << std::endl;

	for(unsigned int i=0; i<ENTRIES; i++) {
		std::cout << "\tATM at " << i << ": " << machine[i].toString() 
			<< std::endl;
		combinations *= (machine[i].getQuantity()+1);
	}

	std::cout << "Maximum of " << combinations << " bill packs" << std::endl;
	std::cout << std::endl;

	unsigned int value = 0;
	std::cout << "Please enter the value to represent: " << std::endl << "$";
	std::cin >> value;

	std::cout << std::endl << "Solving!! Algorithm: " << std::endl;

	BillPack * result = new BillPack[combinations];
	unsigned int remainder = value;
	unsigned int j = 0;
	unsigned int acceptedBills = 0;

	while(remainder > 0 && j < ENTRIES) {
		std::cout << "Current remainder: " << remainder << std::endl; 

		int currentValue = machine[j].getValue();
		int billsNeeded = remainder/currentValue;

		std::cout << "We need " << billsNeeded << " of " << currentValue
			<< std::endl;

		if(billsNeeded > 0) {
			int billsInMachine = machine[j].getQuantity();

			if(billsInMachine - billsNeeded >= 0) {
				result[acceptedBills] = BillPack(currentValue,billsNeeded);
				j++;
				acceptedBills++;
				remainder -= currentValue*billsNeeded;
				std::cout << "New remainder: " << remainder << std::endl;
			}
			else {
				result[acceptedBills] = BillPack(currentValue,billsInMachine);
				j++;
				acceptedBills++;
				remainder -= currentValue*billsInMachine;
				std::cout << "New remainder: " << remainder << std::endl;
			}
		}
		else {			
			std::cout << "$" << currentValue << " bills won't do, moving on" 
				<< " to next bill" << std::endl;
			j++;
		}
	}

	std::cout << std::endl << "The result is " << std::endl;

	for(unsigned int k=0; k<acceptedBills; k++)
		std::cout << "\t" << result[k].toString() << std::endl;

	if(remainder>0)
		std::cout << std::endl << "Sorry, there is no solution!!!" << std::endl;

	cleanBillPacks(machine);
	cleanBillPacks(result);

	return 0;
}

