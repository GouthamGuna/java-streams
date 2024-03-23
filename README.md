# function vs supplier and predicate

 The Consumer, Supplier, and Predicate interfaces are functional interfaces introduced in Java 8 to support functional programming.
 They are part of the java.util.function package.

 1. `Consumer interface`:
 
 * Accepts a single input and returns no output.
 * Used when you need to consume objects.
 
 **Example:**
 
    import java.util.function.Consumer;
 
    class Main {
      public static void main(String[] args) {
        Consumer<String> printCity = city -> System.out.println(city);
        printCity.accept("Mumbai");
      }
    }
	
2.`Supplier interface`:
 
 * Represents a function that does not take any argument but produces a value of type T.
 
 **Example:**
 
    import java.util.function.Supplier;
    import java.util.Arrays;
    
    class Main {
      public static void main(String[] args) {
        Supplier<String[]> citySupplier = () -> {
          return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
        };
        Arrays.asList(citySupplier.get()).forEach(System.out::println);
      }
    }
	
3.`Predicate interface`:
 
 * Accepts an argument and returns a boolean. Used to apply filters on collections of objects.
 
 **Example:**
 
    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Predicate;
 
    class Main {
      public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Goa", "Pune");
        Predicate<String> filterCity = city -> city.equals("Mumbai");
        cities.stream().filter(filterCity).forEach(System.out::println);
      }
    } 
	
4.`Function interface`:
 
 * Takes an input value and returns a value. Used in mapping operations.
 
 **Example:**
 
    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Function;
   
    class Main {
      public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Goa", "Pune");
        Function<String, Character> firstChar = city -> city.charAt(0);
        cities.stream().map(firstChar).forEach(System.out::println);
      }
    }
