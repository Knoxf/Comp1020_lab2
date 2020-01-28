
public class VendingMachine
{

      Food[] foodArray;
      static int maxSize = 10;

      public VendingMachine(){
            foodArray = new Food[maxSize];
      }


      // Return the count of all valid Food objects in the machine.
      // It should skip over null values of the array and not count them
      public int countFood(){
            int count = 0;
            for(int i=0;i<maxSize;i++){
                  if(foodArray[i] != null){
                        count++;
                  }
            }

            return count;
      }

      // returns the size of the current array, or 0 if it is null
      // We just need this to access the array since the array should be private.
      public int size(){
            return maxSize;
      }

      // Add food to the array at a given index if it is valid and not already assigned
      // Return true if you added the new food successfully and false otherwise. 
      // You should check if there is already a Food object in the given index already. 
      // If the spot is already holding a Food object, do not overwrite it, but instead return false
      // You should also check if the given index is a valid index for the array and return false if it is not. 
      // If given an invalid index, you should not add anything and also not crash. 
      public boolean addFood(Food newFood, int index){
            boolean returnVal = false;
            // if spot is valid, and empty, add the food and return true
            // otherwise return false.
            if (index >= 0 && index < maxSize) {

                  if (foodArray[index] == null ) {
                        foodArray[index] = newFood;
                        returnVal = true;
                  }
            }

            return returnVal;
      }

      // To String for the Vending Machine - prints out all foods including the index of the array they are stored in. 
      // See the Expected Output document for details. 
      public String toString(){
            String st= "\n" + "Vending Machine Interface:" + "\n" +  "Contains: "  + size() + " Food Items"+"\n";

            for(int i=0;i<maxSize;i++){
                  if(foodArray[i] == null){
                        st = st + "Item " + i + " is Empty" + "\n";
                  }
                  if(foodArray[i] != null){
                        st = st + "Item " + i + " is Name: " + foodArray[i].toString() +"\n";
                  }
            }
            return st;
      }

      public static void main(String[] args){
            // Run tests of individual objects
            //testLab1();
            testLab2();
      }

      public static void testLab2(){
            VendingMachine vm = new VendingMachine();

            // String newName, int newCalories, int newCost){
            // Apple Food Test Data
            Ingredient[] appleIng = new Ingredient[2];    // Ingredients array
            appleIng[0] = new Ingredient("Apple Junk", 0.5); // add ingredients
            appleIng[1] = new Ingredient("Redness", 0.3);
            Food appleFood = new Food("Apple", 120, 2, appleIng); // create food object

            // Banana Food Test Data
            Ingredient[] bananaIng = new Ingredient[2];
            bananaIng[0] = new Ingredient("Banana Mush", 1.0);
            bananaIng[1] = new Ingredient("Banana Skin", 0.5);
            Food bananaFood = new Food("Banana", 180, 1, bananaIng);

            // ============= These should add new food =============
            // These return boolean however if we don't assign the value it is lost.
            boolean addFlag = false;
            addFlag = vm.addFood(appleFood, 3);

            if(addFlag){
                  System.out.println("Food Added Successfully: " + appleFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + appleFood.toString());
            }
            
            // Recycle the flag
            addFlag = vm.addFood(bananaFood, 6);

            if(addFlag){
                  System.out.println("Food Added Successfully: " + bananaFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + bananaFood.toString());
            }
            System.out.println(vm.toString());

            // ============= These should Fail to add new food =============
            Food invalidFood = new Food("Invalid", 0, 0, new Ingredient[0]); // Note: We are adding an empty array so that it doesn't crash if it is accessed.  

            // Add to existing index, this should NOT work
            addFlag = vm.addFood(invalidFood, 6);

            if(addFlag){
                  System.out.println("Should not have overwritten the old food object with: " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to an occupied spot in the array: " + invalidFood.toString());
            }

            // Add to existing index again, this should NOT work
            addFlag = vm.addFood(invalidFood, 3);

            if(addFlag){
                  System.out.println("Should not have overwritten the old food object with: " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to an occupied spot in the array: " + invalidFood.toString());
            }

             // Add to out of bounds index, this should NOT work
            // Add to existing index again, this should NOT work
            addFlag = vm.addFood(invalidFood, vm.size());

            if(addFlag){
                  System.out.println("Should not return true when adding to an invalid index (-1) " + vm.size() );
            }else{
                  System.out.println("Successfully rejected adding to index " + vm.size() );
            }

            // Add to out of bounds index, this should NOT work
            addFlag = vm.addFood(invalidFood, -1);

            if(addFlag){
                  System.out.println("Should not return true when adding to an invalid index (-1) " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to index -1: " + invalidFood.toString());
            }

      }

      public static void testLab1(){
            // String newName, int newCalories, int newCost){
            Ingredient[] appleIng = new Ingredient[2];
            appleIng[0] = new Ingredient("Apple Junk", 0.5);
            appleIng[1] = new Ingredient("Redness", 0.3);
            Food food1 = new Food("Apple", 120, 2, appleIng);


            Ingredient[] bananaIng = new Ingredient[2];
            bananaIng[0] = new Ingredient("Banana Mush", 1.0);
            bananaIng[1] = new Ingredient("Banana Skin", 0.5);
            Food food2 = new Food("Banana", 180, 1, bananaIng);

            // setIngredients(String[] newIngredients){
            food2.setIngredients(bananaIng);
            Food.getCount();

            System.out.println(food1.toString() + "\n" + food1.getIngredients() + '\n');
            System.out.println(food2.toString() + "\n" + food2.getIngredients());

            // Silver
            Ingredient newIng = new Ingredient("Yellow Banana Outer Shell", 0.2);
            food2.addIngredient(newIng);

            System.out.println(food2.toString() + "\n" + food2.getIngredients());

            // Part g
            Ingredient i1 = new Ingredient("Mushy Stuff", 0.5);
            Ingredient i2 = new Ingredient("Tasty Snack", 0.3);
            Ingredient i3 = new Ingredient("Crispy Bits", 0.1);

            Food food3 = new Food("Test Snack", 123, 9, new Ingredient[0]);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i1);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i2);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i3);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
      }
}
