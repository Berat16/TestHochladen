//
//public class Testklasse {

//	public static void main(String[] args) {
//
//		Testing t = new Testing();
//
//		t.setName("Andy");
//		t.setAge(22);
//
//		System.out.println(t.getName());
//		System.out.println(t.getAge());
//
//		System.out.println("\nAbsatz");
//
//		
//		int[] a = { 1, 2, 3, 4, 5 };
//
//		for (int i = 0; i <= 6; i++) {
//			try {
//				System.out.println(a[i]);
//			} catch (Exception e) {
//				System.out.println("Überlauf");
//			}
//
//		}
//		System.out.println("Ende");
//	}
//}

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Testklasse {
	final int zellen =  50;
	boolean[][] leben = new boolean[zellen][zellen]; // 100 Quadrate + 1 Reihe drum
												// rum die nicht sichbar ist
	JButton Decaption; // manuelle Wahrscheinlichkeitsbestimmung -- noch nicht
						// eingefügt
	JButton Start; // Startet das Leben und Sterben
	JButton Stop; // Stop die Orgie
	JPanel p = new Panel(leben);
	JPanel e;
	MouseListener click;// Das Quadrat aus 100 Quadraten
	boolean d = false; // Decaption Regler (noch nicht eingebaut)
	boolean start = false; // Start/Stop-Regler geht nicht deswegen auf immer an
							// (true)
	JTextField Wahrscheinlichkeit; // Für Decaption --- Konnte noch nicht
									// getestet werden (Benutzte
									// Wahrscheinlichkeit.setTest())
	String w; // Text des JTextField
	double wahr; // umgeändert in ein double-wert
	int k = 0; // wahrscheinloch notwendige Variable --- noch nicht eingefügt
	double r = 0;
	// int r2=0; //RandomZahl für 1.Generation
	JFrame frame = new JFrame();;

	public static void main(String args[]) {
		Testklasse gui = new Testklasse();
		gui.los();
	}

	public void los() {
		Decaption = new JButton("Decaption"); // 3 Buttons
		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Wahrscheinlichkeit = new JTextField(); // 1 Textfeld
		Wahrscheinlichkeit.setText("0.5");
		w = Wahrscheinlichkeit.getText();
		wahr = Double.parseDouble(w); // schonmal in double umwandeln
		Decaption.addActionListener(new Decaption()); // alles zufügen
		Start.addActionListener(new Start());
		Stop.addActionListener(new Stop());
		Wahrscheinlichkeit.addActionListener(new Wahr());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // einrichten
		frame.getContentPane().add(BorderLayout.EAST, Decaption);
		frame.getContentPane().add(BorderLayout.NORTH, Stop);
		frame.getContentPane().add(BorderLayout.WEST, Start);
		frame.getContentPane().add(BorderLayout.SOUTH, Wahrscheinlichkeit);

		alife(); // erste Wahrscheinlichkeit in Quadrate umsetzten
		p = new Panel(leben);
		// Panel erstellen

		frame.getContentPane().add(p);

		frame.setSize(800, 600); // Size setzten
		frame.setVisible(true); // Sichtbar machen

		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			if (d == true) {
				alife();
				frame.getContentPane().remove(p);
				p = new Panel(leben);

				frame.getContentPane().add(p);
				frame.setVisible(true);
				d = false;
			}

			for (int i = p.getX() - 5; i < p.getX() + 10; i++) {
				for (int j = p.getY() - 5; i < p.getY() + 10; j++) {
					if (i > 0 && i < zellen && j > 0 && j < zellen)
						leben[i][j] = true;
					frame.getContentPane().remove(p);
					p = new Panel(leben);

					frame.getContentPane().add(p);
				}
			}
			while (start == true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				rules();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				frame.getContentPane().remove(p);
				p = new Panel(leben);

				frame.getContentPane().add(p);
				frame.setVisible(true);
			}
		}

	}

	class Decaption implements ActionListener { // Selbstgewählte
												// Wahrscheinlichkeit start
		public void actionPerformed(ActionEvent event) {
			d = true;
			start = false;

		}
	}

	class Start implements ActionListener { // Generationen Start
		public void actionPerformed(ActionEvent event) {
			start = true;
			d = false;

		}
	}

	class Stop implements ActionListener { // Generationen Stop
		public void actionPerformed(ActionEvent event) {
			start = false;
			d = false;
		}
	}

	class Wahr implements ActionListener { // Selbstgewählte Wahrscheinlichkeit
											// umgesetzt --- funktioniert nicht
		public void actionPerformed(ActionEvent event) {
			w = Wahrscheinlichkeit.getText();
			wahr = Double.parseDouble(w);
		}
	}

	public void rate() { // Wahrscheinlichkeitsberechnung
		r = Math.random();
		if (r < Double.parseDouble(Wahrscheinlichkeit.getText())) {
			r = 1;
		} else {
			r = 0;
		}
		// System.out.println(r);

	}

	public void alife() { // 1. Generation

		for (int i = 1; i < zellen; i++) {
			for (int j = 1; j < zellen; j++) {
				rate();
				if (r >= 1.0) {
					// System.out.println(r);
					leben[i][j] = true;
					// System.out.println(leben[i][j]);
				} else if (r <= 1.0) {
					leben[i][j] = false;
					// System.out.println(leben[i][j]);
				}

			}
		}
	}

	public void rules() { // Regeln:

		for (int i = 1; i < zellen; i++) // 1. Dimension
		{
			for (int j = 1; j < zellen; j++) // 2. Dimension
			{
				int al = 0;
				if (leben[i - 1][j])
					al++;
				if (leben[i + 1][j])
					al++;
				if (leben[i - 1][j - 1])
					al++;
				if (leben[i + 1][j - 1])
					al++;
				if (leben[i - 1][j + 1])
					al++;
				if (leben[i + 1][j + 1])
					al++;
				if (leben[i][j + 1])
					al++;
				if (leben[i][j - 1])
					al++;
				if (leben[i][j]) {
					if (al > 3) {
						leben[i][j] = false;
					} else if (al < 2) {
						leben[i][j] = false;
					} else if (al == 2 || al == 3) {
						leben[i][j] = true;
					}
				} else {
					if (al == 3) {
						leben[i][j] = true;
					} else
						leben[i][j] = false;
				}

			}
		}

	}

}

class Panel extends JPanel { // Panel zur Quadraterstellung
	boolean[][] l; // Leben[][] in ein l[][]

	public Panel(boolean[][] leben) {
		l = leben;
	}

	public Panel() {

	}

	public void paintComponent(Graphics g) { // Zeichen

		g.setColor(Color.black);
		for (int i = 1; i < 50; i++) { // Für jede Dimension
			for (int j = 1; j < 50; j++) {
				if (l[i][j] == true) {
					g.setColor(Color.white);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(i * 6, j * 6, 6, 6);

			}
		}

	}
}