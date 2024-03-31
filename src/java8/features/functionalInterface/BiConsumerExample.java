package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


/*
BiConsumer
    - two input and returns nothing  -> void accept(T t, U u);
 */
public class BiConsumerExample {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        BiConsumer<Integer, Integer> biConsumer1 = (a, b) -> System.out.print("Add " + a + b);

        BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println("Sub " + a + b);

        biConsumer1.andThen(biConsumer2).accept(10, 20);

        BiConsumer<String,List<String>> hobbiesConsumer = (name,hobbies)-> System.out.println("Name: "+ name+"hobbies: "+hobbies);

        allPersons.forEach(person -> {
            hobbiesConsumer.accept(person.getName(), person.getHobbies());
        });

    }
}

