import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//(a,b) input args
        //-> token which seperated input arguments and body
        // a+b body
//    Interface01 interface01 = (a,b)->a+b;

//    System.out.println(interface01.add(1,2));

//    new Thread(()->System.out.println("hello Thread")).start();
    Comparator<Integer> comparator =  new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    };

        System.out.println(comparator.compare(1,2));
    }


}