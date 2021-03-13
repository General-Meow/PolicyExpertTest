package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private BigDecimal discountedPrice;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.discountedPrice = product.pricePerKilo().multiply(weightInKilos).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        return this.discountedPrice;
    }

    @Override
    public BigDecimal setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice.setScale(2, RoundingMode.HALF_UP);
        return this.discountedPrice;
    }
}
