package in.dev.gmsk.streams;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.System.*;

public class FeeCollectionListRefactor {

    public static void main(String[] args) {
        finalTestingScenario.accept(getStudent.get());
    }

    private static final Supplier<Student> getStudent = () ->
            new Student("Sathaya", "gfq", "no");

    private static final Supplier<Stream<Fee>> getFeeList = () -> Stream.of(
            new Fee("GFQ", 8000),
            new Fee("MFQ", 50000),
            new Fee("Hostel", 10000),
            new Fee("Other", 5000)
    );

    private static final Function<Student, List<Fee>> filterMFQFeeWithOutHostel = s -> getFeeList.get()
            .filter(f -> !f.getFeeTypeId().equalsIgnoreCase("GFQ") && !f.getFeeTypeId().equalsIgnoreCase("Hostel"))
            .toList();

    private static final Function<Student, List<Fee>> filterMFQFeeWithHostel = s -> getFeeList.get()
            .filter(f -> !f.getFeeTypeId().equalsIgnoreCase("GFQ"))
            .toList();

    private static final Function<Student, List<Fee>> filterGFQFeeWithOutHostel = s -> getFeeList.get()
            .filter(f -> !f.getFeeTypeId().equalsIgnoreCase("MFQ") && !f.getFeeTypeId().equalsIgnoreCase("Hostel"))
            .toList();

    private static final Function<Student, List<Fee>> filterGFQFeeWithHostel = s -> getFeeList.get()
            .filter(f -> !f.getFeeTypeId().equalsIgnoreCase("MFQ"))
            .toList();

    private static void testingScenario() {

        List<Fee> mfqFeesWithoutHostel = filterMFQFeeWithOutHostel.apply(getStudent.get());
        List<Fee> mfqFeesWithHostel = filterMFQFeeWithHostel.apply(getStudent.get());
        List<Fee> gfqFeesWithoutHostel = filterGFQFeeWithOutHostel.apply(getStudent.get());
        List<Fee> gfqFeesWithHostel = filterGFQFeeWithHostel.apply(getStudent.get());

        err.println("\nMFQ Fees without Hostel: " + mfqFeesWithoutHostel);
        err.println("\nMFQ Fees with Hostel: " + mfqFeesWithHostel);
        err.println("\nGFQ Fees without Hostel: " + gfqFeesWithoutHostel);
        err.println("\nGFQ Fees with Hostel: " + gfqFeesWithHostel);
    }

    private static void testingScenarioOne() {

        if (getStudent.get().getFeeType().equalsIgnoreCase("GFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("NO")) {
            out.println("\nResult : " + filterGFQFeeWithOutHostel.apply(getStudent.get()));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("GFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("Yes")) {
            out.println("\nResult : " + filterGFQFeeWithHostel.apply(getStudent.get()));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("MFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("No")) {
            out.println("\nResult : " + filterMFQFeeWithOutHostel.apply(getStudent.get()));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("MFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("Yes")) {
            out.println("\nResult : " + filterMFQFeeWithHostel.apply(getStudent.get()));
        }
    }

    private static final Consumer<Student> finalTestingScenario = s -> {

        ConcurrentHashMap<List<Fee>, Boolean> conduction = new ConcurrentHashMap<>();
        conduction.put(filterGFQFeeWithOutHostel.apply(s), s.getFeeType().equalsIgnoreCase("GFQ") && s.getIsHostel().equalsIgnoreCase("NO"));
        conduction.put(filterGFQFeeWithHostel.apply(s), s.getFeeType().equalsIgnoreCase("GFQ") && s.getIsHostel().equalsIgnoreCase("Yes"));
        conduction.put(filterMFQFeeWithOutHostel.apply(s), s.getFeeType().equalsIgnoreCase("MFQ") && s.getIsHostel().equalsIgnoreCase("No"));
        conduction.put(filterMFQFeeWithHostel.apply(s), s.getFeeType().equalsIgnoreCase("MFQ") && s.getIsHostel().equalsIgnoreCase("Yes"));


        Stream<Map.Entry<List<Fee>, Boolean>> stream = conduction.entrySet().parallelStream();

        stream.filter(Map.Entry::getValue).map(k -> "\nResult : " + k.getKey()).forEach(out::println);
    };
}

@Getter
@ToString
@AllArgsConstructor
class Fee {

    private String feeTypeId;
    private long feeAmount;
}

@Getter
@AllArgsConstructor
class Student {

    private String name;
    private String feeType;
    private String isHostel;
}