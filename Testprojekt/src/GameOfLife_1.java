import java.util.Scanner;


public class GameOfLife_1 {
  public static void main(String[] args) {
    new GameOfLife_1().top(); }

  int   KANTENLAENGE =   30 ;
  float FUELLFAKTOR  = 0.25f;
  
  boolean feld [][];
  
  
  void top() {
    initialisiereFeld(KANTENLAENGE);
    fuelleFeld();
    boolean weiter;
    weiter = true;
    while(weiter) {
        zeigeFeld();
        naechsteGenerationFeld();
        weiter = weiterMachen(); } 
  }
 

  void fuelleFeld() {
    int x = 0;
    while(x < kantenLaenge()) {
        fuelleZeile(x);
        x = x + 1; }
  }


  void fuelleZeile(int x) {
    int y = 0;
    while(y < kantenLaenge()) {
        if(Math.random() < FUELLFAKTOR) {
            feld[x][y] = true; }
        y = y + 1;    }
  }


void naechsteGenerationFeld() {
    boolean[][] feldcpy = new boolean[kantenLaenge()][kantenLaenge()]; // quadratisch
    int x = 0;
    while(x < kantenLaenge()) {
        naechsteGenerationZeile(feldcpy, x);
        x = x + 1;  }
    feld = feldcpy;  }


  void naechsteGenerationZeile(boolean[][] feldcpy, int x) {
    int y = 0;
    while(y < kantenLaenge()) {
        feldcpy[x][y] = regel(x, y); 
        y = y + 1;}
  }
  

  int kantenLaenge() {
    return feld.length; }


  /**
   * Es wird geprüft, ob an Stelle x,y ein (evtl. neues) "Bakterium" entsteht.
   * @return
   */
  boolean regel(int x, int y) {
    int anzahlLebende = totalIn3x3(x, y);
    // Vereinsamt oder verhungert:
    if(anzahlLebende < 3 || anzahlLebende >4) {
        return false; }
    // Überlebt
    if(feld[x][y] && (3 == anzahlLebende || 4 == anzahlLebende)) {
        return true; }
    //  neu geboren
    if(!feld[x][y] && (3 == anzahlLebende)) {
        return true;    }
    // nicht neu geboren, da zu wenig oder zu viele Nachbarzellen.
    return false; }


/**
 * Wie viele Felder "leben" im 3x3-Feld um (x, y) inklusive (x, y)
 */
  int totalIn3x3(int x, int y) {
    int xStart = min(x);
    int xEnd   = max(x);
    int yEnd   = max(y);
    int summe = 0;
    while(xStart <= xEnd) {
        int yStart = min(y);
        while(yStart <= yEnd) {
            if(feld[xStart][yStart]) {
                summe = summe + 1; }
            yStart = yStart + 1; }
        xStart = xStart + 1; }
    return summe;
  }


  /**
   * Minimalwert im 3x3 Feld = 0 oder >0
   * @param xy x or y
   */
  int min(int xy) {
    return Math.max(0, xy - 1); }

  
  /**
   * Maximalwert im 3x3 Feld = kantenLaenge -1 oder kleiner
   * @param xy x or y
   */
  int max(int xy) {
    return Math.min(xy + 1, kantenLaenge() - 1); }


  void zeigeFeld() {
    for(boolean [] zeile : feld) {
        for(boolean feld : zeile) {
            if(feld) {
                System.out.print('*'); }
            else {
                System.out.print(' ');
            }
        }
        System.out.println();    }  
  }

  
  void initialisiereFeld(int groesse) {
    feld = new boolean[groesse][groesse];   }

  
  boolean weiterMachen() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Weiter (ja, nein)? :");
    String eingabe;
    eingabe = sc.next();
    return ! eingabe.startsWith("n"); }

} // end of class GameOfLive
