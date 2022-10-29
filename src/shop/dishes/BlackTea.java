package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class BlackTea extends TeahouseDish{
    static final String NAME = "Black tea";
    static final double PRICE=10.99;
    static final int COOKING_TIME=15;

    public BlackTea(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public BlackTea() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
