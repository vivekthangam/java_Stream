package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/*
Function
    - one input and returns one output  -> R apply(T t);
 */
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> p1 = (a) -> a.length();
        System.out.println("length of the string " + p1.apply("vivek Thangam"));
        Function<String, String> p2 = (a) -> a.toUpperCase();
        System.out.println("Upper case of the string " + p2.apply("vivek Thangam"));

        Function<String, String> p3 = (a) -> a.toLowerCase();

        System.out.println("Lower case of the string " + p3.apply("vivek Thangam"));
        Function<String, String> p4 = (a) -> a.concat( " concat");
        System.out.println("And then of function " + p2.andThen(p4).apply("vivek Thangam"));

        System.out.println("Compose of function " + p2.compose(p4).apply("vivek Thangam"));


        BiPredicate<String,Integer> isMaleAndHeightGreaterThan165 = (a, b) -> a.equalsIgnoreCase("male") && b > 165;

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        BiConsumer<String,Double> printPersonNameAndSalary = (name,salary) -> System.out.println("Name: " + name+" Salary:"+salary);


        Function<List<Person>, Map<String,Double>> function =(personList)->{

            Map<String,Double> map = new HashMap<>();
            personList.forEach(person->{
                if(isMaleAndHeightGreaterThan165.test(person.getGender(),person.getHeight() ))
                    map.put(person.getName(),person.getSalary());

            });
        return map;
        };
        function.apply(allPersons).forEach(printPersonNameAndSalary);
    }
}




