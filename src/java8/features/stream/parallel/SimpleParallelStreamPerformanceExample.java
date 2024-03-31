package java8.features.stream.parallel;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SimpleParallelStreamPerformanceExample {

    public static void main(String[] args) {
//System.out.println("seq result: " + sumUsingSeqStream());
//
//        System.out.println("parallel result: " + sumUsingParallelStream());
        System.out.println("Duration seq result: " +checkPerformance(SimpleParallelStreamPerformanceExample::sumUsingSeqStream,25));

        System.out.println("Duration parallel result: " + checkPerformance(SimpleParallelStreamPerformanceExample::sumUsingParallelStream,25));


    }


    static long checkPerformance(Supplier<Integer> fn, int numOfTime) {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfTime; i++) {
            fn.get();
        }
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;

    }


    static int sumUsingSeqStream() {
        return IntStream.rangeClosed(1, 10000000).sum();
    }


    static int sumUsingParallelStream() {
        return IntStream.rangeClosed(1, 10000000).parallel().sum();
    }
}





