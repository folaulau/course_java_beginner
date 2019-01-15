package model;

public class Drink extends Product {

	// user enum {small, medium, large}
	private String size;
	
	public Drink() {
		this(null,null,null);
	}
	
	public Drink(String name, Double price, String size) {
		super();
		super.setName(name);
		super.setPrice(price);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Drink [name=" + super.getName() + ", price=" + super.getPrice() + ", size=" + size + "]";
	}
	
	
}
