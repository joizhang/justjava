package com.joizhang.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;

    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

    private static boolean isNotEmpty(String s) {
        return !(s == null || s.isEmpty());
    }

    public static String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        // example 1
        List<String> stringList = Arrays.asList("2", "", "4", "6", "11");
        int sum = stringList.stream()
                .filter(StreamDemo::isNotEmpty) // Predicate
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0) // IntPredicate
                .sum();
        System.out.println(sum);

        // example 2
        String[] names = Stream
                .of("Mal", "Wash", "Kaylee", "Inara", "Zoë", "Jayne", "Simon", "River", "Shepherd Book")
                .sorted()
                .toArray(String[]::new);
        String lenFiveStrings = StreamDemo.getNamesSatisfyingCondition(LENGTH_FIVE, names);
        System.out.println(lenFiveStrings);

        // example 3
        String startsWithSStrings = StreamDemo.getNamesSatisfyingCondition(STARTS_WITH_S, names);
        System.out.println(startsWithSStrings);

        // example 4 composed predicate
        String andPredicateStrings = StreamDemo.getNamesSatisfyingCondition(LENGTH_FIVE.and(STARTS_WITH_S), names);
        System.out.println(andPredicateStrings);

        // example 5 composed predicate
        String orPredicateStrings = StreamDemo.getNamesSatisfyingCondition(LENGTH_FIVE.or(STARTS_WITH_S), names);
        System.out.println(orPredicateStrings);

        // example 6 negate predicate
        String negatePredicateStrings = StreamDemo.getNamesSatisfyingCondition(LENGTH_FIVE.negate(), names);
        System.out.println(negatePredicateStrings);
    }

}
