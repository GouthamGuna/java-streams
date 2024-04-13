package in.dev.gmsk.optionals;

import in.dev.gmsk.functionalinterface.experimental_fi.MyFunction;

import java.util.Optional;
import java.util.function.*;

import static java.lang.System.*;

@FunctionalInterface
interface InnerMyFunction {

    void operate(int a, int b);
}

public class _Optional {
    public static void main(String[] args) {

        learnOptional.accept(() -> null);

        divedByTen.accept(0);

        enhanceTheRobustness.accept(2);
    }

    private static final Consumer<Supplier<String>> learnOptional = e -> {
        Optional.ofNullable(e.get())
                .ifPresentOrElse(
                        email -> out.println("Sending email to " + email),
                        () -> out.println("Cannot send email"));
    };

    /**
     * divideSafely() helper method encapsulates the division operation within a try-catch block.
     */

    private static final BiFunction<Integer, Integer, Optional<Integer>> divideSafely = (dividend, divisor) -> {
        try {
            return Optional.of(dividend / divisor);
        } catch (Exception e) {
            return Optional.empty();
        }
    };

    private static final Consumer<Integer> divedByTen = x -> {
        MyFunction fun = (num) -> divideSafely.apply(10, num)
                .ifPresentOrElse(
                        out::println,
                        () -> out.println("Cannot divide by zero...")
                );

        fun.operate(x);
    };

    /**
     * Incorporating multiple Optional instances within exception-handling scenarios can further enhance
     * the robustness of Java lambda expressions.
     */

    private static final Consumer<Integer> enhanceTheRobustness = i -> {

        InnerMyFunction fun = (a, b) -> {

            Optional<Integer> resultOne = divideSafely.apply(10, a);
            Optional<Integer> resultTwo = divideSafely.apply(20, b);

            resultOne.ifPresentOrElse(
                    r1 -> resultTwo.ifPresentOrElse(
                            r2 -> System.out.println("Result of division: " + (r1 / r2)),
                            () -> System.out.println("Cannot divide second number by zero")
                    ),
                    () -> System.out.println("Cannot divide first number by zero")
            );
        };

        fun.operate(i, 5);
    };
}
