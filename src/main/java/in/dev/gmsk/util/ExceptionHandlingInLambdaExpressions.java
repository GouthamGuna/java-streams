package in.dev.gmsk.util;

import in.dev.gmsk.functionalinterface.experimental_fi.MyFunction;

import java.util.function.*;

public class ExceptionHandlingInLambdaExpressions {

    public static final Consumer<Integer> dived = num -> {

        MyFunction fun = (x) -> System.out.println(10 / x);

        try {
            fun.operate(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}
