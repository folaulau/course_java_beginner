package controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Drink;
import model.Movie;
import model.Popcorn;
import service.ProductService;
import utility.Contants;
import utility.ScreenDimensionUtil;
import view.CheckOutScreen;
import view.MovieScreen;
import view.SnackScreen;

public class TicketKioskController extends JFrame {

	JPanel homeScreen = new JPanel();
	private MovieScreen movieScreen;
	private CheckOutScreen checkOutScreen;
	private SnackScreen snackScreen;
	
	private JButton homeBtn = new JButton("Home");
	private JButton snackBtn = new JButton("Snack");
	private JButton checkOutBtn = new JButton("Checkout");
	
	private JButton submitMovie = new JButton("next");
	private JButton submitSnack = new JButton("next");
	private JButton submitOrder = new JButton("submit");
	
	private ProductService productService;

	public TicketKioskController() {

		setSize(ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);

		setLocation(ScreenDimensionUtil.SCREEN_LOCATION_X, ScreenDimensionUtil.SCREEN_LOCATION_Y);

		setTitle("Movie Ticket Kiosk");
		
		Container con = getContentPane();
		con.setLayout(null);
		
		productService = new ProductService();

		movieScreen = new MovieScreen();
		checkOutScreen = new CheckOutScreen();
		snackScreen = new SnackScreen();
		
		homeScreen.setBounds(0, 0, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		homeScreen.setLayout(null);
		homeScreen.add(movieScreen);
		
		homeBtn.setBounds(50, 10, ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		homeScreen.add(homeBtn);

		snackBtn.setBounds(50+ScreenDimensionUtil.BUTTON_WIDTH*1+10, 10, ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		homeScreen.add(snackBtn);

		checkOutBtn.setBounds(50+ScreenDimensionUtil.BUTTON_WIDTH*2+20, 10, ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		homeScreen.add(checkOutBtn);

		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action home btn");
				goTo(Contants.HOME_SCREEN);
			}
		});
		snackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action snack btn");
				goTo(Contants.SNACK_SCREEN);
			}
		});
		checkOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action checkout btn");
				goTo(Contants.CHECKOUT_SCREEN);
			}
		});
		
		submitMovie.setBounds(50, (int)(ScreenDimensionUtil.SCREEN_HEIGHT*.45), ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		submitMovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("submit movie and go to snack");
				movieScreen.submit();
				goTo(Contants.SNACK_SCREEN);
			}
		});
		
		movieScreen.add(submitMovie);
		
		submitSnack.setBounds(50, (int)(ScreenDimensionUtil.SCREEN_HEIGHT*.80), ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		submitSnack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("submit snack and go to checkout");
				snackScreen.submit();
				goTo(Contants.CHECKOUT_SCREEN);
			}
		});
		
		snackScreen.add(submitSnack);
		
		submitOrder.setBounds(50, (int)(ScreenDimensionUtil.SCREEN_HEIGHT*.65), ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		submitOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("submit order");
			}
		});
		
		checkOutScreen.add(submitOrder);
		
		
		
		con.add(homeScreen);
	}

	// add soda, popcorn, etc
	// find a real threatre thingy
	public static void main(String[] args) throws InterruptedException {

		EventQueue.invokeLater(() -> {
			TicketKioskController ticketKiosk = new TicketKioskController();
			ticketKiosk.setVisible(true);
		});
	}

	private void run() throws InterruptedException {
		
	}
	
	public void goTo(String screen) {
		System.out.println("go to: " + screen);

		switch (screen) {
		case Contants.SNACK_SCREEN:
			
			//this.checkOutScreen.setVisible(false);
			//this.snackScreen.setVisible(true);
			
			//homeScreen.removeAll();
			homeScreen.remove(snackScreen);
			homeScreen.remove(checkOutScreen);
			homeScreen.remove(movieScreen);
			homeScreen.add(snackScreen);
			snackScreen.revalidate();
			snackScreen.repaint();
//			homeScreen.revalidate();
//			homeScreen.repaint();
			break;
		case Contants.CHECKOUT_SCREEN:
			//this.checkOutScreen.setVisible(true);
			//this.snackScreen.setVisible(false);
			//homeScreen.removeAll();
			homeScreen.remove(snackScreen);
			homeScreen.remove(checkOutScreen);
			homeScreen.remove(movieScreen);
			checkOutScreen.removeAll();
			checkOutScreen.printOrder();
			homeScreen.add(checkOutScreen);
			
			checkOutScreen.revalidate();
			checkOutScreen.repaint();
			//homeScreen.revalidate();
			//homeScreen.repaint();
			break;
		case Contants.MOVIE_SCREEN:
			//this.checkOutScreen.setVisible(true);
			//this.snackScreen.setVisible(false);
			//homeScreen.removeAll();
			homeScreen.remove(snackScreen);
			homeScreen.remove(checkOutScreen);
			homeScreen.remove(movieScreen);
			homeScreen.add(movieScreen);
			movieScreen.revalidate();
			movieScreen.repaint();
			//homeScreen.revalidate();
			//homeScreen.repaint();
			break;
		default:// movie or home screen
			//this.checkOutScreen.setVisible(false);
			//this.snackScreen.setVisible(false);
			//homeScreen.removeAll();
			homeScreen.remove(snackScreen);
			homeScreen.remove(checkOutScreen);
			homeScreen.remove(movieScreen);
			homeScreen.add(movieScreen);
			homeScreen.revalidate();
			homeScreen.repaint();
			break;
		}
	}
}
