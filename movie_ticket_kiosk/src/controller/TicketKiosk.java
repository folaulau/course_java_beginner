package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Movie;
import model.Product;
import service.MovieService;

public class TicketKiosk {
	
	private static MovieService movieService;
	
	private static List<Product> shoppingCart;

	// add soda, popcorn, etc
	// find a real threatre thingy
	
	public static void main(String[] args) {
		List<Movie> movies = movieService.getAll();
		
		List<Movie> selectedMovies = new ArrayList<>();
		
		System.out.println("Welcome to Lau's Cinemax!");
		
		double ticketPrice = 10.50;
		
		System.out.println("Available movies");
		System.out.println("Ticket price: $"+ticketPrice);
		System.out.println();
		
		for(int i=0;i<movies.size();i++) {
			System.out.println((i+1)+". "+movies.get(i).getName()+" $"+String.format("%.2f", movies.get(i).getPrice()));
		}
		
		System.out.println();
		System.out.println("Please select a movie.");
		System.out.print("Enter movie number:");
		
		Scanner scanner = new Scanner(System.in);
		
		int selectedMovieNumber = scanner.nextInt();
		
		System.out.println();
		System.out.println("You selected "+movies.get(selectedMovieNumber-1));
		
		System.out.println();
		System.out.print("How many tickets would you like? ");
		scanner = new Scanner(System.in);
		
		int numberOfTickets = scanner.nextInt();
		double totalPrice = ticketPrice*numberOfTickets;
		System.out.println("Your total: $"+(String.format("%.2f", totalPrice)));
		
		System.out.print("Pay now(y/n): ");
		
		scanner = new Scanner(System.in);
		
		String payNow = scanner.nextLine();
		
		if(payNow.equals("y")) {
			
			System.out.print("You have $");
			
			scanner = new Scanner(System.in);
			
			double customerMoney = scanner.nextDouble();
			
			double change = customerMoney-totalPrice;
			
			System.out.println("Here is "+numberOfTickets+" tickets and your change $"+String.format("%.2f", change));
			
			System.out.println("Enjoy the movie!");
		}else {
			System.out.println("Please try again.");
		}
	}
}
