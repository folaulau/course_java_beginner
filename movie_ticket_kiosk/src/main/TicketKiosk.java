package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicketKiosk {

	// add soda, popcorn, etc
	// find a real threatre thingy
	
	public static void main(String[] args) {
		List<String> movies = Arrays.asList("Star War II","Spiderman","Superman","Batman","Ironman","Captain America");
		System.out.println("Welcome to Lau's Cinemax!");
		double ticketPrice = 10.50;
		
		System.out.println("Available movies");
		System.out.println("Ticket price: $"+ticketPrice);
		System.out.println();
		
		for(int i=0;i<movies.size();i++) {
			System.out.println((i+1)+". "+movies.get(i));
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
