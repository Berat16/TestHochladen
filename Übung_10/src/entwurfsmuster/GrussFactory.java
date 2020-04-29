package entwurfsmuster;

public class GrussFactory extends abstractGrussFactory {
	
	public Person createGruss (String name, String gender){
		if (gender.equals("M")){
			return new Mann (name);
		}
		else if (gender.equals("F")){
			return new Frau (name);
		}
		return new Person();
	}

}
