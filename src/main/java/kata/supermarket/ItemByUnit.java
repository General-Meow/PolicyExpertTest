package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final UnitProduct product;
    private BigDecimal discountedPrice;

    ItemByUnit(final UnitProduct product) {
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

    @Override
    public Product getProduct() {
        return this.product;
    }
}
