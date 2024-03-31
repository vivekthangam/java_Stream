package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStreamFlatMapExample {

    public static List<String> getHobbies(List<Person> allPersons) {
        return allPersons.stream().map(Person::getHobbies).flatMap(List::stream).collect(Collectors.toList());
    }


    public static List<String> getDistinctHobbies(List<Person> allPersons) {
        return allPersons.stream().map(Person::getHobbies).flatMap(List::stream).distinct().collect(Collectors.toList());
    }

    public static List<String> getDistinctAndSortedHobbies(List<Person> allPersons) {
        return allPersons.stream().map(Person::getHobbies).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
    }

    public static long getCountOfHobbies(List<Person> allPersons) {
        return allPersons.stream().map(Person::getHobbies).flatMap(List::stream).distinct().count();
    }
    public static void main(String[] args) {
        List<Integer> oddNumber = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> evenNumber = Arrays.asList(2, 4, 6, 8, 10);
        List<List<Integer>> listOfList = Arrays.asList(oddNumber, evenNumber);
        List<Integer> flatternList = listOfList.stream().flatMap(List::stream).toList();
        System.out.println("Before Falttern:" + listOfList);
        System.out.println("After Falttern:" + flatternList);


        //person Example


        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();

        System.out.println("List of Hobbies:" + getHobbies(allPersons));
        System.out.println("List of Distinct Hobbies:" + getDistinctHobbies(allPersons));
        System.out.println("List of Distinct and Sorted Hobbies:" + getDistinctAndSortedHobbies(allPersons));
        System.out.println("count of Distinct and Sorted Hobbies:" + getCountOfHobbies(allPersons));
    }
}
