package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Puer extends TeahouseDish{
    static final String NAME = "Puer";
    static final double PRICE=35.99;
    static final int COOKING_TIME=25;

    public Puer(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public Puer() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
