import java.util.Optional;

public class TestingOptional {
	
	public static void main(String[] args) {  
		String s = null;
	
		String answer = (String) Optional.ofNullable(s).orElse("NULL!!1");
		
		System.out.println("The value is " + answer); 
	
	}	

}
