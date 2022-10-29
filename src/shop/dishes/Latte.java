package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Latte extends CoffeeCafeDish{
    static final String NAME = "Latte";
    static final double PRICE=15.99;
    static final int COOKING_TIME=20;

    public Latte(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public Latte() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
