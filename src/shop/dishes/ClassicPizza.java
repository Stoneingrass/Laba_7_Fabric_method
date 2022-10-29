package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class ClassicPizza extends PizzeriaDish{
    static final String NAME = "Classic pizza";
    static final double PRICE=25.99;
    static final int COOKING_TIME=30;

    public ClassicPizza(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public ClassicPizza() {

    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
