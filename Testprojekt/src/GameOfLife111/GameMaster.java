package GameOfLife111;

import java.util.concurrent.ThreadLocalRandom;


public class GameMaster {

	public static final int CELLCOUNT = 30; // Anzahl Zellen; Spielfeld von 512*512 Zellen
	public static boolean[][] cells = new boolean[CELLCOUNT][CELLCOUNT];	//jede Stelle im Array repräsentiert eine Zelle
	
	int startCells = 100; 	// Zellen der 1. Generation
	static int generation = 0;
	
	public void setup () {
		for (int i = 0; i < startCells; i++) {	// Generation der verschiedenen Zellen
			int x = random(0, CELLCOUNT);	// Min ist Spielfeld 0 und Max ist Cellcount, also können
			int y = random (0, CELLCOUNT);	// wir entweder am Nullten X-Wert oder am 512. X-Wert eine Zelle generieren
			
			cells[x][y] = true;		// Random generierte Zelle wird true gesetzt
		}
	}
	
	public static int neighbours (int x, int y) {		// berechnet die Nachbarn, das x und y der Zelle die wir überprüfen wollen
		int count = 0;
		//Anfang Mitte Rechts, Uhrzeigersinn
		int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
		int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for (int i = 0; i < 8; i++) {	// wegen 8 Nachbarn
			try {
			if (cells[x + xoff[i]] [y + yoff[i]]) count++;	// wenn sich dort eine lebende Zelle befindet, wird hochgezählt
			} catch (Exception e) {		// Exception wenn wir am Rand sind, Zellen am Rand werden ignoriert
				
			}
		}
		return count;		
	}
	
	
	public static void nextGen() {		// berechnet die nächste Generation
		generation++;
		System.out.println("Generation: " + generation);
		
		for (int x = 0; x < CELLCOUNT; x++) {
			for (int y = 0; y < CELLCOUNT; y++) {
				int n = neighbours(x,y);	// Anzahl der Nachbarn für die aktuell betrachtete Zelle wird abgespeichert
				
				//Regel 1: Vermehrung
				if (n == 3 && !cells[x][y]) {	// wir haben 3 Nachbarn && die betrachtete Zelle lebt nicht
					cells[x][y] = true;
				}
				
				//Regel 2: Vereinsamung
				if (n < 2) {
					cells[x][y] = false;		// stirbt bei weniger als 2 Nachbarn
				}
				
				//Regel 3: Zelle bleibt unverändert
				if (n == 2 || n == 3) {
					
				}
				
				//Regel 4: Überbevölkerung		// stirbt bei >3 Nachbarn
				if (n > 3) {
					cells[x][y] = false;
				}
			}	
		}
	}
	
	public static int random (int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);	// wenn zB der letzte Wert auch drin sein soll, dann muss man max+1 machen
	}
}
