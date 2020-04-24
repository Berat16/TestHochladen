package GameOfLife111;


public class GameClock extends Thread{
	
	public static boolean running = false;	// mit false kann man das Spiel/ Thread pausieren
	
	public void run() {
		while (running) {
			try {
				sleep(100);	// Geschwindigkeit 50ms bis zur nächsten Generation
				GameMaster.nextGen();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} 
	}

}
