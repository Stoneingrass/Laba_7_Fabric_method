package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class Amarula extends AfricanDish {
    static final String NAME = "Amarula";
    static final double PRICE=99.99;
    static final int COOKING_TIME=5;

    public Amarula(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public Amarula() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}