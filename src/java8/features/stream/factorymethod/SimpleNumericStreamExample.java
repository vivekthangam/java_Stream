package java8.features.stream.factorymethod;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
Numeric Stream for primitive variable
    - IntStream (can be converted to Double and Long Stream)
    - LongStream (can be converted to Double Stream)
    - DoubleSteam (cant create DoubleSteam direct only way to create this is convert int or long to DoubleSteam)
Range -> means if we give 1,5 it will create 1,2,3,4 till before range but not the range
RangeClosed -> means if we give 1,5 it will create 1,2,3,4,5 till the range
 */
public class SimpleNumericStreamExample {

    public static void main(String[] args) {
        IntStream int1 = IntStream.range(1, 20);

        IntStream int2 = IntStream.rangeClosed(1, 20);
        int1.forEach(System.out::print);
        System.out.println(" ");
        int2.forEach(System.out::print);
        System.out.println(" ");
        LongStream long1 = LongStream.range(1, 20);

        LongStream long2 = LongStream.rangeClosed(1, 20);
        long1.forEach(System.out::print);
        System.out.println(" ");
        long2.forEach(System.out::print);
        System.out.println(" ");
        DoubleStream double1 = LongStream.range(1, 20).asDoubleStream();

        DoubleStream double2 = LongStream.rangeClosed(1, 20).asDoubleStream();
        double1.forEach(System.out::print);
        System.out.println(" ");
        double2.forEach(System.out::print);
        System.out.println(" ");
        System.out.println("IntStream Sum:"+IntStream.rangeClosed(1,100).sum());


        OptionalInt optionalIntMax= IntStream.rangeClosed(1,1000).max();
        System.out.println("IntStream Max:"+optionalIntMax.getAsInt());

        OptionalInt optionalIntMin= IntStream.rangeClosed(1,1000).min();
        System.out.println("IntStream Max:"+optionalIntMin.getAsInt());



        OptionalDouble optionalDoubleAvg= IntStream.rangeClosed(1,1000).average();
        System.out.println("IntStream average:"+optionalDoubleAvg.getAsDouble());

    }

}




