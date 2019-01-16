package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Drink;
import model.Movie;
import model.Popcorn;
import model.Product;
import service.ProductService;

public class TicketKiosk {

	private ProductService productService;

	private List<Product> shoppingCart;

	private Scanner scanner;

	TicketKiosk() {
		productService = new ProductService();
		shoppingCart = new ArrayList<>();
	}

	private boolean isCancel(Object input) {
		String cancel = "c", CANCEL = "C";
		if (cancel.equals(input.toString()) || CANCEL.equals(input.toString())) {
			System.out.println("\n\n");
			return true;
		}
		return false;
	}

	// add soda, popcorn, etc
	// find a real threatre thingy
	public static void main(String[] args) throws InterruptedException {
		TicketKiosk ticketKiosk = new TicketKiosk();
		ticketKiosk.run();
	}

	private void run() throws InterruptedException {
		List<Movie> movies = productService.getAllMovies();
		List<Drink> drinks = productService.getAllDrinks();
		List<Popcorn> popcorn = productService.getAllPopcorn();
		
		String input = null;

		System.out.println("Welcome to Lau's Cinemax!");
		
		while (true) {
			
			
			System.out.println("Available movies");
			System.out.println("Enter c to cancel your transcation at anytime.");
			System.out.println();

			for (int i = 0; i < movies.size(); i++) {
				System.out.println((i + 1) + ". " + movies.get(i).getName() + " $"
						+ String.format("%.2f", movies.get(i).getPrice()));
			}

			System.out.println();
			System.out.println("Please select a movie.");
			System.out.print("Enter movie number:");

			scanner = new Scanner(System.in);

			input = scanner.next();

			if (isCancel(input)) {
				continue;
			}

			int selectedMovieNumber = Integer.parseInt(input);

			Movie selectedMovie = movies.get(selectedMovieNumber - 1);

			shoppingCart.add(selectedMovie);

			System.out.println();
			System.out.println("You selected " + selectedMovie.getName() + " at $"
					+ String.format("%.2f", selectedMovie.getPrice()));

			System.out.println();
			System.out.print("How many tickets would you like? ");
			scanner = new Scanner(System.in);

			input = scanner.next();

			if (isCancel(input)) {
				continue;
			}

			int numberOfTickets = Integer.parseInt(input);

			double totalPrice = shoppingCart.stream().mapToDouble(i -> i.getPrice()).sum() * numberOfTickets;

			System.out.println("Your total: $" + String.format("%.2f", totalPrice));
			
			System.out.print("Snacks(s) or pay now(p): ");

			input = scanner.next();

			if (isCancel(input)) {
				continue;
			}

			String payNow = input;

			if (payNow.equals("p")) {

				System.out.print("You have $");

				scanner = new Scanner(System.in);

				double customerMoney = scanner.nextDouble();

				double change = customerMoney - totalPrice;

				System.out.println(
						"Here is " + numberOfTickets + " tickets and your change $" + String.format("%.2f", change));

				System.out.println("Enjoy the movie!");
				
				shoppingCart = new ArrayList<>();
				
			} else {
				System.out.println("Please try again.");
			}
			
			Thread.sleep(1500);
			
			System.out.println("\n\n");
		}

	}
}
