package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private List<Movie> movies;

	public MovieScreen() {
		System.out.println("HomeScreen()");
		
		setBounds(0, 60, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		setLayout(null);
		setBackground(Color.GRAY);
		
		int min = 1;
	    int max = 100;
	    int step = 1;
	    int initValue = 1;
		
		JLabel supermanImg = new JLabel( new ImageIcon("superman.jpeg"));
		supermanImg.setBounds(50, 30, 150, 200);
		add(supermanImg);
		
		JSpinner supermanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));
	    
		supermanJSpinner.setBounds(150, 240, 50, 20);
	    add(supermanJSpinner);
	    
	    JLabel supermanQty = new JLabel("Qty");
		supermanQty.setBackground(Color.BLACK);
		supermanQty.setBounds(120, 240, 100, 20);
		add(supermanQty);
		
		//===
		JLabel batmanImg = new JLabel( new ImageIcon("batman.jpeg"));
		batmanImg.setBounds(250, 30, 150, 200);
		add(batmanImg);
		
		JSpinner batmanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));
	    
		batmanJSpinner.setBounds(350, 240, 50, 20);
	    add(batmanJSpinner);
	    
	    JLabel batmanQty = new JLabel("Qty");
	    batmanQty.setBackground(Color.BLACK);
	    batmanQty.setBounds(320, 240, 100, 20);
		add(batmanQty);
		
		//===
		JLabel aquamanImg = new JLabel( new ImageIcon("aquaman.jpeg"));
		aquamanImg.setBounds(450, 30,150, 200);
		add(aquamanImg);
		
		JSpinner aquamanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));
	    
		aquamanJSpinner.setBounds(550, 240, 50, 20);
	    add(aquamanJSpinner);
	    
	    JLabel aquamanQty = new JLabel("Qty");
	    aquamanQty.setBackground(Color.BLACK);
	    aquamanQty.setBounds(520, 240, 100, 20);
		add(aquamanQty);
		
		//===
		JLabel ironmanImg = new JLabel( new ImageIcon("ironman.jpeg"));
		ironmanImg.setBounds(650, 30, 150, 200);
		add(ironmanImg);
		
		JSpinner ironmanJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));
	    
		ironmanJSpinner.setBounds(750, 240, 50, 20);
	    add(ironmanJSpinner);
	    
	    JLabel ironmanQty = new JLabel("Qty");
	    ironmanQty.setBackground(Color.BLACK);
	    ironmanQty.setBounds(720, 240, 100, 20);
		add(ironmanQty);
		
		//===
		JLabel captainImg = new JLabel( new ImageIcon("captain_america.jpeg"));
		captainImg.setBounds(850, 30, 150, 200);
		add(captainImg);
		
		JSpinner captainJSpinner = new JSpinner(new SpinnerNumberModel(initValue, min, max, step));
	    
		captainJSpinner.setBounds(950, 240, 50, 20);
	    add(captainJSpinner);
	    
	    JLabel captainQty = new JLabel("Qty");
	    captainQty.setBackground(Color.BLACK);
	    captainQty.setBounds(920, 240, 100, 20);
		add(captainQty);
		
		//===
		
		
		
	}
	
	
}
