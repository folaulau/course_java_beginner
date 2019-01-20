package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utility.Contants;
import utility.ScreenDimensionUtil;

public class CheckOutScreen extends JPanel{

	private JButton submit = new JButton("submit");
	
	public CheckOutScreen(){
		System.out.println("CheckOutScreen()");
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

        String lyrics =  "<html>It's way too late to think of<br>" +
                "Someone I would call now<br>" +
                "And neon signs got tired<br>" +
                "Red eye flights help the stars out<br>" +
                "I'm safe in a corner<br>" +
                "Just hours before me<br>" +
                "<br>" +
                "I'm waking with the roaches<br>" +
                "The world has surrendered<br>" +
                "I'm dating ancient ghosts<br>" +
                "The ones I made friends with<br>" +
                "The comfort of fireflies<br>" +
                "Long gone before daylight<br>" +
                "<br>" +
                "And if I had one wishful field tonight<br>" +
                "I'd ask for the sun to never rise<br>" +
                "If God leant his voice for me to speak<br>" +
                "I'd say go to bed, world<br>" +
                "<br>" +
                "I've always been too late<br>" +
                "To see what's before me<br>" +
                "And I know nothing sweeter than<br>" +
                "Champaign from last New Years<br>" +
                "Sweet music in my ears<br>" +
                "And a night full of no fears<br>" +
                "<br>" +
                "But if I had one wishful field tonight<br>" +
                "I'd ask for the sun to never rise<br>" +
                "If God passed a mic to me to speak<br>" +
                "I'd say stay in bed, world<br>" +
                "Sleep in peace</html>";
        
		JLabel movieText = new JLabel(lyrics);
		movieText.setBounds(130, 200, 500, 500);
		//movieText.setLocation(120, 290);
		//movieText.setFont(new Font("Serif", Font.PLAIN, 14));
		movieText.setForeground(Color.BLACK);
		
		add(movieText);
		add(submit);
		
	}
	
	
}
