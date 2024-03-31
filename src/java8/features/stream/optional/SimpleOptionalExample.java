package java8.features.stream.optional;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.Optional;

public class SimpleOptionalExample {

    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();

        Optional<String> name = Optional.ofNullable("vivek");
        name = Optional.empty();
        System.out.println("name: " + (name.isPresent() ? name.get() : "Name Not Found"));
        System.out.println("name: " + getName(Optional.ofNullable(allPersons.get(0))).get());
        System.out.println("name: " + getName(Optional.of(new Person())));

    }

    static Optional<String> getName(Optional<Person> person) {

        return person.isPresent() ? person.map(Person::getName) : Optional.empty();
    }
}





