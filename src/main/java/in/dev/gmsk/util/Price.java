package in.dev.gmsk.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Price {

    public static List<BigDecimal> getPrices() {
        return Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"),
                new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12")
        );
    }

    public static Supplier<List<BigDecimal>> getPricesForSupplier = () ->
            Arrays.asList(
                    new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"),
                    new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12")
            );

}
