package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kata.supermarket.discount.BuyOneGetOneFreeDiscount;
import kata.supermarket.discount.Discount;

public class Basket {

    private final int TOTALS_SCALE = 2;

    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        new DiscountsApplicator().applyDiscounts(); //might be better to move this to the add method
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {

        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(TOTALS_SCALE, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of the discount calculations. It is
         * not likely to be the best place to do those calculations. Think about how Basket could
         * interact with something which provides that functionality.
         */
        private BigDecimal discounts() {
            BigDecimal subTotal = subtotal();
            BigDecimal discountedTotal = items.stream()
                    .map(Item::getDiscountedPrice)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(TOTALS_SCALE, RoundingMode.UP);

            return subTotal.subtract(discountedTotal);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }

    //Use the Observer pattern to apply the discounted prices
    private class DiscountsApplicator {

        private final List<Discount> activeDiscounts;

        DiscountsApplicator() {
            //make this better by possibly injecting it
            this.activeDiscounts = new ArrayList<>();
            this.activeDiscounts.add(new BuyOneGetOneFreeDiscount(items(), "Milk"));
        }

        void applyDiscounts() {
            this.activeDiscounts.forEach(Discount::applyDiscount);
        }
    }
}
