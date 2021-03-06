package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();
    BigDecimal getDiscountedPrice();
    BigDecimal setDiscountedPrice(BigDecimal discountedPrice);
    Product getProduct();
}
