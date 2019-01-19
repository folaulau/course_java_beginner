package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utility.Contants;
import utility.ScreenDimensionUtil;

public class CheckOutScreen extends JPanel{

	private JButton submit = new JButton("submit");
	
	public CheckOutScreen(){
		System.out.println("CheckOutScreen()");
		setBounds(0, 150, ScreenDimensionUtil.SCREEN_WIDTH, ScreenDimensionUtil.SCREEN_HEIGHT);
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
	
	
}
