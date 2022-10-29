package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class SouthAfricanVine extends AfricanDish{
    static final String NAME = "South African vine";
    static final double PRICE=49.99;
    static final int COOKING_TIME=5;

    public SouthAfricanVine(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public SouthAfricanVine() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
