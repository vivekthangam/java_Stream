package java8.features.stream.terminal;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleStreamMappingOperationExample {

    public static void main(String[] args) {

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        //this is how we do mapping to get names but we have another way
        List<String> names = allPersons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);


        //we can use collector mapping for to get the names
        List<String> names1 = allPersons.stream().collect(Collectors.mapping(Person::getName, Collectors.toList()));
        System.out.println(names1);
        Set<String> namesSet = allPersons.stream().collect(Collectors.mapping(Person::getName, Collectors.toSet()));
        System.out.println(namesSet);
        Long countPerson = allPersons.stream().collect(Collectors.counting());
        System.out.println("countPerson:"+countPerson);

    }
}
