package movie_ticket_kiosk;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicketKiosk {

	public static void main(String[] args) {
		List<String> movies = Arrays.asList("Star War II","Spiderman","Superman","Batman","Ironman","Captain America");
		System.out.println("Welcome to Lau's Cinemax!");
		System.out.println("Available movies");
		System.out.println();
		
		for(int i=0;i<movies.size();i++) {
			System.out.println((i+1)+". "+movies.get(i));
		}
		System.out.println();
		System.out.println("Please select a movie.");
		System.out.print("Enter movie number:");
		Scanner scanner = new Scanner(System.in);
		
		String selectedMovieNumber = scanner.nextLine();
		System.out.println();
		System.out.println("You selected "+movies.get(Integer.parseInt(selectedMovieNumber)-1));
		
		System.out.println("Enjoy your movie!");
	}
}
