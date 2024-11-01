import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
     String getName();
     double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _qtyInGrams;
    SolidIngredient(String n, double q){_name = n;_qtyInGrams = q;}
    @Override
    public String getName() {return _name;}
    @Override
    public double getQuantity() {return _qtyInGrams;}
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _qtyInMl;
    LiquidIngredient(String n, double q){_name = n;_qtyInMl = q;}
    @Override
    public String getName() {return _name;}
    @Override
    public double getQuantity() {return _qtyInMl;}
}
// Class recipe is not implementing the Ingredient interface.
// rather, the extends word indicates a constraint for the type variable/parameter.
// Extend is the only keyword you can use here.
class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    Recipe(String n, String i){
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<T>();
    }
    public void addIngredient(T i){
        _ingredients.add(i);
    }
    public void print(){
            System.out.println("Recipe: " + _name);
            System.out.println("Instruction: " + _instructions);
            System.out.println("Ingredients:");
            if (_ingredients != null){
                for (T i : _ingredients){
                    System.out.println("- " + i.getName() + ": " + i.getQuantity());
                }
            }


    }
}
public class Main{
    private static int getChoice(Scanner s) {
        int choice = 0;
        System.out.println("RECIPE DATABASE");
        System.out.println("1. Add ingredient to recipe");
        System.out.println("2. List the ingredients of a recipe");
        System.out.println("3. Exit the program");
        System.out.print("Enter your choice: ");
        try{
            choice = Integer.valueOf(s.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid data entered" + e.getMessage());
            System.exit(-1);
        }
        return choice;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //get recipe
        //get instructions
        //provide a simple example of how to conduct a unit test in intellj
        int choice = getChoice(s);
        while (choice != 3){
            if (choice == 1){

            } else {

            }
            choice = getChoice(s);
        }
    }


}
