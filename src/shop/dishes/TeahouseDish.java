package shop.dishes;

import shop.fillings.Filling;
import shop.fillings.FillingsList;
import shop.fillings.TeahouseFillingsList;

import java.util.List;

public abstract class TeahouseDish extends Dish {
    public TeahouseDish(String dishName, double price, int cookingTime, int quantity, List<Filling> fillings) {
        super(dishName, price, cookingTime, quantity, fillings);
    }

    public TeahouseDish() {

    }

    @Override
    public void addFilling(FillingsList filling, int amount) throws Exception {
        if(amount<=0) {
            throw new Exception("Amount of filling can not be less than null or equals to null.");
        }
        if(filling instanceof TeahouseFillingsList) {
            fillings.add(new Filling(filling, amount));
        }
        else {
            throw new Exception("You can not add this filling to dish of this shop: " + filling);
        }
    }

    @Override
    public abstract void dishCooking();
}
