package kata.supermarket;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemByUnitTest {

    private ItemByUnit testObj;
    private Product productStub;
    private final BigDecimal PRODUCT_PRICE = new BigDecimal("2.00");
    private final BigDecimal DISCOUNTED_PRICE = new BigDecimal("1.00");

    @BeforeEach
    void setup() {
        this.productStub = new Product(PRODUCT_PRICE);
        this.testObj = new ItemByUnit(productStub);
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

}
