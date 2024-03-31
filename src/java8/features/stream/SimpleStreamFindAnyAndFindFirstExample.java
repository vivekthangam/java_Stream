package java8.features.stream;

import java.util.Arrays;
import java.util.List;

public class SimpleStreamFindAnyAndFindFirstExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala","prasanna","vijay","arun","keerthana","nivethikas");
        System.out.println("all names legntht is greater than 4 findany: "+
                names.stream().filter(name->name.length()>=6).findAny());
        System.out.println("all names legntht is greater than 4 FindFirst: "+
                names.stream().filter(name->name.length()>=6).findFirst());

    }
}

