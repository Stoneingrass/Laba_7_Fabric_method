package shop.dishes;

import shop.fillings.CoffeeFillingsList;
import shop.fillings.Filling;
import shop.fillings.FillingsList;

import java.util.List;

public abstract class CoffeeCafeDish extends Dish {
    public CoffeeCafeDish(String dishName, double price, int cookingTime, int quantity, List<Filling> fillings) {
        super(dishName, price, cookingTime, quantity, fillings);
    }

    public CoffeeCafeDish() {

    }


    @Override
    public void addFilling(FillingsList filling, int amount) throws Exception {
        if(amount<=0) {
            throw new Exception("Amount of filling can not be less than null or equals to null.");
        }
        if(filling instanceof CoffeeFillingsList) {
            fillings.add(new Filling(filling, amount));
        }
        else {
            throw new Exception("You can not add this filling to dish of this shop: " + filling);
        }
    }

    @Override
    public abstract void dishCooking();
}
