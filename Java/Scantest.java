import java.util.Scanner;

public class Scantest {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = 0;
		while(a != 999) {
			System.out.println("Wrtie something; nothing, to quit");
			a = s.nextInt();
			System.out.println(""+a); 
		}
	}
}
