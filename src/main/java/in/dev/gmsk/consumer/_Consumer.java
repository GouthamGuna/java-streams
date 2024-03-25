package in.dev.gmsk.consumer;

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

        // Consumer functional Interface

        sayGreetingConsumer.accept(employee);

        // BiConsumer functional Interface

        sendEmployeeIdByBiConsumer.accept(employee, true);
    }

    /* Declarative Style */

    static Consumer<Employee> sayGreetingConsumer = employee ->
            System.out.println("Hello " + employee.getName() + " your KYC successfully completed.");

    static BiConsumer<Employee, Boolean> sendEmployeeIdByBiConsumer = (e, isGenerated) ->
            System.out.println("Hello " + e.getName() + " your empID is : " + (isGenerated ? e.getId() : "*****"));

    /* Imperative Style */

    static void sayGreetingMethod(Employee employee) {
        System.out.println("Hello " + employee.getName() + " your KYC successfully completed.");
    }

    static void sendEmployeeIdByMethod(Employee e, boolean isGenerated) {
        System.out.println("Hello " + e.getName() + " your empID is : " + (isGenerated ? e.getId() : "*****"));
    }
}
