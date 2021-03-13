package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private BigDecimal discountedPrice;

    ItemByUnit(final Product product) {
        this.product = product;
        this.discountedPrice = product.pricePerUnit();
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        return this.discountedPrice;
    }

    @Override
    public BigDecimal setDiscountedPrice(BigDecimal discountedPrice) {
        return this.discountedPrice = discountedPrice;
    }
}
