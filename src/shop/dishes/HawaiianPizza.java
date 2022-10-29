package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class HawaiianPizza extends PizzeriaDish{
    static final String NAME = "Hawaiian pizza";
    static final double PRICE=30.99;
    static final int COOKING_TIME=35;

    public HawaiianPizza(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public HawaiianPizza() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
