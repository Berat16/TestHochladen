import java.awt.*;
 import javax.swing.*;
 public class Schachbrett extends JFrame {

 public Schachbrett()    {       
 setSize( 550, 550 );
 setLocationRelativeTo(null);
 setVisible( true );   
 } 
public void paint( Graphics g )    
 {  
 for ( int x = 30; x <= 500; x += 30 )
 for ( int y = 30; y <= 500; y += 30 ) 
 g.drawRect( x, y, 30, 30 );
 
 
 
 g.setColor(Color.BLACK);
 g.fillRect(0, 0, 300, 300);
 g.setColor(Color.WHITE);
 for (int i=0; i<10; i++) {
 	for (int k=0; k<10 ; k++) {
 		if (k%2==i%2)
 			g.fillRect(i*30, k*30, 30, 30);
 	}
 }

 } 
 public static void main( String args[] ) 
 {
     Schachbrett application = new Schachbrett();
 application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   }  } 