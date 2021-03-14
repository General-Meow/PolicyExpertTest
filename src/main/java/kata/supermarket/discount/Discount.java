package kata.supermarket.discount;

import java.util.List;
import kata.supermarket.Item;

public abstract class Discount {

    private List<Item> basketItems;

    public Discount(List<Item> basketItems) {
        this.basketItems = basketItems;
    }

    public List<Item> getBasketItems() {
        return basketItems;
    }

    public abstract void applyDiscount();
}
