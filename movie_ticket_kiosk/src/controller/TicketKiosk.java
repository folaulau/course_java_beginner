package controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Drink;
import model.Movie;
import model.Popcorn;
import model.Product;
import service.ProductService;

public class TicketKiosk extends JFrame {

	private JButton button1 = new JButton("One");
	private JButton button2 = new JButton("Two");
	private JButton button3 = new JButton("Three");

	private ProductService productService;

	private Scanner scanner;

	private List<Movie> movies;
	private List<Drink> drinks;
	private List<Popcorn> popcorn;

	TicketKiosk() {
		productService = new ProductService();

		movies = productService.getAllMovies();
		drinks = productService.getAllDrinks();
		popcorn = productService.getAllPopcorn();

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		Container con = getContentPane();
		con.setLayout(new FlowLayout());

		con.add(panel1);
		con.add(panel2);

		panel1.add(button1);
		panel1.setBackground(Color.BLUE);
		panel2.add(button2);

		Image img = new ImageIcon("superman.jpeg").getImage();
		button3.setIcon(new ImageIcon(img));
		button3.setLocation(200, 200);
		button3.setSize(200, 300);

		panel2.add(button3);
		panel2.setBackground(Color.BLUE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width / 2, screenSize.height / 2);

		setLocation(screenSize.width / 3, 0);

		setTitle("Test Title");

		try {

			setIconImage(img);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);
		
		JMenu editMenu = new JMenu("Edit");

		JMenuItem pasteItem = new JMenuItem("Paste");
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		
		menuBar.add(editMenu);
	}

	// add soda, popcorn, etc
	// find a real threatre thingy
	public static void main(String[] args) throws InterruptedException {

		EventQueue.invokeLater(() -> {
			TicketKiosk ticketKiosk = new TicketKiosk();
			ticketKiosk.setVisible(true);
		});
	}

	private void run() throws InterruptedException {

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

			productService.addProduct(selectedMovie);

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

			double totalPrice = productService.getTotal();

			System.out.println("Your total: $" + String.format("%.2f", totalPrice));

			System.out.print("Snacks(s) or pay now(p): ");

			input = scanner.next();

			if (isCancel(input)) {
				continue;
			}

			String payNow = input;

			if (payNow.equals("p")) {
				checkOut();
				productService.resetShoppingCart();

			} else if (payNow.equals("s")) {

				if (servePopcorn() == false) {
					continue;
				}

				if (serveDrinks() == false) {
					continue;
				}

				checkOut();

			} else {
				System.out.println("Please try again.");
			}

			Thread.sleep(1500);

			System.out.println("\n\n");
		}

	}

	private boolean checkOut() {
		System.out.print("You have $");

		scanner = new Scanner(System.in);

		double customerMoney = scanner.nextDouble();

		double totalPrice = productService.getTotal();

		double change = customerMoney - totalPrice;

		int numberOfTickets = productService.getNumOfSelectedTickets();

		System.out.println("Here is " + numberOfTickets + " tickets and your change $" + String.format("%.2f", change));

		System.out.println("Enjoy the movie!");

		return true;
	}

	private boolean servePopcorn() {
		System.out.println("Select popcorn: ");
		for (int i = 0; i < popcorn.size(); i++) {
			System.out.println((i + 1) + ". " + popcorn.get(i).getName() + " $"
					+ String.format("%.2f", popcorn.get(i).getPrice()));
		}

		String input = scanner.next();

		if (isCancel(input)) {
			return false;
		}

		int selectedPopcornIndex = Integer.parseInt(input);

		Popcorn selectedPopcorn = popcorn.get(selectedPopcornIndex - 1);
		productService.addProduct(selectedPopcorn);

		return true;
	}

	private boolean serveDrinks() {
		System.out.println("Select drinks: ");
		for (int i = 0; i < drinks.size(); i++) {
			System.out.println(
					(i + 1) + ". " + drinks.get(i).getName() + " $" + String.format("%.2f", drinks.get(i).getPrice()));
		}

		String input = scanner.next();

		if (isCancel(input)) {
			return false;
		}

		int selectedDrinkIndex = Integer.parseInt(input);

		Drink drink = drinks.get(selectedDrinkIndex - 1);
		productService.addProduct(drink);

		return true;
	}

	private boolean isCancel(Object input) {
		String cancel = "c", CANCEL = "C";
		if (cancel.equals(input.toString()) || CANCEL.equals(input.toString())) {
			System.out.println("\n\n");
			return true;
		}
		return false;
	}
}
