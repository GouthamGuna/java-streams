package in.dev.gmsk.function;

import in.dev.gmsk.model.Employee;

import java.util.Random;
import java.util.function.Function;

public class Simple {
    private static final String SUFFIX = " / ";

    public static void main(String[] args) {
        companyOne();
        companyTwo();
    }

    private static void companyTwo() {

        Employee employee = new Employee();
        employee.setName( "main" );
        employee.setEmailId( "main@dl.in" );

        Employee result = generateEmployeeId( employee, e -> "dl" + SUFFIX + employee.getEmailId().toUpperCase() + SUFFIX + new Random().nextInt( 100 ) + 1 );

        System.out.println( "result = " + result.getId() );
    }

    private static void companyOne() {

        Employee employee = new Employee();
        employee.setName( "Saran" );
        employee.setEmailId( "saran@gmsk.in" );

        Employee result = generateEmployeeId( employee, e -> "gmsk" + SUFFIX + employee.getEmailId() + SUFFIX + new Random().nextInt( 5000 ) + 2000 );

        System.out.println( "result = " + result.getId() );
    }

    private static Employee generateEmployeeId(Employee e, Function<Employee, String> mapToId) {

        Employee employee = new Employee();
        employee.setName( e.getName() );
        employee.setId( mapToId.apply( e ) );

        return employee;
    }
}
