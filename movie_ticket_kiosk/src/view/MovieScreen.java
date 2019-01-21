package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.TicketKioskController;
import model.Movie;
import service.ProductService;
import utility.Contants;
import utility.ScreenDimensionUtil;

public class MovieScreen extends JPanel {

	private ProductService productService;

	JSpinner supermanJSpinner;
	JSpinner batmanJSpinner;
	JSpinner aquamanJSpinner;
	JSpinner ironmanJSpinner;
	JSpinner captainJSpinner;

	public MovieScreen() {
		System.out.println("HomeScreen()");

		productService = new ProductService();

		setBounds(0, 60, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		setLayout(null);
		setBackground(Color.GRAY);

		int min = 0;
		int max = 100;
		int step = 1;
		int initValue = 0;

		JLabel supermanImg = new JLabel(new ImageIcon("superman.jpeg"));
		supermanImg.setBounds(50, 30, 150, 200);
		add(supermanImg);

		supermanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		supermanJSpinner.setBounds(150, 240, 50, 20);

		add(supermanJSpinner);

		JLabel supermanQty = new JLabel("Qty");
		supermanQty.setBackground(Color.BLACK);
		supermanQty.setBounds(120, 240, 100, 20);
		add(supermanQty);

		// ===
		JLabel batmanImg = new JLabel(new ImageIcon("batman.jpeg"));
		batmanImg.setBounds(250, 30, 150, 200);
		add(batmanImg);

		batmanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		batmanJSpinner.setBounds(350, 240, 50, 20);
		add(batmanJSpinner);

		JLabel batmanQty = new JLabel("Qty");
		batmanQty.setBackground(Color.BLACK);
		batmanQty.setBounds(320, 240, 100, 20);
		add(batmanQty);

		// ===
		JLabel aquamanImg = new JLabel(new ImageIcon("aquaman.jpeg"));
		aquamanImg.setBounds(450, 30, 150, 200);
		add(aquamanImg);

		aquamanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		aquamanJSpinner.setBounds(550, 240, 50, 20);
		add(aquamanJSpinner);

		JLabel aquamanQty = new JLabel("Qty");
		aquamanQty.setBackground(Color.BLACK);
		aquamanQty.setBounds(520, 240, 100, 20);
		add(aquamanQty);

		// ===
		JLabel ironmanImg = new JLabel(new ImageIcon("ironman.jpeg"));
		ironmanImg.setBounds(650, 30, 150, 200);
		add(ironmanImg);

		ironmanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		ironmanJSpinner.setBounds(750, 240, 50, 20);
		add(ironmanJSpinner);

		JLabel ironmanQty = new JLabel("Qty");
		ironmanQty.setBackground(Color.BLACK);
		ironmanQty.setBounds(720, 240, 100, 20);
		add(ironmanQty);

		// ===
		JLabel captainImg = new JLabel(new ImageIcon("captain_america.jpeg"));
		captainImg.setBounds(850, 30, 150, 200);
		add(captainImg);

		captainJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		captainJSpinner.setBounds(950, 240, 50, 20);
		add(captainJSpinner);

		JLabel captainQty = new JLabel("Qty");
		captainQty.setBackground(Color.BLACK);
		captainQty.setBounds(920, 240, 100, 20);
		add(captainQty);

		// ===
	}

	public void submit() {
		
		this.productService.removeAllMovies();
		
		int supermanValue = Integer.parseInt(supermanJSpinner.getValue().toString());

		if (supermanValue > 0) {
			Movie superman = new Movie("Superman", 12.50, null);
			superman.setQuantity(supermanValue);
			this.productService.addProduct(superman);
		}

		int batmanValue = Integer.parseInt(batmanJSpinner.getValue().toString());

		if (batmanValue > 0) {
			Movie batman = new Movie("Batman", 12.50, null);
			batman.setQuantity(batmanValue);
			this.productService.addProduct(batman);
		}

		int aquamanValue = Integer.parseInt(aquamanJSpinner.getValue().toString());

		if (aquamanValue > 0) {
			Movie aquaman = new Movie("Aquaman", 12.50, null);
			aquaman.setQuantity(aquamanValue);
			this.productService.addProduct(aquaman);
		}

		int ironmanValue = Integer.parseInt(ironmanJSpinner.getValue().toString());

		if (ironmanValue > 0) {
			Movie ironman = new Movie("Ironman", 12.50, null);
			ironman.setQuantity(ironmanValue);
			this.productService.addProduct(ironman);
		}

		int captainValue = Integer.parseInt(captainJSpinner.getValue().toString());

		if (captainValue > 0) {
			Movie captain = new Movie("Captain America", 12.50, null);
			captain.setQuantity(captainValue);
			this.productService.addProduct(captain);
		}
		
		this.productService.getShoppingCart().forEach((p)->{
			System.out.println(p.toString());
		});
	}
}
