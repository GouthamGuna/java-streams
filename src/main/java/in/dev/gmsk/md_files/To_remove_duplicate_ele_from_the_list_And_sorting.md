# To remove duplicate elements from the list without using the `distinct()` method, you can use the `collect()` method with a `Collectors.toMap()` collector. This will create a `Map` where the keys are the unique elements and the values are the last occurrences of the duplicates.

Here's the code:

```java
List<Student> uniqueInstances = instance.stream()
        .collect(Collectors.toMap(
                Student::toString, // Use a unique identifier for the key
                Function.identity(), // Use the original object as the value
                (oldValue, newValue) -> newValue // Keep the last occurrence of the duplicate
        ))
        .values()
        .stream()
        .collect(Collectors.toList());
```

Explanation:

1. The `collect(Collectors.toMap())` method creates a `Map` where the keys are the unique identifiers of the `Student` objects (in this case, we use the `toString()` method to get a unique string representation of each object).
2. The `Function.identity()` method is used as the value function, which simply returns the original `Student` object.
3. The `(oldValue, newValue) -> newValue` lambda expression is used as the merge function, which keeps the last occurrence of the duplicate.
4. Finally, we convert the `Map` values back to a `List` using `collect(Collectors.toList())`.

This approach ensures that the final list `uniqueInstances` contains only unique `Student` objects, without using the `distinct()` method.


## To sort the list of `Fee` objects by `studetName`, `classId`, `SectionId`, and `feePaidDate` using Java 8 streams, you can use the `sorted()` method. Here's how you can do it:

```java
List<Fee> sortedInstance = instance.stream()
        .sorted((fee1, fee2) -> {
            int studetNameCompare = fee1.getStudetName().compareTo(fee2.getStudetName());
            if (studetNameCompare != 0) {
                return studetNameCompare;
            }
            int classIdCompare = fee1.getClassId().compareTo(fee2.getClassId());
            if (classIdCompare != 0) {
                return classIdCompare;
            }
            int sectionIdCompare = fee1.getSectionId().compareTo(fee2.getSectionId());
            if (sectionIdCompare != 0) {
                return sectionIdCompare;
            }
            return fee1.getFeePaidDate().compareTo(fee2.getFeePaidDate());
        })
        .collect(Collectors.toList());
```

This code sorts the list of `Fee` objects by:

1. `studetName` (lexicographically)
2. `classId` (lexicographically)
3. `SectionId` (lexicographically)
4. `feePaidDate` (lexicographically)

If two objects have the same values for the first three criteria, they will be sorted by `feePaidDate`.

This approach ensures that the final list `sortedInstance` is sorted according to the specified criteria.