package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/*
BiFunction
    - two input and returns one output  -> R apply(T t, U u);
 */
public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, String,String> p1 = (a, b) -> a.concat(b);
        System.out.println("concat of a and b  " + p1.apply("vivek"," Thangam"));

        Predicate<Person> isMaleAndHeightGreaterThan165 = (person) -> person.getGender().equalsIgnoreCase("male") && person.getHeight() > 165;

        PersonRepository repo = new PersonRepository();
        List<Person> allPersons = repo.getAllPersons();
        BiConsumer<String,Double> printPersonNameAndSalary = (name, salary) -> System.out.println("Name: " + name+" Salary:"+salary);


        BiFunction<List<Person>,Predicate<Person>, Map<String,Double>> function =(personList,predicate)->{

            Map<String,Double> map = new HashMap<>();
            personList.forEach(person->{
                if(predicate.test(person))
                    map.put(person.getName(),person.getSalary());

            });
            return map;
        };
        function.apply(allPersons,isMaleAndHeightGreaterThan165).forEach(printPersonNameAndSalary);
    }
}



