package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class MargaritaPizza extends PizzeriaDish{
    static final String NAME = "Margarita pizza";
    static final double PRICE=25.99;
    static final int COOKING_TIME=35;

    public MargaritaPizza(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public MargaritaPizza() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
