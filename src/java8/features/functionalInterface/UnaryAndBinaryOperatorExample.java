package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/*
UnaryOperator
    - one input and returns same input type as output  -> R apply(T t, U u);

 BinaryOperator
    - two input with same type and returns same input type as output  -> R apply(T t, U u);
 */
public class UnaryAndBinaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> p1 = (a) -> a.toUpperCase();
        System.out.println("a lowercase " + p1.apply("vivek  Thangam"));
        BinaryOperator<String> p2 = (a,b)->a.concat(b);
        System.out.println("a lowercase " + p2.apply("vivek","  Thangam"));
        Comparator<Integer> comp1 = (a,b)->a.compareTo(b);
        BinaryOperator<Integer> b1 = BinaryOperator.maxBy(comp1);
        System.out.println("compare a and b and get max " + b1.apply(10,6));

        BinaryOperator<Integer> b2 = BinaryOperator.minBy(comp1);
        System.out.println("compare a and b and get min " + b2.apply(10,6));
    }
}



