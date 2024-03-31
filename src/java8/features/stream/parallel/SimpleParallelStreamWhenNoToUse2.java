package java8.features.stream.parallel;

import java.util.List;
import java.util.stream.IntStream;

public class SimpleParallelStreamWhenNoToUse2 {

    public static void main(String[] args) {
//        List<Integer> list =

        Calculator cal =new Calculator();
        IntStream.rangeClosed(1, 10000).forEach(cal::calculate);
        System.out
                .println("seq result:"+cal.getTotal());

        Calculator cal1=new Calculator();
        IntStream.rangeClosed(1, 10000).parallel().forEach(cal1::calculate);
        System.out
                .println("par result:"+cal1.getTotal());


    }
}
class Calculator{
private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public void calculate(int num) {
        this.total += num;
    }
}




