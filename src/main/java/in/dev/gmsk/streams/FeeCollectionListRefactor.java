package in.dev.gmsk.streams;

import lombok.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.System.*;

public class FeeCollectionListRefactor {

    public static void main(String[] args) {

        List<Fee> mfqFeesWithoutHostel = filterMFQFeeWithOutHostel.apply(getStudent.get());
        List<Fee> mfqFeesWithHostel = filterMFQFeeWithHostel.apply(getStudent.get());
        List<Fee> gfqFeesWithoutHostel = filterGFQFeeWithOutHostel.apply(getStudent.get());
        List<Fee> gfqFeesWithHostel = filterGFQFeeWithHostel.apply(getStudent.get());

        ConcurrentHashMap<String, List<Fee>> result = new ConcurrentHashMap<>();
        result.put("mfqFeesWithoutHostel", filterMFQFeeWithOutHostel.apply(getStudent.get()));
        result.put("mfqFeesWithHostel", filterMFQFeeWithHostel.apply(getStudent.get()));
        result.put("gfqFeesWithoutHostel", filterGFQFeeWithOutHostel.apply(getStudent.get()));
        result.put("gfqFeesWithHostel", filterGFQFeeWithHostel.apply(getStudent.get()));

        if (getStudent.get().getFeeType().equalsIgnoreCase("GFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("NO")) {
            out.println("\nResult : " + result.get("gfqFeesWithoutHostel"));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("GFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("Yes")) {
            out.println("\nResult : " + result.get("gfqFeesWithHostel"));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("MFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("No")) {
            out.println("\nResult : " + result.get("mfqFeesWithoutHostel"));
        } else if (getStudent.get().getFeeType().equalsIgnoreCase("MFQ") && getStudent.get().getIsHostel().equalsIgnoreCase("Yes")) {
            out.println("\nResult : " + result.get("mfqFeesWithHostel"));
        }

        out.println("MFQ Fees without Hostel: " + mfqFeesWithoutHostel);
        out.println("MFQ Fees with Hostel: " + mfqFeesWithHostel);
        out.println("GFQ Fees without Hostel: " + gfqFeesWithoutHostel);
        out.println("GFQ Fees with Hostel: " + gfqFeesWithHostel);
    }

    private static final Supplier<Student> getStudent = () ->
            new Student("Sathaya", "mfq", "null");

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