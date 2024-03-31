package java8.features.stream;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class SimpleStreamLimitSkipExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala","prasanna","vijay","arun","keerthana","nivethikas");
//        names.stream().limit(8).forEach(System.out::println);
        names.stream().skip(5).forEach(System.out::println);

    }
}



