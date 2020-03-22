package calculatorApplication;

public class Test {
	public static void main (String [] args) {
		String num = "12345";
		
		for(int i=0; i<num.length(); i++) {
			char number = num.charAt(i);
			System.out.println(number);
		}
	}
}
