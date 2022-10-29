package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class FinicLiquor extends AfricanDish {
    static final String NAME = "Finic liquor";
    static final double PRICE=5.99;
    static final int COOKING_TIME=5;

    public FinicLiquor(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public FinicLiquor() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
