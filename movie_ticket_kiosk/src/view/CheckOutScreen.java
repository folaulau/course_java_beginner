package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Drink;
import model.Movie;
import model.Popcorn;
import model.Product;
import service.ProductService;
import utility.Contants;
import utility.HtmlEntity;
import utility.ScreenDimensionUtil;

public class CheckOutScreen extends JPanel{

	private JButton submit = new JButton("submit");
	
	private ProductService productService;
	
	public CheckOutScreen(){
		System.out.println("CheckOutScreen()");
		productService = new ProductService();
		
		setBounds(0, 60, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
		//setBackground(Color.RED);
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
		
	}
	
	public void printOrder() {
		List<Product> products = productService.getShoppingCart();
//		System.out.println("printOrder()");
//		this.productService.getShoppingCart().forEach((p)->{
//			System.out.println(p.toString());
//		});
		
		StringBuilder order = new StringBuilder();
		
		order.append("<html><br><b>Your order</b><br><br>");
		
		// movies
		order.append("Movies:<br>");

		for(Product product : products) {
			if(product instanceof Movie) {
				Movie movie = (Movie)product;
				order.append(HtmlEntity.getSpaces(3)+movie.getName()+" $"+movie.getQuantity()*movie.getPrice());
				order.append("<br>");
			}
		}
		
		order.append("<br>");
		
		order.append("Snacks:<br>");

		for(Product product : products) {
			if(product instanceof Drink) {
				Drink drink = (Drink)product;
				order.append(HtmlEntity.getSpaces(3)+drink.getName()+" $"+drink.getQuantity()*drink.getPrice());
				order.append("<br>");
			}
		}
		
		order.append("<br>");
        
        order.append("</html>");
        
		JLabel orderText = new JLabel(order.toString());
		orderText.setBounds(50, 20, 900, 500);
		orderText.setForeground(Color.BLACK);
		
		add(orderText);
	}
	
	public void payOrder() {
		
	}
	
	
}
