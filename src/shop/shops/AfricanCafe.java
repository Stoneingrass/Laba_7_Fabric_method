package shop.shops;

import shop.dishes.*;
import shop.fillings.Filling;

import java.util.List;

public class AfricanCafe extends Shop {
    public AfricanCafe() {
        shopName=ShopList.AFRICAN_CAFE;
    }
    @Override
    protected Dish createDish(DishesList dishName, int quantity, List<Filling> fillings) throws Exception {
        if(!(dishName instanceof AfricanCafeDishesList)) {
            throw new Exception("This dish does not belong to this shop: " + dishName);
        }

        AfricanCafeDishesList dish = (AfricanCafeDishesList) dishName;
        switch (dish) {
            case SOUTH_AFRICAN_VINE:
                return new SouthAfricanVine(quantity, fillings);
            case AFRICAN_BEER:
                return new AfricanBeer(quantity, fillings);
            case AMARULA:
                return new Amarula(quantity, fillings);
            case FINIC_LIQUOR:
                return new FinicLiquor(quantity, fillings);
            default:
                throw new Exception("This dish does not exist: " + dish);
        }
    }
}
