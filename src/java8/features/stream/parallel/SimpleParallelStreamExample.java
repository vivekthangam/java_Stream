package java8.features.stream.parallel;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SimpleParallelStreamExample {

    public static void main(String[] args) {

//        System.out.println("Available cores: "+Runtime.getRuntime().availableProcessors());
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};


        System.out.println("parallel Stream");
        printStream(Arrays.stream(str).parallel());
        System.out.println("Sequence Stream");
        printStream(Arrays.stream(str));


    }

    static void printStream(Stream<String> _stream) {
        _stream.forEach(s -> {
            System.out.println(LocalTime.now() + " Value :" + s + " :" + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}



