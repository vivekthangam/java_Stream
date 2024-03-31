package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Method refrence
    - it has 3 type of method reference
        - className :: staticMethod -> ()->{}
        - className :: ObjectMethod -> ()->{}
        - className :: new
    - no input and returns  output and output types mentioned in the Supplier class  ->   T get();
 */
public class MethodReferenceExample {
    public static void main(String[] args) {

        Comparator<Integer> comp =MethodReferenceExample::compare;

        System.out.println(comp.compare(10,20));


        System.out.println(comp.compare(100,20));
        PersonRepository repo = new PersonRepository();
        Predicate<Person> p1 = MethodReferenceExample::heihgtCheck;

        BiPredicate<Person,Integer> p2 = MethodReferenceExample::heihgtCheckWithParam;
        MethodReferenceExample obj = new MethodReferenceExample();
        Consumer<Person> c1 = obj::printName;
        List<Person> allPersons = repo.getAllPersons();
//        allPersons.forEach(consumer3);
        System.out.println("Person Height: "+p1.test(allPersons.get(0)));

        System.out.println("Person Height: "+p2.test(allPersons.get(0),100));
        allPersons.forEach(c1);
    }

    public void printName(Person personName){
        System.out.println("Person Name: "+personName.getName());
    }
    public static int compare(int a,int b){
        return Integer.compare(a,b);
    }
    public static boolean heihgtCheck(Person person){
        return person.getHeight()>=165;
    }

    public static boolean heihgtCheckWithParam(Person person,int height){
        return person.getHeight()>=height;
    }



}






