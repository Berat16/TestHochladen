package entwurfsmuster;

public class Frau extends Person{
	
	public Frau (String name){
	super.name = name;
	super.gender = "F";
}
public String getGruss(){
	return "Hallo Frau " + super.name;
}

}
