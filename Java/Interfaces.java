public class Interfaces{

	public static void main(String args[]) {
		//C c = new C();
		C.metodo();
	}

}

interface A {
	default static void metodo() {
		System.out.println("AAAA");
	}
}

interface B {
	default static void metodo() {
		System.out.println("BBBB");
	}
}

class C implements A, B {
	
	@Override
	public static void metodo() {
		A.super.metodo();
	}
}
