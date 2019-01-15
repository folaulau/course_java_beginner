package model;

import java.util.Date;
import java.util.List;

public class Popcorn extends Product {

	// use enum here {small, medium, large}
	private String size;
	
	public Popcorn() {
		this(null,null,null);
	}
	
	public Popcorn(String name, Double price, String size) {
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
		return "Popcorn [name=" + super.getName() + ", price=" + super.getPrice() + ", size=" + size + "]";
	}
}
