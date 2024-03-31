package java8.features.stream.numeric;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleNumericStreamBoxExample {

    public static void main(String[] args) {
        IntStream int1 = IntStream.range(1, 20); //list of int
        List<Integer> intBoxed = int1.boxed().collect(Collectors.toList());


        intBoxed.forEach(System.out::print);

        int count = intBoxed.stream() //Stream of Integer(Wrapper class)
                .mapToInt(Integer::intValue) //Stream of Int (Primitive variable)
                .sum();
        System.out.println("integer Boxed result for double avg:" + count);
        double doubleBoxed = IntStream.range(0, 11).mapToDouble(i -> i).average().getAsDouble();

        System.out.println("Double Boxed result:" + doubleBoxed);
        double longBoxed = IntStream.range(0, 101).mapToDouble(i -> i).sum();

        System.out.println("longBoxed Boxed result:" + longBoxed);


        List<Integer> objBoxed = IntStream.range(0, 101).mapToObj(i -> i).collect(Collectors.toList());

        System.out.println("objBoxed Boxed result:" + objBoxed);
        List<Integer> intforCounting = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());

        int countUsingCollector = intforCounting.stream()

                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("countUsingCollector:" + countUsingCollector);
        double avgUsingCollector = intforCounting.stream()

                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("avgUsingCollector:" + avgUsingCollector);

    }
}







