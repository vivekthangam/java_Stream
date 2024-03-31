package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;

public class SimpleStreamSortedExample {

    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        System.out.println("Sort by name");
        allPersons.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        System.out.println("Sort by Height");
        allPersons.stream().sorted(Comparator.comparing(Person::getHeight)).forEach(System.out::println);

        System.out.println("Sort by reverse Height");
        allPersons.stream().sorted(Comparator.comparing(Person::getHeight).reversed()).forEach(System.out::println);

    }
}




