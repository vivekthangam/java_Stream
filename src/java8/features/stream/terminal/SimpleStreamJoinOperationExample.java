package java8.features.stream.terminal;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamJoinOperationExample {

    public static void main(String[] args) {
        char[] name = {'v','i','v','e','k'};
        String join = Stream.of(name).map(String::new).collect(Collectors.joining());
        System.out.println("join String: "+join);
        Stream.of(name).map(String::new).forEach(System.out::println);

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();

        String joining1 = allPersons.stream().map(Person::getName).collect(Collectors.joining());
                System.out.println("joining 1:"+joining1);

        String joining2 = allPersons.stream().map(Person::getName).collect(Collectors.joining("-"));
        System.out.println("joining 2:"+joining2);

        String joining3 = allPersons.stream().map(Person::getName).collect(Collectors.joining(",","[","]"));
        System.out.println("joining 3:"+joining3);
    }
}




