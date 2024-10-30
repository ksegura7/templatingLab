import java.util.ArrayList;

interface Ingredient{
    public String getName();
    public double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    SolidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }
    @Override
    public String getName() {
        return _name;
    }
    @Override
    public double getQuantity() {
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    LiquidIngredient(String n, double q){
        _name = n;
        _quantity = q;
    }
    @Override
    public String getName() {
        return _name;
    }
    @Override
    public double getQuantity() {
        return _quantity;
    }
}

class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    Recipe(String n, String i, ArrayList t){
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<T>();
    }
    public void addIngredient(T i){
        _ingredients.add(i);
    }
    public void print(){

    }
}
public class Main{
}
