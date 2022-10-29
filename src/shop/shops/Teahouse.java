package shop.shops;

import shop.dishes.*;
import shop.fillings.Filling;

import java.util.List;

public class Teahouse extends Shop{
    public Teahouse() {
        shopName = ShopList.TEAHOUSE;
    }
    @Override
    protected Dish createDish(DishesList dishName, int quantity, List<Filling> fillings) throws Exception {
        if(!(dishName instanceof TeahouseDishesList)) {
            throw new Exception("This dish does not belong to this shop: " + dishName.getClass());
        }

        TeahouseDishesList dish = (TeahouseDishesList) dishName;
        switch (dish) {
            case BLACK_TEA:
                return new BlackTea(quantity, fillings);
            case GREEN_TEA:
                return new GreenTea(quantity, fillings);
            case PUER:
                return new Puer(quantity, fillings);
            case MATCHA:
                return new Matcha(quantity, fillings);
            case CARCADE:
                return new Carcade(quantity, fillings);
            default:
                throw new Exception("This dish does not exist: " + dish);
        }
    }
}
