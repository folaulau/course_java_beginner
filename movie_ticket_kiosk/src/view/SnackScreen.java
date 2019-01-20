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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import model.Drink;
import model.Popcorn;
import service.ProductService;
import utility.ScreenDimensionUtil;

public class SnackScreen extends JPanel {

	private JButton submit = new JButton("submit");

	private List<Drink> drinks;
	private List<Popcorn> popcorn;

	private ProductService productService;

	public SnackScreen() {
		System.out.println("SnackScreen()");
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

		int min = 1;
		int max = 100;
		int step = 1;
		int initValue = 1;

		JLabel supermanImg = new JLabel(new ImageIcon("lemonade.jpeg"));
		supermanImg.setBounds(50, 30, 150, 200);
		add(supermanImg);

		JSpinner supermanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		supermanJSpinner.setBounds(150, 240, 50, 20);
		add(supermanJSpinner);

		JLabel supermanQty = new JLabel("Qty");
		supermanQty.setBackground(Color.BLACK);
		supermanQty.setBounds(120, 240, 100, 20);
		add(supermanQty);

		// ===
		JLabel batmanImg = new JLabel(new ImageIcon("sprite.jpeg"));
		batmanImg.setBounds(250, 30, 150, 200);
		add(batmanImg);

		JSpinner batmanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		batmanJSpinner.setBounds(350, 240, 50, 20);
		add(batmanJSpinner);

		JLabel batmanQty = new JLabel("Qty");
		batmanQty.setBackground(Color.BLACK);
		batmanQty.setBounds(320, 240, 100, 20);
		add(batmanQty);

		// ===
		JLabel fantaImg = new JLabel(new ImageIcon("fanta.jpeg"));
		fantaImg.setBounds(450, 30, 150, 200);
		add(fantaImg);

		JSpinner fantaJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

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

		JSpinner cokeJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

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

		JSpinner pepsiJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

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

		JSpinner popcornJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));

		popcornJSpinner.setBounds(150, 490, 50, 20);
		add(popcornJSpinner);

		JLabel popcornQty = new JLabel("Qty");
		popcornQty.setBackground(Color.BLACK);
		popcornQty.setBounds(120, 490, 100, 20);
		add(popcornQty);

		drinks = productService.getAllDrinks();
		popcorn = productService.getAllPopcorn();

	}
}
