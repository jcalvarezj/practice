/*
  This program tests the Wildcard operator (?) for generic classes. It is used to receive any type, restrict to superclasses, and to make variables read-only
*/

import java.util.List;
import java.util.ArrayList;

public class Wildcard {

	public static void main(String args[]) {
		ArrayList<Integer> readOnlyList = new ArrayList<>();
		readOnlyList.add(1);
		readOnlyList.add(3);
		Wildcard.method(readOnlyList);

		// Thing<?,? extends Number> thing = new Thing<String,String>(new String("cosa"), new String("nnn")); // DOESN'T WORK, SECOND TYPE SHOULD BE NUMBER OR SUBTYPE 
		Thing<?,? extends Number> thing = new Thing<String,Integer>(new String("cosa"), new Integer(8)); 
		System.out.println("DATA: "+thing.data + " NUMBER: "+thing.number);
		// thing.data = "datos"; thing.number = 11111;  // DOES NOT WORK AS ? MAKES IT READ-ONLY
	}

	static void method(List<?> readOnly) {
		System.out.println("RO: "+readOnly);
		// readOnly.add(new Integer(333));   // DOES NOT WORK AS ? MAKES IT READ-ONLY
	}

}

class Thing<E,F> {

	public Thing(E data, F number) { this.data = data; this.number = number; }

	E data;

	F number;

}
