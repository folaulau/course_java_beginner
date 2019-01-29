
public class Variable {
	
	// To create a variable, you must specify the type and assign it a value
	// The equal sign is used to assign values to the variable
	// type variable = value;
	
	public static void main(String[] args) {
		
		String name = "John";
		
		System.out.println("My name is "+name);
		
		int age = 21;
		
		System.out.println("I am "+age+" years old");
		
		// name is pointing to another container in memory
		// that has Peter as its value
		name = "Peter";
		
		// age is pointing to another container in memory 
		// that has 15 as its value
		age = 10 + 5;
		
		System.out.println("My name is "+name);
		System.out.println("I am "+age+" years old");
		
	}
}
