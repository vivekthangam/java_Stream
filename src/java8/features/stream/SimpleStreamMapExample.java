package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SimpleStreamMapExample {

    static Function<Person, String> f1 = Person::getName;

    static UnaryOperator<String> toUppercaseFn = String::toLowerCase;

    static UnaryOperator<String> toLowercaseFn = String::toLowerCase;

    public static List<String> toUpperCase(List<Person> person) {
        return person.stream().map(f1).map(toUppercaseFn).collect(Collectors.toList());
    }


    public static List<String> toLowerCase(List<Person> person) {
        return person.stream().map(f1).map(toLowercaseFn).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banaan", "gua", "Amla");
        List<Integer> listFruits = fruits.stream().map(String::length).collect(Collectors.toList());
        System.out.println("frutes length:" + listFruits);
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        System.out.println("toUpperCase:" + toUpperCase(allPersons));

        System.out.println("toLowerCase:" + toLowerCase(allPersons));

    }
}




