package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/*
Supplier
    - no input and returns  output and output types mentioned in the Supplier class  ->   T get();
 */
public class SupplierExample {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();

        List<Person> allPersons = repo.getAllPersons();

        Supplier<List<Person>> s1 = () -> repo.getAllPersons();
        System.out.println(s1.get().toString());
        Supplier<Person> s2 = () -> repo.getAllPersons().get(0);
        System.out.println(s2.get().toString());
        Supplier<Double> s3 = () -> Math.random()*10;
        System.out.println(s3.get().toString());

    }
}








