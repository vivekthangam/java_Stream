package java8.features.functionalInterface;

import java.util.function.Consumer;

public class LambdaVariableScopeExample {
    static int c=100;
    public static void main(String[] args) {
        int a = 100;
        Consumer<Integer> com = (b) -> {
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            System.out.println("a+b:" + (a + b));
            // a=b ; not able  to modify the local variable inside of the lambda expression
            // it is called as effectively final
            System.out.println("a+b+c:" + (a + b+c));
            c=1000; // Global or class variable can be modified
            System.out.println("a+b+c:" + (a + b+c));

        };
        com.accept(1000);
    }
}



