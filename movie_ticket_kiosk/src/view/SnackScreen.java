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
import javax.swing.border.Border;

import model.Drink;
import model.Popcorn;
import service.ProductService;
import utility.ScreenDimensionUtil;

public class SnackScreen extends JPanel{
	
	private JButton submit = new JButton("submit");
	
	private List<Drink> drinks;
	private List<Popcorn> popcorn;
	
	private ProductService productService;
	
	public SnackScreen(){
		System.out.println("SnackScreen()");
		//setBackground(Color.GREEN);
		setBounds(0, 150, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		setLayout(null);
		setBackground(Color.GRAY);
		submit.setBounds(50, (int)(ScreenDimensionUtil.SCREEN_HEIGHT*.9), ScreenDimensionUtil.BUTTON_WIDTH, ScreenDimensionUtil.BUTTON_HEIGHT);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action submit btn");
			}
		});
		add(submit);
		
		
		productService = new ProductService();
		
		JLabel label = new JLabel( new ImageIcon("superman.jpeg"));
		label.setBounds(50, 30, 150, 200);
		add(label);
		
		drinks = productService.getAllDrinks();
		popcorn = productService.getAllPopcorn();
		
		
	}
}
