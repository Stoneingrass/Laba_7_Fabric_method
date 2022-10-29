package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Mocha extends CoffeeCafeDish{
    static final String NAME = "Mocha";
    static final double PRICE=11.99;
    static final int COOKING_TIME=10;

    public Mocha(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public Mocha() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
