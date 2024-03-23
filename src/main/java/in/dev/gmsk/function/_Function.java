package in.dev.gmsk.function;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        int i = 25;

        System.out.println("incrementTheNumberByMethod = " + incrementTheNumberByMethod(i));

        System.out.println("incrementTheNumberByFunction = " + incrementTheNumberByFun.apply(i));

        int d = 25;

        System.out.println("\ndivedNumberByMethod = " + divedNumberByMethod(d));

        System.out.println("divedNumberByFunction = " + divedNumberByFun.apply(d));

        // Chaining the functions

        Function<Integer, Integer> chainingByFun = incrementTheNumberByFun.andThen(divedNumberByFun);

        System.out.println("\nchainingByFunction = " + chainingByFun.apply(25));
    }

    static Function<Integer, Integer> incrementTheNumberByFun = num -> (num + 1);

    static Function<Integer, Integer> divedNumberByFun = num -> num / 2;

    static int incrementTheNumberByMethod(int i){
        return i + 1;
    }

    static int divedNumberByMethod(int i){
        return i / 2;
    }
}
