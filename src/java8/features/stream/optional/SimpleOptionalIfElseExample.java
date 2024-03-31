package java8.features.stream.optional;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.Optional;

public class SimpleOptionalIfElseExample {

    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        orElse(Optional.ofNullable(allPersons.get(0)));

        orElseGet(Optional.ofNullable(new Person()));
        ifPresent(Optional.ofNullable(allPersons.get(0)));
//        ifPresent(Optional.ofNullable(new Person()));
//        orElseThrow(Optional.ofNullable(new Person()));
    }

    static void orElse(Optional<Person> person) {
        String name = person.map(Person::getName).orElse("No Name found");
        System.out.println(name);
    }

    static void orElseGet(Optional<Person> person) {
        String name = person.map(Person::getName).orElseGet(() -> "No Name found");
        System.out.println(name);
    }

    static void orElseThrow(Optional<Person> person) {
        String name = person.map(Person::getName).orElseThrow(() -> new RuntimeException("No record found"));
        System.out.println(name);
    }


    static void ifPresent(Optional<Person> person) {
        person.ifPresent(per->{
            String name = person.map(Person::getName).orElseThrow(() -> new RuntimeException("No record found"));
            System.out.println(name);

        });
    }
}
