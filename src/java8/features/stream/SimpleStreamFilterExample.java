package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SimpleStreamFilterExample {


    static Predicate<String> length = (name) -> name.length() > 4;

    static Predicate<Person> heightFilter = (person) -> person.getHeight() > 180;

    static Predicate<Person> genderMaleFilter = (person) -> person.getGender().equalsIgnoreCase("male");

    static Predicate<Person> salaryFilter = (person) -> person.getSalary() > 60000;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala");
        names.stream().filter(length).forEach(System.out::println);
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        System.out.println("Filter by height");
        allPersons.stream().filter(heightFilter).forEach(System.out::println);

        System.out.println("Filter by Salary");
        allPersons.stream().filter(salaryFilter).forEach(System.out::println);


        System.out.println("Filter by Salary and gender");
        allPersons.stream().filter(salaryFilter.and(genderMaleFilter)).forEach(System.out::println);
    }
}





