package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Consumer;
/*
Consumer
    - one input and returns nothing  -> void accept(T t);
    - Used for Foreach
 */
public class ConsumerExample {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        Consumer<Person> consumer1 = (person)-> System.out.print(person.getName().toUpperCase()+" ");
        Consumer<Person> consumer2 = (person)-> System.out.println(person.getGender().toUpperCase());
        Consumer<Person> consumer3 = (person)-> System.out.println(person.toString());
        consumer1.andThen(consumer2).andThen(consumer3).accept(repo.getAllPersons().get(0));
        List<Person> allPersons = repo.getAllPersons();
        allPersons.forEach(consumer3);

//        allPersons.forEach(consumer2);

        allPersons.forEach(consumer1.andThen(consumer2));

        //print only men

        allPersons.forEach(person -> {
            if (person.getGender().equalsIgnoreCase("male"))
                System.out.println(person.getName());
        });
    }
}



