package shop.shops;

import shop.dishes.*;
import shop.fillings.Filling;

import java.util.List;

public class CoffeeCafe extends Shop {
    public CoffeeCafe() {
        shopName=ShopList.COFFEE_CAFE;
    }
    @Override
    protected Dish createDish(DishesList dishName, int quantity, List<Filling> fillings) throws Exception {
        if(!(dishName instanceof CoffeeCafeDishesList)) {
            throw new Exception("This dish does not belong to this shop: " + dishName);
        }

        CoffeeCafeDishesList dish = (CoffeeCafeDishesList) dishName;
        switch (dish) {
            case CAPPUCCINO:
                return new Cappuccino(quantity, fillings);
            case MOCHA:
                return new Mocha(quantity, fillings);
            case AMERICANO:
                return new Americano(quantity, fillings);
            case LATTE:
                return new Latte(quantity, fillings);
            case ESPRESSO:
                return new Espresso(quantity, fillings);
            default:
                throw new Exception("This dish does not exist: " + dish);
        }
    }
}
