package shop.shops;

import shop.dishes.Dish;
import shop.dishes.DishesList;
import shop.fillings.Filling;

import java.util.ArrayList;
import java.util.List;

public abstract class Shop {
    protected ShopList shopName;
    protected final List<Dish> order = new ArrayList<>();
    protected boolean isOrderFormed = false;
    private int orderMakingTime = 0;    //time order making
    private double orderCost = 0;

    public ShopList getShopName() {
        return shopName;
    }
    public List<Dish> getOrder() {
        return order;
    }
    public boolean isOrderFormed() {
        return isOrderFormed;
    }
    public int getOrderMakingTime() {
        calculateOrderMakingTime();
        return orderMakingTime;
    }
    public double getOrderCost() {
        calculateOrderSum();
        return orderCost;
    }

    //factory method
    protected abstract Dish createDish(DishesList dish, int quantity, List<Filling> fillings) throws Exception;

    //adds a dish to order list
    public void addProductToOrderList(DishesList dishName, int quantity, List<Filling> fillings) throws Exception {
        ifOrderFormedException();
        if(quantity<=0) {
            throw new Exception("Quantity should be more than 0.");
        }

        Dish addingDish = createDish(dishName, quantity, fillings);
        order.add(addingDish);
    }

    //removes a product by index in the list
    public void removeDishFromOrderList(int orderListIndex) throws Exception{
        ifOrderFormedException();
        if(orderListIndex < 0 || orderListIndex >= order.size()) {
            throw new Exception("This dish index do not exist.");
        }

        order.remove(orderListIndex);
    }

    //forms the final order
    public void formOrder() throws Exception {
        if(order.isEmpty()) {
            throw new Exception("The order list is empty.");
        }

        //dish cooking
        for (Dish dish: order) {
            dish.dishCooking();
        }

        calculateOrderSum();
        calculateOrderMakingTime();
        isOrderFormed =true;
    }

    public void cancelOrder() throws Exception {
        ifOrderIsNotFormedException();

        order.clear();
        orderCost=0;
        orderMakingTime=0;
        isOrderFormed=false;
    }

    public void calculateOrderSum() {
        double sum=0;
        for (Dish p: order) {
            sum+=p.getPrice()*p.getQuantity();
        }
        orderCost=sum;
    }
    public void calculateOrderMakingTime() {
        int time = 0;
        for (Dish p: order) {
            time+=p.getCookingTime()*p.getQuantity();
        }
        orderMakingTime=time;
    }

    //throws exception if user tries to make action he can't do if order is already formed
    private void ifOrderFormedException() throws Exception {
        if(isOrderFormed) {
            throw new Exception("The order is already made. You can't change it.");
        }
    }
    //throws exception if user tries to make action he can't do if order is not formed
    private void ifOrderIsNotFormedException() throws Exception {
        if(!isOrderFormed) {
            throw new Exception("The order is already made. You can't change it.");
        }
    }
}