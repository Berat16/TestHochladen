package threads;

public class ArrayCalc extends Thread{
	
	private int summe = 0;
	private int []a;
	private int start;
	private int ende;
	
	public ArrayCalc (int []a, int start, int ende){
		this.a = a;
		this.start = start;
		this.ende = ende;
	}
	
	public void run (){
		for (int i = start; i<= ende; i++){
			summe += a[i];
		}
	}
	public int getSumme (){
		return summe;
	}

}
