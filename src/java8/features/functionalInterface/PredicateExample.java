package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/*
Predicate
    - one input and returns boolean  -> boolean test(T t);
 */
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> p1 = (a) -> a > 10;
        System.out.println("a is greater than 10: " + p1.test(20));
        Predicate<Integer> p2 = (a) -> a < 15;
        System.out.println("a is greater than 10 and less than 15: " + p1.and(p2).test(12));
        System.out.println("a is greater than 10 and less than 15: " + p1.and(p2).test(16));
        System.out.println("a is greater than 10 or less than 15: " + p1.or(p2).test(16));


        Predicate<Integer> isEven = (a) -> a % 2 == 0;

        Predicate<Integer> isOdd = isEven.negate(); // Predicate.not(isEven) this also do the same as isEven


        IntStream.rangeClosed(0, 100).forEach(a -> {
            if (isEven.test(a)) System.out.println(a + " is even");
            if (isOdd.test(a)) System.out.println(a + " is odd");
        });

        Predicate<Person> isMale = (a) -> a.getGender().equalsIgnoreCase("male");

        Predicate<Person> isHeightGreaterThan165 = (a) -> a.getHeight() > 165;

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        allPersons.forEach(person -> {
            if (isMale.and(isHeightGreaterThan165).test(person))

                System.out.println("Person name:" + person.getName() + "Gender: " + person.getGender() + "Height: " + person.getHeight());
        });
    }
}



