package in.dev.gmsk.functionalinterface.supplier;

import in.dev.gmsk.model.Student;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Simple {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName( null );

        createAccount( student, () -> "Invalid name " + LocalDateTime.now() );
    }

    private static void createAccount(Student s, Supplier<String> errorMsg) {
        if (s.getFirstName() == null) {
            System.out.println( "errorMsg = " + errorMsg.get() );
        }
    }
}
