package entwurfsmuster;

public class Person {
 	protected String name;
	protected String gender;

	public Person() {
		name="";
		gender="";
	}

	protected String getGruss() {
		return "Hallo Person";
	}	
}// End of class

