package guiBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Clicks implements ActionListener {
	
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JFrame frame = new JFrame();

    
    public Clicks() {
        JButton button = new JButton("Click Me");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.setLocation(500,200);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Number of clicks:  " + clicks);
    }

    public static void main(String[] args) {
        new Clicks();
    }
}
