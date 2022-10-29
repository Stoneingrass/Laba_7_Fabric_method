package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class MegaMixPizza extends PizzeriaDish {
    static final String NAME = "Mega Mix Pizza";
    static final double PRICE=40.99;
    static final int COOKING_TIME=60;

    public MegaMixPizza(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public MegaMixPizza() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
