package kata.supermarket;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemByWeightTest {

    private ItemByWeight testObj;
    private WeighedProduct weightedProductStub;
    private final BigDecimal PRODUCT_WEIGHT = new BigDecimal("1.00");
    private final BigDecimal PRODUCT_PRICE = new BigDecimal("2.00");
    private final BigDecimal DISCOUNTED_PRICE = new BigDecimal("1.00");
    private final BigDecimal DISCOUNTED_PRICE_THREE_DECIMAL_PLACES = new BigDecimal("1.001");

    @BeforeEach
    void setup() {
        this.weightedProductStub = new WeighedProduct(PRODUCT_PRICE);
        this.testObj = new ItemByWeight(weightedProductStub, PRODUCT_WEIGHT);
    }

    @Test
    void singleItemHasDiscountedPriceTheSameAsProductPrice() {
        BigDecimal result = testObj.getDiscountedPrice();
        Assertions.assertEquals(PRODUCT_PRICE, result);
    }

    @Test
    void singleItemHasDiscountedPriceSetWithSetValue() {
        testObj.setDiscountedPrice(DISCOUNTED_PRICE);
        BigDecimal result = testObj.getDiscountedPrice();
        Assertions.assertEquals(DISCOUNTED_PRICE, result);
    }

    @Test
    void singleItemHasDiscountedPriceSetWithSetValueRounded() {
        testObj.setDiscountedPrice(DISCOUNTED_PRICE_THREE_DECIMAL_PLACES);
        BigDecimal result = testObj.getDiscountedPrice();
        Assertions.assertEquals(DISCOUNTED_PRICE, result);
    }

}
