package shop.dishes;

import shop.fillings.Filling;

import java.util.List;

public class OneThousandAndOneCheesePizza extends PizzeriaDish{
    static final String NAME = "One Thousand And One Cheese Pizza";
    static final double PRICE=50.99;
    static final int COOKING_TIME=75;

    public OneThousandAndOneCheesePizza(int quantity, List<Filling> fillings) {
        super(NAME, PRICE, COOKING_TIME, quantity, fillings);
    }

    public OneThousandAndOneCheesePizza() {
    }

    @Override
    public void dishCooking() {
        //some actions by choosing ingredients and cooking the dish
    }
}
