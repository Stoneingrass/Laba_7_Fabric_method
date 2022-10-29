package shop.fillings;

public class Filling {
    FillingsList filling;
    int amount;

    public Filling(FillingsList filling, int amount) {
        this.filling=filling;
        this.amount=amount;
    }

    public FillingsList getFilling() {
        return filling;
    }
    public int getAmount() {
        return amount;
    }
}
