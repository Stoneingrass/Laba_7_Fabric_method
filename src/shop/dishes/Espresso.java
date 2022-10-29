package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Espresso extends CoffeeCafeDish{
    static final String NAME = "Espresso";
    static final double PRICE=7.99;
    static final int COOKING_TIME=5;

    public Espresso(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public Espresso() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
