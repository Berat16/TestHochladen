package threads;

public class MyThread {
    public static void main(String[] args) {
    	
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        ArrayCalc a1 = new ArrayCalc(a,0,6);
        ArrayCalc a2 = new ArrayCalc(a,7,9);

        //Ihre Loesung 
        a1.start();
        a2.start();
        
        try {
        	a1.join();
        	a2.join();
        }
        catch (InterruptedException e){
        	e.printStackTrace();
        }

        System.out.println("Summe: "+(a1.getSumme()+a2.getSumme()));
    }
}
