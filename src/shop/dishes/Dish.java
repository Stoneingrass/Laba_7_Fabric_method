package shop.dishes;

import shop.fillings.Filling;
import shop.fillings.FillingsList;

import java.util.ArrayList;
import java.util.List;

public abstract class Dish {
    //is not changeable; specified as a static member of dish subclasses
    protected String dishName;
    protected double price;     //in dollars
    protected int cookingTime;      //in minutes

    //is changeable
    protected int quantity;
    protected List<Filling> fillings = new ArrayList<>();

    public Dish(String dishName, double price, int cookingTime, int quantity, List<Filling> fillings) {
        this.dishName = dishName;
        this.price = price;
        this.cookingTime = cookingTime;
        this.quantity = quantity;
        this.fillings = fillings;
    }

    public Dish() {

    }

    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getQuantity() {
        return quantity;
    }


    public List<Filling> getFillings() {
        return fillings;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public abstract void addFilling(FillingsList filling, int amount) throws Exception;

    //method describes cooking
    public abstract void dishCooking();
}

