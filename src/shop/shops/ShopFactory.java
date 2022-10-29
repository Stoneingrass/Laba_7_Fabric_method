package shop.shops;

public interface ShopFactory {
    static Shop createShop(ShopList shopName) throws Exception {
        switch (shopName) {
            case COFFEE_CAFE:
                return new CoffeeCafe();
            case AFRICAN_CAFE:
                return new AfricanCafe();
            case PIZZERIA:
                return new Pizzeria();
            case TEAHOUSE:
                return new Teahouse();
            default:
                throw new Exception("This shop is not exist: " + shopName);
        }
    }
}
