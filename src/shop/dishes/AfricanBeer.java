package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class AfricanBeer extends AfricanDish {
    static final String NAME = "African beer";
    static final double PRICE=15.99;
    static final int COOKING_TIME=5;

    public AfricanBeer(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }
    public AfricanBeer() {
        super();
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
