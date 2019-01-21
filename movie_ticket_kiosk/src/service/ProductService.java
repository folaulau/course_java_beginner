package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import model.Drink;
import model.Movie;
import model.Popcorn;
import model.Product;

public class ProductService {

	private Map<String, Movie> movies;

	private Map<String, Drink> drinks;

	private Map<String, Popcorn> popcorn;

	private static final List<Product> shoppingCart = new ArrayList<>();

	public ProductService() {

		movies = new HashMap<>();
		movies.put("Batman", new Movie("Batman", 12.50, Arrays.asList(new Date())));
		movies.put("Ironman", new Movie("Ironman", 12.50, Arrays.asList(new Date())));
		movies.put("Captain America", new Movie("Captain America", 12.50, Arrays.asList(new Date())));
		movies.put("Spiderman", new Movie("Spiderman", 14.50, Arrays.asList(new Date())));
		movies.put("Avengers", new Movie("Avengers", 12.50, Arrays.asList(new Date())));
		movies.put("Superman", new Movie("Superman", 13.50, Arrays.asList(new Date())));

		drinks = new HashMap<>();

		drinks.put(Drink.SPRITE + Drink.SMALL, new Drink(Drink.SPRITE, 1.50, Drink.SMALL));
		drinks.put(Drink.SPRITE + Drink.MEDIUM, new Drink(Drink.SPRITE, 2.50, Drink.MEDIUM));
		drinks.put(Drink.SPRITE + Drink.LARGE, new Drink(Drink.SPRITE, 3.00, Drink.LARGE));

		drinks.put(Drink.LEMONADE + Drink.SMALL, new Drink(Drink.LEMONADE, 1.50, Drink.SMALL));
		drinks.put(Drink.LEMONADE + Drink.MEDIUM, new Drink(Drink.LEMONADE, 2.50, Drink.MEDIUM));
		drinks.put(Drink.LEMONADE + Drink.LARGE, new Drink(Drink.LEMONADE, 3.00, Drink.LARGE));

		drinks.put(Drink.WATER + Drink.SMALL, new Drink(Drink.WATER, 1.00, Drink.SMALL));
		drinks.put(Drink.WATER + Drink.MEDIUM, new Drink(Drink.WATER, 1.50, Drink.MEDIUM));
		drinks.put(Drink.WATER + Drink.LARGE, new Drink(Drink.WATER, 2.00, Drink.LARGE));

		popcorn = new HashMap<>();
		popcorn.put(Popcorn.ACT_II + Popcorn.SMALL, new Popcorn(Popcorn.ACT_II, 5.00, Popcorn.SMALL));
		popcorn.put(Popcorn.ACT_II + Popcorn.MEDIUM, new Popcorn(Popcorn.ACT_II, 7.75, Popcorn.MEDIUM));
		popcorn.put(Popcorn.ACT_II + Popcorn.LARGE, new Popcorn(Popcorn.ACT_II, 10.00, Popcorn.LARGE));

		popcorn.put(Popcorn.ORIVILLE + Popcorn.SMALL, new Popcorn(Popcorn.ORIVILLE, 5.00, Popcorn.SMALL));
		popcorn.put(Popcorn.ORIVILLE + Popcorn.SMALL, new Popcorn(Popcorn.ORIVILLE, 7.75, Popcorn.MEDIUM));
		popcorn.put(Popcorn.ORIVILLE + Popcorn.SMALL, new Popcorn(Popcorn.ORIVILLE, 10.00, Popcorn.LARGE));

		
	}

	public List<Movie> getAllMovies() {
		return movies.values().stream().collect(Collectors.toList());
	}

	public List<Popcorn> getAllPopcorn() {
		return popcorn.values().stream().collect(Collectors.toList());
	}

	public List<Drink> getAllDrinks() {
		return drinks.values().stream().collect(Collectors.toList());
	}

	public Movie getMovieByName(String name) {
		return movies.get(name);
	}

	public void addProduct(Product product) {
		shoppingCart.add(product);
	}

	public void resetShoppingCart() {
		Iterator<Product> it = shoppingCart.iterator();

		while (it.hasNext()) {
			Product product = it.next();
			it.remove();
		}
	}

	public double getTotal() {
		return shoppingCart.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
	}

	public int getNumOfSelectedTickets() {
		int total = 0;
		for (Product product : shoppingCart) {
			if (product instanceof Movie) {
				total += (product.getQuantity());
			}
		}
		return total;
	}

	public double getSelectedTicketsTotal() {
		double total = 0.0;
		for (Product product : shoppingCart) {
			if (product instanceof Movie) {
				total += (product.getQuantity() * product.getPrice());
			}
		}
		return total;
	}

	public List<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void removeAllMovies() {
		Iterator<Product> it = shoppingCart.iterator();

		while (it.hasNext()) {
			Product product = it.next();
			if (product instanceof Movie) {
				System.out.println("remove movie: "+product.getName());
				it.remove();
			}
		}
	}

	public void removeAllSnacks() {
		Iterator<Product> it = shoppingCart.iterator();

		while (it.hasNext()) {
			Product product = it.next();
			if (product instanceof Drink || product instanceof Popcorn) {
				System.out.println("remove snack: "+product.getName());
				it.remove();
			}
		}
	}

}
