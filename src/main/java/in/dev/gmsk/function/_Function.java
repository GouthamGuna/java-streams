package in.dev.gmsk.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function takes one arguments process to return one result.

        int i = 25;

        System.out.println("incrementTheNumberByMethod = " + incrementTheNumberByMethod(i));

        System.out.println("incrementTheNumberByFunction = " + incrementTheNumberByFun.apply(i));

        int d = 25;

        System.out.println("\ndivedNumberByMethod = " + divedNumberByMethod(d));

        System.out.println("divedNumberByFunction = " + divedNumberByFun.apply(d));

        // Chaining the functions

        Function<Integer, Integer> chainingByFun = incrementTheNumberByFun.andThen(divedNumberByFun);

        System.out.println("\nchainingByFunction = " + chainingByFun.apply(25));

        // BiFunction takes two arguments process to return one result.

        int a = 4, b = 100;

        System.out.println(
                "\nbyMethod : " + incrementByOneThenMultiply(a, b)
        );

        System.out.println(
                "BiFunction : " + incrementByOneThenMultiplyBiFun.apply(a, b)
        );
    }

    /* Declarative style */

    static Function<Integer, Integer> incrementTheNumberByFun = num -> (num + 1);

    static Function<Integer, Integer> divedNumberByFun = num -> num / 2;

    /* BiFunctional Declarative Program */

    static BiFunction<Integer, Integer, Integer> incrementByOneThenMultiplyBiFun =
            (incrementByOne, numMultiply) -> (incrementByOne + 1) * numMultiply;

    /* Imperative style */

    static int incrementTheNumberByMethod(int i) {
        return i + 1;
    }

    static int divedNumberByMethod(int i) {
        return i / 2;
    }

    static int incrementByOneThenMultiply(int a, int b) {
        return (a + 1) * b;
    }
}
