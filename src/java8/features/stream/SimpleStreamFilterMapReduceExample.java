package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SimpleStreamFilterMapReduceExample {


    static Predicate<String> length = (name) -> name.length() > 4;

    static Predicate<Person> heightFilter = (person) -> person.getHeight() > 180;

    static Predicate<Person> genderMaleFilter = (person) -> person.getGender().equalsIgnoreCase("male");

    static Predicate<Person> salaryFilter = (person) -> person.getSalary() > 60000;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala");
        names.stream().filter(length).forEach(System.out::println);
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
int count = allPersons.stream().filter(heightFilter.and(genderMaleFilter)).map(Person::getKids)
                        .reduce(0, Integer::sum);

        System.out.println("Filter by height and gender male and child count: "+count);
        int count1 = allPersons.stream().filter(genderMaleFilter).map(Person::getKids)
                .reduce(0, Integer::sum);
        System.out.println("Filter by  gender male and child count: "+count1);

        int count2 = allPersons.stream().limit(3).map(Person::getKids)
                .reduce(0, Integer::sum);
        System.out.println("Total child count: "+count2);

    }
}
