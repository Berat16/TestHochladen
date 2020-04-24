import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GameOfLife_3 {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton[][] buttons = new JButton[10][10];
	GridLayout layout = new GridLayout(10, 10);

	GameOfLife_3() {

		gui();
	}

	public void gui() {
		// Frame erstellen

		frame = new JFrame("GameOfLife");
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocation(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.setLayout(new GridLayout());
		panel.setLayout(layout);
		
//		JButton button = new JButton ();
//		panel.add(button, BorderLayout.SOUTH);

		// Buttons erstellen
		int i = 0, j = 0;
		for (i = 0; i < buttons.length; i++) {
			for (j = 0; j < buttons[i].length; j++) {

			//	System.out.println("i" + i + "j" + j);
				buttons[i][j] = new JButton("");
				
			buttons[i][j].setBackground(Color.WHITE);
				
			panel.add(buttons[i][j], BorderLayout.CENTER);

			}

			frame.add(panel, BorderLayout.CENTER);
			
			frame.setVisible(true);
		}
	}

	public static void main(String[] args) {
		
		GameOfLife_3 s1 = new GameOfLife_3();
	}

}