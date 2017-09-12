package intro;
//class is a file describing a new data type
public class CodingConventions {
	//fields
	private String name;
	private String description;
	
	/*
	this is a special method, a "constructor"
	notice it doesn't have a return type.
	that is because the thing it returns is an instance of the class.
	therefore the name of a constructor must always match the name of class
	*/ 
	 
	public CodingConventions() {
		//In java, fields are instantiated in a constructor
		name = "David";
		description = "is a student";
	}
}
