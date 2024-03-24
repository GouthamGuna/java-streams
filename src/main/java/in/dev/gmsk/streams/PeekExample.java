package in.dev.gmsk.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Peek method is used to print each element before it's multiplied by 2.
 */
public class PeekExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );

        numbers.stream()
                .peek( num -> System.out.println( "Processing : " + num ) )
                .map( n -> n * 2 )
                .forEach( System.out::println );
    }
}
