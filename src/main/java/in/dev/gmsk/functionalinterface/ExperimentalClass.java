package in.dev.gmsk.functionalinterface;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExperimentalClass {

    private static final int PASS_PERCENTAGE = 33;
    private static final Supplier<List<String>> getClassList = () -> List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII");

    public static void main(String[] args) {

        int i = 32;

        System.out.println(getResult.apply(i) ? getNextClass.get() : getCurrentClassName.get());
    }

    private static final Function<Integer, Boolean> getResult = num -> num >= PASS_PERCENTAGE;

    private static final Supplier<String> getNextClass = () -> getClassList.get().get(new Random().nextInt(getClassList.get().size()));

    private static final Supplier<String> getCurrentClassName = () -> getClassList.get().get(getClassList.get().size() - 1);

}
