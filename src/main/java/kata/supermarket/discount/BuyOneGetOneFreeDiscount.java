package kata.supermarket.discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import kata.supermarket.Item;

public class BuyOneGetOneFreeDiscount extends Discount {

    private String productName; //TODO: refactor to use product id

    public BuyOneGetOneFreeDiscount(List<Item> basketItems, String productName) {
        super(basketItems);
        this.productName = productName;
    }

    @Override
    public void applyDiscount() {
        List<Item> applicableItems = getBasketItems().stream()
                .filter(product -> product.getProduct().getName().equals(productName))
                .collect(Collectors.toList());

        for (int i = 0; i < applicableItems.size(); i++) {
            if(i % 2 != 0) {
                applicableItems.get(i).setDiscountedPrice(BigDecimal.ZERO);
            }
        }
    }
}
