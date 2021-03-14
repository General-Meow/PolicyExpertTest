package kata.supermarket;

import java.math.BigDecimal;

public class UnitProduct extends Product {

    private final BigDecimal pricePerUnit;

    public UnitProduct(final String name, final BigDecimal pricePerUnit) {
        super(name);
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
