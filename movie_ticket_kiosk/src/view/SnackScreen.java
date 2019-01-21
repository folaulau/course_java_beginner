package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import model.Drink;
import model.Movie;
import model.Popcorn;
import service.ProductService;
import utility.ScreenDimensionUtil;

public class SnackScreen extends JPanel {

	private JButton submit = new JButton("submit");

	private List<Drink> selectedDrinks;
	private List<Popcorn> selectedPopcorn;
	
	private List<Drink> drinks;
	private List<Popcorn> popcorn;

	private ProductService productService;
	
	JSpinner lemonadeJSpinner;
	JSpinner spriteJSpinner;
	JSpinner fantaJSpinner;
	JSpinner cokeJSpinner;
	JSpinner pepsiJSpinner;
	JSpinner popcornJSpinner;
	
	public SnackScreen() {
		System.out.println("SnackScreen()");
		
		selectedDrinks = new ArrayList<>();
		selectedPopcorn = new ArrayList<>();
		
		// setBackground(Color.GREEN);
		setBounds(0, 60, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		setLayout(null);
		setBackground(Color.GRAY);
		submit.setBounds(50, (int) (ScreenDimensionUtil.SCREEN_HEIGHT * .9), ScreenDimensionUtil.BUTTON_WIDTH,
				ScreenDimensionUtil.BUTTON_HEIGHT);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action submit btn");
			}
		});
		add(submit);

		productService = new ProductService();

		int min = 0;
		int max = 100;
		int step = 1;
		int initValue = 0;

		JLabel lemonadeImg = new JLabel(new ImageIcon("lemonade.jpeg"));
		lemonadeImg.setBounds(50, 30, 150, 200);
		add(lemonadeImg);

		lemonadeJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		lemonadeJSpinner.setBounds(150, 240, 50, 20);
		add(lemonadeJSpinner);

		JLabel lemonadeQty = new JLabel("Qty");
		lemonadeQty.setBackground(Color.BLACK);
		lemonadeQty.setBounds(120, 240, 100, 20);
		add(lemonadeQty);

		// ===
		JLabel spriteImg = new JLabel(new ImageIcon("sprite.jpeg"));
		spriteImg.setBounds(250, 30, 150, 200);
		add(spriteImg);

		spriteJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		spriteJSpinner.setBounds(350, 240, 50, 20);
		add(spriteJSpinner);

		JLabel spriteQty = new JLabel("Qty");
		spriteQty.setBackground(Color.BLACK);
		spriteQty.setBounds(320, 240, 100, 20);
		add(spriteQty);

		// ===
		JLabel fantaImg = new JLabel(new ImageIcon("fanta.jpeg"));
		fantaImg.setBounds(450, 30, 150, 200);
		add(fantaImg);

		fantaJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		fantaJSpinner.setBounds(550, 240, 50, 20);
		add(fantaJSpinner);

		JLabel fantaQty = new JLabel("Qty");
		fantaQty.setBackground(Color.BLACK);
		fantaQty.setBounds(520, 240, 100, 20);
		add(fantaQty);

		// ===
		JLabel cokeImg = new JLabel(new ImageIcon("coke.jpeg"));
		cokeImg.setBounds(650, 30, 150, 200);
		add(cokeImg);

		cokeJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		cokeJSpinner.setBounds(750, 240, 50, 20);
		add(cokeJSpinner);

		JLabel cokeQty = new JLabel("Qty");
		cokeQty.setBackground(Color.BLACK);
		cokeQty.setBounds(720, 240, 100, 20);
		add(cokeQty);

		// ===
		JLabel pepsiImg = new JLabel(new ImageIcon("pepsi.jpeg"));
		pepsiImg.setBounds(850, 30, 150, 200);
		add(pepsiImg);

		pepsiJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		pepsiJSpinner.setBounds(950, 240, 50, 20);
		add(pepsiJSpinner);

		JLabel pepsiQty = new JLabel("Qty");
		pepsiQty.setBackground(Color.BLACK);
		pepsiQty.setBounds(920, 240, 100, 20);
		add(pepsiQty);

		// ===
		JLabel popcornImg = new JLabel(new ImageIcon("popcorn.jpeg"));
		popcornImg.setBounds(50, 280, 150, 200);
		add(popcornImg);

		popcornJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		popcornJSpinner.setBounds(150, 490, 50, 20);
		add(popcornJSpinner);

		JLabel popcornQty = new JLabel("Qty");
		popcornQty.setBackground(Color.BLACK);
		popcornQty.setBounds(120, 490, 100, 20);
		add(popcornQty);

		drinks = productService.getAllDrinks();
		popcorn = productService.getAllPopcorn();

	}

	public List<Drink> getSelectedDrinks() {
		return selectedDrinks;
	}

	public List<Popcorn> getSelectedPopcorn() {
		return selectedPopcorn;
	}
	
	public void submit() {
		
		this.productService.removeAllSnacks();
		
		int lemonadeValue = Integer.parseInt(lemonadeJSpinner.getValue().toString());

		if (lemonadeValue > 0) {
			Drink lemonade = new Drink(Drink.LEMONADE,2.50,Drink.LARGE);
			lemonade.setQuantity(lemonadeValue);
			this.productService.addProduct(lemonade);
		}
		
		int spriteValue = Integer.parseInt(spriteJSpinner.getValue().toString());

		if (spriteValue > 0) {
			Drink sprite = new Drink(Drink.SPRITE,2.50,Drink.LARGE);
			sprite.setQuantity(spriteValue);
			this.productService.addProduct(sprite);
		}
		
		int fantaValue = Integer.parseInt(fantaJSpinner.getValue().toString());

		if (fantaValue > 0) {
			Drink lemonade = new Drink(Drink.FANTA,2.50,Drink.LARGE);
			lemonade.setQuantity(fantaValue);
			this.productService.addProduct(lemonade);
		}
		
		int cokeValue = Integer.parseInt(cokeJSpinner.getValue().toString());

		if (cokeValue > 0) {
			Drink coke = new Drink(Drink.COKE,2.50,Drink.LARGE);
			coke.setQuantity(cokeValue);
			this.productService.addProduct(coke);
		}
		
		int pepsiValue = Integer.parseInt(pepsiJSpinner.getValue().toString());

		if (pepsiValue > 0) {
			Drink pepsi = new Drink(Drink.PEPSI,2.50,Drink.LARGE);
			pepsi.setQuantity(pepsiValue);
			this.productService.addProduct(pepsi);
		}
		
		int popcornValue = Integer.parseInt(popcornJSpinner.getValue().toString());

		if (popcornValue > 0) {
			Popcorn popcorn = new Popcorn(Popcorn.ACT_II,5.50,Popcorn.LARGE);
			popcorn.setQuantity(popcornValue);
			this.productService.addProduct(popcorn);
		}
		
		this.productService.getShoppingCart().forEach((p)->{
			System.out.println(p.toString());
		});
	}
	
}
