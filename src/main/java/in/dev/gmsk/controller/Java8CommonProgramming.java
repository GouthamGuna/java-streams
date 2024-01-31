package in.dev.gmsk.controller;

import in.dev.gmsk.model.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

public class Java8CommonProgramming {
    public static void main(String[] args) {

        // 1. Find the list of students whose rank is in between 50 and 100;

        getStudent_50_To_100_RankList( getAllStudentList() );

        //2. Find the Students who stays in Karnataka and sort them by their names;

        getKarnatakaStudentList( getAllStudentList() );

        // 3. Find all departments names

        FindAllDepartmentsNames( getAllStudentList() );

        //4.  Find all the contact numbers

        findAllTheContactNumbers( getAllStudentList() );

        //5.  Group The Student By Department Names

        studentByDepartmentNames( getAllStudentList() );
    }

    static List<Student> getAllStudentList() {

        return Stream.of(
                        new Student( 1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList( "+912632632782", "+1673434729929" ) ),
                        new Student( 2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList( "+912632632762", "+1673434723929" ) ),
                        new Student( 3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList( "+912632633882", "+1673434709929" ) ),
                        new Student( 4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, List.of( "+9126325832782", "+1671434729929" ) ),
                        new Student( 5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, List.of( "+012632632782" ) ),
                        new Student( 6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList( "+9126254632782", "+16736784729929" ) ),
                        new Student( 7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList( "+912632632782", "+1671234729929" ) ),
                        new Student( 8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList( "+9126326355782", "+1673434729929" ) ),
                        new Student( 9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList( "+9126398932782", "+16563434729929", "+5673434729929" ) ),
                        new Student( 10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList( "+912632646482", "+16734323229929" ) ) )
                .toList();
    }

    static void getStudent_50_To_100_RankList(List<Student> studentList) {

        List<Student> studentRankList = studentList.stream()
                .filter( s -> s.getRank() > 50 && s.getRank() < 100 ).toList();

        out.println( "studentRankList = " + studentRankList );
    }

    static void getKarnatakaStudentList(List<Student> studentList) {

        List<Student> karnataka = studentList.stream()
                .filter( s -> s.getCity().equalsIgnoreCase( "Karnataka" ) )
                .sorted( Comparator.comparing( Student::getFirstName ) ) // , Comparator.reverseOrder() -> Results Given Descending Order!
                .toList();

        out.println( "karnataka = " + karnataka );
    }

    static void FindAllDepartmentsNames(List<Student> studentList) {

        List<String> list = studentList.stream().map( Student::getDept )
                .distinct()
                .toList();

        out.println( "list = " + list );

        // One more way to archive to remove the duplicate without distinct();

        Set<String> deptNamesInSet = studentList.stream().map( Student::getDept )
                .collect( Collectors.toSet() );

        out.println( "deptNamesInSet  = " + deptNamesInSet );

        // Sorting Dept Names

        Set<String> deptNamesInSortedSet = studentList.stream().map( Student::getDept )
                .sorted()
                .collect( Collectors.toCollection( LinkedHashSet::new ) );

        out.println( "deptNamesInSortedSet = " + deptNamesInSortedSet );
    }

    /**
     * One TO One -> map();
     * One TO Many -> FlatMap()
     */

    static void findAllTheContactNumbers(List<Student> studentList) {

        List<String> list = studentList.stream()
                .flatMap( s -> s.getContacts().stream() )
                .distinct()
                .toList();

        out.println( "list = " + list );
    }

    static void studentByDepartmentNames(List<Student> studentList) {

        Map<String, List<Student>> collect = studentList.stream()
                .collect( Collectors.groupingBy( Student::getDept ) );

        out.println( "collect = " + collect );

        Map<String, Long> dept_student_count = studentList.stream().collect(
                Collectors.groupingBy( Student::getDept
                        , Collectors.counting() )
        );

        out.println( "dept_student_count = " + dept_student_count );

        // Find Max Student in Department Map.Entry<String, Long>

        Map.Entry<String, Long> stringLongEntry = studentList.stream()
                .collect( Collectors.groupingBy( Student::getDept,
                        Collectors.counting() )
                )
                .entrySet().stream().max( Map.Entry.comparingByValue() ).get();

        out.println( "stringLongEntry = " + stringLongEntry );

        Optional<?> OptionalStringLongEntry = Optional.of( studentList.stream()
                .collect( Collectors.groupingBy( Student::getDept,
                        Collectors.counting() )
                )
                .entrySet().stream().max( Map.Entry.comparingByValue() ).get() );

        out.println( "OptionalStringLongEntry = " + OptionalStringLongEntry );
    }

}
