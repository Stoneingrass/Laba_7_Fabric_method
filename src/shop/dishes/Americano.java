package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Americano extends CoffeeCafeDish{
    static final String NAME = "Americano";
    static final double PRICE=10.99;
    static final int COOKING_TIME=15;

    public Americano(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public Americano() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
