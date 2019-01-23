package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Drink;
import model.Movie;
import model.Popcorn;
import model.Product;
import service.ProductService;
import utility.Contants;
import utility.HtmlEntity;
import utility.ScreenDimensionUtil;

public class CheckOutScreen extends JPanel {

	private JButton submit = new JButton("pay");

	private ProductService productService;
	private double change;
	private double orderTotal;
	
	public CheckOutScreen() {
		System.out.println("CheckOutScreen()");
		productService = new ProductService();

		setBounds(0, 60, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		// setBackground(Color.RED);
		setLayout(null);
		setBackground(Color.GRAY);

	}

	public void printOrder() {
		List<Product> products = productService.getShoppingCart();
		orderTotal = productService.getTotal();
		
		StringBuilder order = new StringBuilder();

		order.append("<html><br/><b>Your order</b><br/><br/>");

		// movies
		order.append("Movies:<br>");

		for (Product product : products) {
			if (product instanceof Movie) {
				Movie movie = (Movie) product;
				order.append(HtmlEntity.getSpaces(3) + movie.getName() + " $" + movie.getQuantity() * movie.getPrice());
				order.append("<br/>");
			}
		}

		order.append("<br/>");

		order.append("Snacks:<br/>");

		for (Product product : products) {
			if (product instanceof Drink) {
				Drink drink = (Drink) product;
				order.append(HtmlEntity.getSpaces(3) + drink.getName() + " $" + drink.getQuantity() * drink.getPrice());
				order.append("<br>");
			}
		}

		order.append("<br/>");

		order.append("</html>");
		System.out.println(order.toString());

		JLabel orderText = new JLabel();
		orderText.setText(order.toString());
		orderText.setBounds(50, 20, 400, 250);
		orderText.setForeground(Color.BLACK);
		
		JLabel totalText = new JLabel();
		totalText.setText("Total: $"+orderTotal);
		totalText.setBounds(250, 30, 200, 30);
		
		
		JTextField customerMoney = new JTextField();
		customerMoney.setBounds(250, 60, 200, 30);
		
		submit.setBounds(250, 100, ScreenDimensionUtil.BUTTON_WIDTH,
				ScreenDimensionUtil.BUTTON_HEIGHT);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pay order");
				String input = customerMoney.getText();
				
				if(input!=null && input.isEmpty()==false) {
					double customerInput = Double.parseDouble(input);
					
					change = customerInput-orderTotal;
					System.out.println("input: "+customerInput+", orderTotal: "+orderTotal+", change: "+change);
					
					if(change==0) {
						productService.resetShoppingCart();
					}
					
					repaint();
				}
			}
		});
		
		add(totalText);
		add(submit);
		add(customerMoney);
		add(orderText);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("paintComponent(..)");
		System.out.println("Your change $"+change);
		g.drawString("Your change $"+change, 250,160);
	}

}
