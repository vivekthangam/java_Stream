package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/*
BiPredicate
    - one input and returns boolean  -> boolean test(T t);
 */
public class ConsumerAndPredicateExample {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> p1 = (a, b) -> a > b;

        System.out.println("a is greater than b: " + p1.test(20, 30));
        System.out.println("a is greater than b: " + p1.test(40, 30));

        BiPredicate<String, Integer> isMaleAndHeightGreaterThan165 = (a, b) -> a.equalsIgnoreCase("male") && b > 165;
        BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println("Name: " + name + "hobbies: " + hobbies);

        Consumer<Person> consumer1 = (person) -> {
            if (isMaleAndHeightGreaterThan165.test(person.getGender(), person.getHeight()))
                hobbiesConsumer.accept(person.getName(), person.getHobbies());
        };

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        allPersons.forEach(consumer1);
    }
}




