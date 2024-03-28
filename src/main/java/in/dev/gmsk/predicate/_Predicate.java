package in.dev.gmsk.predicate;

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

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
