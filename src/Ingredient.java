// An Ingredient object contains information about one component of a 
// Food object. Later we will add nutritional information to this. 
public class Ingredient{
	// instance variables
	private String name; 
	private double amount; // in grams

	// Base constructor to set both variables, Amount is in grams
	public Ingredient(String newName, double newAmount){
		name = newName;
		amount = newAmount;
	}

	// Returns the name of the Ingredient
	public String toString(){
		return name;
	}
}