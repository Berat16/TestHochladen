package GameOfLife111;


public class Main {

	public static void main(String[] args) {

		Gui g = new Gui();
		GameMaster gm = new GameMaster();
		GameClock gc = new GameClock();
		
		gm.setup();		// Punkte aufm Spielfeld werden verteilt
		g.create();		// GUI soll entstehen und gezeichnet werden
		gc.start();		// Clock soll laufen und die Funktion von Generation aufrufen; Damit Thread startet

	}

}
