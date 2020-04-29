package entwurfsmuster;

public class Mann extends Person{
	
	public Mann (String name){
		super.name = name;
		super.gender = "M";
	}
	public String getGruss(){
		return "Hallo Herr " + super.name;
	}

}


