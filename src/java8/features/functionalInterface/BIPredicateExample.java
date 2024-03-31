package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/*
BiPredicate
    - two input and returns boolean  ->  boolean test(T t, U u);
 */
public class BIPredicateExample {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> p1 = (a,b) -> a > b;

        System.out.println("a is greater than b: " + p1.test(20,30));
        System.out.println("a is greater than b: " + p1.test(40,30));

        BiPredicate<String,Integer> isMaleAndHeightGreaterThan165 = (a,b) -> a.equalsIgnoreCase("male") && b > 165;

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        allPersons.forEach(person -> {
            if (isMaleAndHeightGreaterThan165.test(person.getGender(),person.getHeight()))

                System.out.println("Person name:" + person.getName() + "Gender: " + person.getGender() + "Height: " + person.getHeight());
        });
    }
}



