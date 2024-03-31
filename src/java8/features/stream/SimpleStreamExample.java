package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        s1.forEach(System.out::println);
        Integer[] arr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Stream<Integer> s2 = Stream.of(arr);
        s2.forEach(a -> System.out.println("s2:" + a));

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        Map<String, List<String>> personList = allPersons.stream().filter(person -> person.getHeight() > 165).collect(Collectors.toMap(Person::getName, Person::getHobbies));
        personList.forEach((name, hobbies) -> {
            System.out.println("Name:" + name + "Hobbies:" + hobbies);
        });

        List<String> listHobbies = allPersons.stream()//Stream<Person>
                .map(Person::getHobbies)//Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toList());
        listHobbies.forEach((hobbies) -> {
            System.out.println("hobbies:" + hobbies);
        });

    }
}




