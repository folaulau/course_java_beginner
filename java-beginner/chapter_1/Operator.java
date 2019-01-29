
public class Operator {

	public static void main(String[] args) {
		// assignment operator
		int age = 10;
		
		// arithmetic operator
		int total = 2 * 5;
		
		// comparison operator (> - greater than)
		if(age > 12) {
			System.out.println("age is more than 12");
		}
		
		// Logical operator (|| - or)
		boolean teenage = (10 > age || age < 20);
		
		System.out.println("teenage: "+teenage);
	}
}
