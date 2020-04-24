package guiBeispiele;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Aaa1 extends JPanel implements Runnable {

	//private static final long serialVersionUID = 1L;

	final int CELLCOUNT = 30;	//	anklickbare Zellen
	private Bbb1[][] cell = new Bbb1[CELLCOUNT][CELLCOUNT];
	private boolean start = false;
	
	

	public Aaa1() {
		initCells();
		this.addMouseListener(new MouseController(this));
		this.setFocusable(true);
		this.addKeyListener(new KeyController(this));
		
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Das Spiel des Lebens");
		frame.setSize(650, 850);
		frame.setLocationRelativeTo(null);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Aaa1 game = new Aaa1();
		frame.setContentPane(game);
		frame.setVisible(true);
		new Thread(game).start();
		
	}

	public void calculateNextStep() {
		for (int x = 0; x < CELLCOUNT; x++) {
			for (int y = 0; y < CELLCOUNT; y++) {
				int count = 0;
				for (int dx = -1; dx <= 1; dx++) {
					for (int dy = -1; dy <= 1; dy++) {
						int xx = x + dx;
						int yy = y + dy;
						if (!(dx == 0 && dy == 0) && isInside(xx, yy)) {
							if (cell[xx][yy].getAlive()) {
								count++;
							}
						}
					}
				}
				if (cell[x][y].getAlive()) {
					boolean alive = (count == 2 || count == 3);
					cell[x][y].setNextState(alive);
				} else {
					cell[x][y].setNextState(count == 3);
				}
			}
		}
	}

	private boolean isInside(int xx, int yy) {
		return xx >= 0 && yy >= 0 && xx < CELLCOUNT && yy < CELLCOUNT;
	}

	public void initCells() {
		for (int x = 0; x < CELLCOUNT; x++) {
			for (int y = 0; y < CELLCOUNT; y++) {
				cell[x][y] = new Bbb1(false, x * 30, y * 30);	//jjjjj
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < CELLCOUNT; x++) {		//aktive, anklickbare Rasterfläche
			for (int y = 0; y < CELLCOUNT; y++) {
				cell[x][y].paintCell(g);
			}
		}
		g.setColor(Color.BLACK);
		for (int i = 0; i < 31; i++) {				// Raster ?
			g.drawLine(15 * i, 0, 15 * i, 900);		// Raster Fenster 900x900 Groß
			g.drawLine(0, 15 * i, 900, 15 * i);
		
		}
	}

	public void doStep(){
		calculateNextStep();
		for (int x = 0; x < CELLCOUNT; x++) {
			for (int y = 0; y < CELLCOUNT; y++) {
				cell[x][y].step();
			}
		}
	}
	
	public void run() {
		while (true) {
			if (start) {
				doStep();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}

	}

	public void setStart(boolean b) {
		start = b;
	}

	public void setCellAlive(int x, int y, boolean b) {
		cell[x][y].setAlive(true);
	}
}

class KeyController extends KeyAdapter {
	private Aaa1 gol;

	public KeyController(Aaa1 gol) {
		this.gol = gol;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			gol.setStart(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			gol.setStart(false);
		}
	}
}

class MouseController extends MouseAdapter {
	private Aaa1 gol;

	public MouseController(Aaa1 gol) {
		this.gol = gol;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 30;
		int y = e.getY() / 30;
		gol.setCellAlive(x, y, true);
		System.out.println("X: " + x + " Y: " + y);
	}
}
