package in.dev.gmsk.functionalinterface.predicate;

import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.*;

public class _Predicate {

    public static void main(String[] args) {

        out.println("Without predicate");
        out.println(isPhoneNumberValid("07000000000"));
        out.println(isPhoneNumberValid("0700000000"));
        out.println(isPhoneNumberValid("09009877300"));

        out.println("With predicate");
        out.println(isPhoneNumberValidPredicate.test("07000000000"));
        out.println(isPhoneNumberValidPredicate.test("0700000000"));
        out.println(isPhoneNumberValidPredicate.test("09009877300"));

        out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );

        out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000")
        );

        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        out.println("totalValues : " + totalValues(numbers, e -> true));
        out.println("totalValues : " + totalValues(numbers, e -> e % 2 == 0));
        stringTest(s -> s.equalsIgnoreCase("trialBalance"));
    }

    public static void stringTest(Predicate<String> args) {
        if (args.test("trialBalance")) {
            out.println("trialBalance");
        } else {
            out.println("P&L");
        }
    }

    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        int total = 0;

        for (var e : values) {
            if (selector.test(e)) {
                total += e;
            }
        }

        return total;
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
