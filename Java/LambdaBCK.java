import java.util.function.*;
import java.lang.Math;

public class Lambda {

	public static void main(String args[]) {
		int a = 9, b = 2;
		Operacion f1 = (x, y, z) -> ""+(x+y/x+y);
		Operacion op = new Operacion () {
			@Override
			public String sumaCadena(int a, int b, int c) {
				return ""+(a+b/a+b);
			}
		};

//		System.out.println(f1.sumaCadena(a,b));

		Function<Integer,String> function = (Integer p1) -> ""+(Math.pow(p1,2));

		System.out.println(function.apply(new Integer(2)));
	}

//	public int funcion(Operacion o)

}

interface Operacion {
	public String sumaCadena(int a, int b, int c);
}
