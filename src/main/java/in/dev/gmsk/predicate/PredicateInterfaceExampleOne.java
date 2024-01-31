package in.dev.gmsk.predicate;

import java.util.function.Predicate;

public class PredicateInterfaceExampleOne {
    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println( validateIndiaVoterAge( Integer.parseInt( args[0] ) ) );
        } else {
            System.out.println( "No command line arguments were provided." );
            System.exit( 0 );
        }
    }

    static String validateIndiaVoterAge(int age) {
        Predicate<Integer> result = i -> (age >= 18);
        return result.test( age ) ? "Your eligible to vote :-) " : "Sorry your not eligible :-( ";
    }
}
