package guiBeispiele;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setLocation(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField();
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(100, 90, 80, 25);
		button.addActionListener(new Login());
		panel.add(button);
			
		success = new JLabel();
		success.setBounds(10, 120, 300, 25);
		panel.add(success);
	
		
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = passwordText.getText();
		
		if (user.equals ("Berat") && password.equals("123456")){
			success.setText("Login successful!");
			
			NewClass nc = new NewClass();	//öffnet das neue Fenster
			
		}else {
			success.setText("Password or username is wrong.");
			userText.setText("");
			passwordText.setText("");
		}
	}
	
	public class NewClass extends JFrame{
		public NewClass(){
			
			JPanel p = new JPanel();
			JFrame f = new JFrame();
			f.setSize(300,300);
			f.setLocation(600,300);
			f.setVisible(true);
			f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		//damit sich nicht alle Fenster schließen
			f.add(p);
			
			JLabel l = new JLabel("Welcome!");
			p.add(l);
		}
	}
	
}
