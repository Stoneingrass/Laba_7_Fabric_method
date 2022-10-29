package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class GreenTea extends TeahouseDish{
    static final String NAME = "Green tea";
    static final double PRICE=15.99;
    static final int COOKING_TIME=10;

    public GreenTea(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public GreenTea() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
