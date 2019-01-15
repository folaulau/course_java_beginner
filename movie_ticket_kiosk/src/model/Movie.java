package model;

import java.util.Date;
import java.util.List;

public class Movie extends Product{

	private List<Date> showTimes;
	
	public Movie() {
		this(null,null,null);
	}
	
	public Movie(String name, Double price, List<Date> showTimes) {
		super();
		super.setName(name);
		super.setPrice(price);
		this.showTimes = showTimes;
	}
	
	public List<Date> getShowTimes() {
		return showTimes;
	}
	
	public void setShowTimes(List<Date> showTimes) {
		this.showTimes = showTimes;
	}

	@Override
	public String toString() {
		return "Movie [name=" + super.getName() + ", price=" + super.getPrice() + ", showTimes=" + showTimes + "]";
	}
	
}
