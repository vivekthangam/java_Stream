package java8.features.stream.parallel;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleParallelStreamWhenNoToUse {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10000000).boxed().toList();

        checkParallelPerf(list);

        checkSeqPerf(list);
    }

    private static void checkParallelPerf(List<Integer> list) {
        Long startTime = System.currentTimeMillis();
        list.stream().reduce(0, (x, y) -> x + y);

        Long endTime = System.currentTimeMillis();
        System.out.println("Duration parallel result: " + (endTime - startTime));

    }

    private static void checkSeqPerf(List<Integer> list) {
        Long startTime = System.currentTimeMillis();
        list.stream().parallel().reduce(0, (x, y) -> x + y);
        Long endTime = System.currentTimeMillis();
        System.out.println("Duration seq result: " + (endTime - startTime));
    }
}




