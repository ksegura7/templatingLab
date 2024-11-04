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
            System.out.println("\nRecipe: " + _name);
            System.out.println("Instruction: " + _instructions);
            System.out.println("Ingredients:");
            if (_ingredients != null){
                for (T i : _ingredients){
                    System.out.println("- " + i.getName() + ": " + i.getQuantity());
                }
            }
    }
}
//provide a simple example of how to conduct a unit test in intellj
public class Main{
    private static int getChoice(Scanner s) {
        int choice = 0;
        System.out.println("\nRECIPE DATABASE");
        System.out.println("1. Add ingredient to recipe");
        System.out.println("2. List the ingredients of a recipe");
        System.out.println("3. Exit the program");
        System.out.print("Enter your choice: ");
        try{
            choice = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid data entered" + e.getMessage());
            System.exit(-1);
        }
        return choice;
    }
    private static Recipe<Ingredient> addIngredient(Recipe<Ingredient> r, Scanner s) {
        System.out.print("\nSolid (s) or Liquid (l) ingredient: ");
        char type = s.nextLine().charAt(0);
        System.out.print("Name of ingredient: ");
        String name = s.nextLine();
        System.out.print("Quantity of ingredient: ");
        double quantity = Double.parseDouble(s.nextLine());
        if (type == 's' || type == 'S'){
            r.addIngredient(new SolidIngredient(name, quantity));
        } else {
            r.addIngredient(new LiquidIngredient(name, quantity));
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Recipe: ");
        String recipe = s.nextLine();
        System.out.print("Instructions: ");
        String instructions = s.nextLine();
        Recipe<Ingredient> r = new Recipe<>(recipe, instructions);
        int choice = getChoice(s);
        while (choice != 3){
            if (choice == 1){
                 r = addIngredient(r,s);
            } else {
                r.print();
            }
            choice = getChoice(s);
        }
    }



}
