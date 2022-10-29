import shop.ShopsConsoleInput;
import shop.shops.Shop;

import static shop.ShopsConsoleInput.userMenu;

public class Main {
    public static void main(String[] args) {
        Shop shop = ShopsConsoleInput.chooseShop();

        while (true) {
            userMenu(shop);
        }
    }
}