package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class SimpleStreamReduceExample {


    static BinaryOperator<Integer> b1 = (a, b) -> a + b;


    static BinaryOperator<Integer> b2 = (a, b) -> a * b;


    static BinaryOperator<String> b3 = (a, b) -> a.concat(" " + b);

    static BinaryOperator<Person> tallestPerson = (a, b) -> a.getHeight()>b.getHeight()?a:b;

    static BinaryOperator<Person> highestSalary = (a, b) -> a.getSalary()>b.getSalary()?a:b;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala");
        System.out.println(names.stream().reduce(String::concat).get());
        List<Integer> listOfInteger = Arrays.asList(1, 2, 45, 6, 24, 57);
        System.out.println("Addition of integers: " + listOfInteger.stream().reduce(b1).get());
        System.out.println("Addition of integers: " + listOfInteger.stream().mapToInt(i -> i).sum());
        System.out.println("Addition of integers: " + listOfInteger.stream().reduce(0, b1));

        System.out.println("Multiplication of integers: " + listOfInteger.stream().reduce(1, b2));
        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        String allnames = allPersons.stream().map(Person::getName).reduce(" ", b3);
        System.out.println("Highest salary: " + allPersons.stream().reduce( highestSalary).get());

        System.out.println("TallestPerson: " + allPersons.stream().reduce( tallestPerson).get());


    }
}




