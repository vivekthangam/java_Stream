package java8.features.stream.parallel;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleParallelStreamPersonExample {
static         List<Person> allPersons = new PersonRepository().getAllPersons();

    public static void main(String[] args) {

   System.out.println("Duration seq result: " +checkPerformance(SimpleParallelStreamPerformanceExample::sumUsingSeqStream,25));

        System.out.println("Duration parallel result: " + checkPerformance(SimpleParallelStreamPerformanceExample::sumUsingParallelStream,25));


    }


    static long checkPerformance(Supplier<Integer> fn, int numOfTime) {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfTime; i++) {
            fn.get();
        }
        Long endTime = System.currentTimeMillis();
        return endTime - startTime;

    }


    static List<String> sumUsingSeqStream() {
        return allPersons.stream().map(Person::getHobbies).flatMap(List::stream).collect(Collectors.toList());
    }


    static List<String> sumUsingParallelStream() {

        return allPersons.stream().parallel().map(Person::getHobbies).flatMap(List::stream).collect(Collectors.toList());
    }
}




