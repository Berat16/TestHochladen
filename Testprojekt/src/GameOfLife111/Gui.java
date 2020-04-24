package GameOfLife111;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gui {
	
	JFrame frame;
	JButton button;
	public static Draw draw;
	
	
	//public static final int WIDTH = 30, HEIGHT = 30, XOFF = 1, YOFF = 1; // blaues Spielfeld fängt 10 Pixel weiter rechts/unten an

	
	public void create(){
		frame = new JFrame ("Game of Life");
		frame.setSize(470, 570);	// Fenster
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//frame.setResizable(false);
		
		button = new JButton("Next Generation");
		button.setBounds(250, 480, 150, 25);
		button.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GameMaster.nextGen();
			}
			
		});
		
		frame.add(button);
		
		draw = new Draw();
	//	draw.setBounds(0, 0, 470, 570);	// x, y, width, height
		draw.setVisible(true);
		frame.add(draw);
		
		
		frame.setVisible(true);		
	
	}
	
}
