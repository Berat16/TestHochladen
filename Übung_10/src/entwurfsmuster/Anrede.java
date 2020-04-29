package entwurfsmuster;

public class Anrede {

    public static void main(String args[]) {
        GrussFactory factory = new GrussFactory();
        Person p = factory.createGruss(args[0], args[1]);
        
        System.out.println(p.getGruss());
   }
}
	

