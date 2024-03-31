package java8.features.stream;

import java.util.Arrays;
import java.util.List;

public class SimpleStreamAllMatchAndAnyMatchExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("vivek", "thangam", "jaga", "udhaya", "bala","prasanna","vijay","arun","keerthana","nivethikas");
        System.out.println("all names legntht is greater than 4: "+
                names.stream().allMatch(name->name.length()>=4));

        System.out.println("atlease any names legntht is greater than 5: "+
                names.stream().anyMatch(name->name.length()>=5));

    }
}


