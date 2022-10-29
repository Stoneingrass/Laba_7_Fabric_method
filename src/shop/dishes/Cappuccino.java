package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Cappuccino extends CoffeeCafeDish {
    static final String NAME = "Cappuccino";
    static final double PRICE=9.99;
    static final int COOKING_TIME=10;

    public Cappuccino(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public Cappuccino() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
