
public class Food
{
    // basic info
   private String name;
   // related to nutrition
   private int calories;
   private Ingredient[] ingredients;
   private int cost; 
   private static int totalCount; // total amount of Food objects Created
   
   
   // Constructor
   public Food(String newName, int newCalories, int newCost, Ingredient[] ingredientArray){
       // basic info
       name = newName;
       // related to nutrition
       calories = newCalories;
       cost = newCost; 
       
       ingredients = ingredientArray; // Update from String to Ingredient
       
       totalCount++;
    }
    
    public String toString(){
        return "Name: " + name + " Calories: " + calories + " Cost: " + cost;
    }
    
    // method "getIngredients" that returns all the values in the array formatted as a string. 
    public String getIngredients(){
        String str ="Ingredients: ";

        if(ingredients.length == 0){
          str += "None";
        }else if (ingredients.length == 1){ // one ingredient
          str += ingredients[0];
        }else{
          // Handle the case of multiple
          for( int i =0; i < ingredients.length-1; i++){
            str = str + ingredients[i].toString() + ", ";
          }
          str = str + ingredients[ingredients.length-1].toString();
        }
        
        return str;
    }
    
    // method setIngredients which is an instance method that accepts an array of type String 
    // and has a return type of void. This should replace the current ingredient list with the 
    // ingredient list passed as a parameter. 
    public void setIngredients(Ingredient[] newIngredients){
        ingredients = newIngredients;
    }

    public void addIngredient(Ingredient newIng){
        Ingredient[] temp = new Ingredient[ingredients.length+1];
        for(int i = 0 ; i < ingredients.length; i++){
          temp[i] = ingredients[i];
        }
        temp[temp.length -1 ] = newIng;
        ingredients = temp;
    }
    
    public static int getCount(){
        return totalCount;
    }
}
