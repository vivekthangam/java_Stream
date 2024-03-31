package java8.features.stream.terminal;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleStreamPartitionByOperationExample {

    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();


        Predicate<Person> predicateHeight = (p) -> p.getHeight() > 160;
        Map<Boolean, List<Person>> personsPartitionByGender = allPersons.stream()
                .collect(Collectors.partitioningBy(predicateHeight));
        personsPartitionByGender.forEach((k, v) -> System.out.println("Key:" + k + " Persons:" + v));


        Map<Boolean, Set<Person>> personsPartitionByGenderSet = allPersons.stream()
                .collect(Collectors.partitioningBy(predicateHeight,Collectors.toSet()));
        personsPartitionByGenderSet.forEach((k, v) -> System.out.println("Key:" + k + " Persons:" + v));



        Map<Boolean, Map<String,List<String>>> personsPartitionByHobbiesMap= allPersons.stream()
                .collect(Collectors.partitioningBy(predicateHeight,Collectors.toMap(Person::getName,Person::getHobbies)));
        personsPartitionByHobbiesMap.forEach((k, v) -> System.out.println("Key:" + k + " Persons:" + v));

    }

}



