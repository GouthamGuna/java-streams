package in.dev.gmsk.predicate;

import java.util.function.Predicate;

public class CalculateTotalValue {

    public static void main(String[] args) {

        System.out.println(
                totalValues(1000, 3000, 4, s -> true)
        );
    }

    public static double totalValues(int foodFee, int roomFee, int requestMonth, Predicate<Integer> selector) {
        return selector.test(requestMonth) ? (foodFee + roomFee) * requestMonth : (requestMonth * roomFee) + foodFee;
    }
}
