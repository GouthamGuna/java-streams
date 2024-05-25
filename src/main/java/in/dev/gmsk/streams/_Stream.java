package in.dev.gmsk.streams;

import static in.dev.gmsk.util.Price.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class _Stream {

    public static void main(String[] args) {

        // prices greater than $20, discounted by 10%.
        DiscountImperative(getPricesForSupplier.get());
        DiscountDeclarative(getPrices());
        NumericExtractor();
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

    public static void NumericExtractor() {
        String input = " service fee"; // Example input string with a numeric part and description

        // Step 1: Split the string into parts using space as delimiter.
        String[] parts = input.split("\\s+");

        // Step 2: Stream over the array to filter out non-numeric values.
        Integer feeNumber = Arrays.stream(parts)
                .filter(part -> part.matches("\\d+")) // RegEx pattern for digits only
                .findFirst()
                .map(Integer::parseInt) // Convert string representation of number to integer
                .orElse(null); // Handle the case where no numeric parts are found

        if (feeNumber != null) {
            System.out.println("Fee amount is: " + feeNumber);
        } else {
            System.out.println("No numeric part was found in the input string.");
        }
    }
}
