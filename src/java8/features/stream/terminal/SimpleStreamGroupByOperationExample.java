package java8.features.stream.terminal;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleStreamGroupByOperationExample {

    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();

        Map<String, List<Person>> personsGroupByGender = allPersons.stream().collect(Collectors.groupingBy(Person::getGender));
        personsGroupByGender.forEach((k, v) -> System.out.println("Key:" + k + "Persons:" + v));

        Map<String, List<Person>> groupBYHeight = allPersons.stream().collect(Collectors.groupingBy(person -> person.getHeight() > 170 ? "Tallest" : "shortest"));
        groupBYHeight.forEach((k, v) -> System.out.println("Key:" + k + "Persons:" + v));

        Map<String, Map<String, List<Person>>> groupByGenderAndHeight = allPersons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(person -> person.getHeight() > 170 ? "Tallest" : "shortest")));
        groupByGenderAndHeight.forEach((k, v) -> System.out.println("Key:" + k + "Persons:" + v));

        Map<String, Integer> groupByChhild =
                allPersons.stream()
                        .collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getKids)));
        groupByChhild.forEach((k, v) -> System.out.println("Key:" + k + "Persons:" + v));


        Map<String, List<Person>> groupByNames= allPersons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, HashMap::new,Collectors.toList()));
        groupByNames.forEach((k, v) -> System.out.println("Key:" + k + "Persons:" + v));

    }

}


