package in.dev.gmsk.functionalinterface.consumer;

import in.dev.gmsk.model.Employee;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Gowtham Sankar Gunasekaran");
        employee.setId("2427");

        // Natural Method

        sayGreetingMethod(employee);

        sendEmployeeIdByMethod(employee, false);

        printString(System.out::println, "\nNatural Method : Hello, World!");

        // Consumer functional Interface

        sayGreetingConsumer.accept(employee);

        Consumer<String> consumer = System.out::println;
        consumer.accept("\nHello, World!"); // prints "Hello, World!"

        Consumer<String> consumerOne = getConsumer;
        consumerOne.accept("\ngetConsumer() : Hello, Lunar!"); // prints "Hello, Lunar!"

        // BiConsumer functional Interface

        sendEmployeeIdByBiConsumer.accept(employee, true);
    }

    /* Declarative Style */

    static Consumer<Employee> sayGreetingConsumer = employee ->
            System.out.println("Hello " + employee.getName() + " your KYC successfully completed.");

    static BiConsumer<Employee, Boolean> sendEmployeeIdByBiConsumer = (e, isGenerated) ->
            System.out.println("Hello " + e.getName() + " your empID is : " + (isGenerated ? e.getId() : "*****"));

    static Consumer<String> getConsumer = System.out::println;

    /* Imperative Style */

    static void sayGreetingMethod(Employee employee) {
        System.out.println("Hello " + employee.getName() + " your KYC successfully completed.");
    }

    static void sendEmployeeIdByMethod(Employee e, boolean isGenerated) {
        System.out.println("Hello " + e.getName() + " your empID is : " + (isGenerated ? e.getId() : "*****"));
    }

    static void printString(Consumer<String> consumer, String str) {
        consumer.accept(str);
    }
}
