package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Matcha extends TeahouseDish{
    static final String NAME = "Matcha";
    static final double PRICE=25.99;
    static final int COOKING_TIME=25;

    public Matcha(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public Matcha() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
