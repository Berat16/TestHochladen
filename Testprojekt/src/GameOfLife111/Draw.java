package GameOfLife111;

import java.awt.*;
import javax.swing.*;


public class Draw extends JLabel {
	 
	
	public void paint(Graphics g){
		
//		int dx;
//		 int dy;
//	    Random random;
//	     Color color;
//	 dx = 30;
//     dy = 30;
//     random = new Random();
//		
//		super.paint(g);
//		Graphics2D g2d = (Graphics2D) g;
//		
//		for (int i = 0; i < getHeight(); i = i + dx)
//        {
//            for (int j = 0; j < getWidth(); j = j + dy)
//            {
//                color = new Color(random.nextInt(255),
//                        random.nextInt(255), random.nextInt(255));
//                g2d.setColor(color);
//                g2d.fillRect(j, i, dx, dy);
//            }
//        }
//		
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
//		
//		g.setColor(Color.BLUE);
//		g.drawRect(9, 9, Gui.WIDTH+2, Gui.HEIGHT+2);	// Rahmen für das Spiel; ab 10,10 fängt das Spiel an; +2 weil wir ein Pixel weiter anfangen und über den Rand gehen
		
		
		
		
		for (int x = 0; x < GameMaster.CELLCOUNT; x++) {	//generierte Zellen werden gezeichnet
			for (int y = 0; y < GameMaster.CELLCOUNT; y++) {
				if (GameMaster.cells[x][y]) {
					g.setColor(Color.BLUE);					//Schwarz wenn Zelle lebt
				//	g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);	// OFF weil es nicht am Rand sondern im Spielfeld sein soll
					
					g.fillRect(x * 15, y * 15, 15, 15);
					
				}else {
					g.setColor(Color.WHITE);
				//	g.drawRect(x + Gui.XOFF, y + Gui.YOFF, 1, 1);	//Rechteck zeichnen für 1x1 Pixel
					
					g.fillRect(x * 15, y * 15, 15, 15);
				}
			}
			
		}
		
		g.setColor(Color.BLACK);
		for (int i = 0; i < 31; i++) {		// Raster Fenster
			g.drawLine(15 * i, 0, 15 * i, 450);		
			g.drawLine(0, 15 * i, 450, 15 * i);

		}
		repaint();
	}

}
