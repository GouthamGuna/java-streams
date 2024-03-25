package in.dev.gmsk.streams;

import static in.dev.gmsk.util.Price.*;

import java.math.BigDecimal;
import java.util.List;

public class _Stream {

    public static void main(String[] args) {

        // prices greater than $20, discounted by 10%.
        DiscountImperative(getPricesForSupplier.get());
        DiscountDeclarative(getPrices());
    }

    /* Declarative style */

    public static void DiscountDeclarative(List<BigDecimal> prices) {
        final BigDecimal totalOfDiscountedPrices =
                prices.stream()
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    /* Imperative style */

    public static void DiscountImperative(List<BigDecimal> prices) {

        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices =
                        totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
