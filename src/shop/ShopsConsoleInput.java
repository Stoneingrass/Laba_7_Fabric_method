package shop;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import shop.dishes.*;
import shop.fillings.*;
import shop.shops.Shop;
import shop.shops.ShopFactory;
import shop.shops.ShopList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface ShopsConsoleInput {
    static Shop chooseShop(){
        Scanner scanner = new Scanner(System.in);

        int userInput;

        while (true){
            System.out.println("\nChoose a shop you want to visit:");
            for (int i=0; i<ShopList.values().length; i++) {
                System.out.println((i+1) + ". " + ShopList.values()[i]);
            }

            try {
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct option.");
                }

                userInput = scanner.nextInt();

                if(userInput<=0 || userInput > ShopList.values().length) {
                    throw new Exception("Please input correct option.");
                }

                return ShopFactory.createShop(ShopList.values()[userInput-1]);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static void userMenu(@NotNull Shop shop) {
        final int N_MENU_OPTIONS=8;
        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            System.out.println("\nChoose your action:");
            System.out.println("1. Add dish to order.");
            System.out.println("2. Remove dish from order.");
            System.out.println("3. Calculate order cost.");
            System.out.println("4. Calculate order cooking time.");
            System.out.println("5. Form order.");
            System.out.println("6. Show final order.");
            System.out.println("7. Cancel order.");
            System.out.println("0. Exit.");

            try {
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct option.");
                }

                userInput = scanner.nextInt();

                if(userInput<0 || userInput > N_MENU_OPTIONS-1) {
                    throw new Exception("Please input correct option.");
                }
                break;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

        

        switch (userInput) {
            case 0:
                System.out.println("Good bye!");
                scanner.close();
                System.exit(0);
                return;
            case 1:
                addDishToOrder(shop);
                break;
            case 2:
                removeDishFromOrder(shop);
                break;
            case 3:
                calculateOrderCost(shop);
                break;
            case 4:
                calculateOrderCookingTime(shop);
                break;
            case 5:
                formOrder(shop);
                break;
            case 6:
                showFinalOrder(shop);
                break;
            case 7:
                cancelOrder(shop);
                break;
        }
    }

    static void addDishToOrder(Shop shop) {
        if(shop.isOrderFormed()) {
            System.out.println("The order is already formed.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        int userInput;
        DishesList[] dishesOptions = new DishesList[0];

        DishesList chosenDish;
        int quantity;
        List<Filling> fillings = new ArrayList<>();

        //dish choice
        while (true) {
            System.out.println("\nChoose a dish: ");

            //options output
            switch (shop.getShopName()) {
                case COFFEE_CAFE:
                    dishesOptions=CoffeeCafeDishesList.values();
                    break;
                case AFRICAN_CAFE:
                    dishesOptions=AfricanCafeDishesList.values();
                    break;
                case PIZZERIA:
                    dishesOptions=PizzeriaDishesList.values();
                    break;
                case TEAHOUSE:
                    dishesOptions=TeahouseDishesList.values();
                    break;
            }
            for (int i=0; i< dishesOptions.length; i++) {
                System.out.println((i+1) + ". " + dishesOptions[i].toString());
            }
            System.out.println("0. Exit.");

            //option choice
            try {
                scanner = new Scanner(System.in);
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct option.");
                }

                userInput = scanner.nextInt();
                if(userInput==0) {
                    return;
                }

                if(userInput<0 || userInput > dishesOptions.length) {
                    throw new Exception("Please input correct option.");
                }
                
                break;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        chosenDish=dishesOptions[userInput-1];

        //AfricanCafeDishesList a = (AfricanCafeDishesList)chosenDish;

        //number of portions (quantity) choice
        while (true) {
            System.out.println("\nInput quantity of portions (integer): ");

            try {
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct number.");
                }

                if(userInput<1) {
                    throw new Exception("Please input correct number.");
                }

                break;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        quantity = userInput;

        //adding fillings
         try {
            fillings.add(addFilling(shop));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            shop.addProductToOrderList(chosenDish, quantity, fillings);
            System.out.println("The dish added to your order.");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        
    }

    static Filling addFilling(Shop shop) throws Exception {
        Scanner scanner= new Scanner(System.in);
        int userInput=0;

        FillingsList[] fillingsOptions = new FillingsList[0];

        FillingsList addingFilling;
        int quantity =0;

        //adding
        while (true) {
            System.out.println("\nChoose filling: ");

            //shop choice
            switch (shop.getShopName()) {
                case COFFEE_CAFE:
                    fillingsOptions= CoffeeFillingsList.values();
                    break;
                case AFRICAN_CAFE:
                    fillingsOptions= AfricanFillingsList.values();
                    break;
                case PIZZERIA:
                    fillingsOptions= PizzaFillingsList.values();
                    break;
                case TEAHOUSE:
                    fillingsOptions=TeahouseFillingsList.values();
                    break;
            }

            for (int i=0; i< fillingsOptions.length; i++) {
                System.out.println((i+1) + ". " + fillingsOptions[i].toString());
            }
            System.out.println("0. Exit.");

            //option choice
            try {
                scanner = new Scanner(System.in);
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct option.");
                }

                userInput = scanner.nextInt();
                if(userInput==0) {
                    throw new Exception("Filling not added.");
                }

                if(userInput<0 || userInput > fillingsOptions.length) {
                    
                    throw new Exception("Please input correct option.");
                }

                
                break;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        //chosen filling
        addingFilling = fillingsOptions[userInput-1];

        while (true) {
            System.out.println("\nInput amount of filling (integer): ");

            try {
                scanner = new Scanner(System.in);
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct number.");
                }

                userInput = scanner.nextInt();

                if (userInput < 1) {

                    throw new Exception("Please input correct number.");
                }


                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        quantity = userInput;

        return new Filling(addingFilling,quantity);
    }

    static void removeDishFromOrder(Shop shop) {
        if(shop.getOrder().size()==0) {
            System.out.println("Order is empty.");
            return;
        }
        if(shop.isOrderFormed()) {
            System.out.println("The order is already formed.");
            return;
        }

        Scanner scanner;
        int userInput;

        int index;

        //number of portions (quantity) choice
        while (true) {
            System.out.println("\nInput index of deleting dish (integer): ");

            for(int i=0; i<shop.getOrder().size(); i++) {
                System.out.println((i+1) + ". " + shop.getOrder().get(i).getDishName());
            }

            scanner = new Scanner(System.in);
            try {
                if(!scanner.hasNextInt()) {
                    scanner.next();
                    throw new Exception("Please input correct index.");
                }

                userInput = scanner.nextInt();

                if(userInput<1 || userInput > shop.getOrder().size()) {
                    
                    throw new Exception("Please input correct index.");
                }

                
                break;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            
        }

        index = userInput-1;

        try {
            shop.removeDishFromOrderList(index);
            System.out.println("The dish removed from your order.");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void formOrder(Shop shop) {
        try {
            shop.formOrder();
            System.out.println("Your order is formed.");
            System.out.println("Please wait while your order is cooking (cooking time: " + shop.getOrderMakingTime() + " min).");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void showFinalOrder(Shop shop) {
        if(shop.getOrder().size()==0) {
            System.out.println("Order is empty.");
            return;
        }


        System.out.printf("%n%n%s order.%n%n", shop.getShopName());


        for(Dish dish: shop.getOrder()) {
            System.out.printf("%d. %s (%d pieces).%n",shop.getOrder().indexOf(dish)+1, dish.getDishName(), dish.getQuantity());
            System.out.print("Fillings: ");

            if(dish.getFillings().size()==0) {
                System.out.print("none.");
            }
            else {
                for (Filling f: dish.getFillings()) {
                    System.out.printf("\t%s (%d pieces)", f.getFilling().toString(), f.getAmount());
                }
                System.out.printf(".%n");
            }

            double dishCost = dish.getPrice()*dish.getQuantity();

            System.out.printf("Cost: $%.2f per piece, %d pieces: $%.2f.%n", dish.getPrice(), dish.getQuantity(), dishCost);
        }

        System.out.printf("\nFinal order sum: $%.2f.%n", shop.getOrderCost());
        System.out.printf("Order cooking time: %d min.%n%n", shop.getOrderMakingTime());

        System.out.println("See you again!");
    }

    static void cancelOrder(Shop shop) {
        if(!shop.isOrderFormed()) {
            System.out.println("The order is not yet formed.");
            return;
        }

        try {
            shop.cancelOrder();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void calculateOrderCost(Shop shop) {
        if(shop.getOrder().size()==0) {
            System.out.println("Order is empty.");
            return;
        }
        System.out.println("Order cost is: $" + shop.getOrderCost());
    }

    static void calculateOrderCookingTime(Shop shop) {
        if(shop.getOrder().size()==0) {
            System.out.println("Order is empty.");
            return;
        }
        System.out.println("Order cooking time is: " + shop.getOrderMakingTime() + " min.");
    }
}