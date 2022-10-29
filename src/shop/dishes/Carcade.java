package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Carcade extends TeahouseDish{
    static final String NAME = "Carcade";
    static final double PRICE=15.99;
    static final int COOKING_TIME=15;

    public Carcade(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public Carcade() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
