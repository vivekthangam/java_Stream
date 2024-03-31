package java8.features.stream.factorymethod;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SimpleStreamFactoryMethodExample {

    public static void main(String[] args) {
        Stream<Integer> intlist = Stream.of(1, 2, 3, 4, 23, 53, 23);
        Stream<Integer> fiveSequence = Stream.iterate(5,x->x+5).limit(10);
        fiveSequence.forEach(System.out::println);
        Supplier<Double> randomSupplier = Math::random;
        Stream<Double> random = Stream.generate(randomSupplier).limit(10); //s
        random.forEach(System.out::println);
        Stream.generate(new Random()::nextInt).limit(10)
        .forEach(System.out::println);

    }
}



