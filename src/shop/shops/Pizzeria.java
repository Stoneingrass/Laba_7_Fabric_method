package shop.shops;

import shop.dishes.*;
import shop.fillings.Filling;

import java.util.List;

public class Pizzeria extends Shop{
    public Pizzeria() {
        shopName = ShopList.PIZZERIA;
    }
    @Override
    protected Dish createDish(DishesList dishName, int quantity, List<Filling> fillings) throws Exception {
        if(!(dishName instanceof PizzeriaDishesList)) {
            throw new Exception("This dish does not belong to this shop: " + dishName);
        }

        PizzeriaDishesList dish = (PizzeriaDishesList) dishName;
        switch (dish) {
            case MEGA_MIX_PIZZA:
                return new MegaMixPizza(quantity, fillings);
            case CLASSIC_PIZZA:
                return new ClassicPizza(quantity, fillings);
            case ONE_THOUSAND_AND_ONE_CHEESES_PIZZA:
                return new OneThousandAndOneCheesePizza(quantity, fillings);
            case HAWAIIAN_PIZZA:
                return new HawaiianPizza(quantity, fillings);
            case MARGARITA_PIZZA:
                return new MargaritaPizza(quantity, fillings);
            default:
                throw new Exception("This dish does not exist: " + dish);
        }
    }
}
